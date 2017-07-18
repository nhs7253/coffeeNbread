package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.List;

/*
 * 최민희
 * 2017-07-09
 * 생성, 초기 구현
 */
public class ProductSelectForDeleteForm implements Serializable {
	private String productId;
	private List<String> productIdList;
	private String storeId;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public List<String> getProductIdList() {
		return productIdList;
	}
	public void setProductIdList(List<String> productIdList) {
		this.productIdList = productIdList;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
}
