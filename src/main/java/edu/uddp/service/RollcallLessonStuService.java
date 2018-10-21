package edu.uddp.service;

import edu.uddp.model.RollcallLessonStu;

import java.util.List;

public interface RollcallLessonStuService {
    void insert(RollcallLessonStu rollcallLessonStu);

    List<RollcallLessonStu> showByLessonId(String lessonId);

    List<RollcallLessonStu> showByKey(String lessonNo);
}
