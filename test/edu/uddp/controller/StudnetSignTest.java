package edu.uddp.controller;


import edu.uddp.service.StudentSignService;
import edu.uddp.util.JwzxUtil;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.*;
public class StudnetSignTest extends BaseTest {
    @Resource
    private StudentSignService studentSignService;
    @Test
    public void testHistory(){
        List<String> lessonList = new ArrayList<>();
        lessonList.add("A02181023116001");
        studentSignService.signHistory(lessonList,1,50);

    }
    @Test
    public void getLessonList(){

        Set<String> list =JwzxUtil.getkbHtml("2016213228","week");
        System.out.println("list"+list.toString());
    }
}
