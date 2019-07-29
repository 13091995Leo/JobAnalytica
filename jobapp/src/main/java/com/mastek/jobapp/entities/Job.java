package com.mastek.jobapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //one copy for each test case
@Entity //declares the class as an Entity
@Table(name="Jobs")// declaring the table name for the class
public class Job {
	

	@Value("-1")
	private int jobId;
	
	@Value("Default Value")
	private String jobTitle;
	
	@Value("Default Value")
	private String requirements;
	
	@Value("00000000")
	private double salary;
	
	@Value("Default")
	private String location;
	
/*	@Value("-1")
	private int companyId;*/
	
	
/*	//mappedBy: check the config for Many to Many association
	@ManyToMany(mappedBy="jobPoster")
	@XmlTransient
	private Set<Company> team = new HashSet<>();
	*/
	
	@Id
	@Column(name = "projectId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getJobId() {
		return jobId;
	}



	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	
	@Column(name = "jobTitle")
	public String getJobTitle() {
		return jobTitle;
	}



	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	@Column(name = "requirements")
	public String getRequirements() {
		return requirements;
	}



	public void setRequirements(String requirements) {
		this.requirements = requirements;
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


/*	@Column(name = "companyId")
	public int getCompanyId() {
		return companyId;
	}



	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
*/


/*	public Set<Company> getTeam() {
		return team;
	}



	public void setTeam(Set<Company> team) {
		this.team = team;
	}
*/


	public Job() {
		System.out.println("Project Created");
	}
	
	
	
	
	
	
	
	
	

}
