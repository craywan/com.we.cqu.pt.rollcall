package edu.uddp.service;

import edu.uddp.mapper.RollcallLessonStuHistoryMapper;
import edu.uddp.model.RollcallLessonStuHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rollcall-ai
 * @description:
 * @author: yangxinyu
 * @create: 2018-09-21
 **/
@Service
public class RollcallLessonStuHistoryServiceImpl implements RollcallLessonStuHistoryService {
    @Autowired
    RollcallLessonStuHistoryMapper rollcallLessonStuHistoryMapper;

    @Override
    public void insert(RollcallLessonStuHistory rollcallLessonStuHistory) {
        rollcallLessonStuHistoryMapper.insert(rollcallLessonStuHistory);
    }

    @Override
    public List<RollcallLessonStuHistory> showByLessonId(String lessonId) {
        List<RollcallLessonStuHistory> stuHistories = rollcallLessonStuHistoryMapper.selectByLessonId(lessonId);
        return stuHistories;
    }

    @Override
    public void insertList(List<RollcallLessonStuHistory> lessonStuHistories) {
        rollcallLessonStuHistoryMapper.insertList(lessonStuHistories);
    }

    @Override
    public void delete(RollcallLessonStuHistory rollcallLessonStuHistory) {
        rollcallLessonStuHistoryMapper.delete(rollcallLessonStuHistory);
    }
}
