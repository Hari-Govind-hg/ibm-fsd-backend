package com.employee;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.employee.config.EmployeeConfiguration;

public class AppMain {
	
	public static void main(String[] args) {
		// Assemble the objects
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		
		Employee obj = (Employee)context.getBean("employee");
		System.out.println(obj.getId()+"\n"+obj.getName()+"\n"+obj.getAddress().getStreet()+", "+obj.getAddress().getCity()+", "+obj.getAddress().getCountry()+", "+obj.getAddress().getPinCode()+"\n"+obj.getDate()+"\n"+obj.getSkills()+"\n"+obj.isActive());
context.registerShutdownHook();
}
}
