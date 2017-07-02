package com.cnb.exception;

/*
 * 김형주 
 * 2017-07-01
 * 제품이름 부분검색했을때 잘못 검색했거나 아예 없을경우 나타낼 메시지
 * 
 * 김형주 
 * 2017-07-01 
 * 생성, 초기 구현
 */
public class EmptyShoppingBasketProductListByProductNameException extends Exception{

	public EmptyShoppingBasketProductListByProductNameException(){}
	public EmptyShoppingBasketProductListByProductNameException(String message){
		super(message);
	}
}
