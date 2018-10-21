package edu.uddp.service;

import edu.uddp.model.LessonInfo;

import java.util.List;

public interface LessonInfoService {
    /** 
    * @Description: 展示所有课程信息
    * @Param: [] 
    * @return: java.util.List<edu.uddp.model.LessonInfo>
    * @Date: 2018/8/9
    */ 
    List<LessonInfo> selectAll();

    /** 
    * @Description: 多条件模糊查询课程
    * @Param: [lessonId, name, teacherName] 
    * @return: java.util.List<edu.uddp.model.LessonInfo>
    * @Date: 2018/8/10
    */
    List<LessonInfo> selectBySome(String s);


    List<LessonInfo> selectByTeacherId(String teacherId);
}
