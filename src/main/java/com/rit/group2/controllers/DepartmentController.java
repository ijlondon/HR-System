package com.rit.group2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rit.group2.models.Department;
import com.rit.group2.responses.Response;
import com.rit.group2.services.DepartmentService;

@RestController()
@RequestMapping(value = "/department")
@CrossOrigin(origins = {"${settings.cors_origin}"})
@EnableAutoConfiguration
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(method = RequestMethod.GET, value = "")
	public Response getAllDepartments(){
		return departmentService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
    public Response createDepartment(@RequestBody Department department) {
       return departmentService.createDepartment(department);
    }

	@RequestMapping(method = RequestMethod.GET, value = "/{departmentId}")
    public Response getDepartment(@PathVariable("departmentId") int departmentId) {
        return departmentService.getDepartment(departmentId);
    }

	@RequestMapping(method = RequestMethod.POST, value = "/{departmentId}/edit")
    public Response editDepartment(
    		@PathVariable("departmentId") int departmentId,
    		@RequestBody Department departmentEdits
    		) {
		return departmentService.editDepartment(departmentId, departmentEdits);
    }

	@RequestMapping(method = RequestMethod.POST, value = "/{departmentId}/delete")
    public Response deleteDepartment(@PathVariable("departmentId") int departmentId) {
		return departmentService.deleteDepartment(departmentId);
    }

}
