package com.cnb.validation.annotation;

import org.hibernate.validator.constraints.NotEmpty;

/*
 * 노현식
 * 2017-07-13
 * 생성, 초기 구현
 */
public class PointOfSalesViewForm{
	
	private String storeId;
	@NotEmpty
	private String select= "productName";
	private String keyword = null;
	
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		if(select == null || select.trim().isEmpty()){
			this.select = "productName";
			return;
		}
		this.select = select;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
		if(keyword == null || keyword.trim().isEmpty()){
			this.keyword = null;
		}
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((select == null) ? 0 : select.hashCode());
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
		PointOfSalesViewForm other = (PointOfSalesViewForm) obj;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (select == null) {
			if (other.select != null)
				return false;
		} else if (!select.equals(other.select))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PointOfSalesViewForm [storeId=" + storeId + ", select=" + select + ", keyword=" + keyword + "]";
	}
}
