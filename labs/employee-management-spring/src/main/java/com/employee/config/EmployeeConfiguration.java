package com.employee.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.employee.Address;
import com.employee.Employee;

@Configuration
public class EmployeeConfiguration {
	@Bean
	public Employee employee() {
		List<String> skills= new ArrayList<String>();
		skills.add("Java");
		skills.add("HTML");
		skills.add("CSS");
		LocalDate date = LocalDate.now();
		return new Employee(123,"Nakul",address(),date,skills,true);
	}
	
	@Bean
	public Address address() {
		return new Address("Nagawara","Bangalore","India",560045);
	}
}
