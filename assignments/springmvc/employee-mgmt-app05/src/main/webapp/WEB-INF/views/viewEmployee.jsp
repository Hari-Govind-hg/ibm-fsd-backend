<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>View Employee</title>
</head>
<body>
<div><h1>View the Employee</h1></div>
<div>
<form:form action="viewEmp.do" method="post" modelAttribute="emp">
<form:label path="empId">Enter the ID to be displayed</form:label>
<form:input type="text" id="empId" path="empId" placeholder="Enter the ID of the employee to be viewed"/><br>
<input type="submit" id="viewEmp" placeholder="View">
</form:form>
<a href="../">BACK</a>
</div>
</body>
</html>