
<%@page import="java.util.ArrayList"%>
<%@page import="com.example.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/AppTagHandler.tld" prefix="printStudents"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<label> Student Form </label>
		<form action="addStudent" method="GET">
			<div class="form-group">
				<label>First Name:</label> <input type="text" class="form-control"
					name="firstName">
			</div>
			<div class="form-group">
				<label>Last Name:</label> <input type="text" class="form-control"
					name="lastName">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

	<%
		Object alreadyExist = request.getAttribute("alreadyExist");
		if (alreadyExist != null) {
			out.println("<div class=\"alert alert-danger alert-dismissible\"> <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a> <strong> Alreadt exist </strong></div>");
		}
	%>

	<%
		ArrayList<Student> list = new ArrayList<>();
		Object obj = request.getAttribute("personsList");
		if (obj != null)
			list = (ArrayList<Student>) obj;
	%>
	<printStudents:addStudent studentList="<%=list%>" />

</body>
</html>