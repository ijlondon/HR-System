package com.rit.group2.models;

import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Department {
	
	private int id;
	
	private String name;
	
	private Employee head;
	
	public Department(String name, Employee head){
		this.name = name;
		this.head = head;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}

	public Employee getHead() {
		return head;
	}
}