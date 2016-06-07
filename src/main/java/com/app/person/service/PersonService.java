package com.app.person.service;

import com.app.person.Person;

import java.util.List;

public interface PersonService {
    Person addOrUpdatePerson(Person person);
    void deletePerson(Person person);
    Person getPersonById(String id);
    List<Person> search(String query);
}
