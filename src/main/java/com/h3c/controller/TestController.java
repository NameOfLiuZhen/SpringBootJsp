package com.h3c.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "testcontroller",description = "测试接口页面")
public class TestController {

    @GetMapping("/test01")
    @ApiOperation("测试方法1")
    public Object get01(){

        System.out.println("TestController.get01");
        return "abc";
    }



}
