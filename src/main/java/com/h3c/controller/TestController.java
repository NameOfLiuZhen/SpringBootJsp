package com.h3c.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "testcontroller",description = "测试接口页面")
public class TestController {

    @GetMapping("/test01")
    @ApiOperation("测试方法1")
    @PreAuthorize("hasAnyRole('putong','vip')")
    public Object get01(){

        System.out.println("进到了测试方法1");
        System.out.println("TestController.get01");
        return "111";
    }

    @GetMapping("/test02")
    @ApiOperation("测试方法2")
    @PreAuthorize("hasAnyAuthority('select:update','select:delete')")
    public Object get02(){
        System.out.println("进到了测试方法2");

        System.out.println("TestController.get02");
        return "222";
    }

    @GetMapping("/test03")
    @ApiOperation("测试方法3")
    @PreAuthorize("hasAuthority('select:insert')")
    public Object get03(){
        System.out.println("进到了测试方法3");

        System.out.println("TestController.get03");
        return "333";
    }

    @GetMapping("/test04")
    @ApiOperation("测试方法4")
    @PreAuthorize("hasRole('vip')")
    public Object get04(){
        System.out.println("进到了测试方法4");

        System.out.println("TestController.get04");
        return "444";
    }


    @GetMapping("/test05")
    @ApiOperation("测试方法5")
    @PreAuthorize("hasRole('putong')")
    public Object get05(){
        System.out.println("进到了测试方法5");

        System.out.println("TestController.get05");
        return "555";
    }



}
