package com.neu.csye.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
    
    
}
