package com.rit.group2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rit.group2.controllers.DepartmentController;
import com.rit.group2.controllers.EmployeeController;
import com.rit.group2.models.Address;
import com.rit.group2.models.Department;
import com.rit.group2.models.Employee;
import com.rit.group2.responses.Response;
import com.rit.group2.responses.SuccessfulResponse;
import com.rit.group2.services.DepartmentService;
import com.rit.group2.services.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DepartmentController.class)
public class DepartmentControllerTest {
    
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;
	private Employee head;
	private Employee worker;
	
	@Before
	public void setup(){
		worker = new Employee("Nathan", "Connor", new Address("300 Lomb Road", "Rochester", "NY", 14589), "(585)-589-5809", "nxc5929@rit.edu", 1, "tester");
		Set<Employee> workers = new HashSet<>();
		workers.add(worker);
		head = new Employee("Kaylie", "Glynn", new Address("300 Lomb Road", "Rochester", "NY", 14589), "(585)-589-3455", "kcg3450@rit.edu", 1, "tester");
		department = new Department("Testing", head, workers);
	}
	
	@Test
	public void getAllDepartments() throws Exception{
		ArrayList<Department> departments = new ArrayList<>();
		departments.add(department);
		Response response = new SuccessfulResponse("Retrieved all Employees", departments);
		
		when(departmentService.getAll()).thenReturn(response);
		
		System.out.println("Testing /department...");
		mvc.perform(
				get("/department")
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("error", is(false)))
				.andExpect(jsonPath("data.[0].name", is(department.getName())))
				.andExpect(jsonPath("data.[0].head.firstName", is(department.getHead().getFirstName())));
	}
	
	@Test
	public void createDepartment() throws Exception{
		Response response = new SuccessfulResponse("Successfully created", department);
		
		when(departmentService.createDepartment(null)).thenReturn(response);
		System.out.println("Testing /department/create");
		mvc.perform(
				post("/department/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(department))
				)
				.andExpect(status().isOk());
	}
	
	@Test
	public void getDepartment() throws Exception{
		Response response = new SuccessfulResponse("Successfully created", department);
		
		when(departmentService.getDepartment(0)).thenReturn(response);
		System.out.println("Testing /department/0...");
		mvc.perform(
				get("/department/0")
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("data.name", is(department.getName())))
				.andExpect(jsonPath("data.head.firstName", is(department.getHead().getFirstName())));;
	}
	
//	@Test
//	public void editDepartment() throws Exception{
//		Response response = new SuccessfulResponse("Successfully created", department);
//		
//		when(departmentService.editDepartment(0, null)).thenReturn(response);
//		System.out.println("Testing /department/0/edit...");
//		mvc.perform(
//				post("/department/0/edit")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(objectMapper.writeValueAsString(department))
//				)
//				.andExpect(status().isOk());
//	}
	
}