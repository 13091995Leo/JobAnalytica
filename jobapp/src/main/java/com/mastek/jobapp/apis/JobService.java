package com.mastek.jobapp.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.jobapp.repository.JobRepository;



@Component
@Scope("singleton")
@Path("/job/")

public class JobService {
	
	@Autowired
	private JobRepository jobRepository;
	
	public JobService() {
		System.out.println("Job Service Created");
	}
	
	
	@GET
	@Path("/list")
	@Produces({MediaType.APPLICATION_JSON})
	public Iterable<Job> listAllJ(){
		return jobRepository.findAll();
	}
	
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Job registerOrUpdateJob(
			@BeanParam Job job) {
		job = jobRepository.save(job);
		System.out.println("Job Registered "+job);
		return job;
	}
	
	@DELETE
	@Path("/delete/{jobId}")	
	public void deleteByjobId(int jobId) {
			jobRepository.deleteById(jobId);
			
		}	

}
