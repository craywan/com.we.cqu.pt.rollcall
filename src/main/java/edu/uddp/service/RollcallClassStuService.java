package edu.uddp.service;

import edu.uddp.model.RollcallClassStu;

import java.util.List;

/**
 * @program: rollcall-ai
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-27
 **/
public interface RollcallClassStuService {
    void insert(RollcallClassStu rollcallClassStu);

    List<RollcallClassStu> showByClassId(String classId);

    List<RollcallClassStu> showByKey(String key);
}
