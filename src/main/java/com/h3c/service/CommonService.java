package com.h3c.service;

import java.util.Set;

public interface CommonService {

    //    //通过用户名查 角色id
    Set<String> getRolesByUserName(String name);

    //通过用户名查询权限名
    Set<String> getPermissionByUserName(String name);

}
