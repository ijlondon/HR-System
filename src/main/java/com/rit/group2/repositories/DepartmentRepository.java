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
		Set<Employee> workers = new HashSet<>();
		Set<Employee> workers1 = new HashSet<>();
		Set<Employee> workers2 = new HashSet<>();
		Set<Employee> workers3 = new HashSet<>();

		for (int i=4; i<24; i++) {
				if( i <= 8)
					{workers.add(employees.get(i));}
				else if ( i <= 13 )
					{workers1.add(employees.get(i));}
				else if ( i <= 18)
					{workers2.add(employees.get(i));}
				else if ( i < 24)
					{workers3.add(employees.get(i));}
		}

		departments.add(new Department("Software Testing 0", employees.get(0), workers));
		departments.add(new Department("Software Testing 1", employees.get(1), workers1));
		departments.add(new Department("Software Testing 2", employees.get(2), workers2));
		departments.add(new Department("Software Testing 3", employees.get(3), workers3));
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
