package com.rit.group2.models;

import java.util.HashSet;
import java.util.Set;

public class BasicDepartment {

	private String name;

	private BasicEmployee head;

	private Set<BasicEmployee> workers;
	
	public BasicDepartment(){}
	
	public BasicDepartment(String name, BasicEmployee head, Set<BasicEmployee> workers){
		this.name = name;
		this.head = head;
		this.workers = workers;
	}
	
	public BasicDepartment(Department department){
		this.name = department.getName();
		this.head = new BasicEmployee(department.getHead());
		workers = new HashSet<>();
		getAllWorkers(department.getHead());
	}
	
	private void getAllWorkers(Employee employee){
		workers.add(new BasicEmployee(employee));
		for(Employee worker: employee.getWorkers()){
			getAllWorkers(worker);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BasicEmployee getHead() {
		return head;
	}

	public void setHead(BasicEmployee head) {
		this.head = head;
	}

	public Set<BasicEmployee> getWorkers() {
		return workers;
	}

	public void setWorkers(Set<BasicEmployee> workers) {
		this.workers = workers;
	}

}
