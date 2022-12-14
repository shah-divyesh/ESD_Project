package com.neu.csye.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.csye.pojo.User;



@Component
public class SignInValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "userName","empty-user-name", "UserName cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "password","empty-password", "Password cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "userType","User Type not selected", "Select user Type");
	}

}
