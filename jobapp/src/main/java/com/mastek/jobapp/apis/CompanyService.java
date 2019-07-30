package com.mastek.jobapp.apis;

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

	
	public Company findByCompanyId(int companyId) {
		try {
			return companyRepository.findById(companyId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteCompanyById(int companyId) {
		 try {
	            companyRepository.deleteById(companyId);
	            String statement = "Company with Company ID = " + companyId + " sucessfully deleted";
	            System.out.println(statement);
	        } catch (Exception e) {
	            e.printStackTrace();
	            String statement = "ERROR";
	            System.out.println(statement);
	        }
				
		}	
	
	
}
