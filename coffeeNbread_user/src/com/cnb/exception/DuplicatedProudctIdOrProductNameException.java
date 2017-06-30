package com.cnb.exception;
/*
 * 최민희
 * 2017-06-30
 * 생성
 */
/**
 * 제품 등록시 제품 아이디나 제품 이름이 중복될 경우 발생시킬 Exception
 * @author minhee
 *
 */
public class DuplicatedProudctIdOrProductNameException extends Exception{
	public DuplicatedProudctIdOrProductNameException(){}
	public DuplicatedProudctIdOrProductNameException(String message){
		super(message);
	}
}
