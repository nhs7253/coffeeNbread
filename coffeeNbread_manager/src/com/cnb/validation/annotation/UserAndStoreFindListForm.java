package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.cnb.vo.Store;

/*
 * 노현식
 * 2017-07-02
 * 생성, 초기 구현
 */

/**
 * UserAndStoreService의 선택 삭제를 위한 ValidationForm
 * findStoreBookmarkListByKeyword와 
 * findStoreVisitHistoryListByKeyword에서 공동 사용하기 때문에 ValidationForm으로 따로 만듦
 */
public class UserAndStoreFindListForm{
	
	private String userId;
	@NotNull
	private int page = 1; 
	private String keyword = null;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		if(keyword == null || keyword.trim().isEmpty()){
			this.keyword = null;
			return;
		}
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "UserAndStoreFindListForm [userId=" + userId + ", page=" + page + ", keyword=" + keyword + "]";
	}
}
