package edu.uddp.mapper;

import edu.uddp.model.StuInfo;
import edu.uddp.model.StuInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuInfoMapper {
    long countByExample(StuInfoExample example);

    int deleteByExample(StuInfoExample example);

    int insert(StuInfo record);

    int insertSelective(StuInfo record);

//    int insertStuList(List<StuInfo> list);

    List<StuInfo> selectByExample(StuInfoExample example);

    StuInfo selectByStuId(String stuId);

    List<StuInfo> selectByClassId(String classId);

    int updateByExampleSelective(@Param("record") StuInfo record, @Param("example") StuInfoExample example);

    int updateByExample(@Param("record") StuInfo record, @Param("example") StuInfoExample example);
}