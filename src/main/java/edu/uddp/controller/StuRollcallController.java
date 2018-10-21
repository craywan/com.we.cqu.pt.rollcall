package edu.uddp.controller;

import edu.uddp.model.*;
import edu.uddp.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: rollcall-ai
 * @description: 随机数点名学生端
 * @author: yangxinyu
 * @create: 2018-08-27
 **/
@Api(description = "学生签到")
@RestController
@RequestMapping("/rollcall/stu")
public class StuRollcallController {
    @Autowired
    RollcallClassService rollCallClassService;
    @Autowired
    RollcallLessonService rollCallLessonService;
    @Autowired
    RollcallLessonStuService rollCallLessonStuService;
    @Autowired
    RollcallClassStuService rollcallClassStuService;
    @Autowired
    StuInfoService stuInfoService;


    @ApiOperation("班级签到验证是否开始")
    @PostMapping("/classes")
    public Map<String, Object> ingClassList(String stuId){
        StuInfo stuInfo = stuInfoService.selectByStuId(stuId);
        String classId = stuInfo.getClassId();
        Map<String,Object> classIdMap = new HashMap<>();
        classIdMap.put("classId",classId);
        Map<String,Object> result = new HashMap<>();
        result.put("status","200");
        RollcallClass rollcallClass = rollCallClassService.showByClassId(classId);
        if (rollcallClass.getStatus().equals("1")) {
            result.put("message","ok");
            result.put("data",classIdMap);
            return result;
        }
        result.put("message","您所在的班级暂未开始点名。");
        return result;
    }


    @ApiOperation("班级签到输入验证码")
    @PostMapping("/class/answer")
    public Map<String, Object> classAnswer(RollcallClassStu rollcallClassStu){
        Map<String, Object> result = new HashMap<>();
        result.put("status",200);
        rollcallClassStuService.insert(rollcallClassStu);
        RollcallClass rollcallClass = rollCallClassService.showByClassId(rollcallClassStu.getClassId());
        String key = rollcallClass.getKey();
        if(rollcallClassStu.getKey().equals(key)){
            result.put("message","ok");
            return result;
        }
        result.put("message","点名码输入错误！");
        return result;
    }

    @ApiOperation("课程签到输入签到码")
    @PostMapping("/lesson/answer")
    public Map<String, Object> lessonAnswer(RollcallLessonStu rollcallLessonStu){
        Map<String, Object> result = new HashMap<>();
        result.put("status",200);
        RollcallLesson rollcallLesson = rollCallLessonService.showByKey(rollcallLessonStu.getKey());
        if (rollcallLesson != null) {
            if (rollcallLesson.getStatus().equals("0")) {
                result.put("message", "点名已经结束");
                return result;
            }
        }
        String key = rollcallLesson != null ? rollcallLesson.getKey() : null;
        if (key != null){
            rollCallLessonStuService.insert(rollcallLessonStu);
            result.put("message","ok");
            return result;
        }
        result.put("message","点名码输入错误!");
        return result;
    }
}
