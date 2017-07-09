package com.cnb.validation.annotation;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/*
 * 김형주
 * 2017-07-06
 * 생성, 초기 구현
 */
public class RecipeBoardContentsViewForm{
	
	@NotEmpty
	private String select="recipeBoardTitle";
	
	private String keyword = null;
	private String storeId = null;
	private String userId=null;
	
	
	
	public String getUserId() {
		return userId;
	}

	
	
	public RecipeBoardContentsViewForm() {
		super();
	}



	public RecipeBoardContentsViewForm(String select, String keyword, String storeId, String userId, int page) {
		super();
		this.select = select;
		this.keyword = keyword;
		this.storeId = storeId;
		this.userId = userId;
		this.page = page;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}
	@NotNull
	private int page = 1;

	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {	
		if(select == null || select.trim().isEmpty()){
			this.select = "recipeBoardTitle";
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
		return "RecipeBoardContentsViewForm [select=" + select + ", keyword=" + keyword + ", storeId=" + storeId
				+ ", userId=" + userId + ", page=" + page + "]";
	}

	
	
}
