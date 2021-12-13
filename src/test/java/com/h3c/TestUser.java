package com.h3c;

import com.h3c.entity.User;
import com.h3c.mapper.UserMapper;
import org.junit.Test;

import javax.annotation.Resource;

public class TestUser extends AppTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test01(){

        User user = userMapper.selectById(1);
        System.out.println("user = " + user);
    }
}
