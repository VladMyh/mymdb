package com.app.person.dao;

import com.app.person.Person;

import java.util.List;

public interface PersonDao {
    Person addOrUpdatePerson(Person person);
    void deletePerson(Person person);
    Person getPersonById(String id);
    List<Person> search(String query);
}
