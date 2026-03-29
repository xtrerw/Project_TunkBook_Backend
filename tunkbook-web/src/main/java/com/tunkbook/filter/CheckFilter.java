package com.tunkbook.filter;

import com.alibaba.fastjson.JSONObject;
import com.tunkbook.pojo.Result;
import com.tunkbook.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;


import java.io.IOException;

//@Slf4j
//@WebFilter("/*")
//public class CheckFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        //强转 request，response
//        HttpServletRequest req= (HttpServletRequest) request;
//        HttpServletResponse rep=(HttpServletResponse) response;
//        //1. conseguir Url de peticion
//        String url=req.getRequestURL().toString();
//        log.info("请求url",url);
//        //2. comprobar url incluye en login
//        if (url.contains("login")){
//            log.info("login,放行");
//            chain.doFilter(request,response);
//            return;
//        }
//        //3. conseguir token de header
//        String jwt = req.getHeader("token");
//        //4. comprobar el JWT si existe
//        if (!StringUtils.hasLength(jwt)){
//            log.info("请求头token为空，返回未登录信息");
//            Result error=Result.error(0,"NOT_LOGIN");
//            //手动转换对象json------alibab.fastjson
//            String notLogin = JSONObject.toJSONString(error);
//            //devolver a navegador
//            rep.getWriter().write(notLogin);
//            return;
//        }
//        //5.解析jwt
//        try {
//            JwtUtils.parseJwt(jwt);
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.info("解析令牌失败");
//            Result error=Result.error(0,"NOT_LOGIN");
//            //
//            String notLogin = JSONObject.toJSONString(error);
//            rep.getWriter().write(notLogin);
//            return;
//        }
//        //放行
//        log.info("放行");
//        chain.doFilter(request,response);
//    }
//}
