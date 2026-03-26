package com.tunkbook.controller;

import com.tunkbook.pojo.Result;
import com.tunkbook.pojo.User;
import com.tunkbook.service.UserService;
import com.tunkbook.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
//    @GetMapping("/users")
//    public Result list(){
//        log.info("consulta los usuarios");
//        //muestrar usuario
//        List<User> userList=userService.list();
//        //devolver datos a front-end
//        return Result.success(userList);
//    }

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
    @PostMapping("/login")
    public Result login(@RequestBody User user) throws Exception {
        log.info("Iniciar sesión usuario"+ user);
        // verificar los usuarios
        User us= userService.login(user);

        // generar JWT si iniciar sesion con exito
        if (us !=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",user.getId());//user id
            claims.put("name",user.getLastName());
            claims.put("username",user.getUsername());// username
            //inicair sesion con exito, les da jwt
            try {
                String token=JwtUtils.genJwt( claims);// generar JWT con información de usuario
                return Result.success(token);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
        // iniciar sesion fallo
        return Result.error(0,"el nombre de usuario o contraseña no es correcto");
    }

}
