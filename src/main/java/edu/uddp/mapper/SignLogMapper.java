package edu.uddp.mapper;

import edu.uddp.model.SignLog;
import edu.uddp.model.SignLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SignLogMapper {
    int countByExample(SignLogExample example);

    int deleteByExample(SignLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SignLog record);

    int insertSelective(SignLog record);

    List<SignLog> selectByExample(SignLogExample example);

    SignLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SignLog record, @Param("example") SignLogExample example);

    int updateByExample(@Param("record") SignLog record, @Param("example") SignLogExample example);

    int updateByPrimaryKeySelective(SignLog record);

    int updateByPrimaryKey(SignLog record);
}