package edu.uddp.mapper;

import edu.uddp.model.CodeUuid;
import edu.uddp.model.CodeUuidExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeUuidMapper {
    int countByExample(CodeUuidExample example);

    int deleteByExample(CodeUuidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CodeUuid record);

    int insertSelective(CodeUuid record);

    List<CodeUuid> selectByExample(CodeUuidExample example);

    CodeUuid selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CodeUuid record, @Param("example") CodeUuidExample example);

    int updateByExample(@Param("record") CodeUuid record, @Param("example") CodeUuidExample example);

    int updateByPrimaryKeySelective(CodeUuid record);

    int updateByPrimaryKey(CodeUuid record);
     int updateByCodeUuid(String code);
}