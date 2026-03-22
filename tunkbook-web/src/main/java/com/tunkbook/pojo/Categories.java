package com.tunkbook.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    private Integer id;
    private String categoryName;

    private static final String formatoDateTime="yyyy-MM-dd HH:mm:ss";
    @DateTimeFormat(pattern = formatoDateTime)
    private LocalDateTime createTime;
    @DateTimeFormat(pattern = formatoDateTime)
    private LocalDateTime updateTime;
}
