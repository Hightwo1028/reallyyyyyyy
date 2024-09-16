package org.bunnysugar.controller;

import org.bunnysugar.exception.InvalidTokenException;
import org.bunnysugar.exception.TokenExpiredException;
import org.bunnysugar.pojo.LoginRequest;
import org.bunnysugar.pojo.Result;
import org.bunnysugar.pojo.User;
import org.bunnysugar.pojo.VerifyRequest;
import org.bunnysugar.service.UserService;
import org.bunnysugar.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result<String> registerUser(@RequestBody User user) {
        // 檢查帳號是否已存在
        User existingUser = userService.findByUserAccount(user.getAccount());
        if (existingUser != null) {
            return Result.error("帳號已存在");
        }

        // 註冊新用戶
        Integer userId = userService.registerUserAndAll(user);
        return Result.success("註冊成功！您的會員ID: " + userId);
    }

    @PostMapping("/verify")
    public Result verifyUser(@RequestBody VerifyRequest verifyRequest) {
        try {
            userService.verifyUser(verifyRequest.getUserId(), verifyRequest.getToken());
            return Result.success("驗證成功，您的帳戶已啟用");
        } catch (InvalidTokenException | TokenExpiredException e) {
            return Result.error("驗證失敗，請重新嘗試");
        }
    }



    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginRequest loginRequest) {
        // 根據帳號查詢用戶  //把查詢出來的東西丟進一個變數 LoginedUser 代表這個登入的用戶 //而下面的loginRequest是前端拿到這個用戶一開始
        User LoginedUser = userService.findByUserAccount(loginRequest.getAccount());

        if (LoginedUser == null) {
            return Result.error("帳號不存在");
        }
        else {
            // 檢查密碼是否匹配         //而下面的loginRequest是前端拿到這個用戶一開始輸入的帳號密碼
            if (!LoginedUser.getPassword().equals(loginRequest.getPassword())) {
                return Result.error("密碼錯誤");
            }
            if (LoginedUser.getPassword().equals(loginRequest.getPassword())) {
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", LoginedUser.getId());
                claims.put("account", LoginedUser.getAccount());
                String token = JwtUtil.genToken(claims);
                return Result.success(token);
            }
        }
        return null;
    }
}