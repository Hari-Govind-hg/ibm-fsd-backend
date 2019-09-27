package com.examples.empapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.empapp.model.*;
import com.examples.empapp.services.*;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee e = new Employee();
       
    public DeleteEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eId = Integer.parseInt(request.getParameter("delId"));
		EmployeeService eserv = new EmployeeService();
		System.out.println(eId);
		eserv.deleteEmp(eId);
		
		RequestDispatcher rd = request.getRequestDispatcher("listAllEmployee.do");
		rd.forward(request, response);
	}

}
