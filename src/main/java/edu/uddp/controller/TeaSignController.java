package edu.uddp.controller;

import com.alibaba.fastjson.JSON;

import java.util.*;

import edu.uddp.service.TeaSignService;
import edu.uddp.vo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @program: rollcall-ai
 * @description:
 * @author: wanzh
 * @create: 2018-09-22
 **/
@Api(tags = "教师签到接口")
@Controller
@RequestMapping("/teaSign")
public class TeaSignController {
    @Resource
    private TeaSignService teaSignService;

    @ApiOperation(value = "根据教师id获取id")
    @RequestMapping(value = "/selectCourses/{teaId}", produces = "text/plain;charset=utf-8")
    @ResponseBody
    @ApiImplicitParam(name = "teaId", value = "教师ID")
    public String selectCourses(@PathVariable String teaId) {
        return JSON.toJSONString(teaSignService.selectCourses(teaId));
    }

    @ApiOperation(value = "发布签到")
    @RequestMapping("/creatSign")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "teaId", value = "教师ID"), @ApiImplicitParam(name = "lessonId", value = "教学班号")
            , @ApiImplicitParam(name = "weeks", value = "周数"), @ApiImplicitParam(name = "classId", value = "班级id")})
    public ResponseData creatSign(@RequestParam Map<String, Object> paramsMap, HttpSession session) {
        String teaId = (String) paramsMap.get("teaId");
        String lessonId = (String) paramsMap.get("lessonId");
        String weeks = (String) paramsMap.get("weeks");
        String classIds = (String) paramsMap.get("classId");
        return teaSignService.CreatSign(paramsMap, session);
    }
    /*
    1.发布签到接口
    参数：课程id,教师id，课程所在的周数
    动作：1.取出签到ID，生成一次签到，记录签到开始时间，
        2.获取教学班签到学生学号，并放入redis缓存中
        3.签到发布后，只有教学班的学生才能查看此次签到
        存储发起签到的时间，并计时，40分钟后强制关闭,前端搞定。

    2.学生查看签到接口：
    参数：学号
    动作：根据学号查询课程id
          根据课程id查询状态为1（正在签到）签到口令和其他信息；
      返回签到表信息


      表：签到表，签到口令表，课程信息表，
     */
//    public ResponseData selectTeaSign(String stuId){
//
//    }

    /**
     * @param paramsMap
     * @return
     * @deprecated 3.学生输入口令签到接口：
     * 参数：学生ID，签到口令，签到id
     * 动作：根据签到Id获取对应的签到口令
     * 判断签到口令的正确性，如果错误返回错误数据
     * 根据学生ID更改缓存中学生的签到状态，并更新已签到学生的人数
     * 返回签到成功信息
     * 注意：重复签到
     */
    @ApiOperation("教师签到学生输入口令签到")
    @RequestMapping(value = "/joinTeaSign")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "stuId", value = "学生学号"), @ApiImplicitParam(name = "signPassword", value = "签到口令")})
    public ResponseData joinTeaSign(@RequestParam Map<String, Object> paramsMap, HttpSession session) {
        String stuid = (String) paramsMap.get("stuId");
        //String signId = (String) paramsMap.get("signId");
        String signPassword = (String) paramsMap.get("signPassword");
        return teaSignService.joinTeaSign(paramsMap, session);
    }

    /**
     * 结束教师点名
     *
     * @param paramsMap
     * @return
     */
    @ApiOperation(value = "结束点名", notes = "结束点名")
    @ApiImplicitParams({@ApiImplicitParam(name = "teaId", value = "教师ID"), @ApiImplicitParam(name = "lessonId", value = "教学班号")
            , @ApiImplicitParam(name = "weeksDay", value = "星期几"), @ApiImplicitParam(name = "weeks", value = "周数"), @ApiImplicitParam(name = "signId", value = "签到"),
            @ApiImplicitParam(name = "signPassword", value = "签到口令")})

    @RequestMapping("/endSign")
    @ResponseBody
    public ResponseData endSign(@RequestParam Map<String, Object> paramsMap) {
        /*
        参数：教师id,签到id,课程id,签到口令，周数weeks，星期数days
        动作;
            1.根据参数将签到状态置为0，
            2.根据签到口令找到对应的缓存数据
            3.根据签到口令统计签到人数情况及学号，并存入数据库中
            4.返回签到情况
         */
        String teaId = (String) paramsMap.get("teaId");
        String signId = (String) paramsMap.get("signId");
        String lessonId = (String) paramsMap.get("lessonId");
        String signPassword = (String) paramsMap.get("signPassword");
        String weeks = (String) paramsMap.get("weeks");
        String weeksDay = (String) paramsMap.get("weeksDay");
        return teaSignService.endSign(paramsMap);
    }
    //设置点名40分钟失效接口

    @ApiOperation(value = "实时获取点名情况")
    @RequestMapping("/getSignNums/{signPassword}")
    @ResponseBody
    @ApiImplicitParam(name="signPassword",value = "签到口令")
    public ResponseData getSignNums(@PathVariable String signPassword){
        return teaSignService.getSignNums(signPassword);
    }
}
