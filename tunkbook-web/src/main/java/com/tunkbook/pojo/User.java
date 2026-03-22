package com.tunkbook.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private String email;
    private String phone;
    private Boolean isActive;
    private static final String formatoDateTime="yyyy-MM-dd HH:mm:ss";

    //el tiempo creado
    @DateTimeFormat(pattern = formatoDateTime)
    private LocalDateTime createTime;
    //el tiempo actualizado
    @DateTimeFormat(pattern = formatoDateTime)
    private LocalDateTime updateTime;
    
}
