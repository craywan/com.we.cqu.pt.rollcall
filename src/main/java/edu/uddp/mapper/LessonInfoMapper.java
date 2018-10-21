package edu.uddp.mapper;

import edu.uddp.model.LessonInfo;
import edu.uddp.model.LessonInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LessonInfoMapper {
    long countByExample(LessonInfoExample example);

    int deleteByExample(LessonInfoExample example);

    int insert(LessonInfo record);

    int insertSelective(LessonInfo record);

    List<LessonInfo> selectByExample(LessonInfoExample example);

    List<LessonInfo> selectByTeacherId(String teacherId);

    List<LessonInfo> selectBySome(String s);

    int updateByExampleSelective(@Param("record") LessonInfo record, @Param("example") LessonInfoExample example);

    int updateByExample(@Param("record") LessonInfo record, @Param("example") LessonInfoExample example);
}