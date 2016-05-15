package com.app.person.service;

import com.app.person.Person;

public interface PersonService {
    Person addOrUpdatePerson(Person person);
    void deletePerson(Person person);
    Person getPersonById(String id);
}
