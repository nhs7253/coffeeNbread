package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;

/*
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


	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", storeIntro=" + storeIntro + ", storePhone="
				+ storePhone + ", storeAddress=" + storeAddress + ", storeEmail=" + storeEmail + ", storeHits="
				+ storeHits + ", storeOpen=" + storeOpen + ", storeClose=" + storeClose + ", storePermission="
				+ storePermission + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((storeAddress == null) ? 0 : storeAddress.hashCode());
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
		if (storeAddress == null) {
			if (other.storeAddress != null)
				return false;
		} else if (!storeAddress.equals(other.storeAddress))
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
