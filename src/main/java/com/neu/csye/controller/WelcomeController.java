package com.neu.csye.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.csye.pojo.User;

@Controller
public class WelcomeController {
	
	@PostMapping("/welcome.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response,Model model) {
//		HttpSession session=request.getSession();
		model.addAttribute("user",new User());
		ModelAndView mav=new ModelAndView();
		String info=request.getParameter("info");
		if(info.equals("Sign In"))
			mav.setViewName("signIn-form");
		else if(info.equals("Sign Up"))
			mav.setViewName("signUp-form") ;
		return mav;
		
	}
}
