package com.cnb.validation.annotation;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductDetailForm implements Serializable {
	
	@NotEmpty
	private String storeId;
	
	@NotEmpty
	private String productId;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
