package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
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
public class ReservationDetails implements Serializable {
	private int reservationNo;	//PRIMARY KEY //예약 넘버
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date reservationTime; //예약시간
	private int reservationCount;  //예약개수
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date reservationConfirm; //예약 확인여부
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date productHopeTime; //예약 원하는 수령희망시간.
	
	/*********************************************************************
	 * 부모 테이블 : ReservationDetails, 자식 테이블 : GeneralUser
	 * 1개의 예약 정보는 한 명의 사용자에 소속되어있다.
	 * 예약자 정보를 저장할 Instance 변수를 선언해야 한다.
	 *********************************************************************/
	private String userId;		//FORIEGN KEY
	private GeneralUser generalUser;
	
	/*********************************************************************
	 * 부모 테이블 : ReservationDetails, 자식 테이블 : Product
 	 * 1개의 예약 정보에 여러개의 제품들이 포함된다.
	 * 제품들 정보를 저장할 Instance 변수를 선언해야 한다.
	 *********************************************************************/
	private String productId;	//FORIEGN KEY
	private List<Product> productList;
	
	/*********************************************************************
	 * 부모 테이블 : ReservationDetails, 자식 테이블 : Store 
	 * 1개의 예약 정보는 한 매장에 소속되어있다.
	 * 매장 정보를 저장할 Instance 변수를 선언해야 한다.
	 *********************************************************************/
	private String storeId;		//FORIEGN KEY
	private Store store;
	
	public ReservationDetails() {
		super();
	}

	
	
	
	public ReservationDetails(int reservationNo, Date reservationTime, int reservationCount, Date reservationConfirm,
			Date productHopeTime, String userId, String productId, String storeId) {
		super();
		this.reservationNo = reservationNo;
		this.reservationTime = reservationTime;
		this.reservationCount = reservationCount;
		this.reservationConfirm = reservationConfirm;
		this.productHopeTime = productHopeTime;
		this.userId = userId;
		this.productId = productId;
		this.storeId = storeId;
	}






	public ReservationDetails(int reservationNo, Date reservationTime, int reservationCount, Date reservationConfirm,
			Date productHopeTime, String userId, GeneralUser generalUser, String productId, List<Product> productList,
			String storeId, Store store) {
		super();
		this.reservationNo = reservationNo;
		this.reservationTime = reservationTime;
		this.reservationCount = reservationCount;
		this.reservationConfirm = reservationConfirm;
		this.productHopeTime = productHopeTime;
		this.userId = userId;
		this.generalUser = generalUser;
		this.productId = productId;
		this.productList = productList;
		this.storeId = storeId;
		this.store = store;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ReservationDetails [reservationNo=" + reservationNo + ", reservationTime=" + reservationTime
				+ ", reservationCount=" + reservationCount + ", reservationConfirm=" + reservationConfirm
				+ ", productHopeTime=" + productHopeTime + ", userId=" + userId + ", generalUser=" + generalUser
				+ ", productId=" + productId + ", productList=" + productList + ", storeId=" + storeId + ", store="
				+ store + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productHopeTime == null) ? 0 : productHopeTime.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((reservationConfirm == null) ? 0 : reservationConfirm.hashCode());
		result = prime * result + reservationCount;
		result = prime * result + reservationNo;
		result = prime * result + ((reservationTime == null) ? 0 : reservationTime.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
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
		ReservationDetails other = (ReservationDetails) obj;
		if (productHopeTime == null) {
			if (other.productHopeTime != null)
				return false;
		} else if (!productHopeTime.equals(other.productHopeTime))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (reservationConfirm == null) {
			if (other.reservationConfirm != null)
				return false;
		} else if (!reservationConfirm.equals(other.reservationConfirm))
			return false;
		if (reservationCount != other.reservationCount)
			return false;
		if (reservationNo != other.reservationNo)
			return false;
		if (reservationTime == null) {
			if (other.reservationTime != null)
				return false;
		} else if (!reservationTime.equals(other.reservationTime))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
