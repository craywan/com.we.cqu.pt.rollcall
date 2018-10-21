package edu.uddp.service;

import edu.uddp.mapper.DrawStrawStuMapper;
import edu.uddp.model.DrawStrawStu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rollcall-ai
 * @description:
 * @author: yangxinyu
 * @create: 2018-09-08
 **/
@Service
public class DrawStrawStuServiceImpl implements DrawStrawStuService {
    @Autowired
    DrawStrawStuMapper drawStrawStuMapper;

    @Override
    public void insertStuList(List<DrawStrawStu> list) {
        drawStrawStuMapper.insertStuList(list);
    }

    @Override
    public List<DrawStrawStu> showByDrawStrawId(Integer id) {
        return drawStrawStuMapper.selectByDrawStrawId(id);
    }

    @Override
    public List<DrawStrawStu> showCanByDrawStrawId(Integer id) {
        return drawStrawStuMapper.selectCanByDrawStrawId(id);
    }

    @Override
    public void updateStatusToOne() {
        drawStrawStuMapper.updateStatusToOne();
    }

    @Override
    public void updateDrawStrawStu(DrawStrawStu drawStrawStu) {
        drawStrawStuMapper.updateByPrimaryKey(drawStrawStu);
    }
}
