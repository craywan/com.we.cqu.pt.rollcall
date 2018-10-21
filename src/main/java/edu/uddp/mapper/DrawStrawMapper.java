package edu.uddp.mapper;

import edu.uddp.model.DrawStraw;
import edu.uddp.model.DrawStrawExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DrawStrawMapper {
    long countByExample(DrawStrawExample example);

    int deleteByExample(DrawStrawExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DrawStraw record);

    int insertSelective(DrawStraw record);

    List<DrawStraw> selectByExample(DrawStrawExample example);

    DrawStraw selectByPrimaryKey(Integer id);

    DrawStraw selectByMaxId();

    List<DrawStraw> selectByStuId(String stuId);

    int updateByExampleSelective(@Param("record") DrawStraw record, @Param("example") DrawStrawExample example);

    int updateByExample(@Param("record") DrawStraw record, @Param("example") DrawStrawExample example);

    int updateByPrimaryKeySelective(DrawStraw record);

    int updateByPrimaryKey(DrawStraw record);
}