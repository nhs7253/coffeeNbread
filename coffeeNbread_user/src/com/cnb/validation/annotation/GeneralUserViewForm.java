package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/*
 * 노현식
 * 2017-07-03
 * 생성, 초기 구현
 */
public class GeneralUserViewForm implements Serializable{
	
	@NotEmpty
	private String select;
	@NotEmpty
	private String keyword;
	@NotNull
	private int page;
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
