package com.rit.group2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rit.group2.models.Employee;
import com.rit.group2.responses.Response;
import com.rit.group2.services.EmployeeService;

@RestController()
@RequestMapping(value = "/employee")
@CrossOrigin(origins = {"${settings.cors_origin}"})
@EnableAutoConfiguration
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/init")
    public Response initEmployees() {
		return employeeService.init();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "")
    public Response getAllEmployees() {
		return employeeService.getAll();
    }

	@RequestMapping(method = RequestMethod.GET, value = "/userInfo")
    public Response getUserInfo(@RequestHeader("Authorization") String token) {
        return employeeService.userInfo(token);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/canEdit")
    public Response canEditEmployee(@RequestHeader("Authorization") String token, @RequestParam int toModifyId) {
        return employeeService.canUserEdit(token, toModifyId);
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
    		@RequestHeader("Authorization") String token,
    		@PathVariable("employeeId") int employeeId,
    		@RequestBody Employee employeeEdits
    		) {
        return employeeService.editEmployee(token, employeeId, employeeEdits);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/{employeeId}/terminate")
    public Response terminateEmployee(
    		@RequestHeader("Authorization") String token,
    		@PathVariable("employeeId") int employeeId
    		) {
        return employeeService.terminateEmployee(token, employeeId);
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
