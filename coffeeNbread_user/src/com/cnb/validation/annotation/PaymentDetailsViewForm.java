package com.cnb.validation.annotation;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/*
 * 노현식
 * 2017-07-06
 * 생성, 초기 구현
 */
public class PaymentDetailsViewForm{
	
	
	private String storeId = null;
	
	@NotNull
	private int page = 1;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	
	
	
}
