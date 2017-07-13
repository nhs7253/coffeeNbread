package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * 최민희
 * 2017-07-11
 * 생성
 */
public class FindReservationDetailsForm implements Serializable {
	
	@NotNull
	private int page = 1;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date reservationConfirm;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Date getReservationConfirm() {
		return reservationConfirm;
	}

	public void setReservationConfirm(Date reservationConfirm) {
		this.reservationConfirm = reservationConfirm;
	}
}
