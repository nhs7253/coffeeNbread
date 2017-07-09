package com.cnb.exception;
/*
 * 최민희
 * 2017-06-30
 * 생성
 */
/**
 * 제품을 찾을 수 없는 경우 발생시킬 Exception
 * @author minhee
 *
 */
public class ProductNotFoundException extends Exception {
	public ProductNotFoundException(){}
	public ProductNotFoundException(String message){
		super(message);
	}
}
