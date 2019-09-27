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

@WebServlet("/viewEmployee")
public class ViewEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee e = new Employee();

    public ViewEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eId = Integer.parseInt(request.getParameter("viewId"));
		EmployeeService eserv = new EmployeeService();
		e=eserv.viewEmp(eId);
		request.setAttribute("employ", e);
		RequestDispatcher rd = request.getRequestDispatcher("listEmployee.jsp");
		rd.forward(request, response);
	}

}
