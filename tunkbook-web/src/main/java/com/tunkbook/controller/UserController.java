package com.tunkbook.controller;

import com.tunkbook.pojo.Books;
import com.tunkbook.pojo.Result;
import com.tunkbook.pojo.User;
import com.tunkbook.service.BookService;
import com.tunkbook.service.UserService;
import com.tunkbook.utils.JwtUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    //mostrar información de la usuario
    @GetMapping("/users/info")
    public Result getUserInfo(HttpServletRequest req) {
        try {
            //get cookie de Front-End
            Cookie[] cookies = req.getCookies();
            String token=null;
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("Authorization")){
                    log.info("token={}",cookie.getValue());
                    token = cookie.getValue();
                    break;
                }
            }
            // parse解析 token
            Map<String, Object> claims = JwtUtils.parseJwt(token);
            //get id 强转 Integer
            Integer id = (Integer) claims.get("id");
            log.info("user id={}",id);
            // get List de infor
            User us=userService.listUserInfo(id);
            if (us!=null){
                Map<String,Object> infoUser=new HashMap<>();
                infoUser.put("username",us.getUsername());
                infoUser.put("email",us.getEmail());
                infoUser.put("dateBirth",us.getDateBirth());
                infoUser.put("imgPerfil",us.getImgPerfil());
                //devolver infoUser a Front-End
                return Result.success(infoUser);
            }
        } catch (Exception e) {
            return Result.error(0, "NOT LOGIN");
        }
        return null;
    }
}
