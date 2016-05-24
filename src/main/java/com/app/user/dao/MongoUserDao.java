package com.app.user.dao;

import com.app.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MongoUserDao implements UserDao{

    @Autowired
    private MongoOperations mongoOperation;

    @Override
    public User addOrSaveUser(User user) {
        mongoOperation.save(user);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        mongoOperation.remove(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return mongoOperation.findOne(new Query(Criteria.where("username").is(username)), User.class);
    }
}
