package edu.uddp.service;

import edu.uddp.vo.ResponseData;
import java.util.*;

public interface TeaSignRecordService {
    /**
     * 获取具体的某次签到的信息
     * @param paramsMap
     * @return
     */
    ResponseData selectSignRecord(Map<String,Object> paramsMap);

    /**
     * 更新数据
     * @param paramsMap
     * @return
     */
    ResponseData updateSignRecord(Map<String,Object> paramsMap);
}
