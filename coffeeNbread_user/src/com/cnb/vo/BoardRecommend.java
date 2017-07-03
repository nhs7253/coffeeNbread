package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * 김형주
 * 2017-07-03 생성
 * 초기 구현
 */
public class BoardRecommend implements Serializable {
	
   private String userId; //FOREIGN KEY , PRIMARY KEY
   private int recipeBoardNo;//FOREIGN KEY, PRIMARY KEY
   private String StoreId;//FOREIGN KEY, PRIMARY KEY
   
   private GeneralUser generalUser; //조인 위한 유저
   private RecipeBoardContents recipeBoardContents;//조인 위한 레시피 게시글
   private Store store; //조인 위한 매장
public BoardRecommend(String userId, int recipeBoardNo, String storeId, GeneralUser generalUser,
		RecipeBoardContents recipeBoardContents, Store store) {
	super();
	this.userId = userId;
	this.recipeBoardNo = recipeBoardNo;
	StoreId = storeId;
	this.generalUser = generalUser;
	this.recipeBoardContents = recipeBoardContents;
	this.store = store;
}
public BoardRecommend() {
	super();
}
@Override
public String toString() {
	return "BoardRecommend [userId=" + userId + ", recipeBoardNo=" + recipeBoardNo + ", StoreId=" + StoreId
			+ ", generalUser=" + generalUser + ", recipeBoardContents=" + recipeBoardContents + ", store=" + store
			+ "]";
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public int getRecipeBoardNo() {
	return recipeBoardNo;
}
public void setRecipeBoardNo(int recipeBoardNo) {
	this.recipeBoardNo = recipeBoardNo;
}
public String getStoreId() {
	return StoreId;
}
public void setStoreId(String storeId) {
	StoreId = storeId;
}
public GeneralUser getGeneralUser() {
	return generalUser;
}
public void setGeneralUser(GeneralUser generalUser) {
	this.generalUser = generalUser;
}
public RecipeBoardContents getRecipeBoardContents() {
	return recipeBoardContents;
}
public void setRecipeBoardContents(RecipeBoardContents recipeBoardContents) {
	this.recipeBoardContents = recipeBoardContents;
}
public Store getStore() {
	return store;
}
public void setStore(Store store) {
	this.store = store;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((StoreId == null) ? 0 : StoreId.hashCode());
	result = prime * result + ((generalUser == null) ? 0 : generalUser.hashCode());
	result = prime * result + ((recipeBoardContents == null) ? 0 : recipeBoardContents.hashCode());
	result = prime * result + recipeBoardNo;
	result = prime * result + ((store == null) ? 0 : store.hashCode());
	result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
	BoardRecommend other = (BoardRecommend) obj;
	if (StoreId == null) {
		if (other.StoreId != null)
			return false;
	} else if (!StoreId.equals(other.StoreId))
		return false;
	if (generalUser == null) {
		if (other.generalUser != null)
			return false;
	} else if (!generalUser.equals(other.generalUser))
		return false;
	if (recipeBoardContents == null) {
		if (other.recipeBoardContents != null)
			return false;
	} else if (!recipeBoardContents.equals(other.recipeBoardContents))
		return false;
	if (recipeBoardNo != other.recipeBoardNo)
		return false;
	if (store == null) {
		if (other.store != null)
			return false;
	} else if (!store.equals(other.store))
		return false;
	if (userId == null) {
		if (other.userId != null)
			return false;
	} else if (!userId.equals(other.userId))
		return false;
	return true;
}
   
   
}
