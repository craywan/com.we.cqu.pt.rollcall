package edu.uddp.service;

import com.alibaba.fastjson.JSON;
import edu.uddp.mapper.*;
import edu.uddp.model.*;
import edu.uddp.util.*;
import edu.uddp.vo.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TeaSignServiceImpl implements TeaSignService {
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TeaSignServiceImpl.class);

    @Resource
    private LessonsMapper lessonsMapper;
    @Resource
    private CodeUuidMapper codeUuidMapper;
    @Resource
    private TeaSignMapper teaSignMapper;
    @Resource
    private TeaSignStatisticMapper teaSignStatisticMapper;
    @Resource
    private CodeRecordMapper codeRecordMapper;
    @Resource
    private StuInfoServiceImpl stuInfoService;
    @Resource
    private SignLogMapper signLogMapper;

    @Override
    public ResponseData selectCourses(String teaId) {
        LessonsExample lessonsExample = new LessonsExample();
        lessonsExample.createCriteria().andJsbhEqualTo(teaId);
        List<Lessons> lessonsInfos = lessonsMapper.selectByExample(lessonsExample);
        if (lessonsInfos.size() != 0) {
            return ResponseUtil.setResponse(200, "OK", lessonsInfos);
        } else {
            return ResponseUtil.setResponse(5008, "没有找到课程数据", null);
        }
    }

    @Override
    public ResponseData CreatSign(Map<String, Object> paramsMap, HttpSession session) {
//        1.取出签到ID，生成一次签到，记录签到开始时间，
//        补充：计时间
//         合法性分析
//        2.获取教学班签到学生学号，并放入redis缓存中
//        3.签到发布后，只有教学班的学生才能查看此次签到
//        存储发起签到的时间，并计时，40分钟后强制关闭
        Map<String, Object> resultMap = new HashMap<>();
        String lessonId = (String) paramsMap.get("lessonId");
        //获取没有被用的签到id
        CodeRecord codeRecord = codeRecordMapper.selectByPrimaryKey(1);
        int codeIndex = codeRecord.getCodeIndex();
        //记录加1
        if (codeIndex >= 30000) {
            codeRecord.setCodeIndex(5);
            codeRecord.setId(1);
        } else {
            codeRecord.setCodeIndex(codeIndex + 1);
            codeRecord.setId(1);
        }
        codeRecordMapper.updateByPrimaryKey(codeRecord);
        TeaSign teaSign = new TeaSign();
        CodeUuid codeUuid = codeUuidMapper.selectByPrimaryKey(codeIndex);
        logger.error(codeIndex + "codeIndex获取得到的code编号===========TeaSignServiceImpl");
        //把状态置为1
        codeUuid.setStatus((byte) 1);
        codeUuidMapper.updateByPrimaryKey(codeUuid);
        String signId = codeUuid.getId().toString();
        String signPassword = codeUuid.getCode();
        System.out.println("signId" + signId);
        //生成签到
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        String nowTime = simpleDateFormat.format(calendar.getTime());
        teaSign.setBeginTime(nowTime);
        teaSign.setSignId(signId);
        teaSign.setLessonId((String) paramsMap.get("lessonId"));
        teaSign.setClasssId((String) paramsMap.get("classId"));
        teaSign.setTeaId((String) paramsMap.get("teaId"));
        teaSign.setWeeks((String) paramsMap.get("weeks"));
        teaSign.setStatus(1);//状态
        int flag = teaSignMapper.insertSelective(teaSign);
        System.out.println("flag" + flag);
        if (flag != 0) {
            System.out.println("lessonId" + lessonId);
            //根据教学班id获取学生学号信息
            List<StuInfo> stuInfos = JwzxUtil.classStuList(lessonId, "lesson");
            session.setAttribute("stuInfos", stuInfos);
            List<String> stuIdInfos = new ArrayList<>();
            for (StuInfo stuInfo : stuInfos) {
                stuIdInfos.add(stuInfo.getStuId());
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
            //将点名的学生数据存到缓存中
            boolean bl =true;
            EhcacheUtil.getInstance().put("mobileCache",signPassword,stuInfosMap,40*60*1000);
            //添加教师点名信息和口令的映射,信息之间用分号隔开
            String infoKey = (paramsMap.get("teaId")+";"+paramsMap.get("lessonId")+";"+paramsMap.get("weeks")+";"+paramsMap.get("classId")).trim();
            boolean bl2=true;
//                    redisUtil.set(infoKey,signPassword,20*60*1000l);
            EhcacheUtil.getInstance().put("mobileCache",infoKey,signPassword,40*60&1000);
            resultMap.put("signId", signId);
            resultMap.put("signPassword", signPassword);
//            resultMap.put("signStatus", teaSign.getStatus());
//            resultMap.put("beginTime", nowTime);

            if (bl == true&&bl2==true) {
                //记录到日志
                SignLog signLog = new SignLog();
                signLog.setUserId((String) paramsMap.get("teaId"));
                signLog.setClassId((String) paramsMap.get("classId"));
                signLog.setLessonId((String) paramsMap.get("lessonId"));
                signLog.setSignPassword(signPassword);
                signLog.setSignTime(nowTime);
                signLog.setWeeks((String) paramsMap.get("weeks"));
                signLogMapper.insertSelective(signLog);
                return ResponseUtil.setResponse(200, "OK", resultMap);
            } else {
                return ResponseUtil.setResponse(5008, "获取学生数据失败", null);
            }
        } else {
            return ResponseUtil.setResponse(5004, "签到生成失败", null);
        }
    }

    @Override
    public ResponseData joinTeaSign(Map<String, Object> paramsMap, HttpSession session) {

        String stuId = (String) paramsMap.get("stuId");
        //String signId = (String) paramsMap.get("signId");
        String signPassword = (String) paramsMap.get("signPassword");

        /*
        根据signPassword判断签到是否失效
         */
        TeaSign bteaSign = null;
        CodeUuidExample codeUuidExample = new CodeUuidExample();
        codeUuidExample.createCriteria().andCodeEqualTo(signPassword);
        List<CodeUuid> codeUuid = codeUuidMapper.selectByExample(codeUuidExample);
        //口令错误
        if (codeUuid.isEmpty()) {
            return ResponseUtil.setResponse(5004, "口令输入错误", null);
        } else {
            TeaSignExample teaSignExample = new TeaSignExample();
            teaSignExample.createCriteria().andSignIdEqualTo(codeUuid.get(0).getId().toString());
            List<TeaSign> teaSignList = teaSignMapper.selectByExample(teaSignExample);
            //遍历
            for (TeaSign teaSign : teaSignList) {
                if (teaSign.getStatus() == 1) {
                    bteaSign = teaSign;
                }
            }
            if (bteaSign == null) {
                return ResponseUtil.setResponse(5004, "签到已失效", null);
            }
        }
        int flag = 0;
        if(!(EhcacheUtil.getInstance().get("mobileCache",signPassword)==null)) {
        //获取缓存中的签到信息集合
            Map<Object,Object> signInfoMap = (Map<Object, Object>) EhcacheUtil.getInstance().get("mobileCache",signPassword);

            //获取学生的签到状态,判断学生是否在该集合中
            int stuStatus;
            if(signInfoMap.get(stuId)!=null){
             stuStatus = (int) signInfoMap.get(stuId);
            }else{
                return ResponseUtil.setResponse(5004, "口令输入错误或者签到失败", null);
            }
            //获取签到人数
            int signNums= (int) signInfoMap.get("signNums");
            //状态判断
            if(stuStatus==1){
                flag=2;//重复签到
            }else{
                //更新签到状态
                signInfoMap.put(stuId,1);
                signInfoMap.put("signNums",signNums+1);
                flag=1;//签到成功
            }


//        if (!(redisUtil.getHashKey(signPassword, stuId) == null)) {
//            //获取缓存中map集合中的value
//            int stuStatus = (int) redisUtil.getHashKey(signPassword, stuId);
//            //获取nums
//            int signNums = (int) redisUtil.getHashKey(signPassword, "signNums");
//            if (stuStatus == 1) {
//                flag = 2;//重复签到
//            } else {
//                //更新
//                redisUtil.updataHash(signPassword, stuId, 1);
//                redisUtil.updataHash(signPassword, "signNums", signNums + 1);
//                flag = 1;//成功签到
//            }
            session.setAttribute("signNums", signNums + 1);
            if (flag == 1) {
                //记录日志
                SignLog signLog = new SignLog();
                signLog.getSignPassword(signPassword);
                signLog.setUserId(stuId);
//                Integer signId=LogUtil.getSignId(signPassword);
                CodeUuidExample codeUuidExample2 = new CodeUuidExample();
                codeUuidExample.createCriteria().andCodeEqualTo(signPassword);
                List<CodeUuid> codeUuid2 =  codeUuidMapper.selectByExample(codeUuidExample);
                TeaSignExample teaSignExample = new TeaSignExample();
                Integer signId=codeUuid2.get(0).getId();
                teaSignExample.createCriteria().andSignIdEqualTo(signId.toString()).andStatusEqualTo(1);
                List<TeaSign> signList = teaSignMapper.selectByExample(teaSignExample);
                signLog.setWeeks(signList.get(0).getWeeks());
                signLog.setLessonId(signList.get(0).getLessonId());
                signLog.setClassId(signList.get(0).getClasssId());
                //获取当前时间
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Calendar calendar = Calendar.getInstance();
                signLog.setSignTime(simpleDateFormat.format(calendar.getTime()));
                return ResponseUtil.setResponse(200, "OK", bteaSign);
            } else {
                return ResponseUtil.setResponse(5005, "重复签到", null);
            }
        } else {
            return ResponseUtil.setResponse(5004, "口令输入错误或者签到", null);
        }
    }

    @Override
    public ResponseData endSign(Map<String, Object> paramsMap) {
        String teaId = (String) paramsMap.get("teaId");
        String signId = (String) paramsMap.get("signId");
        String lessonId = (String) paramsMap.get("lessonId");
        String signPassword = (String) paramsMap.get("signPassword");
        String classId = (String) paramsMap.get("classId");

        String weeks = null;
        String weeksDay = null;
        if (((String) paramsMap.get("weeks")) == null || ((String) paramsMap.get("weeksDay")) == null) {
            weeks = "0";
            weeksDay = "0";

        } else {
            weeks = (String) paramsMap.get("weeks");
            weeksDay = (String) paramsMap.get("weeksDay");
        }

         /*
        参数：教师id,签到id,课程id,签到口令，周数weeks，星期数days
        动作;
            1.根据参数将签到状态置为0，
            2.根据签到口令找到对应的缓存数据
            3.根据签到口令统计签到人数情况及学号，并存入数据库中
            4.返回签到情况
         */
        //状态置为0
        TeaSignExample teaSignExample = new TeaSignExample();
        teaSignExample.createCriteria().andSignIdEqualTo(signId).andTeaIdEqualTo(teaId).andLessonIdEqualTo(lessonId).andClasssIdEqualTo(classId);
        TeaSign teaSign = new TeaSign();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        teaSign.setStatus(0);
        teaSign.setEndTime(simpleDateFormat.format(calendar.getTime()));
        int tb = teaSignMapper.updateByExampleSelective(teaSign, teaSignExample);
        logger.error(tb + "teaSign=============TeaSignServiceImpl");
        //释放codeUuid
        CodeUuidExample codeUuidExample = new CodeUuidExample();
        codeUuidExample.createCriteria().andCodeEqualTo(signPassword);
        CodeUuid codeUuid = new CodeUuid();
        codeUuid.setStatus((byte) 0);
        int bl = codeUuidMapper.updateByExampleSelective(codeUuid, codeUuidExample);
        logger.error(bl + "codeUuid=============TeaSignServiceImpl");
        int changeId = Integer.valueOf(signId);
        if (changeId >= 30000) {
            changeId = 5;
        } else {
            changeId = changeId + 1;
            System.out.println(changeId);
        }
        CodeRecord codeRecord = new CodeRecord();
        codeRecord.setId(1);
        codeRecord.setCodeIndex(changeId);
        codeRecordMapper.updateByPrimaryKey(codeRecord);
        logger.error(changeId + "更新后的code编号changeId===========================TeaSignServiceImpl");
        //移除缓存的教师ID
        String infoKey=null;
        if(weeks!="0") {
             infoKey = (paramsMap.get("teaId") + ";" + paramsMap.get("lessonId") + ";" + paramsMap.get("weeks") + ";" + paramsMap.get("classId")).trim();//后期添加ClassId            redisUtil.remove(infoKey);
        }else{
            infoKey=(paramsMap.get("teaId") + ";" +paramsMap.get("classId")).trim();
        }
        EhcacheUtil.getInstance().remove("mobileCache",infoKey);
        //获取缓存中的数据
//        Map<Object, Object> stuIdMap = (Map<Object, Object>) redisUtil.getHashKeys(signPassword);
        Map<Object,Object> stuIdMap = (Map<Object, Object>) EhcacheUtil.getInstance().get("mobileCache",signPassword);
        EhcacheUtil.getInstance().remove("mobileCache",signPassword);

        logger.error(stuIdMap + "======================TeaSignServiceImpl");
        if(stuIdMap!=null){
        //List<String> unSignList = new ArrayList<>();
        Map<String, Object> unSignMap = new HashMap<>();
        //取出signNums
        stuIdMap.remove("signNums");
        Set<Object> set = stuIdMap.keySet();
        for (Iterator<Object> iterator = set.iterator(); iterator.hasNext(); ) {
            String stuId = (String) iterator.next();
            //区分班级签到和学生签到
            Object value=-1;
            if(weeks=="0") {
                value =  stuIdMap.get(stuId);
            }else{
                value=stuIdMap.get(stuId);
            }
            if ("0".equals(value)||value.equals(0)) {
                unSignMap.put(stuId, 0);
            }
        }
        String weeksAll = weeks + ";" + weeksDay;
        int flag = -1;
        //非空判断
        if (unSignMap != null) {
            logger.error(unSignMap + "未到学生名单=============TeaSignServiceImpl,");
            //数据处理
//            StringBuffer sb = new StringBuffer();
//            for (String stuId : unSignList) {
//                sb = sb.append(stuId + ";");
//            }
//            String stuIds = null;
//            if (sb.lastIndexOf(";") != -1) {
//                stuIds = sb.substring(0, stuIds.lastIndexOf(";"));
//            }
//            logger.error(stuIds + "===========未签到学生id====TeaSignServiceImpl");
            String stuIds = JSON.toJSONString(unSignMap);
            //存入数据库
            TeaSignStatistic teaSignStatistic = new TeaSignStatistic();
            teaSignStatistic.setSignId(signId);
            teaSignStatistic.setLessonId(lessonId);
            teaSignStatistic.setTeaId(teaId);
            teaSignStatistic.setUnsignId(stuIds);
            teaSignStatistic.setUnsignNum(unSignMap.size());
            teaSignStatistic.setWeeks(weeksAll);
            flag = teaSignStatisticMapper.insertSelective(teaSignStatistic);
        } else {
            TeaSignStatistic teaSignStatistic = new TeaSignStatistic();
            teaSignStatistic.setSignId(signId);
            teaSignStatistic.setLessonId(lessonId);
            teaSignStatistic.setTeaId(teaId);
            teaSignStatistic.setUnsignId(null);
            teaSignStatistic.setUnsignNum(0);
            flag = teaSignStatisticMapper.insertSelective(teaSignStatistic);
        }
        if (flag != -1) {
            //获取该教学班的信息
            //暂时用lessonId的长度来判断是是行政班还是教学班
            List<StuInfo> stuInfos = new ArrayList<>();
            if (lessonId.length() > 10) {
                stuInfos = JwzxUtil.classStuList(lessonId, "lesson");
            } else {
                stuInfos = stuInfoService.selectByClassId(lessonId);
            }
            List<Map<String, Object>> stuInfoList = new ArrayList<>();
            for (StuInfo stuInfo : stuInfos) {
                Map<String, Object> stuInfoMap = new HashMap<>();
                stuInfoMap.put("xh", stuInfo.getStuId());
                stuInfoMap.put("name", stuInfo.getName());
                stuInfoMap.put("class", stuInfo.getClassId());
                if (unSignMap.containsKey(stuInfo.getStuId())) {
                    stuInfoMap.put("status", "0");
                } else {
                    stuInfoMap.put("status", "1");
                }
                stuInfoList.add(stuInfoMap);
            }

//   List<Object> lessonStuids = Arrays.asList((Object) set);
            return ResponseUtil.setResponse(200, "OK", stuInfoList);
        } else {
            return ResponseUtil.setResponse(5005, "签到结束异常", null);
        }}else{
            return  ResponseUtil.setResponse(5008,"没有创建该签到",null);
        }


    }

    @Override
    public void setUuidCodes() {
        for (int i1 = 0; i1 < 10; i1++) {
            for (int i2 = 0; i2 < 10; i2++) {
                if (i2 == i1) {
                    continue;
                }
                for (int i3 = 0; i3 < 10; i3++) {
                    if (i3 == i2 || i3 == i1) {
                        continue;
                    }
                    for (int i4 = 0; i4 < 10; i4++) {
                        if (i4 == i3 || i4 == i2 || i4 == i1) {
                            continue;
                        }
                        for (int i5 = 0; i5 < 10; i5++) {
                            if (i5 == i4 || i5 == i3 || i5 == i2 || i5 == i1) {
                                continue;
                            }
                            System.out.println(String.valueOf(i1) + String.valueOf(i2) + String.valueOf(i3) + String.valueOf(i4) + String.valueOf(i5));
                            String uuidCode = String.valueOf(i1) + String.valueOf(i2) + String.valueOf(i3) + String.valueOf(i4) + String.valueOf(i5);
                            CodeUuid codeUuid = new CodeUuid();
                            codeUuid.setCode(uuidCode);
                            codeUuid.setStatus((byte) 0);
                            codeUuidMapper.insertSelective(codeUuid);
                        }
                    }
                }
            }
        }
    }

    @Override
    public ResponseData getSignNums(String signPassword) {
//        Map<Object, Object> stuInfosMap = redisUtil.getHashKeys(signPassword);
        Map<Object, Object> stuInfosMap= (Map<Object, Object>) EhcacheUtil.getInstance().get("mobileCache",signPassword);
        if (!stuInfosMap.isEmpty()) {
            return ResponseUtil.setResponse(200, "Ok", stuInfosMap);
        } else {
            return ResponseUtil.setResponse(5004, "学生信息为空", null);
        }
    }

}
