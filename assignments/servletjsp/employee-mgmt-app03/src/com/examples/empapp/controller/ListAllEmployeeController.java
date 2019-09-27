package com.examples.empapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.empapp.model.Employee;
import com.examples.empapp.services.*;

@WebServlet("/listAllEmployee.do")
public class ListAllEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    public ListAllEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService eserv = new EmployeeService();
		List<Employee> listEmp = eserv.viewAllEmp();
		request.setAttribute("empList", listEmp);
		RequestDispatcher rd = request.getRequestDispatcher("listEmployees.jsp");
		rd.forward(request, response);
	}

}
