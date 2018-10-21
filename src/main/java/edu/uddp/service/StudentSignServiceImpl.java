package edu.uddp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.uddp.mapper.TeaSignStatisticMapper;
import edu.uddp.model.TeaSignStatistic;
import edu.uddp.model.TeaSignStatisticExample;
import edu.uddp.util.ResponseUtil;
import edu.uddp.vo.ResponseData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class StudentSignServiceImpl implements StudentSignService{
    private static final Logger logger = Logger.getLogger(StudentSignServiceImpl.class);
    @Resource
    private TeaSignStatisticMapper teaSignStatisticMapper;
    @Override
    public ResponseData signHistory(List<String> lessonList,int page,int rows) {
        PageHelper.startPage(page,rows);
        List<TeaSignStatistic> signStatisticLists = (List<TeaSignStatistic>) teaSignStatisticMapper.selectByLimit(lessonList);
        if(signStatisticLists.size()!=0) {
            //分页
            PageInfo<TeaSignStatistic> pageInfo = new PageInfo<>(signStatisticLists);
            long endPage = pageInfo.getTotal();
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("resultList", signStatisticLists);
            resultMap.put("total", endPage);
            logger.error(signStatisticLists.toString()+"signStatisticLists=========================StudentSignServiceImpl");
            logger.error(endPage+"total======================StudentSignServiceImpl");
            ResponseUtil.setResponse(200, "OK", resultMap);
        } else{
          ResponseUtil.setResponse(5003,"没有历史数据",null);
        }






        return null;
    }
}
