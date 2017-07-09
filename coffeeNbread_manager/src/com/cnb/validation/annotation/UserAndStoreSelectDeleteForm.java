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
 * selectRemoveStoreBookmark와 
 * selectRemoveStoreVisitHistory에서 공동 사용하기 때문에 ValidationForm으로 따로 만듦
 */
public class UserAndStoreSelectDeleteForm implements Serializable{
	
	private String userId;
	private List<String> storeIdList;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getStoreIdList() {
		return storeIdList;
	}
	public void setStoreIdList(List<String> storeIdList) {
		this.storeIdList = storeIdList;
	}
}
