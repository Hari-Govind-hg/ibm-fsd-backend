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
<%List<Employee> emp =(List)request.getAttribute("empList");
out.print("No of employees:" +emp.size());
%>
<table>
		<thead> 
			<tr>
				<td>ID</td>
				<td>Name</td>
			</tr> 
		</thead>
		<tbody>
			<% for(Employee empl: emp) { %>
			<tr>
				<td><%= empl.getEmpId() %> </td>
				<td><%= empl.getEmpName() %> </td>
				<td><%= empl.getAge() %></td>
				<td><%= empl.getDesig() %></td>
				<td><%= empl.getDept() %></td>
				<td><%= empl.getSalary() %></td>
				<form action="deleteEmployee" method="post">
				<td><button type="btn" name="delId" value=<%=empl.getEmpId() %>>DELETE</button></td>
				</form>
				<td><a href="updateEmployee.jsp"><button type="btn" name="delId" value=<%=empl.getEmpId() %>>UPDATE</button></a></td>
			</tr>
			<%} %>
		</tbody>
		</tbody>
	</table>
	<br>
	<a href="index.jsp">Back to Menu</a>
</body>
</html>