package com.cnb.exception;

/*
 * 2017-07-09
 * 김형주 
 * 생성
 */
/**
 * 장바구니 버튼누를떄 만약 개수가 0이라면 생기는 오류
 */
public class NullShoppingBasketProductException extends Exception {
	public NullShoppingBasketProductException(){}
	public NullShoppingBasketProductException(String message){
		super(message);
	}
}
