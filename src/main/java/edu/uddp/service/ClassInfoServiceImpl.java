package edu.uddp.service;

import edu.uddp.mapper.ClassInfoMapper;
import edu.uddp.model.ClassInfo;
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
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    ClassInfoMapper classInfoMapper;

    @Override
    public List<ClassInfo> selectByClassId(String classId) {
        List<ClassInfo> stuClasses = classInfoMapper.selectByClassId(classId);
        return stuClasses;
    }

    @Override
    public void insertClassList(List list) {
        classInfoMapper.insertClassList(list);
    }

    @Override
    public List<ClassInfo> showAll() {
        return classInfoMapper.selectAll();
    }
}
