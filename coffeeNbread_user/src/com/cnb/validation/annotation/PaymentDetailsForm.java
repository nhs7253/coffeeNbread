package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cnb.vo.Product;

public class PaymentDetailsForm implements Serializable {
	
	
	
	private int paymentNo;
	
	
	private String paymentOption;
	
	private Date tradeDate;
	
	
	private String sellMethod;
	
	 //controller에서 작업.
	private int reservationOrderCount;
	
	
	private String userId;
	
	
	private String productId;
	
	
	private List<String> productIdList;
	
	
	public List<String> getProductIdList() {
		return productIdList;
	}

	public void setProductIdList(List<String> productIdList) {
		this.productIdList = productIdList;
	}

	private String storeId;
	
	
	private int produtctTradeCount;

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

	public int getProdutctTradeCount() {
		return produtctTradeCount;
	}

	public void setProdutctTradeCount(int produtctTradeCount) {
		this.produtctTradeCount = produtctTradeCount;
	}
	
	
	
	
	
}
