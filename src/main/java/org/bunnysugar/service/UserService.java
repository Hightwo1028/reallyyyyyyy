package org.bunnysugar.service;

import org.bunnysugar.pojo.User;

public interface UserService {
    Integer registerUserAndAll(User user);
    User SelectUserById(Integer id);
    User findByUserAccount(String account);
    void updateIsActiveForUser(Integer id, String isActive);
    void verifyUser(Integer userId, String token);
}
