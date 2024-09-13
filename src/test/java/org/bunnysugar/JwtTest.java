package org.bunnysugar;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",16);
        claims.put("username", "CHIEN-HUNG WU");
        //生成JWT代碼               //這邊要注意 put的header到底會是什麼 錯了可能這個令牌就無法使用
        String token = JWT.create()
                .withClaim("user", claims)//加入載荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))//加入過期時間
                .sign(Algorithm.HMAC256("bunnysugar")); //指定算法，配置密鑰，絕對不能洩漏的key, 防竄改用

        System.out.println(token);
    }

}
