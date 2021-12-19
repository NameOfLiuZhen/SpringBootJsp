package com.h3c;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.h3c.mapper")
public class SpringBootJspApplication
{
    public static void main( String[] args )
    {


        SpringApplication.run(SpringBootJspApplication.class,args);

    }


}
