package com.mastek.jobapp.apis;

import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mastek.jobapp.entities.Company;
import com.mastek.jobapp.entities.Job;
import com.mastek.jobapp.entities.Requirement;
import com.mastek.jobapp.repository.CompanyRepository;

@Component
@Scope("singleton")
@Path("/companies/")
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private JobService jobService;
	
	public CompanyService() {
		System.out.println("Company Service Created");
	}

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Company registerOrUpdateCompany(@BeanParam Company company) {
		company = companyRepository.save(company);
		System.out.println("Company Registered " + company);
		return company;
	}

	@Path("/find/{companyId}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Company findByCompanyId(@PathParam("companyId") int companyId) {
		try {
			return companyRepository.findById(companyId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Path("/delete/{companyId}")
	public String deleteCompanyById(@PathParam("companyId") int companyId) {
		 try {
	            companyRepository.deleteById(companyId);
	            String statement = "Company with Company ID = " + companyId + " sucessfully deleted";
	            System.out.println(statement);
	            return statement;
	        } catch (Exception e) {
	            e.printStackTrace();
	            String statement = "Company with Company ID = " + companyId + " does not exist";
	            System.out.println(statement);
	            return statement;
	        }
				
		}	
	
	@Transactional
	@POST
	@Path("/assign/jobs")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Company assignJob(@FormParam("companyId") int companyId, @FormParam("jobId") int jobId) {
		try {
			Company company = findByCompanyId(companyId);
			Job job = jobService.findByJobId(jobId);
			job.setCurrentCompany(company);
			company.getJobs().add(job);
			registerOrUpdateCompany(company);
			return company;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
