package com.cnb.exception;

/*
 * 김형주 
 * 2017-06-30
 * BookMarkDelete용 Exception으로 용도 변경
 * 
 * 김형주
 * 2017-06-30 
 * 생성, 초기 구현
 */
public class BookCardNumDuplicationException extends Exception{

	public BookCardNumDuplicationException(){}
	public BookCardNumDuplicationException(String message){
		super(message);
	}
}
