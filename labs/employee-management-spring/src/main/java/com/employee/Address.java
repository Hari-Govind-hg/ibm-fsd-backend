package com.employee;

public class Address {
	String street;
	String city;
	String country;
	int pinCode;
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public Address() {
		
	}

	public Address(String street, String city, String country, int pinCode) {
		super();
		this.street = street;
		this.city = city;
		this.country = country;
		this.pinCode = pinCode;
	}
	
	
}
