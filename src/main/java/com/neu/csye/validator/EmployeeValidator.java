package com.neu.csye.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.csye.pojo.Employee;

@Component
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "firstName", "First Name cannot be empty", "Enter FirstName");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "Last Name cannot be empty", "Enter LastName");
		ValidationUtils.rejectIfEmpty(errors, "emailId", "Email Id cannot be empty", "Enter Email Id");
		ValidationUtils.rejectIfEmpty(errors, "contactNumber", "Contact Number cannot be empty", "Enter Contact Number"); 
		ValidationUtils.rejectIfEmpty(errors, "password", "Password cannot be empty", "Enter Password");
		
	}

}
