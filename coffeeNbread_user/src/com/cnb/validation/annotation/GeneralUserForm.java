package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/*
 * 노현식
 * 2017-06-30
 * 생성, 초기 구현
 */
public class GeneralUserForm implements Serializable{
	
	@NotEmpty
	private String userId; //PRIMARY KEY
	@NotEmpty
	private String userPw;
	@NotEmpty
	private String userName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date userBirth;
	@NotEmpty
	private String userGender;
	@NotEmpty
	private String userEmail;
	@NotEmpty
	private String userPhone;
	@NotEmpty
	private String userAddress;
	private String userActiveState;
	private String store_id;
	
	
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
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
}
