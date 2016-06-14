package com.app.person.service;

import com.app.person.Person;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public interface PersonService {
    Person addOrUpdatePerson(Person person);
    void deletePerson(String id);
    Person getPersonById(String id);
    List<Person> search(String query);
	List<Person> getPage(int pageNum, int pageSize, String searchQuery);
	List<Person> getAllMovies(int pageNum, int pageSize);
	Hashtable<String, String> getPeopleByIds(Set<String> ids);
}
