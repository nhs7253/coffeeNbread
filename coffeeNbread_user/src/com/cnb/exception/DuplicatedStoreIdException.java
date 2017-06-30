package com.cnb.exception;

public class DuplicatedStoreIdException extends Exception {
	
	public DuplicatedStoreIdException(){}
	public DuplicatedStoreIdException(String message){
		super(message);
	}
}
