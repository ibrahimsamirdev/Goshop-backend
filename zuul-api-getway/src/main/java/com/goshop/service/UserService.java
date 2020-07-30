package com.goshop.service;

import com.goshop.model.RoleType;
import com.goshop.model.User;

public interface UserService {
    String login(String username, String password);

    User saveUser(User user, RoleType roleType);


    Boolean isValidToken(String token);

    String createNewToken(String token);
}
