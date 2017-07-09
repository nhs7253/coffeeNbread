package com.cnb.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * 노현식
 * 2017-07-04
 * getStoreOpenFormat(), getStoreCloseFormat() 추가
 * 
 * 이진영
 * 2017-06-28 수정
 * 참조변수 추가
 * 
 * 이진영
 * 2017-06-27 수정
 * 참조변수 추가
 * 
 * 
 * 김형주 
 * 2017-06-26 생성
 * 초기 구현
 */
public class Store implements Serializable{
	private String storeId;
	private String storeName;
	private String storeIntro;
	private String storePhone;
	private String storeAddress;
	private String storeEmail;
	private int storeHits;
	@DateTimeFormat(pattern="hh:mm")
	private Date storeOpen;
	@DateTimeFormat(pattern="hh:mm")
	private Date storeClose;
	private String storePermission;
	
	/***************************************************
	 * 부모테이블 : Store  자식 테이블 : StorePicture
	 * 하나의 매장은 여러개의 매장사진을 가지고있음
	 * 매장사진을 저정할 인스턴수변수 선언 
	 ***************************************************/
	private List<StorePicture> storePictureList;
	
	/***************************************************
	 * 부모테이블 : Store  자식 테이블 : StoreEvent
	 * 하나의 매장은 여러개의 이벤트를 가지고있음
	 * 이벤트를 저정할 인스턴수변수 선언 
	 ***************************************************/
	private List<StoreEvent> storeEventList;
	
	/***************************************************
	 * 부모테이블 : Store  자식 테이블 : OptionCategory
	 * 하나의 매장은 여러개의 옵션카테고리를 가지고있음
	 * 옵션카테고리를 저정할 인스턴수변수 선언 
	 ***************************************************/
	private List<OptionCategory> optionCategoryList;
	
	private List<OptionDetail> optionDetailList;
	/***************************************************
	 * 부모테이블 : Store  자식 테이블 : StoreCategory
	 * 하나의 매장은 여러 매장카테고리를 가지고있음
	 * 매장카테고리를 저정할 인스턴수변수 선언 
	 ***************************************************/
	private List<StoreCategory> storeCategoryList;
	
