package com.neu.csye.dao;


import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.neu.csye.pojo.Employer;
import com.neu.csye.pojo.Job;
import com.neu.csye.pojo.User;

@Component
public class EmployerDAO extends DAO{
	Employer e=new Employer();

	public EmployerDAO() {
		
    }

    public  void save(Employer employer) throws Exception {	
        try {
            begin();
            getSession().save(employer);
            commit();
            close();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not add employer ");
        }
    }
    
    public Employer getEmployer(User user)throws Exception{
    	String emailId=user.getUserName();
    	Query query=getSession().createQuery("From Employer where emailId=:emailId");
    	query.setParameter("emailId", emailId);
    	Employer employer=(Employer)query.uniqueResult();
    	close();
    	return employer;
    }
    
    public void delete(Employer employer) throws Exception {
    	begin();
    	getSession().delete(employer);
    	commit();
    }
    
    public boolean auth(String username,String password) throws Exception{
    	try {
            begin();
            Query query=getSession().createQuery("from Employer where emailId=:emailId and password=:password");
            query.setParameter("emailId", username);
            query.setParameter("password", password);
            Employer emp=(Employer)query.uniqueResult();
            if(emp!=null) {
     	       return true;
     	    }else {
     	       return false;
     	    }    
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not find any employer ");
        }
    }
    
    
}
