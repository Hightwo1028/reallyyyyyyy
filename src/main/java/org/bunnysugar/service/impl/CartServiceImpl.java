package org.bunnysugar.service.impl;

import org.bunnysugar.mapper.CartMapper;
import org.bunnysugar.pojo.Cart;
import org.bunnysugar.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public Integer createCartForUser(Integer userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cartMapper.insertCart(cart);
        Integer cartId = cart.getId();
        return cartId;
    }
}

