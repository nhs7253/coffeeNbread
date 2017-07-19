package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 * 김형주
 * 2017-07-09  vo주석 달기- 확인차
 * 
 */


/*
* 김형주
* 2017-06-28 생성
* 
*/
public class PaymentDetails implements Serializable{

	
	private int paymentNo;  //primary key
	private String paymentOption; //지불방식: = 현장에서는 카드, 현금,  예약에서는 - 카드만.
	private Date tradeDate;    //거래날짜 = 예약은 주문날짜 , 현장은 현장거래날짜.
	private String sellMethod;  //판매방식:= 예약: r , 현장: f
	private int reservationOrderCount;  //예약개수
	private String userId;     // 유저  -Foreign key
	private String productId; //제품 - foreign key
 	private String storeId;   //매장 -foreign key
	private int productTradeCount;
	
	private Product product;  //제품과 조인하기위해 
    private Store store;  //매장과 조인하기위해.
    
    private PaymentOptionList paymentOptionList;
    
    
    
	public PaymentDetails(int paymentNo, String paymentOption, Date tradeDate, String sellMethod,
			int reservationOrderCount, String userId, String productId, String storeId, int productTradeCount) {
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
			Product product, Store store) {
		this.paymentNo = paymentNo;
		this.paymentOption = paymentOption;
		this.tradeDate = tradeDate;
		this.sellMethod = sellMethod;
		this.reservationOrderCount = reservationOrderCount;
		this.userId = userId;
		this.productId = productId;
		this.storeId = storeId;
		this.productTradeCount = productTradeCount;
		this.product = product;
		this.store = store;
	}
	public PaymentDetails() {
	}
	
	/**
	 * 사용 추천
	 * @param paymentOption
	 * @param tradeDate
	 * @param sellMethod
	 * @param reservationOrderCount
	 * @param userId
	 * @param productId
	 * @param storeId
	 * @param productTradeCount
	 */
	public PaymentDetails(String paymentOption, Date tradeDate, String sellMethod, int reservationOrderCount,
			String userId, String productId, String storeId, int productTradeCount) {
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
			Product product, Store store, PaymentOptionList paymentOptionList) {
		this.paymentNo = paymentNo;
		this.paymentOption = paymentOption;
		this.tradeDate = tradeDate;
		this.sellMethod = sellMethod;
		this.reservationOrderCount = reservationOrderCount;
		this.userId = userId;
		this.productId = productId;
		this.storeId = storeId;
		this.productTradeCount = productTradeCount;
		this.product = product;
		this.store = store;
		this.paymentOptionList = paymentOptionList;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	
	
	public PaymentOptionList getPaymentOptionList() {
		return paymentOptionList;
	}
	public void setPaymentOptionList(PaymentOptionList paymentOptionList) {
		this.paymentOptionList = paymentOptionList;
	}
	@Override
	public String toString() {
		return "PaymentDetails [paymentNo=" + paymentNo + ", paymentOption=" + paymentOption + ", tradeDate="
				+ tradeDate + ", sellMethod=" + sellMethod + ", reservationOrderCount=" + reservationOrderCount
				+ ", userId=" + userId + ", productId=" + productId + ", storeId=" + storeId + ", productTradeCount="
				+ productTradeCount + ", product=" + product + ", store=" + store + ", paymentOptionList="
				+ paymentOptionList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + paymentNo;
		result = prime * result + ((paymentOption == null) ? 0 : paymentOption.hashCode());
		result = prime * result + ((paymentOptionList == null) ? 0 : paymentOptionList.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + productTradeCount;
		result = prime * result + reservationOrderCount;
		result = prime * result + ((sellMethod == null) ? 0 : sellMethod.hashCode());
		result = prime * result + ((store == null) ? 0 : store.hashCode());
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
		if (paymentOptionList == null) {
			if (other.paymentOptionList != null)
				return false;
		} else if (!paymentOptionList.equals(other.paymentOptionList))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
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
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
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
	
	
	
	
}