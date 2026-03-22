package com.tunkbook.service.impl;


import com.tunkbook.mapper.UserMapper;
import com.tunkbook.pojo.User;
import com.tunkbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // implementa un método de la interfaz list()
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
