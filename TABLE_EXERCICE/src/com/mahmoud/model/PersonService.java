package com.mahmoud.model;

import java.util.List;

public interface PersonService {

	public List<Person> findAll();
	
	public void addPerson(Person person);
	
}
