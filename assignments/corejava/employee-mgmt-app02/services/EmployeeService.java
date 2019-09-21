package com.Java.Assignment1_jdbc.services;

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

import com.Java.Assignment1_jdbc.dao.*;
import com.Java.Assignment1_jdbc.model.Employee;

public class EmployeeService{
	public HashMap<Integer,Employee> empMap=new HashMap<Integer,Employee>();
	Scanner sc = new Scanner(System.in);
	EmployeeDAO dao = new EmployeeDAO();
	
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
		Employee e = new Employee();
		e=empMap.get(id);
		if(empMap.containsKey(id)) {
			System.out.println("Enter the Id");
			e.setEmpId(sc.nextInt());
			System.out.println("Enter the Name");
			e.setEmpName(sc.next());
			System.out.println("Enter the Age");
			e.setAge(sc.nextInt());
			System.out.println("Enter the Designation");
			e.setDesig(sc.next());
			System.out.println("Enter the Department");
			e.setDept(sc.next());
			System.out.println("Enter the Salary");
			e.setSalary(sc.nextInt());
			System.out.println("Updated Successfully");
		}
		else {
			System.out.println("Employee record not found");
		}
	}
	
	
	public void deleteEmp(int id) {
		viewAllEmp();
		dao.delEmpDb(id);
		System.out.println("Deleted successfully");
	}
	
	
	public void viewAllEmp(){
		empMap = dao.viewAllEmpDb();
		if(empMap!=null) {
			for(Employee e:empMap.values()) {
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
            		Employee empfile = new Employee(Integer.parseInt(emp[0]), emp[1], Integer.parseInt(emp[2]), emp[3], emp[4], Integer.parseInt(emp[5]));
            		dao.addEmpDb(empfile);
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
			empMap = dao.viewAllEmpDb();
			for(Employee e:empMap.values()) {
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
