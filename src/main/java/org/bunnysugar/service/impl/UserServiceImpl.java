package org.bunnysugar.service.impl;

import org.bunnysugar.mapper.UserMapper;
import org.bunnysugar.pojo.User;
import org.bunnysugar.service.CartService;
import org.bunnysugar.service.UserService;
import org.bunnysugar.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CartService cartService;

    @Autowired
    private WishListService wishListService;

    @Override
    public Integer registerUserAndAll(User user) {
        userMapper.insertUser(user);
        Integer userId = user.getId();
        Integer cartId = cartService.createCartForUser(userId);
        wishListService.createWishListForUserAndCart(userId,cartId);
        return userId;
    }

    @Override
    public User SelectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }
}

