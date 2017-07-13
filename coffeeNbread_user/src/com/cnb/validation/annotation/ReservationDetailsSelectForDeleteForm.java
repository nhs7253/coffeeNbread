package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.List;

import com.cnb.vo.ReservationDetails;

/*
 * 최민희
 * 2017-07-12
 * 생성, 초기 구현
 */
public class ReservationDetailsSelectForDeleteForm implements Serializable {
	
	private String userId;
	/*
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date reservationTime;
	*/
	
	private List<String> reservationNoList;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
/*
	public Date getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}

	*/

	public List<String> getReservationNoList() {
		return reservationNoList;
	}

	public void setReservationNoList(List<String> reservationNoList) {
		this.reservationNoList = reservationNoList;
	}

}
