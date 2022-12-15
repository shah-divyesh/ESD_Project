package com.neu.csye.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.neu.csye.pojo.Employee;
import com.neu.csye.pojo.Employer;
import com.neu.csye.pojo.Job;

@Component
public class JobDAO extends DAO{
	Job job=new Job();

	public JobDAO() {
		
    }

    public  void save(Job job) throws Exception {	
        try {
            begin();
            getSession().save(job);            
            commit();
            close();
        } catch (HibernateException e) {
            rollback();
            throw new Exception(e.getMessage());
        }
    }
    
    
    public  void update(Job job) throws Exception {	
        try {
            begin();
            getSession().update(job);
            commit();
            close();
        } catch (HibernateException e) {
            rollback();
            throw new Exception(e.getMessage());
        }
    }
    
    public void delete(Job job) throws Exception {
    	begin();
    	getSession().delete(job);
    	commit();
    	close();
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Job> getJobs(Employer emp){
    	Query query=getSession().createQuery("From Job where employer_Id=:id");
    	query.setParameter("id", emp.getEmployerId());
    	List<Job> jobList=query.getResultList();
    	return jobList;
    }
    
	@SuppressWarnings("rawtypes")
	public Job getJobById(int id){
    	Query query=getSession().createQuery("From Job where jobId=:id");
    	query.setParameter("id", id);
    	Job job=(Job)query.uniqueResult();
    	return job;
    }
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Job> getAllJobs(HttpServletRequest request){
		HttpSession session=request.getSession();
		Employee employee=(Employee)session.getAttribute("employee");
		SQLQuery q=getSession().createSQLQuery(" Select Job_ID from employee_jobs where Employee_ID=:employee_id");
		q.setParameter("employee_id", employee.getEmployeeId());
		List<Integer>list=q.getResultList();
	
		Criteria crit=getSession().createCriteria(Job.class);
		crit.add(Restrictions.eq("status", "Hiring"));
		crit.addOrder(Order.desc("jobId"));
		crit.setMaxResults(15);
		List<Job> tempList=crit.list();
		List<Job> result=new ArrayList<>();
		int len=crit.list().size();
		for(int i=0;i<len;i++) {
			if(!list.contains(tempList.get(i).getJobId())) {
				result.add(tempList.get(i));
			}
		}
		return result;
	}
	
	public Set<Job> getAppliedJobs(Employee employee){
		return employee.getJobList();
	}
	
	
	
}
