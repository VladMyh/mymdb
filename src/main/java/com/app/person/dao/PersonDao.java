package com.app.person.dao;

import com.app.person.Person;

public interface PersonDao {
    Person addOrUpdatePerson(Person person);
    void deletePerson(Person person);
    Person getPersonById(String id);
}
