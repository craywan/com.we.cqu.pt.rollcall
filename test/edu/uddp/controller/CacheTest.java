package edu.uddp.controller;

import com.alibaba.fastjson.JSON;
import edu.uddp.model.StuInfo;
import edu.uddp.util.JwzxUtil;
import edu.uddp.util.RedisUtil;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.*;

public class CacheTest extends BaseTest {
//    @Resource
//    private  RedisUtil redisUtil;
//    @Test
//    public void set(){
//        boolean bl = redisUtil.set("12345","1234567");
//        System.out.println(bl);
//    }
//    @Test
//    public void get(){
//        int signNums = (int) redisUtil.getHashKey("333","signNums");
//        int stuStatus = (int) redisUtil.getHashKey("333","2015210895");
//        System.out.println(signNums+1);
//        System.out.println(stuStatus+1);
//    }
//    @Test
//    public void testMap(){
//        Map<String,Object> testMap = new HashMap<>();
//
//        String map = JSON.toJSONString(testMap);
//        System.out.println(testMap.toString());
//        System.out.println(map);
//    }
//    @Test
//    public void getHashKeys(){
//        Map<Object,Object> resultMap = (Map<Object, Object>) redisUtil.getHashKeys("333");
//        System.out.println(resultMap.toString());
//    }
//    @Test
//    public void JWZXTest(){
//        List<StuInfo> list =JwzxUtil.classStuList("11021603","class");
//        System.out.println(list.toString());
//    }
}
