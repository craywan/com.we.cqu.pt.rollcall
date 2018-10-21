package edu.uddp.service;

import edu.uddp.model.LessonInfo;
import edu.uddp.model.LessonInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rollcall
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-08
 **/
@Service
public class LessonInfoServiceImpl implements LessonInfoService {
    @Autowired
    edu.uddp.mapper.LessonInfoMapper LessonInfoMapper;

    @Override
    public List<LessonInfo> selectAll() {
        LessonInfoExample example = new LessonInfoExample();
        List<LessonInfo> LessonInfos = LessonInfoMapper.selectByExample(example);
        return LessonInfos;
    }

    @Override
    public List<LessonInfo> selectBySome(String s) {
        List<LessonInfo> lessonInfos = LessonInfoMapper.selectBySome(s);
        return lessonInfos;
    }

    @Override
    public List<LessonInfo> selectByTeacherId(String teacherId) {
        return LessonInfoMapper.selectByTeacherId(teacherId);
    }
}
