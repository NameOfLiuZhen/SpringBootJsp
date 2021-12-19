package com.h3c.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.h3c.entity.User;
import com.h3c.mapper.UserMapper;
import com.h3c.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Api(value = "captcha")
@Controller
@RequestMapping("admin")
@Slf4j
public class AdminController {

//    private static Logger log = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("captcha")
    @ApiOperation(value = "获取验证码")
    public void getCaptcha(HttpSession session, HttpServletResponse response) throws IOException {

        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(180, 80, 3, 2);
        System.out.println("code = " + lineCaptcha.getCode());
        session.setAttribute("code",lineCaptcha.getCode());

        lineCaptcha.write(response.getOutputStream());

    }

    @Resource
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("register")
    @ApiOperation("注册")
    public String register(String username,String password){
        System.out.println("username = " + username + ", password = " + password);

        if(username != null && password != null ){
            String encode = bCryptPasswordEncoder.encode(password);
            System.out.println("encode = " + encode);
            //进行创建
            User build = User.builder()
                    .username(username)
                    .password(encode)
                    .status(0)
                    .build();
            System.out.println("build = " + build);
            int insert = userMapper.insert(build);
            System.out.println("insert = " + insert);

            //插入成功
            log.info("插入成功");
            return "redirect:/login.jsp";
        }

        return "redirect:/register.jsp";
    }

    //方法不能用get，要不然转发不成功
    @RequestMapping("login/fail")
    public String get01(){
        System.out.println("AdminController.get01");
        log.info("登陆失败进行跳转到这里");
        return "redirect:/login.jsp";
    }


    @RequestMapping("login/succ")
    public String get02(){
        log.info("登陆成功了进行转发到这里");
        System.out.println("AdminController.get02");
        return "redirect:/main.jsp";
    }
}
