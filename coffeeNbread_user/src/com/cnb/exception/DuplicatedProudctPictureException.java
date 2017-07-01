package com.cnb.exception;

/*
 * 최민희
 * 2017-07-01
 * 생성
 */
/**
 * 제품 사진 등록시 제품 사진 (productPicture) 중복될 경우 발생시킬 Exception
 * @author minhee
 *
 */
public class DuplicatedProudctPictureException extends Exception {
	public DuplicatedProudctPictureException(){}
	public DuplicatedProudctPictureException(String message){
		super(message);
	}
}
