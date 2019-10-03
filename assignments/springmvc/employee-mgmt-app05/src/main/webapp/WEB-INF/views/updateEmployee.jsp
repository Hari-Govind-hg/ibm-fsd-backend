<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Update Employee</title>
</head>
<body>
<div><h1>Update Employee</h1></div>
<div>
<form:form action="updateEmp.do" modelAttribute="emp" method="post">

<form:label path="empId">Employee ID</form:label>
<form:input type="text" id="empId" path="empId" placeholder="Enter the name here"/><br><br>

<form:label path="empName">Employee Name</form:label>
<form:input type="text" id="empName" path="empName" placeholder="Enter the name here"/><br><br>

<form:label path="age">Employee Age</form:label>
<form:input type="text" id="age" path="age" placeholder="Enter the designation here"/><br><br>

<form:label path="dept">Employee Department</form:label>
<form:input type="text" id="dept" path="dept" placeholder="Enter the department here"/><br><br>

<form:label path="desig">Employee Designation</form:label>
<form:input type="text" id="desig" path="desig" placeholder="Enter the designation here"/><br><br>

<form:label path="salary">Employee Salary</form:label>
<form:input type="text" id="salary" path="salary" placeholder="Enter the salary here"/><br><br>

<input type="submit" id="addEmp" placeholder="ADD">
<input type="reset" id="resetEmp" placeholder="RESET">
</form:form>
<a href="../">BACK</a>
</div>

</body>
</html>