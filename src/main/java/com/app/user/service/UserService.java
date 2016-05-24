package com.app.user.service;

import com.app.user.User;

public interface UserService {
    User addOrSaveUser(User user);
    void deleteUser(String id);
    User getUserByUsername(String username);
}
