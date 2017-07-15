package com.cnb.validation.annotation;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * 김형주
 * 제품목록 보기
 * 2017-07-14
 * @author 김형주
 *
 */
public class ReserSalesViewForm{
	
	@NotEmpty
	private String storeId;
	@NotEmpty
	private String select= "productCategory";
	private String keyword = null;
	
	@NotNull
	private int page = 1;
	
	
	
	
		public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
		@Override
	public String toString() {
		return "ReserSalesViewForm [storeId=" + storeId + ", select=" + select + ", keyword=" + keyword + ", page="
				+ page + "]";
	}
		public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
