package com.cnb.exception;
/*
 * 노현식
 * 2017-07-08
 * 생성, 초기 구현
 */
/**
 * 댓글 관련해서 발생하는 예외
 */
public class BoardReplyException extends Exception {
	public BoardReplyException(){}
	public BoardReplyException(String message){
		super(message);
	}
}
