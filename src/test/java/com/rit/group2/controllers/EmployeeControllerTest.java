package com.test;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.rit.group2.responses.Response;

import com.rit.group2.controllers.EmployeeController;
import com.rit.group2.services.EmployeeService;
import com.rit.group2.HrSystemApplication;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

// @SpringBootTest(classes=HrSystemApplication.class)
@ContextConfiguration(classes=HrSystemApplication.class)
@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
  @Autowired
  private MockMvc mvc;

  @MockBean
  private EmployeeService service;

  @Test
  public void greetingShouldReturnMessageFromService() throws Exception {
    
      // when(service.getAll()).thenReturn(new Response("Hello Mock", null, null));
      // this.mvc.perform(get("/employee")).andDo(print()).andExpect(status().isOk())
      //         .andExpect(content().string(containsString("Hello Mock")));
  }
}
