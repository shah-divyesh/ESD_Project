package com.neu.csye.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Component;

import com.neu.csye.pojo.Employee;
import com.neu.csye.pojo.Employer;
import com.neu.csye.pojo.Job;
import com.neu.csye.pojo.User;


@Component
public class EmployeeDAO extends DAO{
	Employee e=new Employee();

	public EmployeeDAO() {
		
    }

    public  void save(Employee employee) throws Exception {	
        try {
            begin();
            getSession().save(employee);
            commit();
            close();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not add user ");
        }
    }
    
    public void delete(Employee employee) throws Exception {
    	begin();
    	getSession().delete(employee);
    	commit();
    }
    
    public  void update(Employee employee) throws Exception {	
        try {
            begin();
            getSession().flush();
            getSession().clear();
            getSession().update(employee);
            commit();
            close();
        } catch (HibernateException e) {
            rollback();
            throw new Exception(e.getMessage());
        }
    }
    
    
    public Employee getEmployee(User user)throws Exception{
    	String emailId=user.getUserName();
    	Query query=getSession().createQuery("From Employee where emailId=:emailId");
    	query.setParameter("emailId", emailId);
    	Employee employee=(Employee)query.uniqueResult();
    	close();
    	return employee;
    }
    
    public boolean auth(String username,String password) throws Exception{
    	try {
            begin();
            Query query=getSession().createQuery("from Employee where emailId=:emailId and password=:password");
            query.setParameter("emailId", username);
            query.setParameter("password", password);
            Employee emp=(Employee)query.uniqueResult();
            if(emp!=null) {
      	       return true;
      	    }else {
      	       return false;
      	    }   
        } catch (HibernateException e) {
            rollback();
            return false;
        }
    }
    
    public boolean withDraw(Employee employee,Job job) {
    	begin();
    	
    	SQLQuery q=getSession().createSQLQuery(" Delete from employee_jobs where Employee_ID=:employee_id and Job_ID=:job_id ");
    	q.setParameter("employee_id", employee.getEmployeeId());
    	q.setParameter("job_id", job.getJobId());
    	int n=q.executeUpdate();
    	
    	if(n==1) {
    		Set<Job> temp=new HashSet<>();
    		Iterator<Job> ite=employee.getJobList().iterator();
    		while(ite.hasNext()) {
    			Job tempJob=ite.next();
    			if(tempJob.getJobId()!=job.getJobId())
    				temp.add(tempJob);
    		}
    		employee.setJobList(temp);
    	}
    	
    	commit();
    	if(n==1)
    		
    		return true;
    	else
    		return false;
    		
    }
    
    
}
