package com.cnb.vo;

import java.io.Serializable;

/*
 * 노현식
 * 2017-06-29
 * Store 추가 
 * 
 * 노현식
 * 2017-06-28
 * 생성, 초기구현
 */
public class StoreVisitHistory implements Serializable{
	
	private String userId; //PRIMARY KEY
	private String storeId; //PRIMARY KEY
	
	private Store store;
	
	public StoreVisitHistory() {
	}
	
	public StoreVisitHistory(String userId, String storeId) {
		this.userId = userId;
		this.storeId = storeId;
	}

	public StoreVisitHistory(String userId, String storeId, Store store) {
		this.userId = userId;
		this.storeId = storeId;
		this.store = store;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((store == null) ? 0 : store.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
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
		StoreVisitHistory other = (StoreVisitHistory) obj;
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StoreVisitHistory [userId=" + userId + ", storeId=" + storeId + ", store=" + store + "]";
	}
}
