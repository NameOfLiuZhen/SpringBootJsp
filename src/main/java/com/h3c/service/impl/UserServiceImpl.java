package com.h3c.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper;
import com.h3c.entity.User;
import com.h3c.mapper.UserMapper;
import com.h3c.service.CommonService;
import com.h3c.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HttpServletRequest request;

    @Resource
    private CommonService commonService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("进行调用了loadUserByUsername");
        Object code = request.getParameter("code");
        log.info("验证码为 " + code);
        if(code== null){
            throw new UsernameNotFoundException("验证码为空了！");
        }

        String code1 = request.getSession().getAttribute("code").toString();
        System.out.println("code1 = " + code1);

        if(!code1.equals((String)code)){
            throw new UsernameNotFoundException("验证码不正确！");
        }

        log.info("查询数据库");

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",username);
        User user = userMapper.selectOne(queryWrapper);
        log.info("user = " + user);

        if(user == null){
            throw new UsernameNotFoundException("用户查询结果为空了");
        }

        //走到这里说明存在了
        Set<String> rolesByUserName = commonService.getRolesByUserName(username);

        //需要加ROLE_前缀
        rolesByUserName = rolesByUserName.stream().map(a -> {
            return "ROLE_" + a;
        }).collect(Collectors.toSet());

        Set<String> permissionByUserName = commonService.getPermissionByUserName(username);
        rolesByUserName.addAll(permissionByUserName);

        log.info("进行输出===========角色与权限");
        rolesByUserName.stream().forEach(System.out::println);

        Set<GrantedAuthority> collect = rolesByUserName.stream().map(a -> {
            return new SimpleGrantedAuthority(a);
        }).collect(Collectors.toSet());

        user.setAuthorities(collect);

        return user;

    }

}
