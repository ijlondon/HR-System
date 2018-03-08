package com.rit.group2.repositories;


import java.util.ArrayList;

import com.rit.group2.models.Address;
import com.rit.group2.models.Employee;

public class EmployeeRepository {

	private ArrayList<Employee> employees;

	private static EmployeeRepository employeeRepository;

	public EmployeeRepository(){
		employees = new ArrayList<Employee>();
		employees.add(new Employee("Sam", "Murry", new Address("300 Lomb Rd", "Rochester", "NY", 14580), "(585)658-9050", "test@rit.edu", 1));
		employees.add(new Employee("Nathan", "Connor", new Address("300 Lomb Rd", "Rochester", "NY", 14580), "(585)156-5490", "nxc5929@rit.edu", 1));
		employees.add(new Employee("Matt", "Anacelle", new Address("301 Lomb Rd", "Rochester", "NY", 14580), "(585)586-5975", "max5890@rit.edu", 1));
		employees.add(new Employee("Kaylie", "Glynn", new Address("300 Lomb Rd", "Rochester", "NY", 14580), "(585)963-1005", "kcg2690@rit.edu", 1));

		// TODO: Remove for R2
		int id = 0;
		for (Employee employee : employees) {
			employee.setId(id);
			employee.setJobTitle("Education Teachers")
			id++;
		}
	}

	public static EmployeeRepository getInstance(){
		if(employeeRepository == null){
			employeeRepository = new EmployeeRepository();
		}
		return employeeRepository;
	}

	public void add(Employee employee) {
		employees.add(employee);
	}

	public Employee get(int employeeId) {
		if(employeeId < employees.size()){
			return employees.get(employeeId);
		}
		return null;
	}

	public ArrayList<Employee> getAll() {
		return employees;
	}
}
