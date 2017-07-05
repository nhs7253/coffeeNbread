package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.cnb.vo.OptionCategory;
import com.cnb.vo.OptionDetail;
import com.cnb.vo.StoreCategory;
import com.cnb.vo.StoreEvent;
import com.cnb.vo.StorePicture;

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
	private String storeCategory;
	private String optionCategory;
	@NotEmpty
	private String storePicture;
	private String storeIntro;
	@NotEmpty
	private String storePhone;

	private String storeAddress;
	@NotEmpty
	private String storeEmail;
	private int storeHits;
	@NotNull
	@DateTimeFormat(pattern="hh:mm")
	private Date storeOpen;
	@NotNull
	@DateTimeFormat(pattern="hh:mm")
	private Date storeClose;
	private String storePermission="N";
	private List<StorePicture> storePictureList;
	private List<StoreEvent> storeEventList;
	private List<OptionCategory> optionCategoryList;
	private List<OptionDetail> optionDetailList;
	private List<StoreCategory> storeCategoryList;

	
	public List<StorePicture> getStorePictureList() {
		return storePictureList;
	}
	public void setStorePictureList(List<StorePicture> storePictureList) {
		this.storePictureList = storePictureList;
	}
	public List<StoreEvent> getStoreEventList() {
		return storeEventList;
	}
	public void setStoreEventList(List<StoreEvent> storeEventList) {
		this.storeEventList = storeEventList;
	}
	public List<OptionCategory> getOptionCategoryList() {
		return optionCategoryList;
	}
	public void setOptionCategoryList(List<OptionCategory> optionCategoryList) {
		this.optionCategoryList = optionCategoryList;
	}
	public List<OptionDetail> getOptionDetailList() {
		return optionDetailList;
	}
	public void setOptionDetailList(List<OptionDetail> optionDetailList) {
		this.optionDetailList = optionDetailList;
	}
	public List<StoreCategory> getStoreCategoryList() {
		return storeCategoryList;
	}
	public void setStoreCategoryList(List<StoreCategory> storeCategoryList) {
		this.storeCategoryList = storeCategoryList;
	}
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
	public String getStoreCategory() {
		return storeCategory;
	}
	public void setStoreCategory(String storeCategory) {
		this.storeCategory = storeCategory;
	}
	public String getOptionCategory() {
		return optionCategory;
	}
	public void setOptionCategory(String optionCategory) {
		this.optionCategory = optionCategory;
	}
	public String getStorePicture() {
		return storePicture;
	}
	public void setStorePicture(String storePicture) {
		this.storePicture = storePicture;
	}
	
	
	
}
