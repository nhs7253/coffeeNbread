package com.cnb.validation.annotation;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ProductFindForm implements Serializable {

	private String storeId;

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
