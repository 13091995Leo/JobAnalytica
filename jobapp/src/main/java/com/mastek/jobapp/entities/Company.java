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

import org.springframework.context.annotation.Scope;

@Scope("prototype") // One copy for each test case
@Entity	// Declare class as entity
@Table(name="Company") // Declare table name for class
@EntityListeners({CompanyLifecycleListener.class})
@NamedQueries({@NamedQuery(name="Company.findByIndustry", query="select c from Company c where c.location = 'Leeds'")})
public class Company {
	
	@Value("-1")
	private int companyId;
	
	@Value("Default Company")
	private String companyName;
	
	@Value("Default Location")
	private String location;
	
	@Value("Default Industry")
	private String industry;
	
	public Company() {
		System.out.println("Company Created");
	}

	@Id // Declare as Primary Key
	@Column(name="companyNumber") // Declare name of column
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

}
