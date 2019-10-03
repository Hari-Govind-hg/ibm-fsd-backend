<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Delete Employee</title>
</head>
<body>
<div><h1>Delete the Employee</h1></div>
<div>
<form:form action="delEmp.do" method="post" modelAttribute="empl">
<form:label path="empId">Enter the ID to be deleted</form:label>
<form:input type="text" id="delId" path="empId" placeholder="Enter the ID of the employee to be deleted"/><br>
<input type="submit" id="delEmp" placeholder="DELETE">
</form:form>
<a href="../">BACK</a>
</div>
</body>
</html>