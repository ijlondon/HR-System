package com.rit.group2.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rit.group2.models.BasicDepartment;
import com.rit.group2.models.Department;
import com.rit.group2.models.Employee;
import com.rit.group2.repositories.DepartmentRepository;
import com.rit.group2.responses.ErrorResponse;
import com.rit.group2.responses.Response;
import com.rit.group2.responses.SuccessfulResponse;

@Service("departmentService")
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Response createDepartment(Department newDepartment) {
		departmentRepository.save(newDepartment);
		return new SuccessfulResponse("Successfully created department", newDepartment);
	}

	public Response getDepartment(int departmentId) {
		Department department = departmentRepository.findById(departmentId);
		if(department == null){
			return new ErrorResponse("Unable to find department");
		}
		Set<Employee> workers = departmentRepository.findWorkersByDepartmentId(departmentId);
		return new SuccessfulResponse("Successfully retreived department", new BasicDepartment(department, workers));
	}

	public Response editDepartment(int departmentId, Department departmentEdits) {
		Department originalDepartment = departmentRepository.findById(departmentId);
		if(originalDepartment == null){
			return new ErrorResponse("Unable to find department");
		}
		if(departmentEdits.getName() != null) {
			originalDepartment.setName(departmentEdits.getName());
		}
		departmentRepository.save(originalDepartment);
		return new SuccessfulResponse("Successfully edited department", originalDepartment);
	}

	public Response deleteDepartment(int departmentId) {
		Department department = departmentRepository.findById(departmentId);
		if(department == null){
			return new ErrorResponse("Unable to find department");
		}
		departmentRepository.delete(department);
		return new SuccessfulResponse("Successfully retreived department", department);
	}

	public Response getAll() {
		return new SuccessfulResponse("Retrieved all departments", departmentRepository.findAll());
	}

}
