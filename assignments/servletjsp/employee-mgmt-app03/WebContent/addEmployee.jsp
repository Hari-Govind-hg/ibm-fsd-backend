<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Add Employee</title>
</head>
<body>
<div><h1>Add Employee</h1></div>
<div>
<form action="addEmployeeController" method="post">
<label for="empName">Employee Name</label>
<input type="text" id="empName" name="empName" placeholder="Enter the name here"><br><br>

<label for="empAge">Employee Age</label>
<input type="text" id="empAge" name="empAge" placeholder="Enter the age here"><br><br>

<label for="empDept">Employee Department</label>
<input type="text" id="empDept" name="empDept" placeholder="Enter the department here"><br><br>

<label for="empDesig">Employee Designation</label>
<input type="text" id="empDesig" name="empDesig" placeholder="Enter the designation here"><br><br>

<label for="empSal">Employee Salary</label>
<input type="text" id="empSal" name="empSal" placeholder="Enter the salary here"><br><br>

<input type="submit" id="addEmp" placeholder="ADD">
<input type="reset" id="resetEmp" placeholder="RESET">
</form>
<a href="index.jsp">BACK</a>
</div>

</body>
</html>