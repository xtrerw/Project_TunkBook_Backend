package com.tunkbook.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("users")
public class User {
    @TableId("value = \"id\", type = IdType.AUTO")
    private Integer id;
    private String username;
    private String password;
    @TableField("last_name")
    private String lastName;
    @TableField("first_name")
    private String firstName;
    private String email;
    private String phone;
    @TableField("is_active")
    private Boolean isActive;
    private static final String formatoDateTime="yyyy-MM-dd HH:mm:ss";

    //el tiempo creado
    @DateTimeFormat(pattern = formatoDateTime)
    private LocalDateTime createTime;
    //el tiempo actualizado
    @DateTimeFormat(pattern = formatoDateTime)
    private LocalDateTime updateTime;

    private String tipoUsuario;
}
