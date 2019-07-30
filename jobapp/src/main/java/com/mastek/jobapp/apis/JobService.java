package com.mastek.jobapp.apis;


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
