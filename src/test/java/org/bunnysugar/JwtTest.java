package org.bunnysugar;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",16);
        claims.put("account", "CHIEN-HUNG WU");
        //生成JWT代碼               //這邊要注意 put的header到底會是什麼 錯了可能這個令牌就無法使用
        String token = JWT.create()
                .withClaim("user", claims)//加入載荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))//加入過期時間
                .sign(Algorithm.HMAC256("bunnysugar")); //指定算法，配置密鑰，絕對不能洩漏的key, 防竄改用

        System.out.println(token);
    }

    @Test
    public void testParse(){
        //定義字符串, 模擬使用者傳遞過來的token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxNiwiYWNjb3VudCI6IkNISUVOLUhVTkcgV1UifSwiZXhwIjoxNzI2NDMwMjMzfQ" +
                ".2Qp-9oRaiUvSUUfldcQug63uJ5xMbsdjPJiqa1OW2sA";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("bunnysugar")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token); //驗證token，產生一個解析後的JWT對象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));

        //竄改頭部和載荷部分的數據，驗證會失敗
        //竄改密鑰，驗證也會失敗
    }

}
