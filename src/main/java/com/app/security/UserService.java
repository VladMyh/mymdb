package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {
    @Autowired
    private MongoOperations mongoOperation;


}
