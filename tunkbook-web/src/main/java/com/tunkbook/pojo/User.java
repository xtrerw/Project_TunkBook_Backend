package com.tunkbook.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("users")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String email;
    @TableField("is_active")
    private Boolean isActive;
    private static final String formatoDateTime="yyyy-MM-dd HH:mm:ss";

    //fecha de nacimiento
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBirth;
    //el tiempo creado
    @DateTimeFormat(pattern = formatoDateTime)
    private LocalDateTime createTime;
    //el tiempo actualizado
    @DateTimeFormat(pattern = formatoDateTime)
    private LocalDateTime updateTime;
}
