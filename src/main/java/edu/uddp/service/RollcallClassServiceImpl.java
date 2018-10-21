package edu.uddp.service;

import edu.uddp.mapper.RollcallClassMapper;
import edu.uddp.model.RollcallClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rollcall
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-10
 **/
@Service
public class RollcallClassServiceImpl implements RollcallClassService {
    @Autowired
    RollcallClassMapper rollcallClassMapper;

    @Override
    public void insert(RollcallClass rollcallClass) {
        rollcallClassMapper.insert(rollcallClass);
    }

    @Override
    public RollcallClass showByClassId(String classId) {
        return rollcallClassMapper.selectByClassId(classId);
    }

    @Override
    public void updateByClassId(RollcallClass rollcallClass) {
        rollcallClassMapper.updateByClassIdSelective(rollcallClass);
    }
}