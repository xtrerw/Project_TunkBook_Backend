package com.tunkbook.service.impl;

import com.tunkbook.mapper.UserMapper;
import com.tunkbook.pojo.User;
import com.tunkbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //agregar role esrictor de usuario
    @Override
    public void addRoleToUser(Integer id) {
           userMapper.insertUserRole(id,2);
    }

    @Override
    public User listUserInfo(Integer id) {
        return userMapper.selectById(id);
    }
}
