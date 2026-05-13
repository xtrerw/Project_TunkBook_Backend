package com.tunkbook.controller;

import com.tunkbook.pojo.Result;
import com.tunkbook.pojo.User;
import com.tunkbook.service.LoginService;
import com.tunkbook.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//controller->service->mapper->sql->service->controller->front-end

@Slf4j// usar log
@RestController
public class LoginController {

    //Inyección de dependencias de una interfaz
    @Autowired
    private LoginService loginService;

    /**
     * Registrar la usuario nueva
     * @param user
     * @return Result
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        log.info("Registrar la cuenta nueva:{}",user);
        //agregar usuario nuevo
        loginService.register(user);
        return Result.success();
    }

    /**
     * Iniciar sesion los usuarios
     * @param user
     */
    // get token para iniciar sesion
    @PostMapping("/login")
    public Result login(@RequestBody User user,HttpServletResponse response) {
        try {
            User us = loginService.loginByUsernamePassword(user.getUsername(), user.getPassword());
            // iniciar sesion con JWT
            if (us != null) {
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", us.getId());//user id
                claims.put("username", us.getUsername());// username
                //inicair sesion con exito, les da token
                String token = JwtUtils.genJwt(claims);// generar JWT con user
                //======== cookie para guardar el token ========
                Cookie cookie= new Cookie("Authorization",token);
                cookie.setPath("/");// cookie válido para toda la aplicación
                cookie.setHttpOnly(true);// cookie no accesible por JS
                cookie.setMaxAge(43200);// time de cookie válido
                response.addCookie(cookie);
                //======== cookie ========
                return Result.success(token);
            }
        } catch (RuntimeException e) {
            return Result.error(0, e.getMessage());
        } catch (Exception e) {
            return Result.error(0, "server error");
        }
        return null;
    }

    // verificar ha iniciado sesion
    @GetMapping("/auth/check")
    public Result checkAuth(HttpServletRequest req) {
        try {
            //  get cookie
            Cookie[] cookies = req.getCookies();
            //  varificar cookie si existe
            if (cookies==null) {
                return Result.error(0, "NOT LOGIN");
            }
            //  buscar token en cookie
            String token = null;
            //  buscar "Authorization" cookie
            for (Cookie cookie : cookies) {
                //  si hay cookie "Authorization", obtener token
                if (cookie.getName().equals("Authorization")) {
                    token = cookie.getValue();
                    break;
                }
            }
            //  verificar si hay token existe
            if (token == null || token.isEmpty()) {
                return Result.error(0, "NOT LOGIN");
            }
            //  parse JWT，verificar token con caducidad y firma
            Map<String, Object> claims = JwtUtils.parseJwt(token);
            // devolver infor de user
            return Result.success(claims);
        } catch (Exception e) {
            return Result.error(0, "NOT LOGIN");
        }
    }
}
