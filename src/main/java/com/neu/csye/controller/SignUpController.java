package com.neu.csye.controller;

import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.neu.csye.dao.EmployeeDAO;
import com.neu.csye.dao.EmployerDAO;
import com.neu.csye.pojo.Employee;
import com.neu.csye.pojo.Employer;
import com.neu.csye.pojo.User;
import com.neu.csye.validator.EmployeeValidator;
import com.neu.csye.validator.EmployerValidator;

@Controller
public class SignUpController {
	
	@Autowired
	EmployeeValidator employeeValidator;
	
	@Autowired
	EmployerValidator employerValidator;
	
	@GetMapping("/employeesignup.htm")
	public String showForm(ModelMap model, Employee employee ){
		model.addAttribute("employee", employee);
		return "employeeSignUp-form";
	}
	
	@PostMapping("/employeesignup.htm")
	public String showSuccess(@ModelAttribute("employee") Employee employee,BindingResult result ,SessionStatus status,Model model,HttpServletRequest request ) throws Exception{
		employeeValidator.validate(employee, result);
		
		if(result.hasErrors()) {
			return "employeeSignUp-form";
		}
		status.setComplete();
		
		// New added Code
		if(!employee.getConfirm_pwd().equals(employee.getPassword())) {
			ObjectError error=new ObjectError("employee","Password and Confirm Password doesn't match");
			result.addError(error);
			return "employeeSignUp-form";
		}
		
		if(!(employee.getContactNumber().length()==10)) {
			ObjectError error=new ObjectError("employee","Only 10 digits are allowed in Contact Number");
			result.addError(error);
			return "employeeSignUp-form";
		}
		
		EmployeeDAO employeeDAO=new EmployeeDAO();
		
		// New Code
		Query q=employeeDAO.getSession().createQuery("Select emailId From Employee");
		List<String> emailIdList=q.getResultList();
		if(emailIdList.contains(employee.getEmailId())) {
			ObjectError error=new ObjectError("employee","Employee with same Email id exist in the system ");
			result.addError(error);
			return "employeeSignUp-form";
		}
		
		employeeDAO.save(employee);
		request.setAttribute("name", employee.getFirstName());
		return "signUpSuccessPage";
	}
	
	@GetMapping("/employersignup.htm")
	public String showForm(ModelMap model, Employer employer ){
		model.addAttribute("employer", employer);
		return "employerSignUp-form";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/employersignup.htm")
	public String showSuccess(@ModelAttribute("employer")Employer employer,BindingResult result ,SessionStatus status,Model model,HttpServletRequest request ) throws Exception{
		employerValidator.validate(employer, result);
		
		if(result.hasErrors()) {
			return "employerSignUp-form";
		}
		status.setComplete();
		
		// New added Code
		if(!employer.getConfirm_pwd().equals(employer.getPassword())) {
			ObjectError error=new ObjectError("employer","Password and Confirm Password doesn't match");
			result.addError(error);
			return "employerSignUp-form";
		}
		
		
		EmployerDAO employerDAO=new EmployerDAO();
		
		// New Added code
		Query q=employerDAO.getSession().createQuery("Select emailId From Employer");
		List<String> emailIdList=q.getResultList();
		if(emailIdList.contains(employer.getEmailId())) {
			ObjectError error=new ObjectError("employer","Employer with same Email id exist in the system ");
			result.addError(error);
			return "employerSignUp-form";
		}
		
		employerDAO.save(employer);
		request.setAttribute("name", employer.getFirstName());
		return "signUpSuccessPage";
	}
	
	
	@PostMapping("/signup.htm")
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response,Model model) {
		ModelAndView mav=new ModelAndView();
		if(request.getParameter("signUpType").equals("Employer Sign Up")) {
			model.addAttribute("employer", new Employer());
			mav.setViewName("employerSignUp-form");
		}else {
			model.addAttribute("employee", new Employee());
			mav.setViewName("employeeSignUp-form") ;
		}
		return mav;
	}
	
	@PostMapping("/typePage.htm")
	public String goToWelcomePage() throws Exception{
		return "signUp-form";
	}
	
	@PostMapping("/successfulSignUp.htm")
	public String showSuccess(Model model ) throws Exception{
		model.addAttribute("user", new User());
		return "signIn-form";
	}
	
}
