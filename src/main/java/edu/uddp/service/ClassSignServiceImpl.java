package edu.uddp.service;

import com.sun.javafx.collections.MappingChange;
import edu.uddp.mapper.CodeRecordMapper;
import edu.uddp.mapper.CodeUuidMapper;
import edu.uddp.mapper.SignLogMapper;
import edu.uddp.mapper.TeaSignMapper;
import edu.uddp.model.*;
import edu.uddp.util.*;
import edu.uddp.vo.ResponseData;

import java.util.*;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * @program: rollcall
 * @description:
 * @author: wanzh
 * @create: 2018-11-1
 **/
@Service
public class ClassSignServiceImpl implements ClassSignService {

    @Resource
    private CodeRecordMapper codeRecordMapper;
    @Resource
    private CodeUuidMapper codeUuidMapper;
    @Resource
    private TeaSignMapper teaSignMapper;
    @Resource
    private StuInfoServiceImpl stuInfoService;
    @Resource
    private TeaSignServiceImpl teaSignService;
    @Resource
    private SignLogMapper signLogMapper;

    @Override
    public ResponseData creatClassSign(String classId, String stuId) {
       /*
       1.获取签到码
       1.通过classId获取班级人员信息
       2.存入缓存
       3.返回班级人员，签到成功
        */
        //获取没有被用的签到id
        CodeRecord codeRecord = codeRecordMapper.selectByPrimaryKey(1);
        int codeIndex = codeRecord.getCodeIndex();
        //记录加1
        if(codeIndex>=30000){
            codeRecord.setCodeIndex(5);
            codeRecord.setId(1);
        }else{
            codeRecord.setCodeIndex(codeIndex+1);
            codeRecord.setId(1);
        }
        codeRecordMapper.updateByPrimaryKey(codeRecord);
        TeaSign teaSign = new TeaSign();
        CodeUuid codeUuid = codeUuidMapper.selectByPrimaryKey(codeIndex);
//        logger.error(codeIndex+"codeIndex获取得到的code编号===========TeaSignServiceImpl");
        //把状态置为1
        codeUuid.setStatus((byte) 1);
        codeUuidMapper.updateByPrimaryKey(codeUuid);
        String signId = codeUuid.getId().toString();
        String signPassword = codeUuid.getCode();
        System.out.println("signId"+signId);
        //生成签到
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        String nowTime = simpleDateFormat.format(calendar.getTime());
        teaSign.setBeginTime(nowTime);
        teaSign.setSignId(signId);
        teaSign.setLessonId(classId);
        teaSign.setClasssId(classId);
        teaSign.setTeaId(stuId);
        teaSign.setWeeks("-1");
        teaSign.setStatus(1);
        int flag = teaSignMapper.insertSelective(teaSign);
        System.out.println("flag" + flag);
        if (flag != 0) {
//            System.out.println("lessonId" + lessonId);
            //根据教学班id获取学生学号信息
            List<StuInfo> stuInfos = stuInfoService.selectByClassId(classId);
//            session.setAttribute("stuInfos", stuInfos);
            List<String> stuIdInfos = new ArrayList<>();
            for (StuInfo stuInfo : stuInfos) {
                if(!stuId.equals(stuInfo.getStuId()))//排除点名发起人
                {
                stuIdInfos.add(stuInfo.getStuId());}
            }
            //List装Map
            Map<Object, Object> stuInfosMap = new HashMap<>();
            //初始化签到人员个数
            stuInfosMap.put("signNums", 0);
            for (String stuIdInfo : stuIdInfos) {
                stuInfosMap.put(stuIdInfo, 0);
            }
            //存入缓存
            //boolean bl= redisUtil.set(signId,stuInfosMap);
            //改动将signPassword作为缓存的键
            System.out.println(signPassword);
            System.out.println(stuInfosMap.toString());
//            boolean bl = redisUtil.setHash(signPassword, stuInfosMap);
            boolean bl =true;
            EhcacheUtil.getInstance().put("mobileCache",signPassword,stuInfosMap,40*60*1000);
           String infoKey=(stuId+";"+classId).trim();
            EhcacheUtil.getInstance().put("mobileCache",signPassword,stuInfosMap,40*60*1000);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("signId", signId);
            resultMap.put("signPassword", signPassword);
            resultMap.put("beginTime", nowTime);
            resultMap.put("signStatus", teaSign.getStatus());
            resultMap.put("stuInfoList", stuInfos);
            if (bl == true) {
                SignLog signLog = new SignLog();
                signLog.setUserId(stuId);
                signLog.setClassId(classId);
                signLog.setLessonId(classId);
                signLog.setSignPassword(signPassword);
                signLog.setSignTime(nowTime);
                signLog.setWeeks("0");
                signLogMapper.insertSelective(signLog);
                return ResponseUtil.setResponse(200, "OK", resultMap);
            } else {
                return ResponseUtil.setResponse(5004, "存入缓存失败", null);
            }
        } else {
            return ResponseUtil.setResponse(5008, "签到生成失败", null);
        }
    }

    @Override
    public ResponseData endClassSign(Map<String, Object> paramsMap) {
        return teaSignService.endSign(paramsMap);
    }

    @Override
    public ResponseData joinClassSign(Map<String, Object> paramsMap, HttpSession session) {
        return teaSignService.joinTeaSign(paramsMap,session);
    }
}