	public Store(){}
	public Store(String storeId, String storeName, String storeIntro, String storePhone, String storeAddress,
			String storeEmail, int storeHits, Date storeOpen, Date storeClose, String storePermission) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeIntro = storeIntro;
		this.storePhone = storePhone;
		this.storeAddress = storeAddress;
		this.storeEmail = storeEmail;
		this.storeHits = storeHits;
		this.storeOpen = storeOpen;
		this.storeClose = storeClose;
		this.storePermission = storePermission;
	}
	
	public Store(String storeId, String storeName, String storeIntro, String storePhone, String storeAddress,
			String storeEmail, Date storeOpen, Date storeClose, String storePermission) {
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeIntro = storeIntro;
		this.storePhone = storePhone;
		this.storeAddress = storeAddress;
		this.storeEmail = storeEmail;
		this.storeOpen = storeOpen;
		this.storeClose = storeClose;
		this.storePermission = storePermission;
	}
	public Store(String storeId, String storeName, String storeIntro, String storePhone, String storeAddress,
			String storeEmail, int storeHits, Date storeOpen, Date storeClose, String storePermission,
			List<OptionCategory> optionCategoryList, List<OptionDetail> optionDetailList) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeIntro = storeIntro;
		this.storePhone = storePhone;
		this.storeAddress = storeAddress;
		this.storeEmail = storeEmail;
		this.storeHits = storeHits;
		this.storeOpen = storeOpen;
		this.storeClose = storeClose;
		this.storePermission = storePermission;
		this.optionCategoryList = optionCategoryList;
		this.optionDetailList = optionDetailList;
	}
	public Store(String storeId, String storeName, String storeIntro, String storePhone, String storeAddress,
			String storeEmail, int storeHits, Date storeOpen, Date storeClose, String storePermission,
			List<StorePicture> storePictureList, List<StoreEvent> storeEventList,
			List<OptionCategory> optionCategoryList, List<OptionDetail> optionDetailList,
			List<StoreCategory> storeCategoryList) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeIntro = storeIntro;
		this.storePhone = storePhone;
		this.storeAddress = storeAddress;
		this.storeEmail = storeEmail;
		this.storeHits = storeHits;
		this.storeOpen = storeOpen;
		this.storeClose = storeClose;
		this.storePermission = storePermission;
		this.storePictureList = storePictureList;
		this.storeEventList = storeEventList;
		this.optionCategoryList = optionCategoryList;
		this.optionDetailList = optionDetailList;
		this.storeCategoryList = storeCategoryList;
	}
	
	/**
	 * JSP에서 storeOpenFormat로 호출 - storeOpen를 지정 포멧으로 반환한다.
	 * @return HH-mm형식의 DATE 문자열 - ex - (20:15)
	 */
	public String getStoreOpenFormat(){
		return new SimpleDateFormat("HH:mm").format(storeOpen);
	}
	
	/**
	 * JSP에서 storeCloseFormat로 호출 - storeClose를 지정 포멧으로 반환한다.
	 * @return HH-mm형식의 DATE 문자열 - ex - (20:15)
	 */
	public String getStoreCloseFormat(){
		return new SimpleDateFormat("HH:mm").format(storeClose);
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
	
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", storeIntro=" + storeIntro + ", storePhone="
				+ storePhone + ", storeAddress=" + storeAddress + ", storeEmail=" + storeEmail + ", storeHits="
				+ storeHits + ", storeOpen=" + storeOpen + ", storeClose=" + storeClose + ", storePermission="
				+ storePermission + ", storePictureList=" + storePictureList + ", storeEventList=" + storeEventList
				+ ", optionCategoryList=" + optionCategoryList + ", optionDetailList=" + optionDetailList
				+ ", storeCategoryList=" + storeCategoryList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((optionCategoryList == null) ? 0 : optionCategoryList.hashCode());
		result = prime * result + ((optionDetailList == null) ? 0 : optionDetailList.hashCode());
		result = prime * result + ((storeAddress == null) ? 0 : storeAddress.hashCode());
		result = prime * result + ((storeCategoryList == null) ? 0 : storeCategoryList.hashCode());
		result = prime * result + ((storeClose == null) ? 0 : storeClose.hashCode());
		result = prime * result + ((storeEmail == null) ? 0 : storeEmail.hashCode());
		result = prime * result + ((storeEventList == null) ? 0 : storeEventList.hashCode());
		result = prime * result + storeHits;
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
		result = prime * result + ((storeIntro == null) ? 0 : storeIntro.hashCode());
		result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
		result = prime * result + ((storeOpen == null) ? 0 : storeOpen.hashCode());
		result = prime * result + ((storePermission == null) ? 0 : storePermission.hashCode());
		result = prime * result + ((storePhone == null) ? 0 : storePhone.hashCode());
		result = prime * result + ((storePictureList == null) ? 0 : storePictureList.hashCode());
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
		Store other = (Store) obj;
		if (optionCategoryList == null) {
			if (other.optionCategoryList != null)
				return false;
		} else if (!optionCategoryList.equals(other.optionCategoryList))
			return false;
		if (optionDetailList == null) {
			if (other.optionDetailList != null)
				return false;
		} else if (!optionDetailList.equals(other.optionDetailList))
			return false;
		if (storeAddress == null) {
			if (other.storeAddress != null)
				return false;
		} else if (!storeAddress.equals(other.storeAddress))
			return false;
		if (storeCategoryList == null) {
			if (other.storeCategoryList != null)
				return false;
		} else if (!storeCategoryList.equals(other.storeCategoryList))
			return false;
		if (storeClose == null) {
			if (other.storeClose != null)
				return false;
		} else if (!storeClose.equals(other.storeClose))
			return false;
		if (storeEmail == null) {
			if (other.storeEmail != null)
				return false;
		} else if (!storeEmail.equals(other.storeEmail))
			return false;
		if (storeEventList == null) {
			if (other.storeEventList != null)
				return false;
		} else if (!storeEventList.equals(other.storeEventList))
			return false;
		if (storeHits != other.storeHits)
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		if (storeIntro == null) {
			if (other.storeIntro != null)
				return false;
		} else if (!storeIntro.equals(other.storeIntro))
			return false;
		if (storeName == null) {
			if (other.storeName != null)
				return false;
		} else if (!storeName.equals(other.storeName))
			return false;
		if (storeOpen == null) {
			if (other.storeOpen != null)
				return false;
		} else if (!storeOpen.equals(other.storeOpen))
			return false;
		if (storePermission == null) {
			if (other.storePermission != null)
				return false;
		} else if (!storePermission.equals(other.storePermission))
			return false;
		if (storePhone == null) {
			if (other.storePhone != null)
				return false;
		} else if (!storePhone.equals(other.storePhone))
			return false;
		if (storePictureList == null) {
			if (other.storePictureList != null)
				return false;
		} else if (!storePictureList.equals(other.storePictureList))
			return false;
		return true;
	}
	

}
