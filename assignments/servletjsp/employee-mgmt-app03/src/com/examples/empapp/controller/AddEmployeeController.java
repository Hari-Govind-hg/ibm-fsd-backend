package com.examples.empapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.empapp.model.*;
import com.examples.empapp.services.*;

@WebServlet("/addEmployeeController")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee e = new Employee();  
	
    public AddEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("empName");
		int age = Integer.parseInt(request.getParameter("empAge"));
		String dept = request.getParameter("empDept");
		String desig = request.getParameter("empDesig");
		int sal = Integer.parseInt(request.getParameter("empSal"));
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(dept);
//		
		e.setEmpName(name);
		e.setAge(age);
		e.setDept(dept);
		e.setDesig(desig);
		e.setSalary(sal);
//		
		EmployeeService eserv = new EmployeeService();
		eserv.addEmp(e);
	
		RequestDispatcher rd = request.getRequestDispatcher("listAllEmployee.do");
		rd.forward(request, response);
		
	}

}
