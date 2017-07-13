package com.cnb.vo;

import java.io.Serializable;
/*
* 김형주
* 2017-06-29 생성
* 생성
*/


//매장별 가지고 있는 paymentOption들 설정.  //관리자가 paymentOption을 더 설정할수록 ,  매장입장에서는 매장
public class StorePaymentOptionList implements Serializable{

	
	private String storeId; //PRIMARY KEY ,FOREIGN KEY
	private String paymentId; //PRIMARY KEY, FOREIGN KEY
	private PaymentOptionList paymentOptionList; //join 위한 변수 설정
	
	
	
	
	
	
	
	public StorePaymentOptionList(String storeId, String paymentId) {
		super();
		this.storeId = storeId;
		this.paymentId = paymentId;
	}
	public StorePaymentOptionList(String storeId, String paymentId, PaymentOptionList paymentOptionList) {
		super();
		this.storeId = storeId;
		this.paymentId = paymentId;
		this.paymentOptionList = paymentOptionList;
	}
	public StorePaymentOptionList() {
		super();
	}
	@Override
	public String toString() {
		return "StorePaymentOptionList [storeId=" + storeId + ", paymentId=" + paymentId + ", paymentOptionList="
				+ paymentOptionList + "]";
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public PaymentOptionList getPaymentOptionList() {
		return paymentOptionList;
	}
	public void setPaymentOptionList(PaymentOptionList paymentOptionList) {
		this.paymentOptionList = paymentOptionList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paymentId == null) ? 0 : paymentId.hashCode());
		result = prime * result + ((paymentOptionList == null) ? 0 : paymentOptionList.hashCode());
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
		StorePaymentOptionList other = (StorePaymentOptionList) obj;
		if (paymentId == null) {
			if (other.paymentId != null)
				return false;
		} else if (!paymentId.equals(other.paymentId))
			return false;
		if (paymentOptionList == null) {
			if (other.paymentOptionList != null)
				return false;
		} else if (!paymentOptionList.equals(other.paymentOptionList))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		return true;
	}
	
	
	
}