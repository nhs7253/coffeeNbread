package com.cnb.exception;
/*
 * 김형주
 * 2017-07-03
 * 생성
 */
/**
 * 매장 운영시간이 아닐떄 제품수령 희망시간을 적어놓은 경우.
 * @author minhee
 *
 */
public class NotInsertTradeDateException extends Exception {
	public NotInsertTradeDateException(){}
	public NotInsertTradeDateException(String message){
		super(message);
	}
}
