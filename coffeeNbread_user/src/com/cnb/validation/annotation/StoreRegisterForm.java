package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/*
 * 노현식
 * 2017-07-04
 * 생성, 초기 구현
 */

public class StoreRegisterForm implements Serializable{
	
	@NotEmpty
	private String storeId;
	@NotEmpty
	private String storeName;
	private String storeIntro;
	@NotEmpty
	private String storePhone;
	@NotEmpty
	private String storeAddress;
	@NotEmpty
	private String storeEmail;
	private int storeHits;
	@NotEmpty
	private Date storeOpen;
	@NotEmpty
	private Date storeClose;
	private String storePermission;
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreIntro() {
		return storeIntro;
	}
	public void setStoreIntro(String storeIntro) {
		this.storeIntro = storeIntro;
	}
	public String getStorePhone() {
		return storePhone;
	}
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public String getStoreEmail() {
		return storeEmail;
	}
	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}
	public int getStoreHits() {
		return storeHits;
	}
	public void setStoreHits(int storeHits) {
		this.storeHits = storeHits;
	}
	public Date getStoreOpen() {
		return storeOpen;
	}
	public void setStoreOpen(Date storeOpen) {
		this.storeOpen = storeOpen;
	}
	public Date getStoreClose() {
		return storeClose;
	}
	public void setStoreClose(Date storeClose) {
		this.storeClose = storeClose;
	}
	public String getStorePermission() {
		return storePermission;
	}
	public void setStorePermission(String storePermission) {
		this.storePermission = storePermission;
	}
	
	
}
