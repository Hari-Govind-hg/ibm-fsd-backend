package services;

import model.Employee;
import java.util.*;

public interface IEmployeeService{
	
	public void addEmp(Employee emp);
	public Employee viewEmp(int id);
	public void updateEmp(int id);
	public void deleteEmp(int id);
	public List viewAllEmp();
	public void importEmp();
	public void exportEmp();
}