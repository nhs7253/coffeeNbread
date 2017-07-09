package com.cnb.validation.annotation;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/*
 * 최민희
 * 2017-07-07
 * 생성
 */
public class ProductFindByMethodForm {
	
	@NotEmpty
	private String method = "productCategory";
	
	private String methodContent = null;

	@NotNull
	private int page = 1;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMethodContent() {
		return methodContent;
	}

	public void setMethodContent(String methodContent) {
		this.methodContent = methodContent;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
