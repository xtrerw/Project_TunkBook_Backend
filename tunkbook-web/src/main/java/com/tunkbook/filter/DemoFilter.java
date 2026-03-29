package com.tunkbook.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


////@WebFilter("/login")
//public class DemoFilter implements Filter {
//    @Override//llamar metodo de iniciar una vez cuando web server se inicia
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("ejecutar la metodo de iniciar ");
//    }
//
//    @Override// interceptar las peticións y llama metodo varios veces
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("DEMO interceptar");
//        //放行请求
//        chain.doFilter(request,response);
//        //拦截到请求
//        System.out.println("DEMO 拦截到请求，放行后逻辑");
//    }
//
//    @Override//llamar metodo de destruir una vez cuando web server se detiene
//    public void destroy() {
//        System.out.println("ejecutar la metodo de destruir ");
//    }
//}
