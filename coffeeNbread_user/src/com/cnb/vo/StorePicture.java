package com.cnb.vo;

import java.io.Serializable;

/*
 * 이진영 
 * 2017-06-27 생성
 * 초기 구현
 */
public class StorePicture implements Serializable{

	private String storePicture;
	
	/***************************************************
	 * 부모테이블 : Store  자식 테이블 : Store_Picture
	 * 하나의 Store 테이블은 여러개의 Store_Picture 테이블과 연결
	 * 매장 정보를 저장할 인스턴수 변수 선언 
	 ***************************************************/
	private String storeId;
	private Store store;
	
	public StorePicture(String storePicture, String storeId) {
		super();
		this.storePicture = storePicture;
		this.storeId = storeId;
	}
	
	public StorePicture(String storePicture, String storeId, Store store) {
		super();
		this.storePicture = storePicture;
		this.storeId = storeId;
		this.store = store;
	}
	public StorePicture() {
		super();
	}
	public String getStorePicture() {
		return storePicture;
	}
	public void setStorePicture(String storePicture) {
		this.storePicture = storePicture;
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
	public String toString() {
		return "StorePicture [storePicture=" + storePicture + ", storeId=" + storeId + ", store=" + store + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((store == null) ? 0 : store.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
		result = prime * result + ((storePicture == null) ? 0 : storePicture.hashCode());
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
		StorePicture other = (StorePicture) obj;
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
		if (storePicture == null) {
			if (other.storePicture != null)
				return false;
		} else if (!storePicture.equals(other.storePicture))
			return false;
		return true;
	}
	
	


}
