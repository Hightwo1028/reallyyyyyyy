package org.bunnysugar.controller;

import org.bunnysugar.pojo.LoginRequest;
import org.bunnysugar.pojo.Result;
import org.bunnysugar.pojo.User;
import org.bunnysugar.service.UserService;
import org.bunnysugar.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Integer id) {
        User user = userService.SelectUserById(id);
        if (user == null) {
            return Result.error("用戶不存在");
        }
        return Result.success(user);
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