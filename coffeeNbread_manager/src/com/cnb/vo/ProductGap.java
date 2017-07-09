package com.cnb.vo;

import java.io.Serializable;
import java.util.List;
/*
 * 최민희
 * 2017-06-28 수정
 * 초기 구현
 */
/*
 * 최민희
 * 2017-06-27 생성
 * 초기 구현
 */
public class ProductGap implements Serializable {
	private String identifyCode;	//PRIMARY KEY
	private String productGap;		//PRIMARY KEY
	
	/*********************************************************************
	 * 부모 테이블 : ProductGap, 자식 테이블 : Product
	 * 1개의 증감폭에 여러 개의 제품들이 포함된다.
	 * 제품 정보를 저장할 Instance 변수를 선언해야 한다.
	 *********************************************************************/
	private String productId; //PRIMARY KEY
	private List<Product> productList;
	
	private String storeId;	//PRIMARY KEY
	
	public ProductGap() {
		super();
	}

	public ProductGap(String identifyCode, String productGap, String productId, String storeId) {
		super();
		this.identifyCode = identifyCode;
		this.productGap = productGap;
		this.productId = productId;
		this.storeId = storeId;
	}

	public ProductGap(String identifyCode, String productGap, String productId, List<Product> productList,
			String storeId) {
		super();
		this.identifyCode = identifyCode;
		this.productGap = productGap;
		this.productId = productId;
		this.productList = productList;
		this.storeId = storeId;
	}

	public String getIdentifyCode() {
		return identifyCode;
	}

	public void setIdentifyCode(String identifyCode) {
		this.identifyCode = identifyCode;
	}

	public String getProductGap() {
		return productGap;
	}

	public void setProductGap(String productGap) {
		this.productGap = productGap;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "ProductGap [identifyCode=" + identifyCode + ", productGap=" + productGap + ", productId=" + productId
				+ ", productList=" + productList + ", storeId=" + storeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifyCode == null) ? 0 : identifyCode.hashCode());
		result = prime * result + ((productGap == null) ? 0 : productGap.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
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
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		return true;
	}
}
