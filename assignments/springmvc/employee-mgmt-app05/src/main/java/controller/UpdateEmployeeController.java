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

import model.Employee;
import services.EmployeeService;


//@WebServlet("/updateEmployee.do")
@Controller
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee e= new Employee();
	EmployeeService eserv = new EmployeeService();
	int id;
       
    public UpdateEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @RequestMapping(value = "/emp/update", method = RequestMethod.GET)
	public String saveEmployeePage(Model model) {
    	model.addAttribute("emp",new Employee());
		System.out.println("Entering Add Employee Form");
		return "updateEmployee";
	}
    
    @RequestMapping(value = "/emp/updateEmp.do", method = RequestMethod.POST)
	public String saveEmployeeAction(@ModelAttribute("emp") Employee emp,BindingResult bindingResult, Model model) {
		System.out.println(emp.getEmpName());
		System.out.println(emp.getAge());		
		eserv.updateEmp(emp);
		model.addAttribute("emp", emp);
		return "home";
		
	}

}
