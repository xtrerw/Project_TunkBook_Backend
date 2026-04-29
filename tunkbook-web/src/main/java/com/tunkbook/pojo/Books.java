package com.tunkbook.pojo;


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
@TableName("books")
public class Books {
    @TableId
    private Integer id;
    private String bookName;
    private String cover;
    private Double price;

    private static final String formatoDate="yyyy-MM-dd";
    @DateTimeFormat(pattern = formatoDate)
    private LocalDate createTime;
    @DateTimeFormat(pattern = formatoDate)
    private LocalDate updateTime;

    private String biography;
    private String firstName;
    private String lastName;
}
