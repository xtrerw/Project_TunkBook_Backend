package com.tunkbook.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tunkbook.mapper.LoginMapper;
import com.tunkbook.mapper.UserMapper;
import com.tunkbook.pojo.User;
import com.tunkbook.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.lambdaQuery;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    // implementa un método de la interfaz list()
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    //necesita completar createTime y updateTime en usuarios
    @Override
    public void register(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        //cifrar password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        loginMapper.insert(user);

        //role defectos de usuario nuevo es reader
        userMapper.insertUserRole(user.getId(),1);
    }

    @Override
    public User loginByUsernamePassword(String username, String password) {
        User userLogin=
        loginMapper.selectOne(
                //crear obj de LambdaQueryWrapper
                new LambdaQueryWrapper<User>()
                        //condiciones de consulta
                .eq(username!=null,User::getUsername,username)
                        //password cifrado
                .eq(password!=null,User::getPassword,passwordEncoder.encode(password))
        );
        return userLogin;
    }


}
