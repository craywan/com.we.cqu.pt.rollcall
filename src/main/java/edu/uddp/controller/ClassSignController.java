package edu.uddp.controller;

import edu.uddp.service.ClassSignService;
import edu.uddp.vo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * * @program: rollcall-ai
 * @description: 学生签到第二版接口
 * @author: wanzh
 * @create: 2018-10-25
 */
@Api(tags="学生签名接口第二版")
@Controller
@RequestMapping("/classSign")
public class ClassSignController {

    @Resource
    private ClassSignService classSignService;
    /**
     * 创建学生签到
     * @param paramsMap
     * @return
     */
    @ApiOperation(value="创建学生签到")
    @RequestMapping("/creatSign")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name="stuId",value = "学生ID"),@ApiImplicitParam(name="classId",value = "班级ID")})
    public ResponseData creatSign(@RequestParam Map<String,Object> paramsMap){
        return classSignService.creatClassSign((String) paramsMap.get("classId"),(String)paramsMap.get("stuId"));
    }

    /**
     * 结束学生签到
     * @return
     */
    @ApiOperation(value="结束学生签到")
    @RequestMapping("/endSign")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "teaId", value = "学生ID"), @ApiImplicitParam(name = "lessonId", value = "行政班号"), @ApiImplicitParam(name = "signId", value = "签到"),
            @ApiImplicitParam(name = "signPassword", value = "签到口令"),@ApiImplicitParam(name = "classId", value = "行政班号")})
    public ResponseData endSign(@RequestParam Map<String,Object> paramsMap){
          return classSignService.endClassSign(paramsMap);

    }

    @ApiOperation(value="学生签到")
    @RequestMapping(value = "/joinClassSign",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "stuId", value = "学生学号"), @ApiImplicitParam(name = "signPassword", value = "签到口令")})
    public ResponseData joinClassSign(@RequestParam Map<String,Object> paramsMap, HttpSession session){
        return classSignService.joinClassSign(paramsMap,session);
    }



}
