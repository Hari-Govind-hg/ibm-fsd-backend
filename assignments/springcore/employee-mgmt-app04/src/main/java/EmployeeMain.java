
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import model.Employee;
import services.EmployeeService;
import configuration.*;

public class EmployeeMain {
	public static void main(String[] args) {
			int option=0;
			@SuppressWarnings("resource")
			AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
			final EmployeeService eserv = (EmployeeService) ctx.getBean("eserv");
			do {
				try{@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
					System.out.println("Enter the operation to be carried out: \n 1.Add New Employee \n 2.View an Employee from the List \n 3.Update an Employee's Details \n 4.Delete an Employee \n 5.View all employees \n 6.Import Employees from file \n 7.Export Employees to file \n 10.Exit");
				option = sc.nextInt();
				switch(option) {
				case 1: try{
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
					Employee empnew = (Employee) ctx.getBean("empnew");
					empnew.setEmpId(eId);
					empnew.setEmpName(eName);
					empnew.setAge(eAge);
					empnew.setDesig(eDesig);
					empnew.setDept(eDept);
					empnew.setSalary(eSal);
						eserv.addEmp(empnew);
						}catch(InputMismatchException i) {
							System.out.println("Enter a numeric value");
						}
						break;
				case 2: try{
							System.out.println("Enter the employee id to be updated");
							int empid = sc.nextInt();
							eserv.viewEmp(empid);
							}catch(InputMismatchException i) {
							System.out.println("Enter a numeric value");
							}
						break;
				case 3: try{
							System.out.println("Enter the employee id to be updated");
							int empid = sc.nextInt();
							eserv.updateEmp(empid);
						}catch(InputMismatchException i) {
						System.out.println("Enter a numeric value");
						}
						break;
				case 4: try{
							System.out.println("Enter the employee id to be deleted");
							int empid = sc.nextInt();
							eserv.deleteEmp(empid);
					}catch(InputMismatchException i) {
					System.out.println("Enter a numeric value");
				}
						break;
				case 5: try{
					eserv.viewAllEmp();
					}catch(InputMismatchException i) {
					System.out.println("Enter a numeric value");
				}
						break;
				case 6: 				
					{
						class Sample implements Callable<String>
						{
							public String call() throws Exception 
							{
								eserv.importEmp();
					
								return "Import Completed";
							}
						}
						Callable<String> c1 = new Sample();
						ExecutorService e = Executors.newFixedThreadPool(1);
						Future<String> f =  e.submit(c1);
						while(!f.isDone())
						{
							String s =null;
							try {
								s=(String) f.get();
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ExecutionException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println(s);
							e.shutdown();
						}
						break;
						}
				case 7: {
					class Sample implements Callable<String>
					{
						public String call() throws Exception 
						{
							eserv.exportEmp();
				
							return "Expoprt Completed";
						}
					}
					Callable<String> c1 = new Sample();
					ExecutorService e = Executors.newFixedThreadPool(1);
					Future<String> f =  e.submit(c1);
					while(!f.isDone())
					{
						String s =null;
						try {
							s=(String) f.get();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ExecutionException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println(s);
						e.shutdown();
					}
					break;
					}
				}}catch(InputMismatchException i) {
					System.out.println("Please Enter a valid option");
				}
			}while(option!=10);
	}
}

