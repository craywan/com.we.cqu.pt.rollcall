package edu.uddp.service;


import edu.uddp.vo.ResponseData;

import javax.servlet.http.HttpSession;
import java.util.*;

public interface ClassSignService {
    ResponseData creatClassSign(String classId,String stuId);
    ResponseData endClassSign(Map<String,Object> paramsMap);
    ResponseData joinClassSign(Map<String,Object> paramsMap,HttpSession session);
}
