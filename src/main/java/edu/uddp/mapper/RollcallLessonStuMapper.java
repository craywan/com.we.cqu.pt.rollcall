package edu.uddp.mapper;

import edu.uddp.model.RollcallLessonStu;
import edu.uddp.model.RollcallLessonStuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RollcallLessonStuMapper {
    long countByExample(RollcallLessonStuExample example);

    int deleteByExample(RollcallLessonStuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RollcallLessonStu record);

    int insertSelective(RollcallLessonStu record);

    List<RollcallLessonStu> selectByExample(RollcallLessonStuExample example);

    List<RollcallLessonStu> selectByLessonId(String LessonId);

    List<RollcallLessonStu> selectByKey(String key);

    int updateByExampleSelective(@Param("record") RollcallLessonStu record, @Param("example") RollcallLessonStuExample example);

    int updateByExample(@Param("record") RollcallLessonStu record, @Param("example") RollcallLessonStuExample example);

    int updateByPrimaryKeySelective(RollcallLessonStu record);

    int updateByPrimaryKey(RollcallLessonStu record);
}