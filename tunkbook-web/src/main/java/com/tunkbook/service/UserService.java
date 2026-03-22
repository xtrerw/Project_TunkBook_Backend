package com.tunkbook.service;

import com.tunkbook.pojo.User;

import java.util.List;

public interface UserService {

    //consultar todos los usuarios
    List<User> list();
}
