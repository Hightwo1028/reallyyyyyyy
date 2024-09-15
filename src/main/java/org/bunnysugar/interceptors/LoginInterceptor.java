package org.bunnysugar.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bunnysugar.pojo.Result;
import org.bunnysugar.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component      //去配置一個攔截器
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌驗證  因為我們的JWT令牌設置在header,所以我們這邊用HTTP request去拿到header為Authorization的東西,就能拿到JWT令牌
        String token = request.getHeader("Authorization");
        //驗證token
        try { //沒有異常就回傳success
            Map<String, Object> claims = JwtUtil.parseToken(token);
            return true;  //本來是右邊這樣  Result.success("會員資料..."); 這邊放行直接return true就好 因為這邊preHandle是布林
        } catch (Exception e) {
            //http響應狀態碼為401
            response.setStatus(401);
            //不放行
            return false;
        }
    }
}
