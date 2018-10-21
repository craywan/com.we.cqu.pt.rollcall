package edu.uddp.mapper;

import edu.uddp.model.TeaSignStatistic;
import edu.uddp.model.TeaSignStatisticExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TeaSignStatisticMapper {
    int countByExample(TeaSignStatisticExample example);

    int deleteByExample(TeaSignStatisticExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeaSignStatistic record);

    int insertSelective(TeaSignStatistic record);

    List<TeaSignStatistic> selectByExample(TeaSignStatisticExample example);

    TeaSignStatistic selectByPrimaryKey(Integer id);

    List<TeaSignStatistic> selectByLimit(List<String> lessonids);

    int updateByExampleSelective(@Param("record") TeaSignStatistic record, @Param("example") TeaSignStatisticExample example);

    int updateByExample(@Param("record") TeaSignStatistic record, @Param("example") TeaSignStatisticExample example);

    int updateByPrimaryKeySelective(TeaSignStatistic record);

    int updateByPrimaryKey(TeaSignStatistic record);
}