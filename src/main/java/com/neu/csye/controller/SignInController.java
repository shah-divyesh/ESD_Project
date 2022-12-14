package com.neu.csye.controller;


import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.neu.csye.dao.EmployeeDAO;
import com.neu.csye.dao.EmployerDAO;
import com.neu.csye.dao.JobDAO;
import com.neu.csye.pojo.Employee;
import com.neu.csye.pojo.Job;
import com.neu.csye.pojo.User;
import com.neu.csye.validator.SignInValidator;

@Controller
public class SignInController {
	
	@Autowired
	SignInValidator validator;

	@GetMapping("/login.htm")
	public String showForm(ModelMap model, User user ){
		model.addAttribute("user", user);
		return "signIn-form";
	}
	
	@PostMapping("/login.htm")
	public String showSuccess(@ModelAttribute("user") User user,BindingResult result ,SessionStatus status,HttpServletRequest request ) throws Exception{
		validator.validate(user, result);
		
		if(result.hasErrors()) {
			return "signIn-form";
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		if(user.getUserType().equals("Employee")) {
			EmployeeDAO employeeDAO=new EmployeeDAO();
			boolean b=employeeDAO.auth(user.getUserName(), user.getPassword());
			if(!b) {
				ObjectError error=new ObjectError("user","Invalid username or Password");
				result.addError(error);
				return "signIn-form";
			}else {
				
				Employee employee=employeeDAO.getEmployee(user);
				List<Job> sessionJobList=new JobDAO().getAllJobs();
//				Set<Job> appliedJobs=employee.getJobList();
				request.setAttribute("appliedJobs", new JobDAO().getAppliedJobs(employee));
				session.setAttribute("list", sessionJobList);
				session.setAttribute("employee",employee );
				System.out.println("Employee in SignInController method is :"+employee.getFirstName());
				return "employeeHomePage";
			
			}
			
		}else if(user.getUserType().equals("Employer")) {
			EmployerDAO employerDAO=new EmployerDAO();
			boolean b=employerDAO.auth(user.getUserName(), user.getPassword());
			if(!b) {
				ObjectError error=new ObjectError("user","Invalid username or Password");
				result.addError(error);
				return "signIn-form";
			}else {
				session.setAttribute("employer",employerDAO.getEmployer(user) );
				return "employerHomePage";
			}
			
			
		}
		
		status.setComplete();
		return "login-success";
	}
	
	@GetMapping("/logout.htm")
	public String logoutUser(ModelMap model, User user,HttpSession session) throws Exception{
		User currentUser=(User)session.getAttribute("user");
		if(currentUser.getUserType().equals("Employer")) {
			session.removeAttribute("employer");
			session.removeAttribute("user");
		}else {
			session.removeAttribute("employee");
			session.removeAttribute("user");
		}
		model.addAttribute("user", user);
		return "signIn-form";
	}
	
	
	@PostMapping("/welcomePage.htm")
	public String goToWelcomePage() throws Exception{
		return "welcome-view";
	}
	
	
}
