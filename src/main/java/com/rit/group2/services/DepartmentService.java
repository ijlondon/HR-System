package com.rit.group2.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.rit.group2.models.BasicDepartment;
import com.rit.group2.models.BasicEmployee;
import com.rit.group2.models.Department;
import com.rit.group2.models.Employee;
import com.rit.group2.repositories.DepartmentRepository;
import com.rit.group2.repositories.EmployeeRepository;
import com.rit.group2.responses.ErrorResponse;
import com.rit.group2.responses.Response;
import com.rit.group2.responses.SuccessfulResponse;

@Service("departmentService")
public class DepartmentService {

	private EmployeeRepository employeeRepositoy = EmployeeRepository.getInstance();
	private DepartmentRepository departmentRepository = DepartmentRepository.getInstance();
	
	public Response createDepartment(BasicDepartment newDepartment) {
		Set<Employee> workers = new HashSet<>();
		for(BasicEmployee employee: newDepartment.getWorkers()){
			Employee employeeModel = employeeRepositoy.get(employee.getId());
			workers.add(employeeModel);
		}
		Employee head = employeeRepositoy.get(newDepartment.getHead().getId());
		head.updateWorkers(workers);
		Department department = new Department(newDepartment.getName(), head, workers);
		departmentRepository.add(department);
		return new SuccessfulResponse("Successfully created department", new BasicDepartment(department));
	}

	public Response getDepartment(int departmentId) {
		Department department = departmentRepository.get(departmentId);
		if(department == null){
			return new ErrorResponse("Can't find department");
		}
		return new SuccessfulResponse("Successfully retreived department", new BasicDepartment(department));
	}

	public Response editDepartment(int departmentId, Department departmentEdits) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response deleteDepartment(int departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response getAll() {
		ArrayList<BasicDepartment> departments = new ArrayList<>();
		for(Department department: departmentRepository.getAll()){
			departments.add(new BasicDepartment(department));
		}
		return new SuccessfulResponse("Retrieved all departments", departments);
	}

}
