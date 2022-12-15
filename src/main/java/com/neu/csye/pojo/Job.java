package com.neu.csye.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.HashSet;

@Component
@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;
	private String title;
	private String location;
	private String description;
	private String status;
	
//	(cascade=CascadeType.ALL) ,referencedColumnName="employerId"
	
	

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employer_Id")
	private Employer employer;
	
//	(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,})
//	,referencedColumnName = "jobId"
//	,referencedColumnName="employeeId"
	@ManyToMany
	@JoinTable(
			name="employee_jobs",
			joinColumns= @JoinColumn(name="Job_ID"),
			inverseJoinColumns=@JoinColumn(name="Employee_ID")
	)
	private Set<Employee> employeeList=new HashSet<>();


	public int getJobId() {
		return jobId;
	}


	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Set<Employee> getEmployeeList() {
		return this.employeeList;
	}

	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}
