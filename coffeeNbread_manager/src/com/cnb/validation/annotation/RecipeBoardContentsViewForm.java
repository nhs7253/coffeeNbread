package com.cnb.validation.annotation;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/*
 * 노현식
 * 2017-07-06
 * 생성, 초기 구현
 */
public class RecipeBoardContentsViewForm{
	
	@NotEmpty
	private String select = "title";
	
	private String keyword = null;
	private String storeId = null;
	
	@NotNull
	private int page = 1;

	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {	
		if(select == null || select.trim().isEmpty()){
			this.select = "title";
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
		if(storeId == null || storeId.trim().isEmpty()){
			this.storeId = null;
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
		return "QnaBoardContentsViewForm [select=" + select + ", keyword=" + keyword + ", storeId=" + storeId
				+ ", page=" + page + "]";
	}
	
	
}
