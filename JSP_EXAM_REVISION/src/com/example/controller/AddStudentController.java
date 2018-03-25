package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Student;
import com.example.services.StudentService;
import com.example.services.StudentServiceImpl;

@WebServlet("/addStudent")
public class AddStudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StudentService studentService;

	@Override
	public void init() throws ServletException {
		studentService = new StudentServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		List<Student> findAll = studentService.findAll();
		long count = findAll.stream()
				.filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName)).count();
		if (count > 0) {
			req.setAttribute("alreadyExist", findAll);
		}
		if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty() && count == 0)
			studentService.addStudent(new Student(1, firstName, lastName));

		req.setAttribute("personsList", findAll);

		req.getRequestDispatcher("/view/StudentForm.jsp").forward(req, resp);
	}
}
