package com.app.user.dao;

import com.app.user.User;

public interface UserDao {
    User addOrSaveUser(User user);
    void deleteUser(String id);
    User getUserByUsername(String username);
}
