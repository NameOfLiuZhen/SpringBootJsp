package com.h3c;

import com.h3c.entity.User;
import com.h3c.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

public class TestUser extends AppTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test01(){

        User user = userMapper.selectById(1);
        System.out.println("user = " + user);
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void test02(){
        boolean matches = bCryptPasswordEncoder.matches("123", "$10$0HYvDdSlgi0CwzbPQEGEcOKi/ndPa1LqchjEhAUTcLCsTdsR2oWGG");
        System.out.println("matches = " + matches);

    }

    @Test
    public void test03(){
        String encode = bCryptPasswordEncoder.encode("123");
        System.out.println("encode = " + encode);
    }
}
