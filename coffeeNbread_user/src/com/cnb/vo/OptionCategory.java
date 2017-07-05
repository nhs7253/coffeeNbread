package com.cnb.vo;

import java.io.Serializable;
import java.util.List;

/*
* 이진영
* 2017-06-27 생성
* 초기 구현
*/
public class OptionCategory implements Serializable{
	private int optionId;
	private String optionCategory;
	
	/***************************************************
	 * 부모테이블 : Store  자식 테이블 : OptionCategory
	 * 옵션분류하나는 하나의 매장을 가짐
	 * 옵션 분류에서 어떤 매장을 참조하고있는지 저장할 인스턴수 변수 선언 
	 ***************************************************/
	private String storeId;
	private Store store;
	
	
	/***************************************************
	 * 부모테이블 : OptionCategory  자식 테이블 : OptionDetail
	 * 옵션상세하나는 하나의 옵션카테고리를 가짐
	 * 옵션상세에서 어떤 옵션카테고리를 참조하고있는지 저장할 인스턴수 변수 선언 
	 ***************************************************/
	private List<OptionDetail> optionDetailList;
	
	public OptionCategory() {
	}
	
	public OptionCategory(int optionId, String optionCategory, String storeId, Store store) {
		super();
		this.optionId = optionId;
		this.optionCategory = optionCategory;
		this.storeId = storeId;
		this.store = store;
	}
	
	
	public OptionCategory(String optionCategory, String storeId) {
		this.optionCategory = optionCategory;
		this.storeId = storeId;
	}

	public OptionCategory(int optionId, String storeId, String optionCategory) {
		super();
		this.optionId = optionId;
		this.optionCategory = optionCategory;
		this.storeId = storeId;
	}
	
	public OptionCategory(int optionId, String optionCategory, String storeId, Store store,
			List<OptionDetail> optionDetailList) {
		super();
		this.optionId = optionId;
		this.optionCategory = optionCategory;
		this.storeId = storeId;
		this.store = store;
		this.optionDetailList = optionDetailList;
	}

	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public String getOptionCategory() {
		return optionCategory;
	}
	public void setOptionCategory(String optionCategory) {
		this.optionCategory = optionCategory;
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
		return "OptionCategory [optionId=" + optionId + ", optionCategory=" + optionCategory + ", storeId=" + storeId
				+ ", store=" + store + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((optionCategory == null) ? 0 : optionCategory.hashCode());
		result = prime * result + optionId;
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
		OptionCategory other = (OptionCategory) obj;
		if (optionCategory == null) {
			if (other.optionCategory != null)
				return false;
		} else if (!optionCategory.equals(other.optionCategory))
			return false;
		if (optionId != other.optionId)
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
