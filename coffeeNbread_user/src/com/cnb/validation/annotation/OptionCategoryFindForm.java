package com.cnb.validation.annotation;

import java.io.Serializable;

import com.cnb.vo.OptionCategory;

public class OptionCategoryFindForm  implements Serializable{
	
	private String storeId;
	
	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
}
