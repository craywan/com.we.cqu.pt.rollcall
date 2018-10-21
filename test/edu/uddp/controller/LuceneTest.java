package edu.uddp.controller;

import edu.uddp.mapper.LessonsMapper;
import edu.uddp.model.Lessons;
import edu.uddp.service.LuceneSerchService;
import edu.uddp.util.LuceneUtil;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class LuceneTest extends BaseTest{
    @Resource
    private LuceneSerchService luceneSerchService;
    @Resource
    private LessonsMapper lessonsMapper;
    @Test
    public void luceneTest(){
//        List<Lessons> list = luceneSerchService.serchCourses("应用文写作");
//        System.out.println("list"+list);
    }
    @Test
    public void test(){
        List<Lessons> list = lessonsMapper.selectAll();
        for (Lessons lesson:list
             ) {
            System.out.println(lesson.getJiaos());
        }
    }
}
