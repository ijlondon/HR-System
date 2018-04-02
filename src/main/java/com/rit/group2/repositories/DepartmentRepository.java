package com.rit.group2.repositories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.rit.group2.models.Department;
import com.rit.group2.models.Employee;

public class DepartmentRepository {

	private ArrayList<Department> departments;

	private static DepartmentRepository departmentRepository;

	public DepartmentRepository() {
		departments = new ArrayList<>();
		ArrayList<Employee> employees = EmployeeRepository.getInstance().getAll();

		departments.add(new Department("Software Testing 0", employees.get(0)));
		departments.add(new Department("Software Testing 1", employees.get(1)));
		departments.add(new Department("Software Testing 2", employees.get(2)));
		departments.add(new Department("Software Testing 3", employees.get(3)));
	}

	public static DepartmentRepository getInstance(){
		if(departmentRepository == null){
			departmentRepository = new DepartmentRepository();
		}
		return departmentRepository;
	}

	public void add(Department department) {
		departments.add(department);
	}

	public Department get(int departmentId) {
		if(departmentId < departments.size()){
			return departments.get(departmentId);
		}
		return null;
	}

	public ArrayList<Department> getAll() {
		return departments;
	}

}
