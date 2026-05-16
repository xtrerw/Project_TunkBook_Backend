package com.tunkbook.service;

import com.tunkbook.pojo.User;

import java.util.List;

public interface LoginService {


    /**
     * usuario nuevo registrar
     * @param user
     */
    void register(User user);

    User loginByUsernamePassword(String email, String password);
}
