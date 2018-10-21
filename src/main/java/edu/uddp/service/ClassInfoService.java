package edu.uddp.service;

import edu.uddp.model.ClassInfo;

import java.util.List;

public interface ClassInfoService {

    List<ClassInfo> selectByClassId(String classId);

    void insertClassList(List list);

    List<ClassInfo> showAll();
}
