package com.h3c;

import com.h3c.service.CommonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class TestCommon extends AppTest {

    @Autowired
    private CommonService commonService;

    @Test
    public void test01(){
        Set<String> liuzhen =
                commonService.getRolesByUserName("liuzhen");
//                commonService.getRolesByUserName("yyj");

        liuzhen.stream().forEach(System.out::println);
    }

    @Test
    public void test02(){
        Set<String> liuzhen = commonService.getPermissionByUserName("yyj");
        liuzhen.stream().forEach(System.out::println);
    }
}
