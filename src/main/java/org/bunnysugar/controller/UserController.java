package org.bunnysugar.controller;

import org.bunnysugar.pojo.User;
import org.bunnysugar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        Integer userId = userService.registerUserAndAll(user);
        return "註冊成功！您的會員ID: " + userId;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.SelectUserById(id);
    }
}
