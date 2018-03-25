package com.example.services;

import java.util.ArrayList;

import com.example.model.Student;

public class StudentServiceImpl implements StudentService{
	private ArrayList<Student> list = new ArrayList<>();
	
	
	@Override
	public void addStudent(Student student) {
		list.add(student);		
	}

	@Override
	public ArrayList<Student> findAll() {
		return list;
	}

}
