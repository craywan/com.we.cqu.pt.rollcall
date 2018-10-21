package edu.uddp.mapper;

import edu.uddp.model.RollcallLesson;
import edu.uddp.model.RollcallLessonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RollcallLessonMapper {
    long countByExample(RollcallLessonExample example);

    int deleteByExample(RollcallLessonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RollcallLesson record);

    int insertSelective(RollcallLesson record);

    List<RollcallLesson> selectByExample(RollcallLessonExample example);

    List<RollcallLesson> selectByStatus(String status);

    RollcallLesson selectByKey(String key);

    RollcallLesson selectByLessonId(String lessonId);

    int updateByExampleSelective(@Param("record") RollcallLesson record, @Param("example") RollcallLessonExample example);

    int updateByExample(@Param("record") RollcallLesson record, @Param("example") RollcallLessonExample example);

    int updateByPrimaryKeySelective(RollcallLesson record);

    int updateByPrimaryKey(RollcallLesson record);

    int updateByLessonIdSelective(RollcallLesson record);
}