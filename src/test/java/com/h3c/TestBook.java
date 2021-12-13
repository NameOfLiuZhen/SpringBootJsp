package com.h3c;

import com.h3c.entity.Book;
import com.h3c.mapper.BookMapper;
import org.junit.Test;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

public class TestBook extends AppTest{

    @Resource
    private BookMapper bookMapper;

    @Test
    public void test01(){
        Book book = bookMapper.selectById(1);
        System.out.println("book = " + book);
    }
}
