package edu.uddp.service;

import edu.uddp.mapper.RollcallClassStuMapper;
import edu.uddp.model.RollcallClassStu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rollcall-ai
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-27
 **/
@Service
public class RollcallClassStuServiceImpl implements RollcallClassStuService {
    @Autowired
    RollcallClassStuMapper rollcallClassStuMapper;

    @Override
    public void insert(RollcallClassStu rollcallClassStu) {
        rollcallClassStuMapper.insert(rollcallClassStu);
    }

    @Override
    public List<RollcallClassStu> showByClassId(String classId) {
        return rollcallClassStuMapper.selectByClassId(classId);
    }

    @Override
    public List<RollcallClassStu> showByKey(String key) {
        return rollcallClassStuMapper.selectByKey(key);
    }
}
