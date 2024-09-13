package org.bunnysugar.service.impl;

import org.bunnysugar.mapper.WishListMapper;
import org.bunnysugar.pojo.WishList;
import org.bunnysugar.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class WishListServiceImpl implements WishListService {
    @Autowired
    private WishListMapper wishListMapper;

    @Override
    public Integer createWishListForUserAndCart(Integer userId, Integer cartId) {
        WishList wishList = new WishList();
        wishList.setUserId(userId);
        wishList.setCartId(cartId);
        wishListMapper.insertWishList(wishList);
        return wishList.getId();
    }
}
