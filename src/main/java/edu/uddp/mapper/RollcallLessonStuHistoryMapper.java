package edu.uddp.mapper;

import edu.uddp.model.RollcallLessonStuHistory;
import edu.uddp.model.RollcallLessonStuHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RollcallLessonStuHistoryMapper {
    long countByExample(RollcallLessonStuHistoryExample example);

    int deleteByExample(RollcallLessonStuHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int delete(RollcallLessonStuHistory rollcallLessonStuHistory);

    int insert(RollcallLessonStuHistory record);

    int insertList(List<RollcallLessonStuHistory> rollcallLessonStuHistories);

    int insertSelective(RollcallLessonStuHistory record);

    List<RollcallLessonStuHistory> selectByExample(RollcallLessonStuHistoryExample example);

    RollcallLessonStuHistory selectByPrimaryKey(Integer id);

    List<RollcallLessonStuHistory> selectByLessonId(String lessonId);

    int updateByExampleSelective(@Param("record") RollcallLessonStuHistory record, @Param("example") RollcallLessonStuHistoryExample example);

    int updateByExample(@Param("record") RollcallLessonStuHistory record, @Param("example") RollcallLessonStuHistoryExample example);

    int updateByPrimaryKeySelective(RollcallLessonStuHistory record);

    int updateByPrimaryKey(RollcallLessonStuHistory record);
}