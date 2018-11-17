package edu.uddp.service;

import com.sun.javafx.collections.MappingChange;
import edu.uddp.mapper.CodeUuidMapper;
import edu.uddp.mapper.JssjMapper;
import edu.uddp.mapper.StuInfoMapper;
import edu.uddp.mapper.TeaSignMapper;
import edu.uddp.model.*;
import edu.uddp.util.EhcacheUtil;
import edu.uddp.util.JwzxUtil;
import edu.uddp.util.RedisUtil;
import edu.uddp.util.ResponseUtil;
import edu.uddp.vo.ResponseData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 获取教师信息
 *
 * @author wanzh
 */
@Service
public class TeaCommonServiceImpl implements TeaCommonService {
    private Logger looger = Logger.getLogger(TeaCommonServiceImpl.class);
    @Resource
    private JssjMapper jssjMapper;
    @Resource
    private StuInfoMapper stuInfoMapper;
    @Resource
    private CodeUuidMapper codeUuidMapper;
    @Resource
    private TeaSignMapper teaSignMapper;

    @Override
    public ResponseData getTeaInfo(String teaId) {
        Map<String, Object> resultMap = new HashMap<>();
        JssjExample jssjExample = new JssjExample();
        jssjExample.createCriteria().andJsghEqualTo(teaId);
        List<Jssj> teaInfos = jssjMapper.selectByExample(jssjExample);
        if (teaInfos.size() != 0) {
            //获取当前周数
            Set<String> resultSet = JwzxUtil.getkbHtml(teaInfos.get(0).getJsbh(), "week");
            looger.error(resultSet.toString() + "week===================TeaCommonServiceImpl");
            resultMap.put("teaInfos", teaInfos);
            String week = null;
            for (String weeks : resultSet) {
                week = weeks;
            }
            resultMap.put("week", week);
            return ResponseUtil.setResponse(200, "OK", resultMap);
        } else {
            return ResponseUtil.setResponse(5008, "教师编号未在本库中找到", null);
        }
    }

    @Override
    public ResponseData getClassInfo(String stuId) {
        StuInfo stuInfo = stuInfoMapper.selectByStuId(stuId);
        if (!stuInfo.getClassId().isEmpty()) {
            return ResponseUtil.setResponse(200, "OK", stuInfo);
        }
        return ResponseUtil.setResponse(5004, "无该学生的班级信息", null);
    }


    @Override
    public String judgeSign(Map<String, Object> paramsMap) {
        /*
        1.判断缓存中的点到是否存在
        2.进入数据库判断缓存中教师的点名状态是否存在(缓存中加存一个key-value,key:教师Id，value：签到口令)
        3.若存在，则返回签到口令,若不存在则返回O字符
         */
        String infoKey = (paramsMap.get("teaId")+";"+paramsMap.get("lessonId")+";"+paramsMap.get("weeks")+";"+paramsMap.get("classId")).trim();//后期添加ClassId
        String alreadySignPassword = "0";
//        if (redisUtil.exists(infoKey)) {
//            alreadySignPassword = (String) redisUtil.get(infoKey);
//        }
        if(EhcacheUtil.containskey("mobileCache",infoKey)){
            alreadySignPassword= (String) EhcacheUtil.getInstance().get("mobileCache",infoKey);
            System.out.println("alreadySignPassword"+alreadySignPassword);
        }
        return alreadySignPassword;
    }

    @Override
    public ResponseData getAlreadySign(String signPassword, Map<String, Object> paramsMap) {
        //从数据库中获取签到信息
        CodeUuidExample codeUuidExample = new CodeUuidExample();
        codeUuidExample.createCriteria().andCodeEqualTo(signPassword);
        List<CodeUuid> codeUuidList = codeUuidMapper.selectByExample(codeUuidExample);
        int signId = 0;
        //判断口令是否在点名
        if (codeUuidList.size() != 0 && codeUuidList.get(0).getStatus() == 1) {
            signId = codeUuidList.get(0).getId();
        }

        TeaSignExample teaSignExample = new TeaSignExample();
        teaSignExample.createCriteria().andSignIdEqualTo(String.valueOf(signId)).andTeaIdEqualTo((String) paramsMap.get("teaId"))
                .andLessonIdEqualTo((String) paramsMap.get("lessonId")).andClasssIdEqualTo((String) paramsMap.get("classId")).andWeeksEqualTo((String) paramsMap.get("weeks"));
        List<TeaSign> teaSignList = teaSignMapper.selectByExample(teaSignExample);
        //判断签到是否在进行
        Map<Object, Object> resultMap = new HashMap<>();
        if (teaSignList.size() != 0 && teaSignList.get(0).getStatus() == 1) {
            //返回签到信息
//            resultMap = redisUtil.getHashKeys(signPassword);
//            resultMap= (Map<Object, Object>) EhcacheUtil.getInstance().get("mobileCache",signPassword);
            resultMap.put("signId", signId);
            resultMap.put("signPassword", signPassword);
            return ResponseUtil.setResponse(200, "OK", resultMap);
        } else {
            return ResponseUtil.setResponse(5002, "点名已结束", null);
        }


    }
}
