package com.tunkbook.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtils {
    // generar clave
    private static String secret="thisIsASecretKeyThatIsAtLeast32Bytes!";
    private static long expiration=43200*1000;
    private static Key signKey=Keys.hmacShaKeyFor(secret.getBytes());

    // generar JWT
    public static String genJwt(Map<String, Object> claims) throws Exception{

        return Jwts.builder()
                        .signWith(signKey, SignatureAlgorithm.HS256)// algorithm firma con clave
                        .setClaims(claims)//establecer objeto que quiere
                        .setExpiration(new Date(System.currentTimeMillis()+expiration)) // establecer tiempo de expiracion
                        .compact();
    }

    // parsear JWT
    public  static  Map<String, Object> parseJwt(String token) throws Exception{

       // devolver map<key,value>
       return Jwts.parserBuilder()
                   .setSigningKey(signKey)
                   .build()
                   .parseClaimsJws(token) // parsear el token
                   .getBody();
    }



}
