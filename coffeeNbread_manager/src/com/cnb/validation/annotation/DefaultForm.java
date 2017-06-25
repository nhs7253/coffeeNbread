package com.cnb.validation.annotation;

import org.hibernate.validator.constraints.NotEmpty;

/*
 * 노현식 
 * 2017-06-26 생성
 * 초기 구현
 */
/**
 * git용 Default 파일
 */
public class DefaultForm {
	
	@NotEmpty
	private String defaultData;

	public String getDefaultData() {
		return defaultData;
	}

	public void setDefaultData(String defaultData) {
		this.defaultData = defaultData;
	}

}
