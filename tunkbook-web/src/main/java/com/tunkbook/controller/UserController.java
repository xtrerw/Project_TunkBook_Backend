package com.tunkbook.controller;

import com.tunkbook.pojo.Result;
import com.tunkbook.pojo.User;
import com.tunkbook.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

//controller->service->mapper->sql->service->controller->front-end

@Slf4j// usar log
@RestController
public class UserController {

    //Inyección de dependencias de una interfaz
    @Autowired
    private UserService userService;

    //private static Logger log = LoggerFactory.getLogger(UserController.class);

    //@RequestMapping(value = "/users",method = RequestMethod.GET)//metodo de get
    @GetMapping("/users")
    public Result list(){
        log.info("consulta los usuarios");

        List<User> userList=userService.list();
        //devolver datos a front-end
        return Result.success(userList);
    }
}
