package com.tunkbook.controller;

import com.tunkbook.pojo.Books;
import com.tunkbook.pojo.Result;
import com.tunkbook.service.BookService;
import com.tunkbook.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @PostMapping("/users/{id}/roles/writer")
    public Result addRoleToUser(@PathVariable("id") Integer id){
        log.info("agregar el rol de escritor a la usuario id={}",id);
        userService.addRoleToUser(id);
        return Result.success("agregar el rol de escritor con éxito");
    }

    // agregar libro nuevo
    @PostMapping("/users/{id}/book")
    public Result addBook(@PathVariable("id") Integer userId,@RequestBody Books book){
        log.info("agregar un libro nuevo a la usuario id={}",userId);
        bookService.addBookToUser(userId,book);
        return Result.success("agregar libro nuevo con éxito");
    }

    //muestra información de la usuario
    @PutMapping("/users/{id}")
    public Result listUserInfo(@PathVariable("id") Integer id) {
        log.info("muestra información de la usuario id={}", id);
        return Result.success(userService.listUserInfo(id));
    }
}
