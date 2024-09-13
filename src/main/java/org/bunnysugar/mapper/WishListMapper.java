package org.bunnysugar.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.bunnysugar.pojo.WishList;

@Mapper
public interface WishListMapper {
    @Insert("INSERT INTO wish_list (user_id, cart_id, create_time, update_time) VALUES (#{userId}, #{cartId}, NOW(), NOW())")
    void insertWishList(WishList wishList);
}
