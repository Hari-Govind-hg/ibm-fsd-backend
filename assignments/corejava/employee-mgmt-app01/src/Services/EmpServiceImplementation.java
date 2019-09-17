package Services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Structures.Employee;

public class EmpServiceImplementation {
	List<Employee> empList = new ArrayList<Employee>();
	Scanner sc = new Scanner(System.in);
	
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
	
	
	public void importEmp(){
		Scanner scan = new Scanner(System.in);
		try {
            scan = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\HariGovind\\Desktop\\FSD-Saravana\\Personal Progress\\Assignments\\src\\com\\Java\\Assignment1\\Services\\emplist.txt"))));
            while (scan.hasNextLine()) {
            	String[] emp = scan.nextLine().split(",");	
            		Employee empfile = new Employee(Integer.parseInt(emp[0]), emp[1], Integer.parseInt(emp[2]), emp[3], emp[4], Integer.parseInt(emp[5]));
            		empList.add(empfile);
            }
            viewAllEmp();
        } 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		finally {
            if (scan != null) {
                scan.close();
            }
        }
	}
	
	
	public void exportEmp() {
		try {
			FileOutputStream fileOut = new FileOutputStream("C:\\\\Users\\\\HariGovind\\\\Desktop\\\\FSD-Saravana\\\\Personal Progress\\\\Assignments\\\\src\\\\com\\\\Java\\\\Assignment1\\\\Services\\\\empexp.txt");
			empList.forEach(e->{
				try {
					String objlist = String.format("%d,%s,%d,%s,%s,%d", e.getEmpId(),e.getEmpName(),e.getAge(),e.getDesig(),e.getDept(),e.getSalary());
					System.out.println(objlist);
					fileOut.write(objlist.getBytes());
					fileOut.write("\n".getBytes());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
			fileOut.close();
		}
		catch (IOException i){
			i.printStackTrace();
		}
		
	}
}
