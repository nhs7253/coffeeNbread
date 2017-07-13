package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cnb.vo.Product;

public class ReservationDetailsForm implements Serializable {
	
	
	
	private int reservationNo;
	
	
	private Date reservationTime;
	
	private int reservationCount;
	
	
	private Date reservationConfirm=null;
	
	 //controller에서 작업.
	private Date productHopeTime;
	
	
	private String userId;
	
	
	private String productId;
	
	
   private String storeId;


@Override
public String toString() {
	return "ReservationDetailsForm [reservationNo=" + reservationNo + ", reservationTime=" + reservationTime
			+ ", reservationCount=" + reservationCount + ", reservationConfirm=" + reservationConfirm
			+ ", productHopeTime=" + productHopeTime + ", userId=" + userId + ", productId=" + productId + ", storeId="
			+ storeId + "]";
}


public int getReservationNo() {
	return reservationNo;
}


public void setReservationNo(int reservationNo) {
	this.reservationNo = reservationNo;
}


public Date getReservationTime() {
	return reservationTime;
}


public void setReservationTime(Date reservationTime) {
	this.reservationTime = reservationTime;
}


public int getReservationCount() {
	return reservationCount;
}


public void setReservationCount(int reservationCount) {
	this.reservationCount = reservationCount;
}


public Date getReservationConfirm() {
	return reservationConfirm;
}


public void setReservationConfirm(Date reservationConfirm) {
	this.reservationConfirm = reservationConfirm;
}


public Date getProductHopeTime() {
	return productHopeTime;
}


public void setProductHopeTime(Date productHopeTime) {
	this.productHopeTime = productHopeTime;
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

	

	
	
}
