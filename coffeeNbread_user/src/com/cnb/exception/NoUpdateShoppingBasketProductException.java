package com.cnb.exception;

/*
 * 김형주 
 * 2017-07-01
 * ShoppingBasketProduct용 Exception으로 용도 변경
 * 
 * 김형주
 * 2017-07-01
 * 생성, 초기 구현
 */
public class NoUpdateShoppingBasketProductException extends Exception{

	public NoUpdateShoppingBasketProductException(){}
	public NoUpdateShoppingBasketProductException(String message){
		super(message);
	}
}
