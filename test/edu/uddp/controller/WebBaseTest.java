package edu.uddp.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @program: rollcall
 * @description:
 * @author: yangxinyu
 * @create: 2018-08-08
 **/
// 单元测试的时候真实的开启一个web服务
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextHierarchy({
        @ContextConfiguration("classpath:/spring/springmvcServlet.xml"),
        @ContextConfiguration("classpath:/spring/applicationContext.xml")
})
public class WebBaseTest {
    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void setup() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void test() throws Exception{

    }
}