package edu.uddp.service;

import edu.uddp.model.DrawStraw;

import java.util.List;

/**
 * @program: rollcall-ai
 * @description:
 * @author: yangxinyu
 * @create: 2018-09-08
 **/
public interface DrawStrawService {

    void insert(DrawStraw drawStraw);

    void deleteByPrimaryKey(Integer key);

    List<DrawStraw> showByStuId(String stuId);

    DrawStraw showByMaxId();
}
