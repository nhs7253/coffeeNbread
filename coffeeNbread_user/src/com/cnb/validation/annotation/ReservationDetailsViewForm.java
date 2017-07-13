package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.cnb.vo.Product;

public class ReservationDetailsViewForm implements Serializable {
	
	

	@NotNull
	private int page = 1;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "RecipeBoardContentsViewForm [page=" + page + "]";
	}
	

	
	
}
