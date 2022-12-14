package com.neu.csye.pojo;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;
import java.util.HashSet;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String contactNumber;
	private String password;
	
	
//	cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,},
	@ManyToMany(fetch = FetchType.EAGER,mappedBy="employeeList")
//	@JoinTable(
//			name="employee_jobs",
//			joinColumns= @JoinColumn(name="Employee_ID",referencedColumnName = "employeeId"),
//			inverseJoinColumns=@JoinColumn(name="Job_ID",referencedColumnName="jobId")
//	)
	private Set<Job> jobList=new HashSet<>();
	
	public Employee() {
		
	}

	public Set<Job> getJobList() {
		return this.jobList;
	}

	public void setJobList(Set<Job> jobList) {
		this.jobList = jobList;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNo) {
		this.contactNumber = contactNo;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void removeJob(Job job) {
		System.out.println("Before removing  JobList="+this.jobList.size()+" EmployeeList= "+job.getEmployeeList().size());
		System.out.println(this.jobList.contains(job));
		System.out.println(job.getEmployeeList().contains(this));
        this.jobList.remove(job);
        job.getEmployeeList().remove(this);
        
        System.out.println("After removing  JobList="+this.jobList.size()+" EmployeeList= "+job.getEmployeeList().size());
    }
	
}
