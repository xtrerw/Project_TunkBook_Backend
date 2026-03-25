package com.tunkbook.service;

import com.tunkbook.pojo.User;

import java.util.List;

public interface UserService {


    /**
     * usuario nuevo registrar
     * @param user
     */
    void register(User user);

    /**
     * usuario login
     * @param user
     */
    User login(User user);
}
