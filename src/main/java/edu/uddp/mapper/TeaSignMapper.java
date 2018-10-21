package edu.uddp.mapper;

import edu.uddp.model.TeaSign;
import edu.uddp.model.TeaSignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeaSignMapper {
    int countByExample(TeaSignExample example);

    int deleteByExample(TeaSignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeaSign record);

    int insertSelective(TeaSign record);

    List<TeaSign> selectByExample(TeaSignExample example);

    TeaSign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeaSign record, @Param("example") TeaSignExample example);

    int updateByExample(@Param("record") TeaSign record, @Param("example") TeaSignExample example);

    int updateByPrimaryKeySelective(TeaSign record);

    int updateByPrimaryKey(TeaSign record);
}