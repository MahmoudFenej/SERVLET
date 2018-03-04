package com.mahmoud.controller;

import java.util.ArrayList;
import java.util.List;

import com.mahmoud.model.Person;
import com.mahmoud.model.PersonService;

public class PersonServiceImpl implements PersonService{
	private List<Person> personList = new ArrayList<>();
	
	@Override
	public List<Person> findAll() {
		return personList;
	}

	@Override
	public void addPerson(Person person) {
		personList.add(person);		
	}

}
