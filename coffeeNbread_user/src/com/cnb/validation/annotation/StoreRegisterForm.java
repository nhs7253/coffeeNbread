package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.cnb.vo.OptionCategory;
import com.cnb.vo.OptionDetail;
import com.cnb.vo.StoreCategory;
import com.cnb.vo.StoreEvent;

/*
 * 노현식
 * 2017-07-04
 * 생성, 초기 구현
 */

public class StoreRegisterForm implements Serializable{
	
	private String originalName; //원래이름
	private String saveName; //UUID로 생성한 이름 - 파일명 중복을 피하기 위해
	
	@NotEmpty
	private String storeId; 
	@NotEmpty
	private String storeName; 
	private MultipartFile storePicture; 
	private String storeIntro;  
	@NotEmpty
	private String storePhone; 
	private String storeAddress; 
	@NotEmpty
	private String storeEmail; 
	private int storeHits; 
	@NotNull
	@DateTimeFormat(pattern="HH:mm") 
	private Date storeOpen;
	@NotNull
	@DateTimeFormat(pattern="HH:mm")
	private Date storeClose;
	private String storePermission="N";
	private List<MultipartFile> storePictureList = new ArrayList<>();
	private List<StoreEvent> storeEventList;
	
	private List<String> optionCategoryList;
	private List<OptionDetail> optionDetailList;
	private List<String> storeCategoryList;

	private List<String> paymentIdList;
	
	private String X;
	private String Y;
	
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public List<StoreEvent> getStoreEventList() {
		return storeEventList;
	}
	public void setStoreEventList(List<StoreEvent> storeEventList) {
		this.storeEventList = storeEventList;
	}
	public List<String> getOptionCategoryList() {
		return optionCategoryList;
	}
	public void setOptionCategoryList(List<String> optionCategoryList) {
		this.optionCategoryList = optionCategoryList;
	}
	public List<OptionDetail> getOptionDetailList() {
		return optionDetailList;
	}
	public void setOptionDetailList(List<OptionDetail> optionDetailList) {
		this.optionDetailList = optionDetailList;
	}
	public List<String> getStoreCategoryList() {
		return storeCategoryList;
	}
	public void setStoreCategoryList(List<String> storeCategoryList) {
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
	
	public List<MultipartFile> getStorePictureList() {
		return storePictureList;
	}
	public void setStorePictureList(List<MultipartFile> storePictureList) {
		this.storePictureList = storePictureList;
	}
	public MultipartFile getStorePicture() {
		return storePicture;
	}
	public void setStorePicture(MultipartFile storePicture) {
		this.storePicture = storePicture;
	}
	public List<String> getPaymentIdList() {
		return paymentIdList;
	}
	public void setPaymentIdList(List<String> paymentIdList) {
		this.paymentIdList = paymentIdList;
	}
	public String getX() {
		return X;
	}
	public void setX(String x) {
		X = x;
	}
	public String getY() {
		return Y;
	}
	public void setY(String y) {
		Y = y;
	}
	@Override
	public String toString() {
		return "StoreRegisterForm [originalName=" + originalName + ", saveName=" + saveName + ", storeId=" + storeId
				+ ", storeName=" + storeName + ", storePicture=" + storePicture + ", storeIntro=" + storeIntro
				+ ", storePhone=" + storePhone + ", storeAddress=" + storeAddress + ", storeEmail=" + storeEmail
				+ ", storeHits=" + storeHits + ", storeOpen=" + storeOpen + ", storeClose=" + storeClose
				+ ", storePermission=" + storePermission + ", storePictureList=" + storePictureList
				+ ", storeEventList=" + storeEventList + ", optionCategoryList=" + optionCategoryList
				+ ", optionDetailList=" + optionDetailList + ", storeCategoryList=" + storeCategoryList
				+ ", paymentIdList=" + paymentIdList + ", X=" + X + ", Y=" + Y + "]";
	}
	
	

	
	
	
	
}
