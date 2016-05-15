package com.app.person.dao;

import com.app.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class MongoPersonDao implements PersonDao {

    @Autowired
    private MongoOperations mongoOperation;

    @Override
    public Person addPerson(Person person) {
        mongoOperation.save(person);
        return person;
    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(Person person) {
        mongoOperation.remove(person);
    }

    @Override
    public Person getPersonById(String id) {
        return null;
    }
}
