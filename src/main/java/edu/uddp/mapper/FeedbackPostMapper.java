package edu.uddp.mapper;

import java.util.List;

import edu.uddp.model.FeedbackPost;
import edu.uddp.model.FeedbackPostExample;
import org.apache.ibatis.annotations.Param;

public interface FeedbackPostMapper {
    long countByExample(FeedbackPostExample example);

    int deleteByExample(FeedbackPostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FeedbackPost record);

    int insertSelective(FeedbackPost record);

    List<FeedbackPost> selectByExample(FeedbackPostExample example);

    FeedbackPost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FeedbackPost record, @Param("example") FeedbackPostExample example);

    int updateByExample(@Param("record") FeedbackPost record, @Param("example") FeedbackPostExample example);

    int updateByPrimaryKeySelective(FeedbackPost record);

    int updateByPrimaryKey(FeedbackPost record);
}