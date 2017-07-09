package com.cnb.vo;

import java.io.Serializable;

/*
 * 노현식
 * 2017-06-27
 * 생성, 초기구현
 */
public class UserAuthority implements Serializable{
	
	private String userId; //PRIMARY KEY
	private String userAuthority;
	
	public UserAuthority() {
	}

	public UserAuthority(String userId, String userAuthority) {
		this.userId = userId;
		this.userAuthority = userAuthority;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userAuthority == null) ? 0 : userAuthority.hashCode());
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
		UserAuthority other = (UserAuthority) obj;
		if (userAuthority == null) {
			if (other.userAuthority != null)
				return false;
		} else if (!userAuthority.equals(other.userAuthority))
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
		return "UserAuthority [userId=" + userId + ", userAuthority=" + userAuthority + "]";
	}
}
