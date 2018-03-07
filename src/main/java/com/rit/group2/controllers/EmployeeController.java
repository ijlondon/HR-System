package com.rit.group2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rit.group2.responses.Response;
import com.rit.group2.services.EmployeeService;

@RestController()
@RequestMapping(value = "/employee")
@CrossOrigin(origins = { "http://localhost:3000", "https://hr-system-client-professionals.herokuapp.com" })
@EnableAutoConfiguration
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET, value = "")
    public Response getAllEmployees() {
		return employeeService.getAll();
    }

	@RequestMapping(method = RequestMethod.POST, value = "/create")
    public Response createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/{employeeId}")
    public Response getEmployee(@PathVariable("employeeId") int employeeId) {
        return employeeService.getEmployee(employeeId);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/{employeeId}/edit")
    public Response editEmployee(
    		@PathVariable("employeeId") int employeeId,
    		@RequestBody Employee employeeEdits
    		) {
        return employeeService.editEmployee(employeeId, employeeEdits);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/{employeeId}/terminate")
    public Response terminateEmployee(@PathVariable("employeeId") int employeeId) {
        return employeeService.terminateEmployee(employeeId);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/{employeeId}/changeDepartment")
    public Response changeEmployeeDepartment(
    		@PathVariable("employeeId") int employeeId,
    		@RequestParam("newDepartmentId") int newDepartmentId) {
        return employeeService.changeDepartments(employeeId, newDepartmentId);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
    public Response searchs(
    		@RequestParam("toSearch") String searchQuery) {
        return employeeService.search(searchQuery);
    }
	
	
}
