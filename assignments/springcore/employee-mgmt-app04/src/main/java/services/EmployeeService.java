package services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import configuration.EmployeeConfiguration;
import dao.*;
import model.Employee;

public class EmployeeService{
	public HashMap<Integer,Employee> empMap=new HashMap<Integer,Employee>();
	Scanner sc = new Scanner(System.in);
	AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
	EmployeeDAO dao = (EmployeeDAO) ctx.getBean("dao");
	
	public void addEmp(Employee emp) {
		empMap.put(emp.getEmpId(),emp);
		dao.addEmpDb(emp);
		System.out.println("Added Successfully");
	}
	
	public void viewEmp(int id) {
			dao.viewEmpDb(id);
	}

	

	public void updateEmp(int id)
	{
		dao.updateEmpDb(id);
	}
	
	
	public void deleteEmp(int id) {
		viewAllEmp();
		dao.delEmpDb(id);
		System.out.println("Deleted successfully");
	}
	
	
	public void viewAllEmp(){
		List<Employee> eList = new ArrayList<Employee>();
		eList = dao.viewAllEmpDb();
		if(empMap!=null) {
			for(Employee e:eList) {
			e.printDetails();
		}
		}
		else {
			System.out.println("No records found");
		}
	}
	
	
	public void importEmp(){
		Scanner scan = new Scanner(System.in);
		try {
            scan = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\HariGovind\\Desktop\\FSD-Saravana\\Personal Progress\\Assignments\\src\\com\\Java\\Assignment1_jdbc\\Services\\emplist.txt"))));
            while (scan.hasNextLine()) {
            	String[] emp = scan.nextLine().split(",");
            		Employee empFile = (Employee)ctx.getBean("empnew");
            		empFile.setEmpId(Integer.parseInt(emp[0]));
            		empFile.setEmpName(emp[1]);
            		empFile.setAge(Integer.parseInt(emp[2]));
            		empFile.setDesig(emp[3]);
            		empFile.setDept(emp[4]);
            		empFile.setSalary(Integer.parseInt(emp[5]));
            		dao.addEmpDb(empFile);
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
			FileOutputStream fileOut = new FileOutputStream("C:\\\\Users\\\\HariGovind\\\\Desktop\\\\FSD-Saravana\\\\Personal Progress\\\\Assignments\\\\src\\\\com\\\\Java\\\\Assignment1_jdbc\\\\services\\\\empexp.txt");
			List<Employee> eList = new ArrayList<Employee>();
			eList = dao.viewAllEmpDb();
			for(Employee e:eList) {
				try {
					String objlist = String.format("%d,%s,%d,%s,%s,%d", e.getEmpId(),e.getEmpName(),e.getAge(),e.getDesig(),e.getDept(),e.getSalary());
					System.out.println(objlist);
					fileOut.write(objlist.getBytes());
					fileOut.write("\n".getBytes());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			fileOut.close();
		}
		catch (IOException i){
			i.printStackTrace();
		}
		
	}
}
