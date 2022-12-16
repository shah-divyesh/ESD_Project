package com.neu.csye.pojo;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String company;
	private String password;
	
	@Transient
	private String confirm_pwd;
	
	@OneToMany(mappedBy="employer",fetch = FetchType.EAGER)
	private Set<Job> jobList;
	
	public Employer() {
		
	}
	
	public int getEmployerId() {
		return employerId;
	}
	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Job> getJobList() {
		return jobList;
	}

	public void setJobList(Set<Job> jobList) {
		this.jobList = jobList;
	}
	
	public String getConfirm_pwd() {
		return confirm_pwd;
	}

	public void setConfirm_pwd(String confirm_pwd) {
		this.confirm_pwd = confirm_pwd;
	}
	
	
}
