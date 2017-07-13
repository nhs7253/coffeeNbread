package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.cnb.vo.Product;

public class ReservationDetailsViewForm implements Serializable {
	
	

	@NotNull
	private int page = 1;

	@Override
	public String toString() {
		return "ReservationDetailsViewForm [page=" + page + "]";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}


	
	

	

	
	
}
