package com.neu.csye.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
		EmployeeDAO employeeDAO=new EmployeeDAO();
		employeeDAO.save(employee);
//		model.addAttribute("user",new User());
//		return "signIn-form";
		request.setAttribute("name", employee.getFirstName());
		return "signUpSuccessPage";
	}
	
	@GetMapping("/employersignup.htm")
	public String showForm(ModelMap model, Employer employer ){
		model.addAttribute("employer", employer);
		return "employerSignUp-form";
	}
	
	@PostMapping("/employersignup.htm")
	public String showSuccess(@ModelAttribute("employer")Employer employer,BindingResult result ,SessionStatus status,Model model,HttpServletRequest request ) throws Exception{
		employerValidator.validate(employer, result);
		
		if(result.hasErrors()) {
			return "employerSignUp-form";
		}
		status.setComplete();
		EmployerDAO employerDAO=new EmployerDAO();
		employerDAO.save(employer);
//		model.addAttribute("user", new User());
//		return "signIn-form";
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
