package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;




/*
* 김형주
* 2017-06-28 생성
* 
*/
public class PaymentDetails implements Serializable{

	
	private int paymentNo;
	private String paymentOption;
	private Date tradeDate;
	private String sellMethod;
	private int reservationOrderCount;
	private String userId;
	private String productId;
	private String storeId;
	private int productTradeCount;
	
	private List<Product> productList;
	
	
	public PaymentDetails(int paymentNo, String paymentOption, Date tradeDate, String sellMethod,
			int reservationOrderCount, String userId, String productId, String storeId, int productTradeCount) {
		super();
		this.paymentNo = paymentNo;
		this.paymentOption = paymentOption;
		this.tradeDate = tradeDate;
		this.sellMethod = sellMethod;
		this.reservationOrderCount = reservationOrderCount;
		this.userId = userId;
		this.productId = productId;
		this.storeId = storeId;
		this.productTradeCount = productTradeCount;
	}
	
	
	public PaymentDetails(int paymentNo, String paymentOption, Date tradeDate, String sellMethod,
			int reservationOrderCount, String userId, String productId, String storeId, int productTradeCount,
			List<Product> productList) {
		super();
		this.paymentNo = paymentNo;
		this.paymentOption = paymentOption;
		this.tradeDate = tradeDate;
		this.sellMethod = sellMethod;
		this.reservationOrderCount = reservationOrderCount;
		this.userId = userId;
		this.productId = productId;
		this.storeId = storeId;
		this.productTradeCount = productTradeCount;
		this.productList = productList;
	}


	public PaymentDetails() {
		super();
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getSellMethod() {
		return sellMethod;
	}
	public void setSellMethod(String sellMethod) {
		this.sellMethod = sellMethod;
	}
	public int getReservationOrderCount() {
		return reservationOrderCount;
	}
	public void setReservationOrderCount(int reservationOrderCount) {
		this.reservationOrderCount = reservationOrderCount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public int getProductTradeCount() {
		return productTradeCount;
	}
	public void setProductTradeCount(int productTradeCount) {
		this.productTradeCount = productTradeCount;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + paymentNo;
		result = prime * result + ((paymentOption == null) ? 0 : paymentOption.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + productTradeCount;
		result = prime * result + reservationOrderCount;
		result = prime * result + ((sellMethod == null) ? 0 : sellMethod.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
		result = prime * result + ((tradeDate == null) ? 0 : tradeDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		PaymentDetails other = (PaymentDetails) obj;
		if (paymentNo != other.paymentNo)
			return false;
		if (paymentOption == null) {
			if (other.paymentOption != null)
				return false;
		} else if (!paymentOption.equals(other.paymentOption))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productTradeCount != other.productTradeCount)
			return false;
		if (reservationOrderCount != other.reservationOrderCount)
			return false;
		if (sellMethod == null) {
			if (other.sellMethod != null)
				return false;
		} else if (!sellMethod.equals(other.sellMethod))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		if (tradeDate == null) {
			if (other.tradeDate != null)
				return false;
		} else if (!tradeDate.equals(other.tradeDate))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaymentDetails [paymentNo=" + paymentNo + ", paymentOption=" + paymentOption + ", tradeDate="
				+ tradeDate + ", sellMethod=" + sellMethod + ", reservationOrderCount=" + reservationOrderCount
				+ ", userId=" + userId + ", productId=" + productId + ", storeId=" + storeId + ", productTradeCount="
				+ productTradeCount + "]";
	}
	
	
	
}