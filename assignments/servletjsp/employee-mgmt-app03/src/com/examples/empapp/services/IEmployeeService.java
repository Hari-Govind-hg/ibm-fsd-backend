package com.examples.empapp.services;

import com.examples.empapp.model.Employee;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public interface IEmployeeService{
	
	public void addEmp(Employee emp);
	public Employee viewEmp(int id);
	public void updateEmp(int id);
	public void deleteEmp(int id);
	public List viewAllEmp();
	public void importEmp();
	public void exportEmp();
}