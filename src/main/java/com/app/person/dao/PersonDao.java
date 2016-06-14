package com.app.person.dao;

import com.app.person.Person;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public interface PersonDao {
    Person addOrUpdatePerson(Person person);
    void deletePerson(String id);
    Person getPersonById(String id);
    List<Person> search(String query);
	List<Person> getPage(int pageNum, int pageSize, String searchQuery);
	List<Person> getAllPeople(int pageNum, int pageSize);
	Hashtable<String, String> getPeopleByIds(Set<String> ids);
}
