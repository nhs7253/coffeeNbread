package com.cnb.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/*
 * 노현식 
 * 2017-06-26 생성
 */
/**
 * git용 Default 파일
 */
public class DefaultValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
