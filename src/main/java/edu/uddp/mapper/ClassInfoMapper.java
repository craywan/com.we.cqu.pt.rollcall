package edu.uddp.mapper;

import edu.uddp.model.ClassInfo;
import edu.uddp.model.ClassInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassInfoMapper {
    long countByExample(ClassInfoExample example);

    int deleteByExample(ClassInfoExample example);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    int insertClassList(List<ClassInfo> list);

    List<ClassInfo> selectAll();

    List<ClassInfo> selectByClassId(String id);

    List<ClassInfo> selectByExample(ClassInfoExample example);

    int updateByExampleSelective(@Param("record") ClassInfo record, @Param("example") ClassInfoExample example);

    int updateByExample(@Param("record") ClassInfo record, @Param("example") ClassInfoExample example);
}