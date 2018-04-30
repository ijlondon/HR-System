package com.rit.group2.security;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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
		UserInfo userInfo;
		
		try{
			userInfo = restemplate.getForObject(url + token, UserInfo.class);
		}catch(HttpClientErrorException e){
			return null;
		}
		
		if(userInfo.getId() != null){
			String email = userInfo.getEmail();
			return employeeRespository.findByEmail(email);
		}
		return null;
	}

}
