package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.*;
import services.*;

//@WebServlet("/deleteEmployee")
@Controller
public class DeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee e = new Employee();
	EmployeeService eserv = new EmployeeService();
       
    public DeleteEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @RequestMapping(value = "/emp/del", method = RequestMethod.GET)
	public String saveEmployeePage(Model model) {
    	model.addAttribute("empl",new Employee());
		System.out.println("Entering Delete Employee Form");
		return "deleteEmployee";
	}
    
    @RequestMapping(value = "/emp/delEmp.do", method = RequestMethod.POST)
	public String deleteEmployeeAction(@ModelAttribute("empl") Employee empl,BindingResult bindingResult, Model model) {
    	System.out.println(empl.getEmpId());
    	eserv.deleteEmp(empl.getEmpId());
    	return "home";
    }
    
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int eId = Integer.parseInt(request.getParameter("delId"));
//		System.out.println(eId);
//		eserv.deleteEmp(eId);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("listAllEmployee.do");
//		rd.forward(request, response);
//	}

}
