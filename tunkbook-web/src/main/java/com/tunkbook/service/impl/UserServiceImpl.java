package com.tunkbook.service.impl;

import com.tunkbook.mapper.UserMapper;
import com.tunkbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addRoleToUser(Integer id) {
           userMapper.insertUserRole(id,2);
    }
}
