package edu.uddp.service;

import edu.uddp.model.DrawStrawStu;

import java.util.List;

/**
 * @program: rollcall-ai
 * @description:
 * @author: yangxinyu
 * @create: 2018-09-08
 **/
public interface DrawStrawStuService {

    void insertStuList(List<DrawStrawStu> list);

    List<DrawStrawStu> showByDrawStrawId(Integer id);

    List<DrawStrawStu> showCanByDrawStrawId(Integer id);

    void updateStatusToOne();

    void updateDrawStrawStu(DrawStrawStu drawStrawStu);
}
