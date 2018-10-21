package edu.uddp.service;

import edu.uddp.mapper.LessonsMapper;
import edu.uddp.model.Lessons;
import edu.uddp.model.LessonsExample;
import edu.uddp.util.ResponseUtil;
import edu.uddp.vo.ResponseData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@Service
public class LuceneSerchServiceImpl implements LuceneSerchService {
    @Resource
    private LessonsMapper lessonsMapper;


    @Override
    public ResponseData serchCourses(String serchContext) {
        System.out.println(serchContext);
        LessonsExample lessonsExample = new LessonsExample();
        //LessonsExample.Criteria criteria = lessonsExample.createCriteria();
        lessonsExample.or().andBjEqualTo(serchContext);
        lessonsExample.or().andKcmcEqualTo(serchContext);
        lessonsExample.or().andJsEqualTo(serchContext);
        lessonsExample.or().andJiaosEqualTo(serchContext);
        List<Lessons> lessonsList = lessonsMapper.selectByExample(lessonsExample);
        System.out.println(lessonsList.toString());
        if (!lessonsList.isEmpty()) {
           return  ResponseUtil.setResponse(200, "OK", lessonsList);
        } else {
            //模糊查询
            Lessons lessons = new Lessons();
            lessons.setBj(serchContext);
            lessons.setKcmc(serchContext);
            lessons.setJs(serchContext);
            lessons.setJiaos(serchContext);
            List<Lessons> likeList = lessonsMapper.selectLikes(lessons);
            if (likeList.isEmpty()) {
                return ResponseUtil.setResponse(5004, "没有查询的数据", null);
            } else {
             return   ResponseUtil.setResponse(5005, "相似数据", likeList);
            }
        }
    }
}