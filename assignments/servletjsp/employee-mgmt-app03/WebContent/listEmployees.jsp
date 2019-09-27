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
<style type="text/css">
body{
background-color: #000000;
color: #FFF;
}
</style>
</head>
<body>
<h3>List of Employees</h3>
<%List<Employee> emp =(List)request.getAttribute("empList");
out.print("No of employees:" +emp.size());
%>
<table class="table table-striped table-dark table-bordered">
		<thead> 
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Age</th>
				<th scope="col">Desig</th>
				<th scope="col">Dept</th>
				<th scope="col">Salary</th>
			</tr> 
		</thead>
		<tbody>
			<% for(Employee empl: emp) { %>
			<tr>
				<th scope="col"><%= empl.getEmpId() %> </th>
				<th scope="col"><%= empl.getEmpName() %> </th>
				<th scope="col"><%= empl.getAge() %></th>
				<th scope="col"><%= empl.getDesig() %></th>
				<th scope="col"><%= empl.getDept() %></th>
				<th scope="col"><%= empl.getSalary() %></th>
				<form action="deleteEmployee" method="post">
				<th scope="col"><button type="btn" name="delId" value=<%=empl.getEmpId() %>>DELETE</button></th>
				</form>
				<td><a href="updateEmployee.do"><button type="btn" name="updateId" value=<%=empl.getEmpId() %>>UPDATE</button></a></td>
			</tr>
			<%} %>
		</tbody>
		</tbody>
	</table>
	<br>
	<a href="index.jsp">Back to Menu</a>
</body>
</html>