package com.tunkbook.controller;

import com.tunkbook.pojo.Result;
import com.tunkbook.pojo.User;
import com.tunkbook.pojo.UserLogin;
import com.tunkbook.service.UserService;
import com.tunkbook.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//controller->service->mapper->sql->service->controller->front-end

@Slf4j// usar log
@RestController
public class LoginController {

    //Inyección de dependencias de una interfaz
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authManager;

    /**
     * Registrar la usuario nueva
     * @param user
     * @return Result
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        log.info("Registrar la cuenta nueva:{}",user);
        //agregar usuario nuevo
        userService.register(user);
        return Result.success();
    }

    /**
     * Iniciar sesion los usuarios
     *
     */
    //使用spring security进行验证,jwt发放token令牌
    @PostMapping("/login")
    public Result login(@RequestBody User user) throws Exception {
        log.info("Iniciar sesión usuario"+ user);
        //调用loadUserByUsername verificar password, username, role
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(), user.getPassword()
                )
        );
        // conseguir userDetail,la información según la bbdd
        //强转，拿到“登录成功后的用户信息” Spring Security 只认 UserDetails
        UserLogin userLogin=(UserLogin) auth.getPrincipal();
        User us=userLogin.getUser();
        // generar JWT si iniciar sesion con exito
        if (us !=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",us.getId());//user id
            claims.put("name",us.getLastName());
            claims.put("username",us.getUsername());// username
            //inicair sesion con exito, les da jwt
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

    //login success
    @PostMapping(path="/login-success",produces = "text/plain;charset=utf-8")
    public String loginSuccess(){
        return "iniciar sesion con exito";
    }


}
