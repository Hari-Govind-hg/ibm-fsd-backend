<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Employee"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Employees</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h3>List of Employees</h3>
<%-- <%Employee emp =(Employee)request.getAttribute("employ");%> --%>
<form:form method="get" modelAttribute="emp">
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
				<th scope="col">${emp.getEmpId()} </th>
				<th scope="col">${emp.getEmpName()} </th>
				<th scope="col">${emp.getAge()}</th>
				<th scope="col">${emp.getDesig()}</th>
				<th scope="col">${emp.getDept()}</th>
				<th scope="col">${emp.getSalary()}</th>
				<form:form action="emp/del.do" method="post">
				<th scope="col"><button type="btn" name="delId" value=${empl.getEmpId()} >DELETE</button></th>
				</form:form>
				<td><a href="/emp/update"><button type="btn" name="updateId" value=${empl.getEmpId()}>UPDATE</button></a></td>
			</tr>
			</tr>
		</tbody>
		</tbody>
	</table>
	</form:form>
	<br>
	<a href="../">Back to Menu</a>
</body>
</html>