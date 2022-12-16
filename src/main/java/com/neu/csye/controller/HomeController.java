package com.neu.csye.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.neu.csye.dao.DAO;
import com.neu.csye.dao.EmployeeDAO;
import com.neu.csye.dao.EmployerDAO;
import com.neu.csye.dao.JobDAO;
import com.neu.csye.pojo.Employee;
import com.neu.csye.pojo.Employer;
import com.neu.csye.pojo.Job;
import com.neu.csye.validator.JobValidator;


@Controller
public class HomeController {

	@Autowired
	JobValidator validator;
	
	@GetMapping("/createnewjob.htm")
	public String createNewJobs( Model model){
		model.addAttribute("jobs", new Job());
		return "newjob-form";
	}
	
	@PostMapping("/createnewjob.htm")
	public String createNewJobs(@ModelAttribute("jobs")  Job job,BindingResult result ,SessionStatus status,HttpServletRequest request ) throws Exception{
		HttpSession session=request.getSession();
		validator.validate(job, result);
		if(result.hasErrors()) {
			return "newjob-form";
		}
		Employer employer=(Employer)session.getAttribute("employer");
		System.out.println(employer.getFirstName());
		job.setEmployer(employer);
		JobDAO jobDAO=new JobDAO();
		jobDAO.save(job);
		status.setComplete();
		return "employerHomePage";
	}
	
	@PostMapping("/jobList.htm")
	public ModelAndView getAllJobs(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		Employer employer=(Employer)session.getAttribute("employer");
		JobDAO jobDAO=new JobDAO();
		List<Job> jobList=jobDAO.getJobs(employer);
		request.setAttribute("jobList", jobList);
		mav.setViewName("employerView");
		return mav;
	}
	
	@PostMapping("/update.htm")
	public String updateJob(@ModelAttribute("defaultJob")  Job job,BindingResult result ,SessionStatus status,HttpServletRequest request,Model model,HttpSession session) throws Exception {
		
		int id=(int)session.getAttribute("updateJobId");
		validator.validate(job, result);
		if(result.hasErrors()) {
			return "updateJobPage";
		}
		Employer employer=(Employer)session.getAttribute("employer");
		job.setEmployer(employer);
		job.setJobId(id);
		System.out.println(job.getJobId()+" "+job.getDescription()+" "+job.getLocation()+" "+job.getStatus()+" "+job.getTitle());
		JobDAO jobDAO=new JobDAO();
		jobDAO.update(job);
		return "employerHomePage";
	}
	
	@PostMapping("/updateJob.htm")
	public String updateJobPage(Model model,HttpServletRequest request,HttpSession session) {
		System.out.println("Update job");
		int jobId=Integer.parseInt(request.getParameter("Id"));
		JobDAO jobDAO=new JobDAO();
		Job job=jobDAO.getJobById(jobId);
		session.setAttribute("updateJobId", jobId);
		request.setAttribute("updateJob", job);	
		model.addAttribute("defaultJob", job);
		return "updateJobPage";
	}
	
	
	@PostMapping("deleteJob.htm")
	public String deleteJob(HttpServletRequest request) throws Exception {
		int jobId=Integer.parseInt(request.getParameter("Id"));
		SQLQuery q=DAO.getSession().createSQLQuery(" Select Job_ID from employee_jobs where Job_ID=:id");
		q.setParameter("id", jobId);
		Job job=new JobDAO().getJobById(jobId);
		int count=q.getResultList().size();
		if(count > 0) {
			request.setAttribute("status", 0);
			
		}else {
			request.setAttribute("status", 1);
			EmployerDAO employerDAO=new EmployerDAO();
			employerDAO.deleteJob(jobId);
//			Employer employer=(Employer)request.getSession().getAttribute("employer");
//			Set<Job> jobs=employer.getJobList();
//			jobs.remove(job);
//			employer.setJobList(jobs);
//			new EmployerDAO().update(employer);
//			new EmployeeDAO().save(null);
		}
		request.setAttribute("deleteJob", job.getTitle());
		return "deleteJobPage";
		
	}
	
	@PostMapping("/employerHome.htm")
	public String goToEmployerHome(HttpServletRequest request,Model model) {
		return "employerHomePage";
	}
	
	
	// Employee Methods
	
	@PostMapping("/applyJob.htm")
	public String applyJobPage(Model model,HttpServletRequest request,HttpSession session) throws Exception {
		int jobId=Integer.parseInt(request.getParameter("Id"));
		JobDAO jobDAO=new JobDAO();
		Job job=jobDAO.getJobById(jobId);
		Employee employee=(Employee)session.getAttribute("employee");
		session.setAttribute("applyJobId", jobId);

		job.getEmployeeList().add(employee);
		employee.getJobList().add(job);
		EmployeeDAO employeeDAO=new EmployeeDAO();
		employeeDAO.update(employee);
		request.setAttribute("jobName", job.getTitle());
		return "applicationSuccessPage";
	}
	
	@PostMapping("/employeeHome.htm")
	public String goToEmployeeHome(HttpServletRequest request) {
		HttpSession session=request.getSession();
		request.removeAttribute("appliedJobs");
		request.removeAttribute("list");
		
		request.setAttribute("list", new JobDAO().getAllJobs(request));
		request.setAttribute("appliedJobs", new JobDAO().getAppliedJobs((Employee)session.getAttribute("employee")));
		return "employeeHomePage";
	}
	
	
	
	@PostMapping("/withdraw.htm")
	public String withdrawApplication(HttpServletRequest request) throws Exception {
		
		int id=Integer.parseInt(request.getParameter("withdrawId"));
		Job job=new JobDAO().getJobById(id);
		request.setAttribute("jobName", job.getTitle());
		
		
		
		Employee employee=(Employee)request.getSession().getAttribute("employee");
//		System.out.println("------------------BEFORE UPDATING--------------");
//		Set<Job>temp1=employee.getJobList();
//		Iterator<Job> ite1=temp1.iterator();
//		while(ite1.hasNext()) {
//			System.out.println(ite1.next().getJobId());
//		}
			
//		boolean removeJOb=employee.getJobList().remove(job);
//		boolean removeEmployee=job.getEmployeeList().remove(employee);		
//		employee.removeJob(job);
//		new EmployeeDAO().update(employee);
		new EmployeeDAO().withDraw(employee, job);
		return "withdrawSuccessPage";
	}
	
	@PostMapping("/search.htm")
	public String searchJobs(HttpServletRequest request) {
		String companyName=request.getParameter("companyName");
		
		Query q=DAO.getSession().createQuery("From Employer where company=:companyName");
		q.setParameter("companyName", companyName);
		List<Employer> list=q.getResultList();
		List<Job> jobList=new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
			Criteria crit=DAO.getSession().createCriteria(Job.class);
			crit.add(Restrictions.eq("employer",list.get(i)));
			crit.add(Restrictions.eq("status","Hiring"));
			jobList.addAll(crit.list());
		}
		if(jobList.size()==0) {
			request.setAttribute("countFlag",0);
		}else {
			request.setAttribute("countFlag",1);
			request.setAttribute("jobList", jobList);
		}
		request.setAttribute("companyName", companyName);
		return "searchResultPage";
	}
}
