package com.rit.group2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rit.group2.models.Department;
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
			return new ErrorResponse("Can't find department");
		}
		return new SuccessfulResponse("Successfully retreived department", department);
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
		return new SuccessfulResponse("Retrieved all departments", departmentRepository.findAll());
	}

}
