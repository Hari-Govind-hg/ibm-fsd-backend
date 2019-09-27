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
<form action="viewEmployee" method="post">
<label for="viewId">Enter the ID to be displayed</label>
<input type="text" id="viewId" name="viewId" placeholder="Enter the ID of the employee to be viewed"><br>
<input type="submit" id="viewEmp" placeholder="View">
</form>
<a href="index.jsp">BACK</a>
</div>
</body>
</html>