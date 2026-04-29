package com.tunkbook.controller;

import com.tunkbook.pojo.Result;
import com.tunkbook.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users/{id}/roles/writer")
    public Result addRoleToUser(Integer id){
        log.info("agregar el rol de escritor a la usuario id={}",id);
        userService.addRoleToUser(id);
        return Result.success();
    }

}
