package edu.uddp.service;

import edu.uddp.model.StuInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rollcall
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-08
 **/
public interface StuInfoService {
    
    /** 
    * @Description: 根据课程编号查询学生信息
    * @Param:  
    * @return:  
    * @Date: 2018/8/14
    */ 
    List<StuInfo> selectByClassId(String stuClass);

//    /**
//    * @Description: 以List的形式向数据库插入学生列表
//    * @Param: [list]
//    * @return: void
//    * @Date: 2018/8/14
//    */
//    void insertStuList(List list);

    StuInfo selectByStuId(String stuId);

    List<StuInfo> selectByLessonId(String stuLesson);
}
