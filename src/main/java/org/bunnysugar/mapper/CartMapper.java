package org.bunnysugar.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.bunnysugar.pojo.Cart;

@Mapper
public interface CartMapper {
    @Insert("INSERT INTO cart (user_id, create_time, update_time) VALUES (#{userId}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertCart(Cart cart);
}

