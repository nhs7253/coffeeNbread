package com.cnb.validation.annotation;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * 최민희
 * 2017-07-09
 * 생성
 */
public class SalesVolumeMethodForm {
	
	private String storeId;

	private String method;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
