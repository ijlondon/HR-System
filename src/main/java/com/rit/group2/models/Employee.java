package com.rit.group2.models;

import javax.persistence.Entity;

@Entity
public class Employee {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private Address address;
	
	private String telephone;
	
	private String email;
	
	private int salary;
	
	private boolean active;
	
	public Employee(){
		this.active = true;
	}
	
	public Employee(String firstName, String lastName, Address address, String telephone, String email, int salary){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.salary = salary;
		this.active = true;
	}
	
	public int getId(){
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public boolean getActive(){
		return active;
	}
	
	public void terminate(){
		this.active = false;
	}
	
	
}
