package org.bunnysugar.mapper;

import org.apache.ibatis.annotations.*;
import org.bunnysugar.pojo.User;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users (account, password, email, name, gender, phone, birthday, bunny_coin, " +
            "is_active, verifying_token, token_expiration_time, forget_token, login_method, google_token, " +
            "facebook_token, game_times, create_time, update_time) " +
            "VALUES (#{account}, #{password}, #{email}, #{name}, #{gender}, #{phone}, #{birthday}, #{bunnyCoin}, " +
            "#{isActive}, #{verifyingToken}, #{tokenExpirationTime}, #{forgetToken}, #{loginMethod}, #{googleToken}, " +
            "#{facebookToken}, #{gameTimes}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);

    @Select("SELECT * FROM users WHERE id = #{id}")
    User selectUserById(Integer id);

    @Select("SELECT * FROM users WHERE account = #{account}")
    User findByUserAccount(String account);

    @Update("UPDATE users " +
            "SET is_active = #{isActive}, " +
            "verifying_token = #{verifyingToken}, " +
            "token_expiration_time = #{tokenExpirationTime}, " +  // 新增 token_expiration_time
            "update_time = NOW() " +
            "WHERE id = #{id}")
    void updateVerifyingTokenForUser(User user);

    @Update("UPDATE users SET is_active = #{isActive}, update_time = NOW() WHERE id = #{id}")
    void updateIsActiveForUser(@Param("id") Integer id, @Param("isActive") String isActive);




}
