package com.app.person.service;

import com.app.person.Person;
import com.app.person.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDaoImp implements PersonService{

    @Autowired
    private PersonDao dao;

    @Override
    public Person addOrUpdatePerson(Person person) {
        return null;
    }

    @Override
    public void deletePerson(Person person) {

    }

    @Override
    public Person getPersonById(String id) {
        return null;
    }
}
