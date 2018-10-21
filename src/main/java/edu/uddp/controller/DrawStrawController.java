package edu.uddp.controller;

import edu.uddp.model.DrawStraw;
import edu.uddp.model.DrawStrawStu;
import edu.uddp.model.StuInfo;
import edu.uddp.service.DrawStrawService;
import edu.uddp.service.DrawStrawStuService;
import edu.uddp.service.StuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(description = "抽签 API")
@RestController
@RequestMapping("/drawStraw")
public class DrawStrawController {
    @Autowired
    DrawStrawService drawStrawService;
    @Autowired
    DrawStrawStuService drawStrawStuService;
    @Autowired
    StuInfoService stuInfoService;

    @ApiOperation(value = "创建抽签")
    @PostMapping
    public Map<String, Object> create(DrawStraw drawStraw, String classId){
        Map<String, Object> result = new HashMap<>();
        result.put("status",200);
        result.put("message","ok");
        drawStrawService.insert(drawStraw);
        Integer maxId = drawStrawService.showByMaxId().getId();
        List<StuInfo> stuInfos = stuInfoService.selectByClassId(classId);
        List<DrawStrawStu> drawStrawStus = new ArrayList<>();
        for (int i = 0; i < stuInfos.size(); i++){
            DrawStrawStu drawStrawStu = new DrawStrawStu();
            StuInfo stuInfo = stuInfos.get(i);
            drawStrawStu.setStuId(stuInfo.getStuId());
            drawStrawStu.setStuName(stuInfo.getName());
            drawStrawStu.setDrawStrawId(maxId);
            drawStrawStu.setStatus("1");
            drawStrawStus.add(drawStrawStu);
        }
        drawStrawStuService.insertStuList(drawStrawStus);
        return result;
    }

    @ApiOperation(value = "删除抽签")
    @PostMapping("/delete")
    public Map<String, Object> delete(Integer id){
        Map<String, Object> result = new HashMap<>();
        result.put("status",200);
        result.put("message","ok");
        drawStrawService.deleteByPrimaryKey(id);
        return result;
    }

    @ApiOperation(value = "展示抽签")
    @GetMapping
    public Map<String, Object> show(String stuId){
        Map<String, Object> result = new HashMap<>();
        result.put("status",200);
        result.put("message","ok");
        List<DrawStraw> drawStraws = drawStrawService.showByStuId(stuId);
        result.put("data",drawStraws);
        return result;
    }

    @ApiOperation(value = "查看抽签名单")
    @GetMapping("/list")
    public Map<String, Object> list(Integer id){
        Map<String, Object> result = new HashMap<>();
        result.put("status",200);
        result.put("message","ok");
        List<DrawStrawStu> drawStrawStus = drawStrawStuService.showByDrawStrawId(id);
        result.put("data",drawStrawStus);
        return result;
    }

    @ApiOperation(value = "发布抽签")
    @PostMapping("/post")
    public Map<String, Object> start(Integer drawStrawId ,String comment, Integer nums){
        Map<String, Object> result = new HashMap<>();
        result.put("status",200);
        result.put("message","ok");
        List<DrawStrawStu> drawStrawStus = drawStrawStuService.showCanByDrawStrawId(drawStrawId);
        List<DrawStrawStu> data = new ArrayList<>();
        if (drawStrawStus.size() < nums){
            for (int i = 0; i < drawStrawStus.size(); i++) {
                data.add(drawStrawStus.get(i));
            }
            drawStrawStuService.updateStatusToOne();
            List<DrawStrawStu> drawStrawStusIf = drawStrawStuService.showCanByDrawStrawId(drawStrawId);
            for (int j = 0; j < nums - drawStrawStus.size(); j++){
                DrawStrawStu stu = drawStrawStus.get(j);
                Collections.shuffle(drawStrawStusIf);
                stu.setComment(comment);
                stu.setStatus("0");
                drawStrawStuService.updateDrawStrawStu(stu);
                data.add(stu);
            }
            result.put("data",data);
            return result;
        }
        Collections.shuffle(drawStrawStus);
        for (int i = 0; i < nums; i++) {
            DrawStrawStu stu = drawStrawStus.get(i);
            stu.setComment(comment);
            stu.setStatus("0");
            drawStrawStuService.updateDrawStrawStu(stu);
            data.add(drawStrawStus.get(i));
        }
        result.put("data", data);
        return result;
    }
}