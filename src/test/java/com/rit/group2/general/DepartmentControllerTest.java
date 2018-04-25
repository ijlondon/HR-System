//package com.rit.group2.general;
//
//import com.rit.group2.HrSystemApplication;
//import com.rit.group2.controllers.DepartmentController;
//import com.rit.group2.responses.SuccessfulResponse;
//import com.rit.group2.services.DepartmentService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ContextConfiguration(classes=HrSystemApplication.class)
//@RunWith(SpringRunner.class)
//@WebMvcTest(DepartmentController.class)
//public class DepartmentControllerTest {
//  @Autowired
//  private MockMvc mvc;
//
//  @MockBean
//  private DepartmentService service;
//
//  @Test
//  public void getAllDepartmentsShouldReturnMessageFromService() throws Exception {
//    // Arrange
//    String expectedMessage = "Retrieved all departments";
//    String endpoint = "/department";
//    when(service.getAll()).thenReturn(new SuccessfulResponse(expectedMessage, null));
//    // Act
//    this.mvc.perform(get(endpoint)).andDo(print())
//    // Assert
//      .andExpect(status().isOk())
//      .andExpect(content().string(containsString(expectedMessage)));
//  }
//
//  @Test
//  public void getDepartmentShouldReturnMessageFromService() throws Exception {
//    // Arrange
//    int id = 0;
//    String expectedMessage = "hit get department endpoint";    
//    String endpoint = "/department/" + id;
//    when(service.getDepartment(id)).thenReturn(new SuccessfulResponse(expectedMessage, null));
//    // Act
//    this.mvc.perform(get(endpoint)).andDo(print())
//    // Assert
//      .andExpect(status().isOk())
//      .andExpect(content().string(containsString(expectedMessage)));
//  }
//}
