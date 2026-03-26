package com.tunkbook;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TunkbookWebApplicationTests {


//    @Test
//    public void testGenJwt(){
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("id",1);
//        claims.put("username","testUser");
//
//        // 生产环境使用一个至少 256-bit 的密钥（32字节）
//        String secret = "thisIsASecretKeyThatIsAtLeast32Bytes!";
//        Key key = Keys.hmacShaKeyFor(secret.getBytes());
//
//
//        String jwt= Jwts.builder()
//                        .signWith(key,SignatureAlgorithm.HS256)//签名算法
//                        .setClaims(claims)//自定义加载内容
//                        .setExpiration(new Date(System.currentTimeMillis()+3600*1000))//什么时候失效,有效期1小时，1s=1000ms
//                        .compact();
//        System.out.println(jwt);
//    }
//
//
//    /**
//     *  解析JWT
//     */
//    @Test
//    public void testParseJwt(){
//
//        String token="eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJ0ZXN0VXNlciIsImV4cCI6MTc3NDU2MjEwMX0.881PPJIYbubin9zc9_LbdT2q8xok1h-R1pMzjmfLiPY";
//
//        String secret="thisIsASecretKeyThatIsAtLeast32Bytes!";
//        Key key=Keys.hmacShaKeyFor(secret.getBytes());
//
//
//        Claims claims = Jwts.parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//        System.out.println(claims);
//    }
}
