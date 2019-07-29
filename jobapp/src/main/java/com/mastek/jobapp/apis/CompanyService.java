package com.mastek.jobapp.apis;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.jobapp.repository.CompanyRepository;
import com.mastek.jobapp.repository.UserRepository;

@Component
@Scope("singleton")
@Path("/companies")
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public CompanyService() {
		System.out.println("Company Service Created");
	}

}
