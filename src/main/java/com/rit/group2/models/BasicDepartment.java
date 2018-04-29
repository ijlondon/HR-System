package com.rit.group2.models;

import java.util.HashSet;
import java.util.Set;

public class BasicDepartment {

	private int id;
	
	private String name;
	
	private Set<BasicEmployee> workers;
	
	public BasicDepartment(){}
	
	public BasicDepartment(Department department, Set<Employee> workers){
		this.id = department.getId();
		this.name = department.getName();
		
		Set<BasicEmployee> basicWorkers = new HashSet<>();
		for(Employee employee: workers){
			basicWorkers.add(new BasicEmployee(employee));
		}
		this.workers = basicWorkers;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<BasicEmployee> getWorkers() {
		return workers;
	}
	
}
