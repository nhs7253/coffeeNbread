package com.cnb.exception;

/*
 * 김형주 
 * 2017-07-04
 * BookMarkDelete용 Exception으로 용도 변경
 * 
 * 김형주
 * 2017-07-04 
 * 생성, 초기 구현
 */
public class NotInputRecipeBoardPictureException extends Exception{

	public NotInputRecipeBoardPictureException(){}
	public NotInputRecipeBoardPictureException(String message){
		super(message);
	}
}
