package com.app.person.dao;

import com.app.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public class MongoPersonDao implements PersonDao {

    @Autowired
    private MongoOperations mongoOperation;

    @Override
    public Person addOrUpdatePerson(Person person) {
        mongoOperation.save(person);
        return person;
    }

    @Override
    public void deletePerson(String id) {
        Person person = new Person();
        person.setId(id);
        mongoOperation.remove(person);
    }

    @Override
    public Person getPersonById(String id) {
        return mongoOperation.findOne(new Query(Criteria.where("_id").is(id)), Person.class);
    }

    @Override
    public List<Person> search(String query) {
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        return mongoOperation.find(new Query(Criteria.where("name").regex(pattern)), Person.class);
    }
}
