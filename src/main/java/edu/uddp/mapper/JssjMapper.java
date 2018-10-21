package edu.uddp.mapper;

import edu.uddp.model.Jssj;
import edu.uddp.model.JssjExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JssjMapper {
    int countByExample(JssjExample example);

    int deleteByExample(JssjExample example);

    int insert(Jssj record);

    int insertSelective(Jssj record);

    List<Jssj> selectByExample(JssjExample example);

    int updateByExampleSelective(@Param("record") Jssj record, @Param("example") JssjExample example);

    int updateByExample(@Param("record") Jssj record, @Param("example") JssjExample example);
}