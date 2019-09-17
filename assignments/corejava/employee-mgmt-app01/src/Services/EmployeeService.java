package Services;

import Structures.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService extends EmpServiceImplementation{
	List<Employee> empList = new ArrayList<Employee>();
	Scanner sc = new Scanner(System.in);
	public void operator(){
		int option=0;
		do {System.out.println("Enter the operation to be carried out: \n 1.Add New Employee \n 2.View an Employee from the List \n 3.Update an Employee's Details \n 4.Delete an Employee \n 5.View all employees \n 6.Import Employees from file \n 7.Export Employees to file \n 10.Exit");
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
			case 6: importEmp();
					break;
			case 7: exportEmp();
					break;
			}
		}while(option!=10);
	}
}