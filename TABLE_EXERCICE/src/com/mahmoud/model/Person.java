package com.mahmoud.model;

public class Person {
	private String ID;
	private String firstName;
	private String lastName;

	public Person(String iD, String firstName, String lastName) {
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
