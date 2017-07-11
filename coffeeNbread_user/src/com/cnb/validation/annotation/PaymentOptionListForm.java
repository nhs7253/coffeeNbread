package com.cnb.validation.annotation;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/*
 * 노현식 
 * 2017-07-11
 * 생성, 초기 구현
 */
public class PaymentOptionListForm{
	
	@NotEmpty
	@Size(max=1)
	private String paymentId;
	@NotEmpty
	private String paymentMethod;
	
	public PaymentOptionListForm(String paymentId, String paymentMethod) {
		this.paymentId = paymentId;
		this.paymentMethod = paymentMethod;
	}
	public PaymentOptionListForm() {
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
		PaymentOptionListForm other = (PaymentOptionListForm) obj;
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
