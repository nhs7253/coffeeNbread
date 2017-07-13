package com.cnb.validation.annotation;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/*
 * 노현식
 * 2017-07-09
 * 생성, 초기 구현
 */
public class StoreViewForm{
	
	@NotEmpty
	private String select= "storeName";
	private String keyword = null;
	@NotNull
	private int page = 1;
	
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		if(select == null || select.trim().isEmpty()){
			this.select = "storeName";
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
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page == 0){
			this.page = 1;
			return;
		}
		this.page = page;
	}
	@Override
	public String toString() {
		return "StoreViewForm [select=" + select + ", keyword=" + keyword + ", page=" + page + "]";
	}
	
	
	
}
