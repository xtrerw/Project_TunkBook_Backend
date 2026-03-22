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


    @Override
    public List<User> list() {

        return userMapper.list();
    }

    //necesita completar createTime y updateTime en usuarios
    @Override
    public void register(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        userMapper.insert(user);
    }

    @Override
    public User login(User user) {

        switch (user.getTipoUsuario()) {
            case "lector":
                user.setTipoUsuario("reader");
                return userMapper.getByReaderUsernameAndPassword(user);
            case "autor":
                user.setTipoUsuario("writer");
                return userMapper.getByWriterUsernameAndPassword(user);
            case "admin":
                user.setTipoUsuario("admin");
                return userMapper.getByAdminUsernameAndPassword(user);
            default:
                return null;
        }

        //return userMapper.getByUserNameAndPassword(user);

    }
}
