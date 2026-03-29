package com.tunkbook.service.impl;


import com.tunkbook.mapper.UserMapper;
import com.tunkbook.pojo.User;
import com.tunkbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    // implementa un método de la interfaz list()
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //necesita completar createTime y updateTime en usuarios
    @Override
    public void register(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        userMapper.insert(user);
    }

//    @Override
//    public User login(User user) {
//        return userMapper.getByUserNameAndPassword(user);
//
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从mapper获取用户信息
        User user=userMapper.getByUserName(username);
        //如果用户不存在，抛出异常
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encuentro");
        }
        //角色查询
        List<String> roles=userMapper.getUserRolesById(user.getId());
        //比较用户信息和密码
        UserDetails userDetails= org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(
                //之后要加password的加密
                user.getPassword()
        ).roles(roles.toArray(new String[0]))//把List变成String []
                .build();
        return userDetails;
    }
}
