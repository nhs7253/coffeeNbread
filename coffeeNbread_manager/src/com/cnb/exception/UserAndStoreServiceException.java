package com.cnb.exception;

/*
 * 노현식
 * 2017-07-01
 * 생성, 최초 구현
 */
public class UserAndStoreServiceException extends Exception{

	public UserAndStoreServiceException(){}
	public UserAndStoreServiceException(String message){
		super(message);
	}
}
