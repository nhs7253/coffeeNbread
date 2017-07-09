package com.cnb.exception;

/*
 * 노현식 
 * 2017-06-28
 * Login용 Exception으로 용도 변경
 * 
 * 노현식 
 * 2017-06-23 
 * 생성, 초기 구현
 */
public class UserManageException extends Exception{

	public UserManageException(){}
	public UserManageException(String message){
		super(message);
	}
}
