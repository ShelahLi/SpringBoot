package com.lucky.myspringboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    //@Value:在启动时，自动的扫描YAML配置文件，将key对应的value注入进来
    @Value("${mall.config.name}")
    private String name;
    @Value("${mall.config.description}")
    private String description;
    @Value("${mall.config.hot-sales}")
    private Integer hotSales;
    @Value("${mall.config.show-advert}")
    private Boolean showAdvert;

    @RequestMapping("/out")
    @ResponseBody
    public String out(){
        return "success";
    }

    @RequestMapping("/info")
    @ResponseBody
    public String info(){
        return String.format("name:%s,description:%s,hot-sales:%s,show-advert:%s",
                name,description,hotSales,showAdvert);
    }
}
