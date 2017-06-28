package com.cnb.vo;

import java.io.Serializable;

/*
 * 노현식
 * 2017-06-28
 * 생성, 초기구현
 */
public class UserPreferenceStore implements Serializable{
	
	private String userId; //PRIMARY KEY
	private String storeId; //PRIMARY KEY
	private int preferenceHits;

	public UserPreferenceStore() {
	}

	public UserPreferenceStore(String userId, String storeId, int preferenceHits) {
		this.userId = userId;
		this.storeId = storeId;
		this.preferenceHits = preferenceHits;
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

	public int getPreferenceHits() {
		return preferenceHits;
	}

	public void setPreferenceHits(int preferenceHits) {
		this.preferenceHits = preferenceHits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + preferenceHits;
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
		UserPreferenceStore other = (UserPreferenceStore) obj;
		if (preferenceHits != other.preferenceHits)
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
		return "UserPreferenceStore [userId=" + userId + ", storeId=" + storeId + ", preferenceHits=" + preferenceHits
				+ "]";
	}
}
