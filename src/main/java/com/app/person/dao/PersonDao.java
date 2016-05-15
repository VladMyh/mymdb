package com.app.person.dao;

import com.app.person.Person;

public interface PersonDao {
    Person addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
    Person getPersonById(String id);
}
