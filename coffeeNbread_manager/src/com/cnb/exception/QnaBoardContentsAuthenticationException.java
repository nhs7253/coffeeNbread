package com.cnb.exception;
/*
 * 노현식
 * 2017-07-07
 * 생성, 초기 구현
 */
/**
 * QnaBoardContents 특정 동작시 권한이 부족한 경우 발생
 */
public class QnaBoardContentsAuthenticationException extends Exception {
	public QnaBoardContentsAuthenticationException(){}
	public QnaBoardContentsAuthenticationException(String message){
		super(message);
	}
}
