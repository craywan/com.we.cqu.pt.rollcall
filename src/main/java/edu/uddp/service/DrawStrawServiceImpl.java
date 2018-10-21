package edu.uddp.service;

import edu.uddp.mapper.DrawStrawMapper;
import edu.uddp.mapper.DrawStrawStuMapper;
import edu.uddp.model.DrawStraw;
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
public class DrawStrawServiceImpl implements DrawStrawService {
    @Autowired
    DrawStrawMapper drawStrawMapper;
    @Autowired
    DrawStrawStuMapper drawStrawStuMapper;

    @Override
    public void insert(DrawStraw drawStraw) {
        drawStrawMapper.insert(drawStraw);
    }

    @Override
    public void deleteByPrimaryKey(Integer key) {
        drawStrawMapper.deleteByPrimaryKey(key);
        drawStrawStuMapper.deleteByDrawStrawId(key);
    }

    @Override
    public List<DrawStraw> showByStuId(String stuId) {
        return drawStrawMapper.selectByStuId(stuId);
    }

    @Override
    public DrawStraw showByMaxId() {
        return drawStrawMapper.selectByMaxId();
    }
}
