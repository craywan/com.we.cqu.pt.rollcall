package edu.uddp.controller;

import edu.uddp.service.TeaSignRecordService;
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
 * @program: rollcall-ai
 * @description:
 * @author: wanzh
 * @create: 2018-09-26
 **/
@Controller
@Api(tags="签到记录接口")
@RequestMapping("/signRecord")
public class SignRecordController {

    @Resource
    private TeaSignRecordService teaSignRecordService;
    @ApiOperation(value="获取某次点名学生签到的情况")
    @RequestMapping(value="/selectSignRecord")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "teaId",value = "教师ID"),@ApiImplicitParam(name="lessonId",value = "课程id"),@ApiImplicitParam(name="weeks",value = "周次"),@ApiImplicitParam(name="weeksDay",value = "星期几")})
    public ResponseData selectSignRecord(@RequestParam Map<String,Object> paramsMap){
        return teaSignRecordService.selectSignRecord(paramsMap);
    }
    @ApiImplicitParam(name="设置签到状态")
    @RequestMapping("/changeSignStatus")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "teaId",value = "教师ID",type = "String"),@ApiImplicitParam(name="lessonId",value = "课程id"),@ApiImplicitParam(name="weeks",value = "周次",type = "String"),@ApiImplicitParam(name="weeksDay",value = "星期几",type="String")
    ,@ApiImplicitParam(name = "changeMap",value = "改变的数据集合",type = "String"),@ApiImplicitParam(name = "changeUnsignNum",value = "改变未签到人数",type = "int")})
    public ResponseData changeSignStatus(@RequestParam Map<String,Object> paramsMap){
    return teaSignRecordService.updateSignRecord(paramsMap);
    }
}
