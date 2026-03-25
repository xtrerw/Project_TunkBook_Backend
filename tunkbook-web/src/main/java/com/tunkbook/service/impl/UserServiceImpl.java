package com.tunkbook.service.impl;


import com.tunkbook.mapper.UserMapper;
import com.tunkbook.pojo.User;
import com.tunkbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // implementa un método de la interfaz list()
    @Autowired
    private UserMapper userMapper;

    //necesita completar createTime y updateTime en usuarios
    @Override
    public void register(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        userMapper.insert(user);
    }

    @Override
    public User login(User user) {
        return userMapper.getByUserNameAndPassword(user);

    }
}
