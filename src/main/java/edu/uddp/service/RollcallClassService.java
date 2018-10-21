package edu.uddp.service;

import edu.uddp.model.RollcallClass;

import java.util.List;

/**
 * @program: rollcall
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-10
 * 约定：数据基本不变的为select,数据变化快的为show
 * **/
public interface RollcallClassService {

    void insert(RollcallClass rollcallClass);

    RollcallClass showByClassId(String classId);

    void updateByClassId(RollcallClass rollcallClass);
}