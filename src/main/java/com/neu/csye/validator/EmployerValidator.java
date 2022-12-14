package com.neu.csye.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.csye.pojo.Employer;

@Component
public class EmployerValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "firstName", "First Name cannot be empty", "Enter FirstName");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "Last Name cannot be empty", "Enter LastName");
		ValidationUtils.rejectIfEmpty(errors, "emailId", "Email Id cannot be empty", "Enter Email Id");
		ValidationUtils.rejectIfEmpty(errors, "company", "Company Name cannot be empty", "Enter Company Name");
		ValidationUtils.rejectIfEmpty(errors, "password", "Password cannot be empty", "Enter Password");
	}

}
