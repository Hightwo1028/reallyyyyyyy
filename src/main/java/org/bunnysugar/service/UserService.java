package org.bunnysugar.service;

import org.bunnysugar.pojo.User;

public interface UserService {
    Integer registerUserAndAll(User user);
    User SelectUserById(Integer id);
}
