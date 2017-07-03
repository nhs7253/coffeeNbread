package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.cnb.vo.Store;

/*
 * 노현식
 * 2017-07-02
 * 생성, 초기 구현
 */
public class StoreBookmarkForm implements Serializable{
	
	@NotEmpty
	private String userId; //PRIMARY KEY
	@NotEmpty
	private String storeId; //PRIMARY KEY
	
	private Store store;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	
}
