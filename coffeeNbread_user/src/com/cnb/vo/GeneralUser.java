package com.cnb.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/* 
 * 노현식
 * 2017-07-04
 * getBirthFormat()
 * 
 * 노현식
 * 2017-07-03
 * String storeId 추가
 * 
 * 노현식
 * 2017-06-29
 * userBirth에 @DateTimeFormat(pattern="yyyy-MM-dd") 추가
 * 
 * 노현식
 * 2017-06-27
 * String userActiveState 추가
 * 
 * 노현식 
 * 2017-06-23 생성
 * 초기 구현
 */
public class GeneralUser implements Serializable{
	private String userId; //PRIMARY KEY
	private String userPw;
	private String userName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date userBirth;
	private String userGender;
	private String userEmail;
	private String userPhone;
	private String userAddress;
	private String userActiveState;
	private String storeId;

	private Store store;
	
	public GeneralUser() {
	}

	public GeneralUser(String userId, String userPw, String userName, Date userBirth, String userGender,
			String userEmail, String userPhone, String userAddress, String userActiveState) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userActiveState = userActiveState;
		this.storeId = null;
	}

	public GeneralUser(String userId, String userPw, String userName, Date userBirth, String userGender,
			String userEmail, String userPhone, String userAddress, String userActiveState, String storeId) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userActiveState = userActiveState;
		this.storeId = storeId;
	}
	
	public GeneralUser(String userId, String userPw, String userName, Date userBirth, String userGender,
			String userEmail, String userPhone, String userAddress, String userActiveState, String storeId,
			Store store) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userActiveState = userActiveState;
		this.storeId = storeId;
		this.store = store;
	}

	/**
	 * sec:authentication를 통해 JSP에서 yyyy-MM-dd형식으로 DATE 타입을 문자열로 출력
	 * <sec:authentication property="principal.userName"/>
	 * 처럼 getBirthFormat -> birthFormat 호출 됨(get을 제외한 맨 앞글자 소문자 - is도 가능)
	 * @return new SimpleDateFormat("yyyy-MM-dd").format(userBirth);
	 */
	public String getBirthFormat(){
		return new SimpleDateFormat("yyyy-MM-dd").format(userBirth);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserActiveState() {
		return userActiveState;
	}

	public void setUserActiveState(String userActiveState) {
		this.userActiveState = userActiveState;
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
		result = prime * result + ((userActiveState == null) ? 0 : userActiveState.hashCode());
		result = prime * result + ((userAddress == null) ? 0 : userAddress.hashCode());
		result = prime * result + ((userBirth == null) ? 0 : userBirth.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userGender == null) ? 0 : userGender.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
		result = prime * result + ((userPw == null) ? 0 : userPw.hashCode());
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
		GeneralUser other = (GeneralUser) obj;
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
		if (userActiveState == null) {
			if (other.userActiveState != null)
				return false;
		} else if (!userActiveState.equals(other.userActiveState))
			return false;
		if (userAddress == null) {
			if (other.userAddress != null)
				return false;
		} else if (!userAddress.equals(other.userAddress))
			return false;
		if (userBirth == null) {
			if (other.userBirth != null)
				return false;
		} else if (!userBirth.equals(other.userBirth))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userGender == null) {
			if (other.userGender != null)
				return false;
		} else if (!userGender.equals(other.userGender))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPhone == null) {
			if (other.userPhone != null)
				return false;
		} else if (!userPhone.equals(other.userPhone))
			return false;
		if (userPw == null) {
			if (other.userPw != null)
				return false;
		} else if (!userPw.equals(other.userPw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GeneralUser [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userBirth="
				+ userBirth + ", userGender=" + userGender + ", userEmail=" + userEmail + ", userPhone=" + userPhone
				+ ", userAddress=" + userAddress + ", userActiveState=" + userActiveState + ", storeId=" + storeId
				+ ", store=" + store + "]";
	}

	
}
