package edu.uddp.service;

import com.alibaba.fastjson.JSON;
import edu.uddp.mapper.TeaSignStatisticMapper;
import edu.uddp.model.TeaSignStatistic;
import edu.uddp.model.TeaSignStatisticExample;
import edu.uddp.util.ResponseUtil;
import edu.uddp.vo.ResponseData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class TeaSignRecordServiceImpl implements TeaSignRecordService{
    private Logger logger = Logger.getLogger(TeaSignRecordServiceImpl.class);
    @Resource
    private TeaSignStatisticMapper teaSignStatisticMapper;
    @Override
    public ResponseData selectSignRecord(Map<String, Object> paramsMap) {
        String weeks = (String) paramsMap.get("weeks");
        String weeksDay = (String) paramsMap.get("weeksDay");
        String allWeeks = weeks + ";" + weeksDay;
        TeaSignStatistic teaSignStatistic = new TeaSignStatistic();
//        teaSignStatistic.setWeeks(allWeeks);
//        teaSignStatistic.setTeaId((String) paramsMap.get("teaId"));
//        teaSignStatistic.setLessonId((String) paramsMap.get("lessonId"));
        TeaSignStatisticExample teaSignStatisticExample = new TeaSignStatisticExample();
        teaSignStatisticExample.createCriteria().andWeeksEqualTo(allWeeks).andTeaIdEqualTo((String) paramsMap.get("teaId")).andLessonIdEqualTo((String) paramsMap.get("lessonId"));
        List<TeaSignStatistic> teaSignStatisticList = teaSignStatisticMapper.selectByExample(teaSignStatisticExample);
        Map<String, Object> unSignMap = new HashMap<String, Object>();
        String unSignString = teaSignStatisticList.get(teaSignStatisticList.size() - 1).getUnsignId();
        unSignMap = JSON.parseObject(unSignString);
        logger.error(unSignString+"================TeaSignRecordServiceImpl");
        int unsignNum = teaSignStatisticList.get(teaSignStatisticList.size() - 1).getUnsignNum();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("unsignMap", unSignMap);
        resultMap.put("unsignNum", unsignNum);
        return ResponseUtil.setResponse(200, "OK", resultMap);
    }

    @Override
    public ResponseData updateSignRecord(Map<String, Object> paramsMap) {
        String weeks = (String) paramsMap.get("weeks");
        String weeksDay = (String) paramsMap.get("weeksDay");
        String allWeeks = weeks + ";" + weeksDay;
        TeaSignStatistic teaSignStatistic = new TeaSignStatistic();
        teaSignStatistic.setUnsignId((String) paramsMap.get("changeMap"));
        teaSignStatistic.setUnsignNum((Integer) paramsMap.get("changeUnsignNum"));
        TeaSignStatisticExample teaSignStatisticExample = new TeaSignStatisticExample();
        teaSignStatisticExample.createCriteria().andWeeksEqualTo(allWeeks).andTeaIdEqualTo((String) paramsMap.get("teaId")).andLessonIdEqualTo((String) paramsMap.get("lessonId"));
        int bl=teaSignStatisticMapper.updateByExampleSelective(teaSignStatistic,teaSignStatisticExample);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("unsignMap",paramsMap.get("changeMap"));
        resultMap.put("unsignNum",paramsMap.get("changeUnsignNum"));
        if(bl!=-1){
            return ResponseUtil.setResponse(200,"OK",resultMap);
        }else{
         return ResponseUtil.setResponse(5005,"数据更新失败",null);
        }
    }
}
