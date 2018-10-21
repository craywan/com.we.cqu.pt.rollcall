package edu.uddp.mapper;

import edu.uddp.model.RollcallClass;
import edu.uddp.model.RollcallClassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RollcallClassMapper {
    long countByExample(RollcallClassExample example);

    int deleteByExample(RollcallClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RollcallClass record);

    int insertSelective(RollcallClass record);

    List<RollcallClass> selectByExample(RollcallClassExample example);

    RollcallClass selectByClassId(String classId);

    List<RollcallClass> selectByStatus(String status);

    int updateByExampleSelective(@Param("record") RollcallClass record, @Param("example") RollcallClassExample example);

    int updateByExample(@Param("record") RollcallClass record, @Param("example") RollcallClassExample example);

    int updateByPrimaryKeySelective(RollcallClass record);

    int updateByPrimaryKey(RollcallClass record);

    int updateByClassIdSelective(RollcallClass rollcallClass);
}