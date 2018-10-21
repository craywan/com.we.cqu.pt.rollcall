package edu.uddp.mapper;

import edu.uddp.model.DrawStrawStu;
import edu.uddp.model.DrawStrawStuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DrawStrawStuMapper {
    long countByExample(DrawStrawStuExample example);

    int deleteByExample(DrawStrawStuExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteByDrawStrawId(Integer DrawStrawId);

    int insert(DrawStrawStu record);

    int insertSelective(DrawStrawStu record);

    int insertStuList(List<DrawStrawStu> list);

    List<DrawStrawStu> selectByExample(DrawStrawStuExample example);

    List<DrawStrawStu> selectByDrawStrawId(Integer drawStrawId);

    List<DrawStrawStu> selectCanByDrawStrawId(Integer drawStrawId);

    DrawStrawStu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DrawStrawStu record, @Param("example") DrawStrawStuExample example);

    int updateByExample(@Param("record") DrawStrawStu record, @Param("example") DrawStrawStuExample example);

    int updateByPrimaryKeySelective(DrawStrawStu record);

    int updateByPrimaryKey(DrawStrawStu record);

    int updateStatusToOne();
}