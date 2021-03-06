package com.mastek.jobapp.repository;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.mastek.jobapp.entities.Job;

public interface JobRepository extends CrudRepository<Job, Integer> {
	
	@Autowired
	public List<Job> findBySearchParam(@Param("searchParam") String searchParam);


	public String[] findAverageJobSalaryByJobTitle(@Param("jobTitle") String jobTitle);
	

	@Autowired
	public List<Job> fetchJobByCompanyId(@Param("companyId") int companyId);

}
