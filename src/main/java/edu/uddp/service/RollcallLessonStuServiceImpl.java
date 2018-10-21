package edu.uddp.service;

import edu.uddp.mapper.RollcallLessonStuMapper;
import edu.uddp.model.RollcallLessonStu;
import edu.uddp.util.JwzxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rollcall-ai
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-27
 **/
@Service
public class RollcallLessonStuServiceImpl implements RollcallLessonStuService {
    @Autowired
    RollcallLessonStuMapper rollcallLessonStuMapper;

    @Override
    public void insert(RollcallLessonStu rollcallLessonStu) {
        rollcallLessonStuMapper.insert(rollcallLessonStu);
    }

    @Override
    public List<RollcallLessonStu> showByLessonId(String lessonId) {
        return JwzxUtil.classStuList(lessonId,"lesson");
    }

    @Override
    public List<RollcallLessonStu> showByKey(String key) {
        return rollcallLessonStuMapper.selectByKey(key);
    }
}
