package com.h3c.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper;
import com.h3c.entity.User;
import com.h3c.mapper.UserMapper;
import com.h3c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",username);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println("user = " + user);
        return user;
    }
}
