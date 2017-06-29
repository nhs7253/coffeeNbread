package com.cnb.vo;

import java.io.Serializable;
/*
* 이진영
* 2017-06-27 생성
* 초기 구현
*/
public class EventProduct implements Serializable{
	
	/***************************************************
	 * 부모테이블 : StoreEvent  자식 테이블 : EventProduct
	 * 이벤트제품 하나는 매장이벤트를 가짐
	 * 이벤트제품에서 어떤 매장이벤트를 참조하고있는지 저장할 인스턴수 변수 선언 
	 ***************************************************/
	private String eventNo;	//PRIMARY KEY
	
	/***************************************************
	 * 부모테이블 : product  자식 테이블 : EventProduct
	 * 이벤트제품 하나는 제품을 가짐
	 * 이벤트제품에서 어떤 제품을 참조하고있는지 저장할 인스턴수 변수 선언 
	 ***************************************************/
	private String productId;	//PRIMARY KEY
	private String storeId;	//PRIMARY KEY
	
	public EventProduct(String eventNo, String productId, String storeId) {
		super();
		this.eventNo = eventNo;
		this.productId = productId;
		this.storeId = storeId;
	}
	public EventProduct() {
		super();
	}
	public String getEventNo() {
		return eventNo;
	}
	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	@Override
	public String toString() {
		return "EventProduct [eventNo=" + eventNo + ", productId=" + productId + ", storeId=" + storeId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventNo == null) ? 0 : eventNo.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
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
		EventProduct other = (EventProduct) obj;
		if (eventNo == null) {
			if (other.eventNo != null)
				return false;
		} else if (!eventNo.equals(other.eventNo))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		return true;
	}
	
	
}