package com.app.person.dao;

import com.app.person.Person;

import java.util.List;

public interface PersonDao {
    Person addOrUpdatePerson(Person person);
    void deletePerson(String id);
    Person getPersonById(String id);
    List<Person> search(String query);
	List<Person> getPage(int pageNum, int pageSize, String searchQuery);
	List<Person> getAllPeople(int pageNum, int pageSize);
}
