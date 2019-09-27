<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.examples.empapp.model.Employee"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Employees</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h3>List of Employees</h3>
<%Employee emp =(Employee)request.getAttribute("employ");%>
<table class="table table-striped table-dark table-bordered">
		<thead> 
			<tr>
				<th scope="col">ID</th>
				<td>Name</td>
				<td>Age</td>
				<td>Desig</td>
				<td>Dept</td>
				<td>Salary</td>
			</tr> 
		</thead>
		<tbody>
			<tr>
				<td><%= emp.getEmpId() %> </td>
				<td><%= emp.getEmpName() %> </td>
				<td><%= emp.getAge() %></td>
				<td><%= emp.getDesig() %></td>
				<td><%= emp.getDept() %></td>
				<td><%= emp.getSalary() %></td>
			</tr>
		</tbody>
		</tbody>
	</table>
	<br>
	<a href="index.jsp">Back to Menu</a>
</body>
</html>