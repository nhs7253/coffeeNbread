package com.cnb.service;

import com.cnb.exception.DuplicatedOptionCategoryNameException;

import com.cnb.vo.OptionCategory;

public interface OptionCategoryService {

	/**
	 * 1개의 매장에 1개의 옵션카테고리 정보 추가
	 * @param optionCategory
	 * @throws DuplicatedIdException 한 매장에 등록하려는 옵션카테고리가 이미 등록되 있는 경우 발생
	 */
	 int addOptionCategory(OptionCategory optionCategory) throws DuplicatedOptionCategoryNameException;	
	
	 /**
	 * 1개의 매장에 있는 1개의 옵션카테고리 정보 수정
	 * @param optionCategory
	 */
	 int modifyOptionCategory(OptionCategory optionCategory);
	
	 /**
	* 1개의 매장에 있는 1개의 옵션카테고리 정보 삭제
	* @param storeId optionId
		 */
	 int removeOptionCategory(String storeId,int optionId);
}
