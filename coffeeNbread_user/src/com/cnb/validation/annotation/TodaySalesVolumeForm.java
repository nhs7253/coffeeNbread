package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/*
 * 최민희
 * 2017-07-09
 * 생성
 */
public class TodaySalesVolumeForm implements Serializable {

	private String storeId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date todayDate;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Date getTodayDate() {
		return todayDate;
	}

	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}
}
