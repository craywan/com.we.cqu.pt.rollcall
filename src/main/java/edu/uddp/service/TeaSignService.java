package edu.uddp.service;

import java.util.*;
import edu.uddp.vo.ResponseData;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpSession;

public interface TeaSignService {
    ResponseData selectCourses(String teaId);
    ResponseData CreatSign(Map<String,Object> paramsMap, HttpSession session);
    ResponseData joinTeaSign(Map<String,Object> paramsMap,HttpSession session);
    ResponseData endSign(Map<String,Object> paramsMap);
    void setUuidCodes();
    ResponseData getSignNums(String signPassword);

}
