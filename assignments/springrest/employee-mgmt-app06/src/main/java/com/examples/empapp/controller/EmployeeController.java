package com.examples.empapp.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService eserv;
	@Autowired
	Employee emp;
	//GET  /employees		=> List All Employees
//	@RequestMapping(method=RequestMethod.GET)		//We are using @GetMapping for obtaining the same
	@GetMapping
	public List<Employee> getEmployees(){
		return eserv.viewAllEmp();
	}
	
	
	//GET  /employees/id		=> List specific Employees
	@GetMapping(value="/{id}")
	public Employee get(@PathVariable int id){
		return eserv.viewEmp(id);
	}
	
	//POST /employees			=> Create Employee
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE})
	public String CreateEmployee(@RequestBody Employee empl) {
		boolean status = eserv.addEmp(empl);
		return status ?"Employee Created Failed":"Employee Creation Successful";
	}
	
	@PutMapping(value="/{id}")
	public String UpdateEmployee(@PathVariable int id,@RequestBody Employee empl) {
		empl.setEmpId(id);
		eserv.updateEmp(empl);
		return "Employee Created Successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		eserv.deleteEmp(id);
		return "Employee deleted successfully";
	}	
}
