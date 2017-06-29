package com.cnb.vo;

import java.io.Serializable;

/*
 * 김형주 
 * 2017-06-29PaymentDetailsDao 생성
 * 초기 구현
 */
public class PaymentOptionList implements Serializable{
	
	private String paymentId;
	private String paymentMethod;
	
	public PaymentOptionList(String paymentId, String paymentMethod) {
		this.paymentId = paymentId;
		this.paymentMethod = paymentMethod;
	}
	public PaymentOptionList() {
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	@Override
	public String toString() {
		return "PaymentOptionList [paymentId=" + paymentId + ", paymentMethod=" + paymentMethod + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paymentId == null) ? 0 : paymentId.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
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
		PaymentOptionList other = (PaymentOptionList) obj;
		if (paymentId == null) {
			if (other.paymentId != null)
				return false;
		} else if (!paymentId.equals(other.paymentId))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		return true;
	}


}
