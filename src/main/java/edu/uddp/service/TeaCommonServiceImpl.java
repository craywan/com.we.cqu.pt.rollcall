package edu.uddp.service;

import edu.uddp.mapper.JssjMapper;
import edu.uddp.model.Jssj;
import edu.uddp.model.JssjExample;
import edu.uddp.util.JwzxUtil;
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
 * @author wanzh
 */
@Service
public class TeaCommonServiceImpl implements TeaCommonService {
    private Logger looger = Logger.getLogger(TeaCommonServiceImpl.class);
   @Resource
   private JssjMapper jssjMapper;
    @Override
    public ResponseData getTeaInfo(String teaId) {
        Map<String,Object> resultMap = new HashMap<>();
        JssjExample jssjExample = new JssjExample();
        jssjExample.createCriteria().andJsghEqualTo(teaId);
        List<Jssj> teaInfos=jssjMapper.selectByExample(jssjExample);
        if(teaInfos.size()!=0){
            //获取当前周数
            Set<String> resultSet = JwzxUtil.getkbHtml(teaInfos.get(0).getJsbh(),"week");
            looger.error(resultSet.toString()+"week===================TeaCommonServiceImpl");
            resultMap.put("teaInfos",teaInfos);
            String week=null;
            for (String weeks:resultSet) {
                week=weeks;
            }
            resultMap.put("week",week);
            return ResponseUtil.setResponse(200,"OK",resultMap);
        }else{
            return ResponseUtil.setResponse(5008,"教师编号未在本库中找到",null);
        }
    }

}
