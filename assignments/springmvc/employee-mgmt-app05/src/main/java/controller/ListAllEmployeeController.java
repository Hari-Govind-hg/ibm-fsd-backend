package controller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Employee;
import services.*;

@WebServlet("/listAllEmployee.do")
@Controller
public class ListAllEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService eserv = new EmployeeService();

    public ListAllEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @RequestMapping(value = "/listAll.do", method = RequestMethod.GET)
   	public String saveEmployeePage(Model model) {
    	
    	List<Employee> listEmp = eserv.viewAllEmp();
    	for(Employee e:listEmp) {
    		System.out.println(e.getEmpName());
    		System.out.println(e.getAge());
    		System.out.println(e.getDept());
    		System.out.println(e.getDesig());
    		System.out.println(e.getSalary());
    	}
       	model.addAttribute("listEmp",listEmp);
   		System.out.println("Entering View All Employee Form");
//   		return "listEmployees";
   		return "listEmployees";
   	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		EmployeeService eserv = new EmployeeService();
//		List<Employee> listEmp = eserv.viewAllEmp();
//		request.setAttribute("empList", listEmp);
//		RequestDispatcher rd = request.getRequestDispatcher("listEmployees.jsp");
//		rd.forward(request, response);
//	}

}
