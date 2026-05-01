package com.tunkbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan//因为拦截器是java-web的组件不是spring boot，所以需要加这个注解
@SpringBootApplication
@MapperScan("com.tunkbook.mapper")
public class TunkbookWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TunkbookWebApplication.class, args);
    }

}
