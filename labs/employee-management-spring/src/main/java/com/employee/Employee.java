package com.employee;

import java.util.List;
import java.time.LocalDate;

public class Employee {
	int id;
	String name;
	Address address;
	java.util.List<String> skills;
	boolean isActive;
	LocalDate date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public java.util.List<String> getSkills() {
		return skills;
	}

	public void setSkills(java.util.List<String> skills) {
		this.skills = skills;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Employee() {
	}

	public Employee(int id, String name, Address address,LocalDate date, java.util.List<String> skills2, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.skills = skills2;
		this.isActive = isActive;
		this.date =date;
	}
	
	
}
