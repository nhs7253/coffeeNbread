package com.cnb.exception;

/*
 * 김형주 
 * 2017-07-06
 * 작성한사람이 추천수를 누르려고 할떄.
 * 
 * 김형주
 * 2017-07-06 
 * 생성, 초기 구현
 */
public class NotInputRecipeBoardWriterException extends Exception{

	public NotInputRecipeBoardWriterException(){}
	public NotInputRecipeBoardWriterException(String message){
		super(message);
	}
}
