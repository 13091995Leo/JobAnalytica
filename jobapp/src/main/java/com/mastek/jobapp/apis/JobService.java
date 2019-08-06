package com.mastek.jobapp.apis;


import java.util.List;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mastek.jobapp.entities.Job;
import com.mastek.jobapp.entities.Requirement;
import com.mastek.jobapp.repository.JobRepository;

@Component
@Scope("singleton")
@Path("/jobs/")
public class JobService {
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private RequirementService requirementService;
	
	public JobService() {
		System.out.println("Job Service Created");
	}
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Job registerOrUpdateJob(@BeanParam Job job) {
		job = jobRepository.save(job);
		System.out.println("Job Registered "+job);
		return job;
	}
	
	@GET
	@Path("/find/{jobId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Job findByJobId(@PathParam("jobId") int jobId) {
		try {
			return jobRepository.findById(jobId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Path("/delete/{jobId}")
	public String deleteJobById(@PathParam("jobId") int jobId) {
		 try {
	            jobRepository.deleteById(jobId);
	            String statement = "Job with Job ID = " + jobId + " sucessfully deleted";
	            System.out.println(statement);
	            return statement;
	        } catch (Exception e) {
	            e.printStackTrace();
	            String statement = "Job with job ID = " + jobId + " does not exist";
	            System.out.println(statement);
	            return statement;
	        }

		}
	
	@GET
	@Path("/fetchBySearchParam")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Job> fetchJobUsingSearchBar(@QueryParam("searchParam") String searchParam){
		return jobRepository.findBySearchParam(searchParam);
	}

	
	@GET
	@Path("/fetchAverageJobSalaryByJobTitle")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String[] fetchAverageJobSalaryByJobTitle(@QueryParam("jobTitle") String jobTitle){
		return  jobRepository.findAverageJobSalaryByJobTitle(jobTitle);}

	@GET
	@Path("/displayAllJobs")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Job> fetchAllJobs(){
		return jobRepository.findAll();
	}
	
	@Transactional
	@POST
	@Path("/assign/requirement")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Requirement> assignRequirement(@FormParam("jobId") int jobId, @FormParam("requirementId") int requirementId) {
		try {
			Job job = findByJobId(jobId);
			Requirement req = requirementService.findByRequirementId(requirementId);
			job.getRequirements().add(req);
			job = registerOrUpdateJob(job);
			return job.getRequirements();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("/fetchJobsByCompanyId")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Job> fetchJobsByCompanyId(@QueryParam("companyId") String companyId){
		return jobRepository.fetchJobByCompanyId(companyId);
	}

}
