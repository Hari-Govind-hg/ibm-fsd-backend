package Services;

import Structures.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService extends Employee{
	List<Employee> empList = new ArrayList<Employee>();
	Scanner sc = new Scanner(System.in);
	public void operator() {
		int option=0;
		do {System.out.println("Enter the operation to be carried out: \n 1.Add New Employee \n 2.View an Employee from the List \n 3.Update an Employee's Details \n 4.Delete an Employee \n 5.View all employees \n 6.Exit");
			option = sc.nextInt();
			switch(option) {
			case 1: addEmp();
					break;
			case 2: viewEmp();
					break;
			case 3: updateEmp();
					break;
			case 4: deleteEmp();
					break;
			case 5: viewAllEmp();
					break;
			}
		}while(option!=6);
	}
	 
	public void addEmp() {
		System.out.println("Enter the employee ID");
		int eId = sc.nextInt();
		System.out.println("Enter the employee Name");
		String eName = sc.next();
		System.out.println("Enter the employee Age");
		int eAge = sc.nextInt();
		System.out.println("Enter the employee Designation");
		String eDesig = sc.next();
		System.out.println("Enter the employee Department");
		String eDept = sc.next();
		System.out.println("Enter the employee Salary");
		int eSal = sc.nextInt();
		Employee empnew = new Employee(eId, eName, eAge, eDesig, eDept, eSal);
		empList.add(empnew);
		System.out.println("Added Successfully");
	}
	
	public void viewEmp() {
		System.out.println("Enter the Employee Id of the employee to be viewed");
		int eId = sc.nextInt();
		empList.forEach(e->{
			if(e.getEmpId()==eId) {
				System.out.println("Employee Found:");
				e.printDetails();
			}
		});
	}

	public void updateEmp()
	{
		System.out.println("Enter the employee id to be updated");
		int empid = sc.nextInt();
		List<Employee> tempList = new ArrayList<Employee>();
		empList.forEach(e->{
				if(e.getEmpId()!=empid){
					tempList.add(e);
				}
		});
		empList = tempList;
		addEmp();
		System.out.println("Updated Successfully");
	}
	
	public void deleteEmp() {
		System.out.println("Enter the employee id to be deleted");
		int empid = sc.nextInt();
		List<Employee> tempList = new ArrayList<Employee>();
		empList.forEach(e->{
				if(e.getEmpId()!=empid){
					tempList.add(e);
				}
		});
		empList = tempList;
		viewAllEmp();
		System.out.println("Deleted successfully");
	}
	
	public void viewAllEmp(){
		empList.forEach(e->{
				e.printDetails();
		});
	}
}