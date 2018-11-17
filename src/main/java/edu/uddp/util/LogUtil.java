package edu.uddp.util;

import edu.uddp.mapper.CodeUuidMapper;
import edu.uddp.mapper.SignLogMapper;
import edu.uddp.mapper.TeaSignMapper;
import edu.uddp.model.CodeUuid;
import edu.uddp.model.CodeUuidExample;
import edu.uddp.model.SignLog;
import edu.uddp.model.TeaSignExample;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日志工具类
 */
public class LogUtil {
    @Resource
    private static SignLogMapper signLogMapper;
   @Resource
   private static CodeUuidMapper codeUuidMapper;
    //添加日志
    public  void setLog(SignLog signLog){
        signLogMapper.insertSelective(signLog);
    }
    //signPassword找signId
    public  int getSignId(String signPassword){
        CodeUuidExample codeUuidExample = new CodeUuidExample();
        codeUuidExample.createCriteria().andCodeEqualTo(signPassword);
        List<CodeUuid> codeUuid =  codeUuidMapper.selectByExample(codeUuidExample);
        return codeUuid.get(0).getId();
    }
}
