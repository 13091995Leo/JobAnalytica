package com.mastek.jobapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Used for Services only, needs to be commented out for Postman to work
//@Component

@Scope("prototype") //one copy for each test case
@Entity //declares the class as an Entity
@Table(name="Jobs") // declaring the table name for the class
@NamedQueries({
	@NamedQuery( name = "Job.findBySearchParam",
			query = "select j from Job j where j.jobTitle like concat('%', :searchParam, '%') " //JPA Query language
			), // LIKE CONCAT('%' , :searchParam , '%')
	@NamedQuery(name = "Job.findAverageJobSalaryByJobTitle",
			query = "select avg(j.salary) from Job j where job_title = :jobTitle")
})
@XmlRootElement
public class Job implements Serializable{

	@Value("-1")
	private int jobId;
	
	@Value("Default Value")
	@FormParam("jobTitle")
	private String jobTitle;
	
	@Value("00000000")
	@FormParam("salary")
	private double salary;
	
	@Value("Default")
	@FormParam("location")
	private String location;

/// Many to One relationship between jobs and company	
	private Company currentCompany;
	
	@ManyToOne
	@JoinColumn(name="FkCompanyNumber")
	public Company getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(Company currentCompany) {
		this.currentCompany = currentCompany;
	}
	
/// Many to many relationship between jobs and requirements.
	private Set<Requirement> requirements = new HashSet<>();
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="JOB_REQUIREMENTS",joinColumns=@JoinColumn(name="FK_JOBID"),inverseJoinColumns=@JoinColumn(name="FK_REQUIREMENTID"))
	@XmlTransient
	public Set<Requirement> getRequirements() {
		return requirements;
	}
	
	public void setRequirements(Set<Requirement> requirements) {
		this.requirements = requirements;
	}

/// Many to many relationship between job and users.
	private Set<User> assignments = new HashSet<>();
	 
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ASSIGNMENTS",joinColumns = @JoinColumn(name = "FK_JOBID"),inverseJoinColumns = @JoinColumn(name="FK_USERID"))
	@XmlTransient
	public Set<User> getAssignments() {
		 return assignments;
	}
	public void setAssignments(Set<User> assignments) {
		this.assignments = assignments;
	}

	
	@Id
	@Column(name = "jobId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	@Column(name="jobTitle")
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name = "salary")
	public double getSalary() {
		return salary;
	}

	public void setSalary(double d) {
		this.salary = d;
	}


	@Column(name = "location")
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}

	public Job() {
		System.out.println("Job Created");
	}


	
	
	
	
	 
	
	
	
	

}
