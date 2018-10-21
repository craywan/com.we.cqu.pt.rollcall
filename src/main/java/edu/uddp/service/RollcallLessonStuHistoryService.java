package edu.uddp.service;

import edu.uddp.model.RollcallLessonStuHistory;

import java.util.List;

/**
 * @program: rollcall-ai
 * @description:
 * @author: yangxinyu
 * @create: 2018-09-21
 **/
public interface RollcallLessonStuHistoryService {

    void insert(RollcallLessonStuHistory rollcallLessonStuHistory);

    List<RollcallLessonStuHistory> showByLessonId(String lessonId);

    void insertList(List<RollcallLessonStuHistory> lessonStuHistories);

    void delete(RollcallLessonStuHistory rollcallLessonStuHistory);
}

