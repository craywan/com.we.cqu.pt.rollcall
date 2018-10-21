package edu.uddp.controller;

import com.alibaba.fastjson.JSONArray;
import edu.uddp.model.*;
import edu.uddp.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

/**
 * @program: ssm
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-04
 **/
@Api(description = "老师班长点名")
@RestController
@RequestMapping("/rollcall/tea")
@EnableSwagger2
public class TeaRollcallController {
    @Autowired
    ClassInfoService stuClassService;
    @Autowired
    LessonInfoService stuLessonService;
    @Autowired
    StuInfoService stuInfoService;
    @Autowired
    RollcallClassService rollCallClassService;
    @Autowired
    RollcallLessonService rollCallLessonService;
    @Autowired
    RollcallClassStuService rollcallClassStuService;
    @Autowired
    RollcallLessonStuService rollcallLessonStuService;
    @Autowired
    RollcallLessonStuHistoryService rollcallLessonStuHistoryService;

    @PostMapping("/class")
    @ApiOperation(value = "搜索展示班级列表")
    public Map<String, Object> classList(@RequestParam(defaultValue = "11111111") String classId) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        List<ClassInfo> stuClasses = stuClassService.selectByClassId(classId);
        result.put("status", 200);
        if(stuClasses.isEmpty()){
            result.put("message","暂无班级信息");
            return result;
        }
        data.put("total", stuClasses.size());
        data.put("rows", stuClasses);
        result.put("message", "ok");
        result.put("data", data);
        return result;
    }

    @PostMapping("/lesson")
    @ApiOperation(value = "搜索展示课程类别")
    public Map<String, Object> lessonList(@RequestParam(defaultValue = "111111111") String s) {
        List<LessonInfo> stuLessons = stuLessonService.selectBySome(s);
        Map<String, Object> result = new HashMap<>();
        result.put("message", "ok");
        result.put("status", 200);
        result.put("data", stuLessons);
        return result;
    }

    @ApiOperation(value = "老师课程列表")
    @PostMapping("/personLesson")
    public Map<String, Object> personLessonList(String teacherId){
        Map<String, Object> result = new HashMap<>();
        result.put("status",200);
        result.put("message","ok");
        List<LessonInfo> stuLessons = stuLessonService.selectByTeacherId(teacherId);
        result.put("data",stuLessons);
        return result;
    }

    @PostMapping("/class/{classNo}")
    @ApiOperation(value = "开始班级点名")
    public Map<String, Object> classCall(@PathVariable String classNo) {
        String key = RandomStringUtils.randomNumeric(5);
        while (key.equals("0000000000")) {
            key = RandomStringUtils.randomNumeric(5);
        }
        RollcallClass rollcallClass = new RollcallClass();
        rollcallClass.setKey(key);
        rollcallClass.setClassId(classNo);
        rollcallClass.setStatus("1");
        rollCallClassService.insert(rollcallClass);

        Map<String, Object> result = new HashMap<>();
        result.put("key",key);
        result.put("message", "0k");
        result.put("status", 200);
        return result;
    }

    @ApiOperation(value = "开始课程点名")
    @PostMapping("/lesson/{lessonNo}")
    public Map<String, Object> lessonCall(@PathVariable String lessonNo) {
        String key = RandomStringUtils.randomNumeric(5);
        while (key.equals("0000000000")) {
            key = RandomStringUtils.randomNumeric(5);
        }
        RollcallLesson rollcallLesson = new RollcallLesson();
        rollcallLesson.setKey(key);
        rollcallLesson.setStatus("1");
        rollcallLesson.setLessonId(lessonNo);
        rollCallLessonService.insert(rollcallLesson);

        Map<String, Object> result = new HashMap<>();
        result.put("key",key);
        result.put("message", "ok");
        result.put("status", 200);
        return result;
    }

    @PostMapping("/class/result")
    @ApiOperation(value = "查看班级点名结果")
    public Map<String, Object> classStop(String classNo) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        List<StuInfo> red = new ArrayList<>();
        List<StuInfo> green = new ArrayList<>();
        //比对stuInfos和rollcalllClassStus
        List<StuInfo> stuInfos = stuInfoService.selectByClassId(classNo);
        RollcallClass r = rollCallClassService.showByClassId(classNo);
        List<RollcallClassStu> rollcallClassStus = rollcallClassStuService.showByKey(r.getKey());
        if(!rollcallClassStus.isEmpty()) {
            for (int i = 0; i < stuInfos.size(); i++) {
                for (int j = 0; j < rollcallClassStus.size(); j++) {
                    if (stuInfos.get(i).getStuId().equals(rollcallClassStus.get(j).getStuId())) {
                        green.add(stuInfos.get(i));
                    } else {
                        red.add(stuInfos.get(i));
                    }
                }
            }
            data.put("red",red);
        }else{
            data.put("red",stuInfos);
        }
        data.put("green",green);
        int rows = red.size();
        data.put("red_rows",rows);
        //更新班级点名状态
        RollcallClass rollcallClass = new RollcallClass();
        rollcallClass.setClassId(classNo);
        rollcallClass.setStatus("0");
        rollCallClassService.updateByClassId(rollcallClass);
        result.put("data",data);
        result.put("message", "ok");
        result.put("status", "200");
        return result;
    }

    @PostMapping("/lesson/result")
    @ApiOperation(value = "查看课程点名结果")
    public Map<String, Object> lessonStop(String lessonNo) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        List<StuInfo> red = new ArrayList<>();
        List<StuInfo> green = new ArrayList<>();
        //比对stuInfos和rollcallLessonStus
        List<StuInfo> stuInfos = stuInfoService.selectByLessonId(lessonNo);
        RollcallLesson r = rollCallLessonService.showByLessonId(lessonNo);
        List<RollcallLessonStu> rollcallLessonStus = rollcallLessonStuService.showByKey(r.getKey());
        if (!rollcallLessonStus.isEmpty()) {
            for (int i = 0; i < stuInfos.size(); i++) {
                for (int j = 0; j < rollcallLessonStus.size(); j++) {
                    if (stuInfos.get(i).getStuId().equals(rollcallLessonStus.get(j).getStuId())) {
                        green.add(stuInfos.get(i));
                    } else {
                        red.add(stuInfos.get(i));
                    }
                }
            }
            data.put("red",red);
        }else {
            data.put("red",stuInfos);
        }
        data.put("green",green);
        int rows = red.size();
        data.put("red_rows",rows);
        //更新课程点名状态
        RollcallLesson rollcallLesson = new RollcallLesson();
        rollcallLesson.setLessonId(lessonNo);
        rollcallLesson.setStatus("0");
        rollCallLessonService.updateStatusByLessonId(rollcallLesson);
        result.put("data", data);
        result.put("message", "ok");
        result.put("status", "200");
        return result;
    }

    @PostMapping("/lesson/history")
    @ApiOperation(value = "确定点名有效，将未到计入历史记录")
    public Map<String, Object> lessonHistory(String require){
        Map<String, Object> res = new HashMap<>();
        if(require == null || require.isEmpty()){
            res.put("message", "null");
            res.put("status",200);
            return res;
        }
        List<RollcallLessonStuHistory> rollcallLessonStuHistories = new ArrayList<>();
        List<Object> list = JSONArray.parseArray(require);
        for (int i = 0; i < list.size(); i++){
            Map<String,Object> map = (Map<String, Object>) list.get(i);
            RollcallLessonStuHistory stuHistory = new RollcallLessonStuHistory();
            stuHistory.setStuId((String) map.get("stuId"));
            stuHistory.setLessonId((String) map.get("lessonId"));
            rollcallLessonStuHistories.add(stuHistory);
        }
        rollcallLessonStuHistoryService.insertList(rollcallLessonStuHistories);
        res.put("message", "ok");
        res.put("status",200);
        return res;
    }

    @GetMapping("/lesson/history/{lessonId}")
    @ApiOperation(value = "查看课程历史未到情况")
    public Map<String, Object> lessonHistoryResult(@PathVariable String lessonId){
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        List stus = new ArrayList<>();
        List<RollcallLessonStuHistory> stuHistories = rollcallLessonStuHistoryService.showByLessonId(lessonId);
        if (stuHistories.isEmpty()){
            res.put("message", "暂无记录");
            res.put("status",200);
            return res;
        }
        for (int i = 0; i < stuHistories.size(); i++) {
            RollcallLessonStuHistory stuHistory = stuHistories.get(i);
            Map<String, Object> stu = new HashMap<>();
            stu.put("stuId",stuHistory.getStuId());
            stu.put("lessonId",stuHistory.getLessonId());
            stu.put("createAt",stuHistory.getCreateAt());
            String name = stuInfoService.selectByStuId(stuHistory.getStuId()).getName();
            stu.put("name", name);
            List<String> time = new ArrayList<>();
            for (int j =  0; j < stuHistories.size(); j++){
                if(stuHistories.get(j).getStuId().equals(stuHistory.getStuId())){
                    time.add(stuHistories.get(j).getCreateAt());
                }
            }
            stu.replace("createAt",time);
            stus.add(stu);
        }
        HashSet tmp = new HashSet(stus);
        stus.clear();
        stus.addAll(tmp);
        data.put("data", stus);
        res.put("data",data);
        res.put("message", "ok");
        res.put("status",200);
        return res;
    }

    @PostMapping("/lesson/history/delete")
    @ApiOperation(value = "删除单条未到记录")
    public  Map<String, Object> lessonHistoryDelete(String stuId, String time){
        Map<String, Object> res = new HashMap<>();
        RollcallLessonStuHistory stuHistory = new RollcallLessonStuHistory();
        stuHistory.setCreateAt(time);
        stuHistory.setStuId(stuId);
        rollcallLessonStuHistoryService.delete(stuHistory);
        res.put("message", "ok");
        res.put("status",200);
        return res;
    }
}
