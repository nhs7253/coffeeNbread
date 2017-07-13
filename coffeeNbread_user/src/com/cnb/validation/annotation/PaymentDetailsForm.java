package com.cnb.validation.annotation;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class PaymentDetailsForm{
	
	
	
	private int paymentNo;
	
	
	private String paymentOption;
	
	private Date tradeDate;
	
	
	private String sellMethod;
	
	 //controller에서 작업.
	private List<Integer> reservationOrderCount;
	
	
	private String userId;
	
	
	private String productId;
	
	
	private List<String> productIdList;
	
    private List<String> storeIdList;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date productHopeTime;
    
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

	public List<Integer> getReservationOrderCount() {
		return reservationOrderCount;
	}

	public void setReservationOrderCount(List<Integer> reservationOrderCount) {
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

	public List<String> getProductIdList() {
		return productIdList;
	}

	public void setProductIdList(List<String> productIdList) {
		this.productIdList = productIdList;
	}

	public List<String> getStoreIdList() {
		return storeIdList;
	}

	public void setStoreIdList(List<String> storeIdList) {
		this.storeIdList = storeIdList;
	}



	public Date getProductHopeTime() {
		return productHopeTime;
	}

	public void setProductHopeTime(Date productHopeTime) {
		this.productHopeTime = productHopeTime;
	}

	@Override
	public String toString() {
		return "PaymentDetailsForm [paymentNo=" + paymentNo + ", paymentOption=" + paymentOption + ", tradeDate="
				+ tradeDate + ", sellMethod=" + sellMethod + ", reservationOrderCount=" + reservationOrderCount
				+ ", userId=" + userId + ", productId=" + productId + ", productIdList=" + productIdList
				+ ", storeIdList=" + storeIdList + ", productHopeTime=" + productHopeTime + "]";
	}	

	
	
}
