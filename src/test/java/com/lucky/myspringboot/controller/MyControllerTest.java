package com.lucky.myspringboot.controller;

import com.lucky.myspringboot.MyspringbootApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//引入Spring对JUnit4的支 持。
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring Boot的启动类。
@SpringBootTest(classes = MyspringbootApplication.class)
//开启Web应用的配置， 用千模拟ServletContext。
@WebAppConfiguration
public class MyControllerTest {

    //MockMvc对象: 用于模拟调用 Controller的接口发起请求，
    // 在@Test定义的hello 测试用例中， perform函数执行 一 次请求调用， accept用于执行接收的数据类型，
    //andExpect用于判断接口返回的期望值。
    private MockMvc mvc;

    @Before
    //@Before: JUnit中定义在测试用例@Test内容执行前预加载的内容， 这里用来初
    //始化对HelloController的模拟 。
    public void setUp() throws Exception {

        mvc = MockMvcBuilders.standaloneSetup(new MyController()).build();

    }

    @Test
    public void out() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/out").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));
    }

    @Test
    public void info() {
    }
}