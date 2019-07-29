package com.mastek.jobapp.entities;

public class Company {
	
	private int companyId;

	private String companyName;

	private String location;

	private String industry;
	
	public Company() {
		System.out.println("Company Created");
	}

	public int getCompany_id() {
		return companyId;
	}

	public void setCompany_id(int companyId) {
		this.companyId = companyId;
	}

	public String getCompany_name() {
		return companyName;
	}

	public void setCompany_name(String companyName) {
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
