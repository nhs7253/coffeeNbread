package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/* 이진영
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
	private Date storeOpen;
	private Date storeClose;
	private String storePermission;
	
	/***************************************************
	 * 부모테이블 : Store  자식 테이블 : StorePicture
	 * 하나의 매장은 여러개의 매장사진을 가지고있음
	 * 매장사진을 저정할 인스턴수변수 선언 
	 ***************************************************/
	private List<StorePicture> StorePictureList;
	
	/***************************************************
	 * 부모테이블 : Store  자식 테이블 : StoreEvent
	 * 하나의 매장은 여러개의 이벤트를 가지고있음
	 * 이벤트를 저정할 인스턴수변수 선언 
	 ***************************************************/
	private List<StoreEvent> StoreEventList;
	
	/***************************************************
	 * 부모테이블 : Store  자식 테이블 : OptionCategory
	 * 하나의 매장은 여러개의 옵션카테고리를 가지고있음
	 * 옵션카테고리를 저정할 인스턴수변수 선언 
	 ***************************************************/
	private List<OptionCategory> OptionCategoryList;
	
	/***************************************************
	 * 부모테이블 : Store  자식 테이블 : StoreCategory
	 * 하나의 매장은 한 매장카테고리를 가지고있음
	 * 매장카테고리를 저정할 인스턴수변수 선언 
	 ***************************************************/
	private StoreCategory storeCategory;
	
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
			String storeEmail, int storeHits, Date storeOpen, Date storeClose, String storePermission,
			List<StorePicture> storePictureList, List<StoreEvent> StoreEventList,
			List<OptionCategory> optionCategoryList) {
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
		StorePictureList = storePictureList;
		StoreEventList = StoreEventList;
		OptionCategoryList = optionCategoryList;
	}
	public Store(String storeId, String storeName, String storeIntro, String storePhone, String storeAddress,
			String storeEmail, int storeHits, Date storeOpen, Date storeClose, String storePermission,
			List<StorePicture> storePictureList, List<StoreEvent> StoreEventList,
			List<OptionCategory> optionCategoryList, StoreCategory storeCategory) {
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
		StorePictureList = storePictureList;
		StoreEventList = StoreEventList;
		OptionCategoryList = optionCategoryList;
		this.storeCategory = storeCategory;
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
		return StorePictureList;
	}
	public void setStorePictureList(List<StorePicture> storePictureList) {
		StorePictureList = storePictureList;
	}
	public List<StoreEvent> getStoreEventList() {
		return StoreEventList;
	}
	public void setStoreEventList(List<StoreEvent> StoreEventList) {
		StoreEventList = StoreEventList;
	}
	public List<OptionCategory> getOptionCategoryList() {
		return OptionCategoryList;
	}
	public void setOptionCategoryList(List<OptionCategory> optionCategoryList) {
		OptionCategoryList = optionCategoryList;
	}
	public StoreCategory getStoreCategory() {
		return storeCategory;
	}
	public void setStoreCategory(StoreCategory storeCategory) {
		this.storeCategory = storeCategory;
	}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", storeIntro=" + storeIntro + ", storePhone="
				+ storePhone + ", storeAddress=" + storeAddress + ", storeEmail=" + storeEmail + ", storeHits="
				+ storeHits + ", storeOpen=" + storeOpen + ", storeClose=" + storeClose + ", storePermission="
				+ storePermission + ", StorePictureList=" + StorePictureList + ", StoreEventList="
				+ StoreEventList + ", OptionCategoryList=" + OptionCategoryList + ", storeCategory=" + storeCategory
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OptionCategoryList == null) ? 0 : OptionCategoryList.hashCode());
		result = prime * result + ((StoreEventList == null) ? 0 : StoreEventList.hashCode());
		result = prime * result + ((StorePictureList == null) ? 0 : StorePictureList.hashCode());
		result = prime * result + ((storeAddress == null) ? 0 : storeAddress.hashCode());
		result = prime * result + ((storeCategory == null) ? 0 : storeCategory.hashCode());
		result = prime * result + ((storeClose == null) ? 0 : storeClose.hashCode());
		result = prime * result + ((storeEmail == null) ? 0 : storeEmail.hashCode());
		result = prime * result + storeHits;
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
		result = prime * result + ((storeIntro == null) ? 0 : storeIntro.hashCode());
		result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
		result = prime * result + ((storeOpen == null) ? 0 : storeOpen.hashCode());
		result = prime * result + ((storePermission == null) ? 0 : storePermission.hashCode());
		result = prime * result + ((storePhone == null) ? 0 : storePhone.hashCode());
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
		if (OptionCategoryList == null) {
			if (other.OptionCategoryList != null)
				return false;
		} else if (!OptionCategoryList.equals(other.OptionCategoryList))
			return false;
		if (StoreEventList == null) {
			if (other.StoreEventList != null)
				return false;
		} else if (!StoreEventList.equals(other.StoreEventList))
			return false;
		if (StorePictureList == null) {
			if (other.StorePictureList != null)
				return false;
		} else if (!StorePictureList.equals(other.StorePictureList))
			return false;
		if (storeAddress == null) {
			if (other.storeAddress != null)
				return false;
		} else if (!storeAddress.equals(other.storeAddress))
			return false;
		if (storeCategory == null) {
			if (other.storeCategory != null)
				return false;
		} else if (!storeCategory.equals(other.storeCategory))
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
		return true;
	}
	
}
