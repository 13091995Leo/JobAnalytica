package com.mastek.jobapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
@Scope("prototype") //one copy for each test case
@Entity //declares the class as an Entity
@Table(name="requirements")// declaring the table name for the class
@XmlRootElement
public class Requirement {
	@Value("-1")
	private int requirementId;
	
	@Value("Defaualt requirement")
	@FormParam("requirement")
	private JobSkillRole requirement;
	
	private Set<Job> jobRequirement = new HashSet<>();
	
	@ManyToMany(mappedBy="requirements",fetch=FetchType.LAZY)
	@XmlTransient
	public Set<Job> getJobRequirement() {
		return jobRequirement;
	}
	
	public void setJobRequirement(Set<Job> jobRequirement) {
		this.jobRequirement = jobRequirement;
	}

	@Id
	@Column(name="requirementId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(int requirementId) {
		this.requirementId = requirementId;
	}

	@Column(name="requirement")
	public JobSkillRole getRequirement() {
		return requirement;
	}

	public void setRequirement(JobSkillRole requirement) {
		this.requirement = requirement;
	}
}
