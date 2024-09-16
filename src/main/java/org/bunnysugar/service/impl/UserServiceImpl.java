package org.bunnysugar.service.impl;

import org.bunnysugar.mapper.UserMapper;
import org.bunnysugar.pojo.User;
import org.bunnysugar.service.CartService;
import org.bunnysugar.service.UserService;
import org.bunnysugar.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bunnysugar.exception.InvalidTokenException;
import org.bunnysugar.exception.TokenExpiredException;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CartService cartService;

    @Autowired
    private WishListService wishListService;
    private UserServiceImpl userService;

    @Override
    public Integer registerUserAndAll(User user) {
        //設置成未啟用
        user.setIsActive("0");
        userMapper.insertUser(user);
        Integer userId = user.getId();
        // 生成驗證碼
        String token = UUID.randomUUID().toString();
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(300);
        // 更新用戶資料，儲存驗證碼和有效期
        user.setVerifyingToken(token);
        user.setTokenExpirationTime(expirationTime);
        userMapper.updateVerifyingTokenForUser(user);
        Integer cartId = cartService.createCartForUser(userId);
        wishListService.createWishListForUserAndCart(userId,cartId);

        return userId;
    }

    @Override
    public User findByUserAccount(String account) {
        return userMapper.findByUserAccount(account);
    }

    @Override
    public User SelectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public void verifyUser(Integer userId, String token) {
        User user = userMapper.selectUserById(userId);
        if (user == null || !token.equals(user.getVerifyingToken())) {
            throw new InvalidTokenException("驗證失敗，無效的驗證碼");
        }
        if (user.getTokenExpirationTime().isBefore(LocalDateTime.now())) {
            throw new TokenExpiredException("驗證失敗，驗證碼已過期");
        }
        updateIsActiveForUser(userId, "1"); // 更新is_active為1
    }




    @Override
    public void updateIsActiveForUser(Integer id, String isActive) {
        userMapper.updateIsActiveForUser(id, isActive);
    }
}

