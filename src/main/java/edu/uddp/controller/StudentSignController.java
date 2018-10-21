package edu.uddp.controller;

import edu.uddp.service.StudentSignService;
import edu.uddp.vo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
        * @program: rollcall-w
        * @description:
        * @author: wanzh
        * @create: 2018-10-05
        **/
@Api(tags="学生签到的接口")
@Controller
@RequestMapping(value="/studentSign")
public class StudentSignController {
    @Resource
    private StudentSignService studentSignService;
    /**
     * 1.学生签到历史记录
     */
    @ApiOperation(nickname = "学生签到历史",value="学生签到历史")
    @RequestMapping("/signHistory")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name="lessonList",value="该学生所对应的所有教学班"),@ApiImplicitParam(name="page",value="分页的页码"),@ApiImplicitParam(name="rows",value="每页的数据条数，默认为50")})
    public ResponseData signHistory(@RequestParam List<String> lessonList,@RequestParam(defaultValue="1",required = true) int page,@RequestParam(defaultValue ="50",required = false)int rows){
        return studentSignService.signHistory(lessonList,page,rows);
    }
}
