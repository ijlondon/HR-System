package com.rit.group2.security;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rit.group2.models.Employee;
import com.rit.group2.repositories.EmployeeRepository;

@Service("securityService")
public class GoogleOauth2{

	@Autowired
	private EmployeeRepository employeeRespository;

	private static final String url = "https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token=";

	private RestTemplate restemplate = new RestTemplate();

	public Employee getEmployeeFromToken(String token){

		UserInfo userInfo = restemplate.getForObject(url + token, UserInfo.class);
		System.out.println("User ID: " + userInfo.getId());
		System.out.println("First Name: " + userInfo.getGiven_name());
		System.out.println("Last Name: " + userInfo.getFamily_name());

		if(userInfo.getId() != null){
			String familyName = userInfo.getFamily_name();
			String givenName = (String) userInfo.getGiven_name();

			return employeeRespository.findByFirstAndLastName(givenName, familyName);
		}
		return null;
	}

}
