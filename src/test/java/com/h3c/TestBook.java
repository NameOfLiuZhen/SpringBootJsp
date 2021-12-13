package com.h3c;

import com.h3c.entity.Book;
import com.h3c.mapper.BookMapper;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

public class TestBook extends AppTest{

    @Resource
    private BookMapper bookMapper;

    String str = "$2a$10$0HYvDdSlgi0CwzbPQEGEcOKi/ndPa1LqchjEhAUTcLCsTdsR2oWGG";

    @Test
    public void test01(){
        Book book = bookMapper.selectById(1);
        System.out.println("book = " + book);
    }

    @Test
    public void test02(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println("encode = " + encode);


    }

    @Test
    public void test03(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean matches = bCryptPasswordEncoder.matches("123456", str);
        System.out.println("matches = " + matches);
    }
}
