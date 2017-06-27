package com.cnb.vo;

import java.io.Serializable;

/*
 * 최민희
 * 2017-06-27 생성
 * 초기 구현
 */
public class ProductGap implements Serializable {
	private String productGap;		//PRIMARY KEY
	private String identifyCode;	//PRIMARY KEY
	
	public ProductGap() {
		super();
	}
	public ProductGap(String productGap, String identifyCode) {
		super();
		this.productGap = productGap;
		this.identifyCode = identifyCode;
	}
	
	public String getProductGap() {
		return productGap;
	}
	public void setProductGap(String productGap) {
		this.productGap = productGap;
	}
	public String getIdentifyCode() {
		return identifyCode;
	}
	public void setIdentifyCode(String identifyCode) {
		this.identifyCode = identifyCode;
	}
	
	@Override
	public String toString() {
		return "ProductGap [productGap=" + productGap + ", identifyCode=" + identifyCode + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifyCode == null) ? 0 : identifyCode.hashCode());
		result = prime * result + ((productGap == null) ? 0 : productGap.hashCode());
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
		ProductGap other = (ProductGap) obj;
		if (identifyCode == null) {
			if (other.identifyCode != null)
				return false;
		} else if (!identifyCode.equals(other.identifyCode))
			return false;
		if (productGap == null) {
			if (other.productGap != null)
				return false;
		} else if (!productGap.equals(other.productGap))
			return false;
		return true;
	}
}
