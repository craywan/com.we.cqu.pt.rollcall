package edu.uddp.util;

import com.alibaba.fastjson.JSON;
import edu.uddp.vo.ResponseData;

public class ResponseUtil {
    /**
     * 返回数据
     * @param status
     * @param message
     * @param result
     * @return
     */
    public static ResponseData setResponse(int status, String message, Object result){
        ResponseData responseData = new ResponseData();
        responseData.setData(result);
        responseData.setMessagge(message);
        responseData.setStatus(status);
        //String ResponseJson = JSON.toJSONString(responseData);
        return responseData;
    }
}
