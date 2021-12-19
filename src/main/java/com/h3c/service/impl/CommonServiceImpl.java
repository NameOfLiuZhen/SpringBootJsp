package com.h3c.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.h3c.entity.*;
import com.h3c.mapper.*;
import com.h3c.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommonServiceImpl implements CommonService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RolePerMapper rolePerMapper;



    @Override
    public Set<String> getRolesByUserName(String name) {

        //通过设备ID，进行获取到角色
        User name1 = userMapper.selectOne(new QueryWrapper<User>().eq("name", name));

        log.info("name1 = " + name1);

        List<UserRole> user_id = userRoleMapper.selectList(new QueryWrapper<UserRole>().eq("user_id", name1.getId()));

        Set<Integer> collect = user_id.stream().map(userRole -> {
            return userRole.getRoleId();
        }).collect(Collectors.toSet());

        log.info("user_id = " + user_id);

        List<Role> id = roleMapper.selectList(new QueryWrapper<Role>().in("id", collect));

        Set<String> collect1 = id.stream().map(role -> {
            return role.getRoleName();
        }).collect(Collectors.toSet());

        log.info("id = " + id);
        log.info("collect1 = " + collect);
        return collect1;
    }

    @Override
    public Set<String> getPermissionByUserName(String name) {

        Set<String> rolesByUserName = getRolesByUserName(name);

        log.info("rolesByUserName = " + rolesByUserName);

        List<Role> role_name = roleMapper.selectList(new QueryWrapper<Role>().in("role_name", rolesByUserName));

        log.info("role_name = " + role_name);

        Set<Integer> collect = role_name.stream().map(role -> {
            return role.getId();
        }).collect(Collectors.toSet());

        log.info("collect = " + collect);


        List<RolePer> role_id = rolePerMapper.selectList(new QueryWrapper<RolePer>().in("role_id", collect));

        Set<Integer> collect1 = role_id.stream().map(rolePer -> {
            return rolePer.getPerId();
        }).collect(Collectors.toSet());

        log.info("collect1 = " + collect1);

        List<Permission> id = permissionMapper.selectList(new QueryWrapper<Permission>().in("id", collect1));
        Set<String> collect2 = id.stream().map(permission -> {
            return permission.getPermission();
        }).collect(Collectors.toSet());

        return collect2;
    }
}
