package com.tunkbook.controller;

import com.tunkbook.pojo.Result;
import com.tunkbook.pojo.User;
import com.tunkbook.service.LoginService;
import com.tunkbook.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    //jwt发放token令牌
    @PostMapping("/login")
    public Result login(@RequestBody User user) throws Exception {
        User us=loginService.loginByUsernamePassword(user.getUsername(),user.getPassword());
        // iniciar sesion con JWT
        if (us !=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",us.getId());//user id
            claims.put("name",us.getLastName());
            claims.put("username",us.getUsername());// username
            //inicair sesion con exito, les da token
            try {
                String token=JwtUtils.genJwt(claims);// generar JWT con información de usuario
                claims.put("token",token);
                return Result.success(claims);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
        // iniciar sesion fallo
        return Result.error(0,"el nombre de usuario o contraseña no es correcto");
    }
}
