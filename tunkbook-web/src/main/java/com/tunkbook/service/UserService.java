package com.tunkbook.service;

import com.tunkbook.pojo.User;

import java.util.List;

public interface UserService {
    //agregar role esrictor de usuario
    void addRoleToUser(Integer id);

    User listUserInfo(Integer id);
}
