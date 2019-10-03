package controller;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.*;
import services.*;

//@WebServlet("/addEmployeeController")
@Controller
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee emp = new Employee(); 
	EmployeeService eserv = new EmployeeService();
	
    public AddEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @RequestMapping(value = "/emp/add", method = RequestMethod.GET)
	public String saveEmployeePage(Model model) {
    	model.addAttribute("emp",new Employee());
		System.out.println("Entering Add Employee Form");
		return "addEmployee";
	}
    
    @RequestMapping(value = "/emp/addEmp.do", method = RequestMethod.POST)
	public String saveEmployeeAction(@ModelAttribute("emp") Employee empl,BindingResult bindingResult, Model model) {
		System.out.println(empl.getEmpName());
		System.out.println(empl.getAge());
		emp.setEmpName(empl.getEmpName());
		emp.setAge(empl.getAge());
		emp.setDept(empl.getDesig());
		emp.setDesig(empl.getDept());
		emp.setSalary(empl.getSalary());		
		eserv.addEmp(empl);
		model.addAttribute("emp", emp);
		return "redirect:/listAll.do";
		
	}

}
