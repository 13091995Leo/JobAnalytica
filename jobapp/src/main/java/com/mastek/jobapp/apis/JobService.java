package com.mastek.jobapp.apis;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.jobapp.entities.Job;
import com.mastek.jobapp.repository.JobRepository;

@Component
public class JobService {
	
	@Autowired
	private JobRepository jobRepository;
	
	public JobService() {
		System.out.println("Job Service Created");
	}
	
	public Job registerOrUpdateJob(Job job) {
		job = jobRepository.save(job);
		System.out.println("Job Registered "+job);
		return job;
	}
	
//	@Path("/find/{jobId}")
//	@GET
//	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Job findByJobId(int jobId) {
		try {
			return jobRepository.findById(jobId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	public void deleteJobById(int jobId) {
		 try {
	            jobRepository.deleteById(jobId);
	            String statement = "Job with Job ID = " + jobId + " sucessfully deleted";
	            System.out.println(statement);
	        } catch (Exception e) {
	            e.printStackTrace();
	            String statement = "ERROR";
	            System.out.println(statement);
	        }
				
		}	

}
