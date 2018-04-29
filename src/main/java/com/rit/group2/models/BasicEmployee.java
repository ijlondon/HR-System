package com.rit.group2.models;

public class BasicEmployee {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	public BasicEmployee(){}
	
	public BasicEmployee(Employee employee){
		if (employee != null) {
			this.id = employee.getId();
			this.firstName = employee.getFirstName();
			this.lastName = employee.getLastName();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}
}
