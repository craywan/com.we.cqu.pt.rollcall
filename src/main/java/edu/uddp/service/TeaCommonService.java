package edu.uddp.service;

import edu.uddp.vo.ResponseData;
import java.util.*;

public interface TeaCommonService {
    ResponseData getTeaInfo(String teaId);
    ResponseData getClassInfo(String stuId);
    //判断点名是否正在进行。若在进行则返回正在进行的点名
    String judgeSign(Map<String,Object> paramsMap);
    //获取已经创建的签到
    ResponseData getAlreadySign(String signPassword,Map<String,Object> paramsMap);
}
