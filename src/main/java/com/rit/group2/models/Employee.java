package com.rit.group2.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	@OneToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
	private Address address;
	
	private String telephone;
	
	private String email;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade =  CascadeType.PERSIST)
	private Department department;
	
	private String jobTitle;
	
	private int salary;
	
	private boolean active;

	private boolean admin;
	
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Employee boss;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Employee> workers;
	
	public Employee(){
		workers = new HashSet<Employee>();
		this.active = true;
	}
	
	public Employee(String firstName, String lastName, Address address, String telephone, String email, Department department, int salary, String jobTitle){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.department = department;
		this.salary = salary;
		this.active = true;
		this.admin = false;
		this.jobTitle = jobTitle;
		workers = new HashSet<Employee>();
	}
	
	public int getId(){
		return id;
	}

	// TODO: Remove for R2
	public void setId(int id){
		this.id = id;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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
		this.workers = new HashSet<>();
	}
	
	public boolean getAdmin(){
		return admin;
	}

	public void setAdmin(boolean admin){
		this.admin = admin;
	}

	public BasicEmployee getBoss() {
		return new BasicEmployee(boss);
	}
	
	public Employee fetchBoss(){
		return boss;
	}

	public void setBoss(Employee boss){
		this.boss = boss;
	}

	public Set<BasicEmployee> getWorkers(){
		Set<BasicEmployee> basicWorkers = new HashSet<>();
		for(Employee worker: workers){
			basicWorkers.add(new BasicEmployee(worker));
		}
		return basicWorkers;
	}
	
	public Set<Employee> fetchRawWorkers(){
		return workers;
	}
	
	public void setWorkers(Set<Employee> workers){
		this.workers = workers;
	}
	
	public void addWorker(Employee worker){
		this.workers.add(worker);
	}
	
	public void removeWorker(Employee worker){
		this.workers.remove(worker);
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
}
