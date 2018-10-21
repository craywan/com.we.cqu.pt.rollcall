package edu.uddp.mapper;

import edu.uddp.model.RollcallClassStu;
import edu.uddp.model.RollcallClassStuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RollcallClassStuMapper {
    long countByExample(RollcallClassStuExample example);

    int deleteByExample(RollcallClassStuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RollcallClassStu record);

    int insertSelective(RollcallClassStu record);

    List<RollcallClassStu> selectByExample(RollcallClassStuExample example);

    List<RollcallClassStu> selectByClassId(String classId);

    List<RollcallClassStu> selectByKey(String Key);

    int updateByExampleSelective(@Param("record") RollcallClassStu record, @Param("example") RollcallClassStuExample example);

    int updateByExample(@Param("record") RollcallClassStu record, @Param("example") RollcallClassStuExample example);

    int updateByPrimaryKeySelective(RollcallClassStu record);

    int updateByPrimaryKey(RollcallClassStu record);
}