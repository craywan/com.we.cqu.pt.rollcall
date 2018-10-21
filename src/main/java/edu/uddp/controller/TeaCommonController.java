package edu.uddp.controller;

import edu.uddp.model.StuInfo;
import edu.uddp.service.TeaCommonService;
import edu.uddp.util.CommonUtil;
import edu.uddp.util.JwzxUtil;
import edu.uddp.util.ResponseUtil;
import edu.uddp.vo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.*;


@Api(tags="获取信息的公共接口")
@Controller
@RequestMapping("/teaCommon")
public class TeaCommonController {
    @Resource
    private TeaCommonService teaCommonService;
    @RequestMapping("/getTeaInfo/{authId}")
    @ResponseBody
    @ApiOperation(value="通过进教师统一认证吗获取教师信息")
    @ApiImplicitParam(name="authId",value = "教师的统一认证码")
    public ResponseData getTeaInfo(@PathVariable String authId){
        return teaCommonService.getTeaInfo(authId);

    }

    /**
     * 获取教学班对用的上课班级
     * @param lessonId
     * @return
     */
    @RequestMapping("/getClassIds/{lessonId}")
    @ResponseBody
    @ApiOperation(value="获取教学班对应的行政班级")
    @ApiImplicitParams({@ApiImplicitParam(name="lessonId",value = "教学班id")})
    public ResponseData getClassIds(@PathVariable String lessonId){
            List<StuInfo> stuList = JwzxUtil.classStuList(lessonId,"lesson");
            //遍历班级
        Set<String> classSet = new HashSet<>();
        for (StuInfo stuInfo:stuList) {
            if(stuInfo.getClassId()!=null){
                classSet.add(stuInfo.getClassId());
            }
        }
        if(classSet.size()<=8) {
            return ResponseUtil.setResponse(200, "OK", classSet);
        }else{
            return ResponseUtil.setResponse(5004,"非正常教学班或者是选修班",null);
        }
    }

    /**
     * 通过学号获取学学生所有的教学班号
     * @param stuId
     * @return
     */
    @RequestMapping("/getStuLessonId/{stuId}")
    @ResponseBody
    @ApiOperation(value="通过学号获取所有的教学班号")
    @ApiImplicitParams(@ApiImplicitParam(name="stuId",value="学生学号"))
    public ResponseData getStuLessonId(@PathVariable String stuId){
        Set<String> stuLessonList =JwzxUtil.getkbHtml(stuId,"lesson");
        if(stuLessonList.size()!=0) {
            return ResponseUtil.setResponse(200, "OK", stuLessonList);
        }else{
            return ResponseUtil.setResponse(5004,"暂时没有教学班信息",null);
        }
    }

    /**
     * 获取教务在线当前的周数
     * @return
     */
    @RequestMapping("/getWeeks/{id}")
    @ResponseBody
    @ApiOperation(value="获取教务在线当前的周数")
    @ApiImplicitParam(name="id",value = "当前登录者的id")
    public ResponseData getWeek(@PathVariable String id){
        Set<String> resultSet =JwzxUtil.getkbHtml(id,"week");
        if(!resultSet.isEmpty()){
            return ResponseUtil.setResponse(200,"OK",resultSet);
        }else{
            return ResponseUtil.setResponse(5008,"没有获取到教务数据",null);
        }
    }

    /**
     *
     * @return
     */
    @RequestMapping("/getAccessToken")
    @ResponseBody
    @ApiOperation(value="获取微信小程序的accessToken")
    public ResponseData getAccessToken(){
        Map<String,Object> resultMap = CommonUtil.getAccessToken();
        System.out.println(resultMap.get("errcode"));
        if(resultMap!=null){
            if(resultMap.get("access_token")!=null){
                String resultUrl="https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", (CharSequence) resultMap.get("access_token"));
                return ResponseUtil.setResponse(200,"OK",resultUrl);
            }else{
                return ResponseUtil.setResponse(5008,"接口访问错误",null);
            }
        }else{
            return ResponseUtil.setResponse(5004,"微信接口访问异常",null);
        }
    }
}


