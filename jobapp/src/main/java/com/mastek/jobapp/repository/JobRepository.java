package com.mastek.jobapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.mastek.jobapp.entities.Job;

//@Component
public interface JobRepository extends CrudRepository<Job, Integer> {
	
	@Autowired
	public List<Job> findBySearchParam(@Param("searchParam") String searchParam);

}
