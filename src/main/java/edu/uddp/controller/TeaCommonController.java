package edu.uddp.controller;


import com.alibaba.fastjson.JSON;
import edu.uddp.model.StuInfo;
import edu.uddp.service.TeaCommonService;
import edu.uddp.util.CommonUtil;
import edu.uddp.util.HttpClientUtils;
import edu.uddp.util.JwzxUtil;
import edu.uddp.util.ResponseUtil;
import edu.uddp.vo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.omg.IOP.TAG_CODE_SETS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;


/**
 * @program: rollcall-ai
 * @description:
 * @author: wanzh
 * @create: 2018-09-22
 **/
@Api(tags = "获取信息的公共接口")
@Controller
@RequestMapping("/teaCommon")
public class TeaCommonController {
    @Resource
    private TeaCommonService teaCommonService;

    @RequestMapping(value = "/getTeaInfo",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "通过进教师统一认证吗获取教师信息")
    @ApiImplicitParam(name = "authId", value = "教师的统一认证码")
    public ResponseData getTeaInfo(@RequestParam String authId) {
        return teaCommonService.getTeaInfo(authId);

    }

    /**
     * 获取教学班对用的上课班级
     *
     * @param lessonId
     * @return
     */
    @RequestMapping("/getClassIds/{lessonId}")
    @ResponseBody
    @ApiOperation(value = "获取教学班对应的行政班级")
    @ApiImplicitParams({@ApiImplicitParam(name = "lessonId", value = "教学班id")})
    public ResponseData getClassIds(@PathVariable String lessonId) {
        List<StuInfo> stuList = JwzxUtil.classStuList(lessonId, "lesson");
        //遍历班级
        Set<String> classSet = new HashSet<>();
        for (StuInfo stuInfo : stuList) {
            if (stuInfo.getClassId() != null) {
                classSet.add(stuInfo.getClassId());
            }
        }
        if (classSet.size() <= 8) {
            return ResponseUtil.setResponse(200, "OK", classSet);
        } else {
            return ResponseUtil.setResponse(5004, "非正常教学班或者是选修班", null);
        }
    }

    /**
     * 通过学号获取学学生所有的教学班号
     *
     * @param stuId
     * @return
     */
    @RequestMapping("/getStuLessonId/{stuId}")
    @ResponseBody
    @ApiOperation(value = "通过学号获取所有的教学班号")
    @ApiImplicitParams(@ApiImplicitParam(name = "stuId", value = "学生学号"))
    public ResponseData getStuLessonId(@PathVariable String stuId) {
        Set<String> stuLessonList = JwzxUtil.getkbHtml(stuId, "lesson");
        if (stuLessonList.size() != 0) {
            return ResponseUtil.setResponse(200, "OK", stuLessonList);
        } else {
            return ResponseUtil.setResponse(5004, "暂时没有教学班信息", null);
        }
    }

    /**
     * 获取教务在线当前的周数
     *
     * @return
     */
    @RequestMapping("/getWeeks/{id}")
    @ResponseBody
    @ApiOperation(value = "获取教务在线当前的周数")
    @ApiImplicitParam(name = "id", value = "当前登录者的id")
    public ResponseData getWeek(@PathVariable String id) {
        Set<String> resultSet = JwzxUtil.getkbHtml(id, "week");
        if (!resultSet.isEmpty()) {
            return ResponseUtil.setResponse(200, "OK", resultSet);
        } else {
            return ResponseUtil.setResponse(5008, "没有获取到教务数据", null);
        }
    }

    /**
     * @return
     */
    @RequestMapping("/getQRCode")
    @ResponseBody
    @ApiOperation(value = "获取微信小程序的二维码")
    @ApiImplicitParams({@ApiImplicitParam(name = "scene", value = "参数"), @ApiImplicitParam(name = "page", value = "页面"), @ApiImplicitParam(name = "width", value = "狂赌")})
    public ResponseData getQRCode(@RequestParam Map<String, String> paramsMap, HttpServletResponse response) {
        System.out.println("scene" + paramsMap.get("scene"));
        System.out.println("page" + paramsMap.get("page"));
        System.out.println("width" + paramsMap.get("width"));
        Map<String, Object> resultMap = CommonUtil.getAccessToken();
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("content-type", "application/json");
        Map<String, Object> QRMap = new HashMap<>();
        byte[] resultByte = null;//接受返回的二维码数据。
        String resultUrl = null;
        //System.out.println(resultMap.get("errcode"));
        PrintWriter printWriter = null;
        OutputStream out = null;
        System.out.println("accessToken" + resultMap.get("access_token"));
        if (resultMap != null) {
            if (resultMap.get("access_token") != null) {
                resultUrl = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", (CharSequence) resultMap.get("access_token"));
            } else {
                return ResponseUtil.setResponse(5008, "接口访问错误", null);
//                try {
//                    printWriter= response.getWriter();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                printWriter.write(ResponseUtil.setResponse(5008,"接口访问错误",null).toString());
//                printWriter.flush();
//                printWriter.close();
            }
        } else {
//            printWriter.write(ResponseUtil.setResponse(5004,"微信接口访问异常",null).toString());
//            printWriter.flush();
//            printWriter.close();
            return ResponseUtil.setResponse(5004, "微信接口访问异常", null);
        }
        try {
            resultByte = HttpClientUtils.QRPostParameters(resultUrl, JSON.toJSONString(paramsMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //response.setContentType("image/png");
//        try {
//            out=response.getOutputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            out.write(resultByte);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                out.flush();
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        return ResponseUtil.setResponse(200, "OK", org.apache.commons.codec.binary.Base64.encodeBase64String(resultByte));
    }

    @ApiOperation(value = "通过学号获取教学班信息")
    @RequestMapping(value = "/getClassInfo/{stuId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiImplicitParam(name = "stuId", value = "学号")
    public ResponseData getClassInfo(@PathVariable String stuId) {
        return teaCommonService.getClassInfo(stuId);

    }
}


