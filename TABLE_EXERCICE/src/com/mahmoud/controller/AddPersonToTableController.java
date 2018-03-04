package com.mahmoud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mahmoud.model.Person;
import com.mahmoud.model.PersonService;

@WebServlet("/index")
public class AddPersonToTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonService personService;

	@Override
	public void init() throws ServletException {
		personService = new PersonServiceImpl();
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		if(id != null && !id.isEmpty() && firstName !=null && !firstName.isEmpty() && lastName !=null && !lastName.isEmpty()){
		long count = personService.findAll().stream().filter(e->e.getID().equals(id)).count();
		if(count > 0) {
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('deadbeef');");  
			out.println("</script>");
		}else {
		Person person = new Person(id, firstName, lastName);
		personService.addPerson(person);
		}
	}
		request.setAttribute("persons", personService.findAll());
		request.getRequestDispatcher("/PersonForm.jsp").forward(request, response);
	}
	
}
