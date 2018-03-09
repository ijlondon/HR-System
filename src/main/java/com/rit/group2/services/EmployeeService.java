package com.rit.group2.services;

import java.util.ArrayList;
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

@Service("employeeService")
public class EmployeeService {

	private EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
	private DepartmentRepository departmentRepository = DepartmentRepository.getInstance();

	public EmployeeService(){}

	public Response createEmployee(Employee employee) {
		employeeRepository.add(employee);
		return new SuccessfulResponse("Successfully Created Employee", employee);
	}

	public Response getEmployee(int employeeId) {
		Employee employee = employeeRepository.get(employeeId);
		if(employee == null){
			return new ErrorResponse("Unable to find employee");
		}
		return new SuccessfulResponse("Successfully found emplyee", employee);
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
		for(Department oldDepartment: departmentRepository.getAll()){
			Set<Employee> workers = oldDepartment.getWorkers();
			for(Employee employ: workers){
				if(employ.getId() == employeeId){
					workers.remove(employ);
					break;
				}
			}
		}
		employee.terminate();
		return new SuccessfulResponse("Successfully terminated Employee", employee);
	}

	public Response changeDepartments(int employeeId, int newDepartmentId) {
		Department department = departmentRepository.get(newDepartmentId);
		Employee employee = employeeRepository.get(employeeId);
		if(department != null && employee != null){

			for(Department oldDepartment: departmentRepository.getAll()){
				Set<Employee> workers = oldDepartment.getWorkers();
				for(Employee employ: workers){
					if(employ.getId() == employeeId){
						workers.remove(employ);
						break;
					}
				}
			}
			department.getWorkers().add(employee);
			return new SuccessfulResponse("Successfully transfered employee", new BasicDepartment(department));
		}else{
			return new ErrorResponse("Can't find department and/or employee");
		}
	}

	public Response search(String searchQuery) {
		if(searchQuery == null){
			return new ErrorResponse("Search Query was empty");
		}
		ArrayList<BasicEmployee> employeesFound = new ArrayList<>();
		for(Employee employee: employeeRepository.getAll()){
			if(employee.getFirstName().contains(searchQuery) || employee.getLastName().contains(searchQuery) 
					|| employee.getTelephone().contains(searchQuery) || employee.getEmail().contains(searchQuery)){
				employeesFound.add(new BasicEmployee(employee));
			}
		}
		return new SuccessfulResponse("Found " + employeesFound.size() + " matches", employeesFound);
	}

	public Response getAll() {
		ArrayList<BasicEmployee> employees = new ArrayList<>();
		for(Employee employee: employeeRepository.getAll()){
			if(employee.getActive()){
				employees.add(new BasicEmployee(employee));
			}
		}
		return new SuccessfulResponse("Retrieved all employees", employees);
	}



}
