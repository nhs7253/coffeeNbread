package com.cnb.vo;

import java.io.Serializable;

/*
* 이진영
* 2017-06-27 생성
* 초기 구현
*/
public class OptionDetail implements Serializable{
	
	
	private String optionCategoryDetail;
	
	

	/***************************************************
	 * 부모테이블 : OptionCategory  자식 테이블 : OptionDetail
	 * 옵션상세하나는 하나의 옵션카테고리를 가짐
	 * 옵션상세에서 어떤 옵션카테고리를 참조하고있는지 저장할 인스턴수 변수 선언 
	 ***************************************************/
	private String storeId;
	private Store store;
	private String optionId;
	private OptionCategory optionCategory;
	
	/***************************************************
	 * 부모테이블 : Product  자식 테이블 : OptionDetail
	 * 옵션상세하나는 하나의 제품을 가짐
	 * 옵션상세에서 어떤 제품을 참조하고있는지 저장할 인스턴수 변수 선언 
	 ***************************************************/
	private String productId;
	private Product product;
	
	
	public OptionDetail() {
		super();
	}
	public OptionDetail(String optionCategoryDetail, String storeId, Store store, String optionId,
			OptionCategory optionCategory, String productId, Product product) {
		super();
		this.optionCategoryDetail = optionCategoryDetail;
		this.storeId = storeId;
		this.store = store;
		this.optionId = optionId;
		this.optionCategory = optionCategory;
		this.productId = productId;
		this.product = product;
	}
	public String getOptionCategoryDetail() {
		return optionCategoryDetail;
	}
	public void setOptionCategoryDetail(String optionCategoryDetail) {
		this.optionCategoryDetail = optionCategoryDetail;
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
	public String getOptionId() {
		return optionId;
	}
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	public OptionCategory getOptionCategory() {
		return optionCategory;
	}
	public void setOptionCategory(OptionCategory optionCategory) {
		this.optionCategory = optionCategory;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "OptionDetail [optionCategoryDetail=" + optionCategoryDetail + ", storeId=" + storeId + ", store="
				+ store + ", optionId=" + optionId + ", optionCategory=" + optionCategory + ", productId=" + productId
				+ ", product=" + product + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((optionCategory == null) ? 0 : optionCategory.hashCode());
		result = prime * result + ((optionCategoryDetail == null) ? 0 : optionCategoryDetail.hashCode());
		result = prime * result + ((optionId == null) ? 0 : optionId.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((store == null) ? 0 : store.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OptionDetail other = (OptionDetail) obj;
		if (optionCategory == null) {
			if (other.optionCategory != null)
				return false;
		} else if (!optionCategory.equals(other.optionCategory))
			return false;
		if (optionCategoryDetail == null) {
			if (other.optionCategoryDetail != null)
				return false;
		} else if (!optionCategoryDetail.equals(other.optionCategoryDetail))
			return false;
		if (optionId == null) {
			if (other.optionId != null)
				return false;
		} else if (!optionId.equals(other.optionId))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		return true;
	}
	
	
	
	

}
