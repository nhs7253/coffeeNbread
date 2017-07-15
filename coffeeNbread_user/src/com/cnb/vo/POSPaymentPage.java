package com.cnb.vo;

import java.io.Serializable;
import java.util.List;
/*
 * 노현식
 * 2017-07-13
 * 생성, 초기 구현
 */
public class POSPaymentPage implements Serializable{
	
	private String storeId; 
	private String productId; 
	private String productName;
	private int productTradeCount;
	private int productPrice;
	
	public POSPaymentPage() {
	}

	public POSPaymentPage(String storeId, String productId, String productName, int productTradeCount,
			int productPrice) {
		this.storeId = storeId;
		this.productId = productId;
		this.productName = productName;
		this.productTradeCount = productTradeCount;
		this.productPrice = productPrice;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductTradeCount() {
		return productTradeCount;
	}

	public void setProductTradeCount(int productTradeCount) {
		this.productTradeCount = productTradeCount;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + productPrice;
		result = prime * result + productTradeCount;
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
		POSPaymentPage other = (POSPaymentPage) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPrice != other.productPrice)
			return false;
		if (productTradeCount != other.productTradeCount)
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "POSPaymentPage [storeId=" + storeId + ", productId=" + productId + ", productName=" + productName
				+ ", productTradeCount=" + productTradeCount + ", productPrice=" + productPrice + "]";
	}

	
}
