package com.tunkbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan//因为拦截器是java-web的组件不是spring boot，所以需要加这个注解
@SpringBootApplication
public class TunkbookWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TunkbookWebApplication.class, args);
    }

}
