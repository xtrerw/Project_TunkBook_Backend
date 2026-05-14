package com.tunkbook.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class JwtCookieUtils {
    //get auth token
    public static String getToken(HttpServletRequest request){
        //get cookie
        Cookie[] cookies=request.getCookies();
        // verificar cookie existe
        if (cookies==null){
            return null;
        }
        //get "Authoization" cookie
        for (Cookie cookie:cookies){
            if (cookie.equals("Authorization")){
                return cookie.getValue();
            }
        }
        return null;
    }

}
