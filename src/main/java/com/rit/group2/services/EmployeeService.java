package com.rit.group2.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.rit.group2.models.BasicEmployee;
import com.rit.group2.models.Employee;
import com.rit.group2.repositories.EmployeeRepository;
import com.rit.group2.responses.ErrorResponse;
import com.rit.group2.responses.Response;
import com.rit.group2.responses.SuccessfulResponse;

@Service("employeeService")
public class EmployeeService {
	
	private EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
	
	public EmployeeService(){}

	public Response listEmployees() {
		return new SuccessfulResponse("Successfully retrieved department list", employeeRepository.getAll());
	}

	public Response createEmployee(Employee employee) {
		employeeRepository.add(employee);
		return new SuccessfulResponse("Successfully Created Employee", employee);
	}

	public Response getEmployee(int employeeId) {
		Employee employee = employeeRepository.get(employeeId);
		if(employee == null){
			return new ErrorResponse("Unable to find employee");
		}
		return new SuccessfulResponse("Successfully found employee", employee);
	}

	public Response editEmployee(int employeeId, Employee employeeEdits) {
		Employee originalEmployee = employeeRepository.get(employeeId);
		if(originalEmployee == null){
			return new ErrorResponse("Unable to find employee");
		}
		if(employeeEdits.getFirstName() != null){
			originalEmployee.setFirstName(employeeEdits.getFirstName());
		}
		if(employeeEdits.getLastName() != null){
			originalEmployee.setLastName(employeeEdits.getLastName());
		}
		if(employeeEdits.getAddress().getStreet() != null){
			originalEmployee.getAddress().setStreet(employeeEdits.getAddress().getStreet());
		}
		if(employeeEdits.getAddress().getCity() != null){
			originalEmployee.getAddress().setCity(employeeEdits.getAddress().getCity());
		}
		if(employeeEdits.getAddress().getState() != null){
			originalEmployee.getAddress().setState(employeeEdits.getAddress().getState());
		}
		if(employeeEdits.getAddress().getZip() != 0){
			originalEmployee.getAddress().setZip(employeeEdits.getAddress().getZip());
		}
		if(employeeEdits.getTelephone() != null){
			originalEmployee.setTelephone(employeeEdits.getTelephone());
		}
		if(employeeEdits.getEmail() != null){
			originalEmployee.setEmail(employeeEdits.getEmail());
		}
		return new SuccessfulResponse("Succesfully edited Employee", originalEmployee);
	}

	public Response terminateEmployee(int employeeId) {
		Employee employee = employeeRepository.get(employeeId);
		if(employee == null){
			return new ErrorResponse("Unable to find employee");
		}
		employee.terminate();
		return new SuccessfulResponse("Successfully terminated Employee", employee);
	}

	public Response changeDepartments(int employeeId, int newDepartmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response search(String searchQuery) {
		if(searchQuery == null){
			return new ErrorResponse("Search Query was empty");
		}
		ArrayList<BasicEmployee> employeesFound = new ArrayList<>();
		for(Employee employee: employeeRepository.getAll()){
			if(searchQuery.contains(employee.getFirstName()) || searchQuery.contains(employee.getLastName()) 
					|| searchQuery.contains(employee.getTelephone()) || searchQuery.contains(employee.getEmail())){
				employeesFound.add(new BasicEmployee(employee));
			}
		}
		return new SuccessfulResponse("Found " + employeesFound.size() + " matches", employeesFound);
	}

	
	
}
