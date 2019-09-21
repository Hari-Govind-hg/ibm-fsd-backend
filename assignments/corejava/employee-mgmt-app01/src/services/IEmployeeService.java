package services;

import model.*;
public interface IEmployeeService{
	
	public void addEmp(Employee emp);
	public void viewEmp(int id);
	public void updateEmp(int id);
	public void deleteEmp(int id);
	public void viewAllEmp();
	public void importEmp();
	public void exportEmp();
}