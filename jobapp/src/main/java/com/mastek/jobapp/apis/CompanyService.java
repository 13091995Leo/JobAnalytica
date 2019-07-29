package com.mastek.jobapp.apis;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastek.jobapp.repository.CompanyRepository;

public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyService() {
		System.out.println("Company Service Created");
	}

}
