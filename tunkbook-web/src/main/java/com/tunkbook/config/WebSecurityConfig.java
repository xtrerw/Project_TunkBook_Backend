package com.tunkbook.config;

import com.tunkbook.utils.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    // 用户角色权限认证
    //get start快速上手
    //0.把 Spring Security 内部的 AuthenticationManager 暴露成一个 Bean，交给 Spring 容器管理
    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration authConfig){
        return authConfig.getAuthenticationManager();
    }
    //1.定义用户服务
//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("admin").password(passwordEncoder().encode("123")).roles("ADMIN").build());
//        manager.createUser(User.withUsername("juan123").password(passwordEncoder().encode("1234")).roles("LECTOR","AUTOR").build());
//        manager.createUser(User.withUsername("employee_tunkbook").password(passwordEncoder().encode("123")).authorities("p3").build());
//        return manager;
//    }
    //2.密码编码器,现在暂时不加密
    @Bean
    public PasswordEncoder passwordEncoder(){

        return NoOpPasswordEncoder.getInstance();
    }
    //3.安全拦截机制
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //解决CORS问题
                .cors(cors -> {})   //
                .csrf(csrf -> csrf.disable())
                //用户权限拦截设置
                .authorizeHttpRequests(auth->
                        auth
                                .requestMatchers("/login","/register").permitAll()//登录页面
                                    // 普通用户
                                    .requestMatchers("/user/**").hasRole("USER")
                                    .requestMatchers("/admin/**").hasRole("ADMIN")//匹配admin下的所有请求
                                    .anyRequest().authenticated()//其他请求都要验证登录
                );
        return http.build();
        //4./logout可以直接退出登录
    }
}
