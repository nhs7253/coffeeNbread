package com.cnb.exception;
/*
 * 노현식
 * 2017-07-07
 * 생성, 초기 구현
 */
/**
 * 해당 게시글을 찾을 수 없는 경우 발생
 */
public class ContentsNotFoundException extends Exception {
	public ContentsNotFoundException(){}
	public ContentsNotFoundException(String message){
		super(message);
	}
}
