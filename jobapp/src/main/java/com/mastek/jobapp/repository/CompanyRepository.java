package com.mastek.jobapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mastek.jobapp.entities.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
	
	public List<Company> findByLocation (@Param("loc") String loc);

}
