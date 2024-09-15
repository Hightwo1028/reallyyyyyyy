package org.bunnysugar.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.bunnysugar.pojo.Result;
import org.bunnysugar.utils.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/memberPage")
public class NewController {
    @GetMapping("/memberData")                                                      //為了去回傳401錯誤
    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/) {
        //驗證token
//        try { //沒有異常就回傳success
//            Map<String, Object> claims = JwtUtil.parseToken(token);
//            return Result.success("會員資料...");
//        } catch (Exception e) {
//            //http響應狀態碼為401
//            response.setStatus(401);
//            return Result.error("未登入");
//        }
        return Result.success("會員資料...");
    }
}
