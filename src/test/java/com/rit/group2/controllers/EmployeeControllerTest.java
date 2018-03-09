package com.rit.group2.controllers;

import com.rit.group2.HrSystemApplication;
import com.rit.group2.responses.SuccessfulResponse;
import com.rit.group2.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes=HrSystemApplication.class)
@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
  @Autowired
  private MockMvc mvc;

  @MockBean
  private EmployeeService service;

  @Test
  public void getAllEmployeesShouldReturnMessageFromService() throws Exception {
    // Arrange
    String expectedMessage = "Retrieved all employees";
    String endpoint = "/employee";
    when(service.getAll()).thenReturn(new SuccessfulResponse(expectedMessage, null));
    // Act
    this.mvc.perform(get(endpoint)).andDo(print())
    // Assert
      .andExpect(status().isOk())
      .andExpect(content().string(containsString(expectedMessage)));
  }

  @Test
  public void getEmployeeShouldReturnMessageFromService() throws Exception {
    // Arrange
    int id = 0;
    String endpoint = "/employee/" + id;
    when(service.getEmployee(id)).thenReturn(new SuccessfulResponse("hit get employee endpoint", null));
    // Act
    this.mvc.perform(get(endpoint)).andDo(print())
    // Assert
      .andExpect(status().isOk())
      .andExpect(content().string(containsString("hit get employee endpoint")));
  }

  @Test
  public void searchsShouldReturnMessageFromService() throws Exception {
    // Arrange
    String query = "asdf";
    String endpoint = "/employee/search?toSearch=" + query;
    String expectedMessage = "hit searchs endpoint with argument " + query;
    when(service.search(query)).thenReturn(new SuccessfulResponse(expectedMessage, null));
    // Act
    this.mvc.perform(get(endpoint)).andDo(print())
    // Assert
      .andExpect(status().isOk())
      .andExpect(content().string(containsString(expectedMessage)));
  }
}
