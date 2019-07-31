package com.mastek.jobapp.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


// Used for Services only, needs to be commented out for Postman to work
@Component
@Scope("prototype") // One copy for each test case
@Entity	// Declare class as entity
@Table(name="Company") // Declare table name for class
@EntityListeners({CompanyLifecycleListener.class})
@NamedQueries({@NamedQuery(name="Company.findByIndustry", query="select c from Company c where c.location = 'Leeds'")})
@XmlRootElement
public class Company implements Serializable{
	
	@Value("-1")
	private int companyId;
	
	@Value("Default Company")
	@FormParam("companyName")
	private String companyName;
	
	@Value("Default Location")
	@FormParam("location")
	private String location;
	
	@Value("Default Industry")
	@FormParam("industry")
	private String industry;
	
	@Value("Default Password")
	@FormParam("companyPassword")
	private String companyPassword;
	
	private Set<Job> jobs = new HashSet<>();
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="currentCompany")
	@XmlTransient
	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	public Company() {
		System.out.println("Company Created");
	}

	@Id // Declare as Primary Key
	@Column(name="companyId") // Declare name of column
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto-numbering
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Column
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	@Column
	public String getCompanyPassword() {
		return companyPassword;
	}

	public void setCompanyPassword(String companyPassword) {
		this.companyPassword = companyPassword;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", location=" + location + ", industry=" + industry + "]";
	}

}
