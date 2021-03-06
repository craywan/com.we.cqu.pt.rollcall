package edu.uddp.service;

import edu.uddp.mapper.UserInfoMapper;
import edu.uddp.model.UserInfo;
import edu.uddp.model.UserInfoExample;
import edu.uddp.util.*;
import edu.uddp.vo.ResponseData;
import org.springframework.stereotype.Service;

import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class QRCodeSignServiceImpl implements QRCodeSignService{
   @Resource
   private UserInfoMapper userInfoMapper;

    @Override
    public ResponseData codeSign(HttpSession session, String openId, String signPassword) {

        //将openId存入数组中
        session.setAttribute("openId",openId);
        //获取学号
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andOpenidEqualTo(openId);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        if(!userInfos.isEmpty()){
            String stuId = userInfos.get(0).getXh();
            RedisUtil redisUtil = new RedisUtil();
            int flag = 0;
            if(!(EhcacheUtil.getInstance().get("mobileCache",signPassword)==null)) {
                //获取缓存中的签到信息集合
                Map<Object,Object> signInfoMap = (Map<Object, Object>) EhcacheUtil.getInstance().get("mobileCache",signPassword);
                //获取学生的签到状态
                int stuStatus = (int) signInfoMap.get(stuId);
                //获取签到人数
                int signNums= (int) signInfoMap.get("signNums");
                //状态判断
                if(stuStatus==1){
                    flag=2;//重复签到
                }else{
                    //更新签到状态
                    signInfoMap.put(stuId,1);
                    signInfoMap.put("signNums",signNums+1);
                    flag=1;//签到成功
                }
//            if (!(redisUtil.getHashKey(signPassword, stuId) == null)) {
//                //获取缓存中map集合中的value
//                int stuStatus = (int) redisUtil.getHashKey(signPassword, stuId);
//                //获取nums
//                int signNums = (int) redisUtil.getHashKey(signPassword, "signNums");
//                if (stuStatus == 1) {
//                    flag = 2;//重复签到
//                } else {
//                    //更新
//                    redisUtil.updataHash(signPassword, stuId, 1);
//                    redisUtil.updataHash(signPassword, "signNums", signNums + 1);
//                    flag = 1;//成功签到
//                }
                session.setAttribute("signNums", signNums + 1);
                if (flag == 1) {
                    return ResponseUtil.setResponse(200, "OK",userInfos.get(0));
                } else {
                    return ResponseUtil.setResponse(5005, "重复签到", null);
                }
            } else {
                return ResponseUtil.setResponse(5004, "不在此签到中", null);
            }

        }else{
            return ResponseUtil.setResponse(5004,"没有学号信息，请先绑定we重邮",null);
        }
    }
}
