package com.examples.empapp.model;

public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 8993745505444964587L;
	int empId;
	String empName;
	int age;
	String desig;
	String dept;
	int salary;
	
	public Employee() {}
	
	public Employee(int empId, String empName, int age, String desig, String dept, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.age = age;
		this.desig = desig;
		this.dept = dept;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}


	public void printDetails() {
		// print employee details
		System.out.println("Print employee details");
		System.out.println("EmpId: " + this.getEmpId());
		System.out.println("Name: " + this.getEmpName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Designation: " + this.getDesig());
		System.out.println("Department: " + this.getDept());
		System.out.println("Salary: " + this.getSalary());
		System.out.println();
	}
}
