package org.bunnysugar.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.bunnysugar.pojo.User;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users (account, password, email, name, gender, phone, birthday, bunny_coin, is_active, verifying_token, forget_token, login_method, google_token, facebook_token, game_times, create_time, update_time) VALUES (#{account}, #{password}, #{email}, #{name}, #{gender}, #{phone}, #{birthday}, #{bunnyCoin}, #{isActive}, #{verifyingToken}, #{forgetToken}, #{loginMethod}, #{googleToken}, #{facebookToken}, #{gameTimes}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);

    @Select("SELECT * FROM users WHERE id = #{id}")
    User selectUserById(Integer id);


}
