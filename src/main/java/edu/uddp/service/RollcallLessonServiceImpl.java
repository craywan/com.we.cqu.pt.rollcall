package edu.uddp.service;

import edu.uddp.mapper.RollcallLessonMapper;
import edu.uddp.model.RollcallLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rollcall
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-10
 **/
@Service
public class RollcallLessonServiceImpl implements RollcallLessonService {
    @Autowired
    RollcallLessonMapper rollcallLessonMapper;

    @Override
    public List<RollcallLesson> showIng() {
        String status = "1";
        return rollcallLessonMapper.selectByStatus(status);
    }

    @Override
    public void insert(RollcallLesson rollcallLesson) {
        rollcallLessonMapper.insert(rollcallLesson);
    }

    @Override
    public void updateStatusByLessonId(RollcallLesson rollcallLesson) {
        rollcallLessonMapper.updateByLessonIdSelective(rollcallLesson);
    }

    @Override
    public RollcallLesson showByKey(String key) {
        if(rollcallLessonMapper.selectByKey(key) != null) {
            return rollcallLessonMapper.selectByKey(key);
        }
        return null;
    }

    @Override
    public RollcallLesson showByLessonId(String lessonId) {
        return rollcallLessonMapper.selectByLessonId(lessonId);
    }
}
