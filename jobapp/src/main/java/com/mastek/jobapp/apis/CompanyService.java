package com.mastek.jobapp.apis;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.jobapp.entities.Company;
import com.mastek.jobapp.repository.CompanyRepository;

@Component
@Scope("singleton")
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	public CompanyService() {
		System.out.println("Company Service Created");
	}

	public Company registerOrUpdateCompany(Company company) {
		company = companyRepository.save(company);
		System.out.println("Company Registered " + company);
		return company;
	}

}
