package com.app.person.service;

import com.app.person.Person;
import com.app.person.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    private PersonDao personDao;

    @Override
    public Person addOrUpdatePerson(Person person) {
        return personDao.addOrUpdatePerson(person);
    }

    @Override
    public void deletePerson(String id) {
        personDao.deletePerson(id);
    }

    @Override
    public Person getPersonById(String id) {
        return personDao.getPersonById(id);
    }

    @Override
    public List<Person> search(String query) {
        return personDao.search(query);
    }

    @Override
    public List<Person> getPage(int pageNum, int pageSize, String searchQuery) {
        return personDao.getPage(pageNum, pageSize, searchQuery);
    }

    @Override
    public List<Person> getAllMovies(int pageNum, int pageSize) {
        return personDao.getAllPeople(pageNum, pageSize);
    }

    @Override
    public Hashtable<String, String> getPeopleByIds(Set<String> ids) {
        return personDao.getPeopleByIds(ids);
    }
}
