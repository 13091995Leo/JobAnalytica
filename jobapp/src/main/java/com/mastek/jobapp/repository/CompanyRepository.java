package com.mastek.jobapp.repository;


import org.springframework.data.repository.CrudRepository;

import com.mastek.jobapp.entities.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
	

}
