package edu.uddp.service;

import edu.uddp.model.RollcallLesson;

import java.util.List;

public interface RollcallLessonService {

    List<RollcallLesson> showIng();

    void insert(RollcallLesson rollcallLesson);

    void updateStatusByLessonId(RollcallLesson rollcallLesson);

    RollcallLesson showByKey(String key);

    RollcallLesson showByLessonId(String lessonId);
}