package edu.uddp.service;

import edu.uddp.mapper.StuInfoMapper;
import edu.uddp.model.StuInfo;
import edu.uddp.model.StuInfoExample;
import edu.uddp.util.JwzxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rollcall
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-08
 **/
@Service
public class StuInfoServiceImpl implements StuInfoService{
    @Autowired
    StuInfoMapper stuInfoMapper;

    @Override
    public List<StuInfo> selectByClassId(String stuClass) {
        return stuInfoMapper.selectByClassId(stuClass);
    }

//    @Override
//    public void insertStuList(List list) {
//        stuInfoMapper.insertStuList(list);
//    }

    @Override
    public StuInfo selectByStuId(String stuId) {
        return stuInfoMapper.selectByStuId(stuId);
    }

    @Override
    public List<StuInfo> selectByLessonId(String stuLesson) {
        return JwzxUtil.classStuList(stuLesson,"lesson");
    }
}
