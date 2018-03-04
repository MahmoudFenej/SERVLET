<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mahmoud.model.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

	<form action="index" method="GET">
		ID : <input type="text" name="id"> 
		<br>
		<br>
		FirstName : <input type="text" name="firstName"> 
		<br>
		<br>
		LastName : <input type="text" name="lastName"> 
		<br>
		<br>
		<input type="submit" value="addPerson">
		<br>
		<br>
	</form>

	<table style="width: 100%" border = 1>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<%
			Object attr= request.getAttribute("persons");
			if(attr != null){
			@SuppressWarnings("unchecked")
			List<Person> list = (ArrayList<Person>) attr;
			int i = 0;
			for (Person person : list) {
		%>
		<tr>
			<td><% out.print(person.getID());%></td>
			<td><% out.print(person.getFirstName()); %></td>
			<td><% out.print(person.getLastName()); %></td>
		</tr>
	<% 
} }
%>
	</table>

</body>
</html>