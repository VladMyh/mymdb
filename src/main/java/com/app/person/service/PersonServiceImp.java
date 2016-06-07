package com.app.person.service;

import com.app.person.Person;
import com.app.person.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    private PersonDao personDao;

    @Override
    public Person addOrUpdatePerson(Person person) {
        return personDao.addOrUpdatePerson(person);
    }

    @Override
    public void deletePerson(Person person) {
        personDao.deletePerson(person);
    }

    @Override
    public Person getPersonById(String id) {
        return personDao.getPersonById(id);
    }

    @Override
    public List<Person> search(String query) {
        return personDao.search(query);
    }
}
