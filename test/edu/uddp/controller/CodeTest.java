package edu.uddp.controller;

import edu.uddp.mapper.CodeUuidMapper;
import edu.uddp.model.CodeUuid;
import edu.uddp.service.TeaSignService;
import edu.uddp.util.EhcacheUtil;
import edu.uddp.util.JwzxUtil;
import edu.uddp.util.UuidCodeUtil;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


public class CodeTest extends BaseTest{

    @Resource
    private TeaSignService teaSignService;
    @Test
    public void getCode(){
        teaSignService.setUuidCodes();
    }
    @Test
    public void testCache(){
        EhcacheUtil.getInstance().put("mobileCache","wan","zhong");
        System.out.println(EhcacheUtil.getInstance().get("mobileCache","wan"));
    }

}
