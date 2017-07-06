package com.cnb.vo;

import java.io.Serializable;
/*
 * 이진영 
 * 2017-06-27 생성
 * 초기 구현
 */
public class StoreCategory implements Serializable{
	private int storeCategoryNo;
	private String storeCategory;
	
	/***************************************************
	 * 부모테이블 : Store  자식 테이블 : StoreCategory
	 * 매장분류하나는 하나의 매장을 가짐
	 * 매장 분류에서 어떤 매장을 참조하고있는지 저장할 인스턴수 변수 선언 
	 ***************************************************/
	private String storeId;
	private Store store;
	
	
	public StoreCategory() {
		super();
	}
	
	public StoreCategory(int storeCategoryNo, String storeCategory, String storeId) {
		super();
		this.storeCategoryNo = storeCategoryNo;
		this.storeCategory = storeCategory;
		this.storeId = storeId;
	}
	
	

	public StoreCategory(String storeCategory, String storeId) {
		this.storeCategory = storeCategory;
		this.storeId = storeId;
	}

	public StoreCategory(int storeCategoryNo, String storeCategory, String storeId, Store store) {
		super();
		this.storeCategoryNo = storeCategoryNo;
		this.storeCategory = storeCategory;
		this.storeId = storeId;
		this.store = store;
	}
	public int getStoreCategoryNo() {
		return storeCategoryNo;
	}
	public void setStoreCategoryNo(int storeCategoryNo) {
		this.storeCategoryNo = storeCategoryNo;
	}
	public String getStoreCategory() {
		return storeCategory;
	}
	public void setStoreCategory(String storeCategory) {
		this.storeCategory = storeCategory;
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
	@Override
	public String toString() {
		return "StoreCategory [storeCategoryNo=" + storeCategoryNo + ", storeCategory=" + storeCategory + ", storeId="
				+ storeId + ", store=" + store + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((store == null) ? 0 : store.hashCode());
		result = prime * result + ((storeCategory == null) ? 0 : storeCategory.hashCode());
		result = prime * result + storeCategoryNo;
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
		StoreCategory other = (StoreCategory) obj;
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
			return false;
		if (storeCategory == null) {
			if (other.storeCategory != null)
				return false;
		} else if (!storeCategory.equals(other.storeCategory))
			return false;
		if (storeCategoryNo != other.storeCategoryNo)
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		return true;
	}
	
	
	
}
