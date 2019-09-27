package com.examples.empapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.empapp.model.Employee;
import com.examples.empapp.services.EmployeeService;


@WebServlet("/updateEmployee.do")
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee e= new Employee();
	int id;
       
    public UpdateEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	id = Integer.parseInt(req.getParameter("updateId"));
    	req.setAttribute("employeeId", id);
    	RequestDispatcher rd = req.getRequestDispatcher("updateEmployee.jsp");
		rd.forward(req, resp);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		id = Integer.parseInt(request.getParameter("empId"));
		String name = request.getParameter("empName");
		int age = Integer.parseInt(request.getParameter("empAge"));
		String dept = request.getParameter("empDept");
		String desig = request.getParameter("empDesig");
		int sal = Integer.parseInt(request.getParameter("empSal"));
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(dept);
//		
		e.setEmpId(id);
		e.setEmpName(name);
		e.setAge(age);
		e.setDept(dept);
		e.setDesig(desig);
		e.setSalary(sal);
//		
		EmployeeService eserv = new EmployeeService();
		eserv.updateEmp(e);
		
		RequestDispatcher rd = request.getRequestDispatcher("listAllEmployee.do");
		rd.forward(request, response);
	}

}
