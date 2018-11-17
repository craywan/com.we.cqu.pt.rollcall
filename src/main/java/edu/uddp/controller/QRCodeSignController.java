package edu.uddp.controller;

import edu.uddp.service.QRCodeSignService;
import edu.uddp.util.ConfigUtil;
import edu.uddp.util.QRUtil;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/**
 * @program: rollcall-ai
 * @description: 二维码签到
 * @author: wanzh
 * @create: 2018-08-26
 **/
@Api(tags="二维码签到接口")
@Controller
@RequestMapping("/QRCodeSign")
public class QRCodeSignController {

    @Resource
    private QRCodeSignService qrCodeSignService;
    /**
     * 获取二维码
     * @param signPassword
     * @return
     */
    @ApiOperation(value="生成二维码")
    @ApiImplicitParams({@ApiImplicitParam(name="signPassword",value="签到口令")})
    @RequestMapping("/getQRCode/{signPassword}")
    @ResponseBody
    public void getQRCode(@PathVariable String signPassword, HttpServletResponse httpServletResponse){
        //String signPassword = (String) paramsMap.get("signPassword");
        String redirectUrl = "https://we.cqu.pt/dm/rollcall-w/QRCodeSign/codeSign";
        String enRedirectUrl=null;
        try {
             enRedirectUrl = URLEncoder.encode(redirectUrl,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        String Url= ConfigUtil.ERWEI_URL.replace("APPID",ConfigUtil.APPID).replace("REDIRECT_URI",enRedirectUrl);
        String Url="http://www.vicwen.com/";
        //获取二维
        byte[] QRArray = QRUtil.getQR(Url);
        httpServletResponse.setContentType("image/png");
      OutputStream out = null;
        try {
            out =httpServletResponse.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.write(QRArray);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 扫码签到
     * @param session
     * @param
     * @param signPassword
     * @return
     */
    @ApiOperation(value="扫码签到实现")
    @RequestMapping("/codeSign")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name="stuId",value="用户的openId"),@ApiImplicitParam(name="signPassword",value="签到口令")})
    public ResponseData codeSign(HttpSession session, @RequestParam String stuId,@RequestParam String signPassword){
    /*
    1.检测是否为空
    2.根据code去获取openid
    3.根据openId得到学号
    4.根据signPassword去得到缓存中的数据
    5.进行签到逻辑判断
     */
    return qrCodeSignService.codeSign(session,stuId,signPassword);

    }
}
