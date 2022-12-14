package com.neu.csye.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.neu.csye.pojo.Job;

@Component
public class JobValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Job.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "title", "Job Title cannot be empty", "Enter Job Title");
		ValidationUtils.rejectIfEmpty(errors, "location", "Job Location cannot be empty", "Enter Job Location");
		ValidationUtils.rejectIfEmpty(errors, "description", "Job Description cannot be empty", "Enter Job Description");
		ValidationUtils.rejectIfEmpty(errors, "status", "Job Status cannot be empty", "Enter Job Status"); 
		
	}

}
