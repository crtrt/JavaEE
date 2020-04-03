package org.example.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/app/")
@Controller
public class TestController {

    //访问地址：http://localhost:8080/app/test
    @RequestMapping("test")
    public  String test(){
        return "/index.jsp";
    }


    @RequestMapping(value = "test2",produces = {"text/plain;charset=UTF-8"})
    //produces用于解决返回中文乱码问题，application/json;为json解决中文乱码
    @ResponseBody       //用于返回字符串,不写即返回视图
    public  String test2(){
        return "/index.jsp";
    }

}
