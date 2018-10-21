package edu.uddp.mapper;

import edu.uddp.model.Lessons;
import edu.uddp.model.LessonsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonsMapper {
    int countByExample(LessonsExample example);

    int deleteByExample(LessonsExample example);

    int insert(Lessons record);

    int insertSelective(Lessons record);

    List<Lessons> selectByExample(LessonsExample example);

    List<Lessons> selectAll();

    List<Lessons> selectLikes(Lessons lessons);

    int updateByExampleSelective(@Param("record") Lessons record, @Param("example") LessonsExample example);

    int updateByExample(@Param("record") Lessons record, @Param("example") LessonsExample example);
}