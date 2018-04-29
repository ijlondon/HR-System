package com.rit.group2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

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
import com.rit.group2.controllers.EmployeeController;
import com.rit.group2.models.Address;
import com.rit.group2.models.Employee;
import com.rit.group2.responses.Response;
import com.rit.group2.responses.SuccessfulResponse;
import com.rit.group2.services.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class)
public class EmployeeControllerTest {
    
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private EmployeeService employeeService;
	
	private Employee employee1;
	
	@Before
	public void setup(){
		employee1 = new Employee("Nathan", "Connor", new Address("300 Lomb Road", "Rochester", "NY", 14589), "(585)-589-5809", "nxc5929@rit.edu", null, 1, "tester");
	}
	
	@Test
	public void getAllEmployees() throws Exception{
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(employee1);
		Response response = new SuccessfulResponse("Retrieved all Employees", employees);
		
		when(employeeService.getAll()).thenReturn(response);
		
		System.out.println("Testing /employee...");
		mvc.perform(
				get("/employee")
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("error", is(false)))
				.andExpect(jsonPath("data.[0].firstName", is(employee1.getFirstName())))
				.andExpect(jsonPath("data.[0].lastName", is(employee1.getLastName())))
				.andExpect(jsonPath("data.[0].address.street", is(employee1.getAddress().getStreet())))
				.andExpect(jsonPath("data.[0].telephone", is(employee1.getTelephone())))
				.andExpect(jsonPath("data.[0].email", is(employee1.getEmail())));
	}
	
	@Test
	public void createEmployee() throws Exception{
		Response response = new SuccessfulResponse("Successfully created", employee1);
		
		when(employeeService.createEmployee(employee1)).thenReturn(response);
		System.out.println("Testing /employee/create...");
		mvc.perform(
				post("/employee/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee1))
				)
				.andExpect(status().isOk());
	}
	
	@Test
	public void getEmployee() throws Exception{
		Response response = new SuccessfulResponse("Successfully retreived employee", employee1);
		
		when(employeeService.getEmployee(0)).thenReturn(response);
		System.out.println("Testing /employee/0...");
		mvc.perform(
				get("/employee/0")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee1))
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("error", is(false)))
				.andExpect(jsonPath("data.firstName", is(employee1.getFirstName())))
				.andExpect(jsonPath("data.lastName", is(employee1.getLastName())));
	}
	
	@Test
	public void editEmployee() throws Exception{
		Response response = new SuccessfulResponse("Successfully created", employee1);
		
		when(employeeService.createEmployee(employee1)).thenReturn(response);
		System.out.println("Testing /employee/0/edit...");
		mvc.perform(
				post("/employee/0/edit")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee1))
				)
				.andExpect(status().isOk());
	}
	
	@Test
	public void searchEmployee() throws Exception{
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(employee1);
		Response response = new SuccessfulResponse("Retrieved all Employees", employees);
		
		when(employeeService.search("Nathan")).thenReturn(response);
		System.out.println("Testing /employee/search...");
		mvc.perform(
				get("/employee/search?toSearch=Nathan")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee1))
				)
				.andExpect(status().isOk());
	}
	
}