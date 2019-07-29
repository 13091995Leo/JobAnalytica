package com.mastek.jobapp.entities;

import javax.persistence.Entity;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Entity

public class Company {
	
	private int companyId;
	
	private String companyName;
	
	private String location;
	
	private String industry;
	
	public Company() {
		System.out.println("Company Created");
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}


}
