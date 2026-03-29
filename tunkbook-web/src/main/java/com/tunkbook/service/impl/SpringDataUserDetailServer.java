package com.tunkbook.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


//UserDetailsService接口是获取用户信息接口
//@Service
//public class SpringDataUserDetailServer implements UserDetailsService {
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//    // consulta los usuario según username
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //将来连接数据库查询
//        //登录账号
//        System.out.println("username = "+username);
//        //暂时采用模拟的方式
//        UserDetails userDetails= User.withUsername("admin").password(passwordEncoder.encode("123")).roles("ADMIN").build();
//        return userDetails;
//    }
//}
