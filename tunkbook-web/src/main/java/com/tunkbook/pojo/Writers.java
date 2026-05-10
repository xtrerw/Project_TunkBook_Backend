package com.tunkbook.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("writer")
public class Writers {
    @TableId("user_id")
    private Integer userId;
    private String biography;
    private Double income;

    User user;
}
