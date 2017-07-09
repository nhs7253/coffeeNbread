package com.cnb.service;

import java.util.List;

import com.cnb.exception.DuplicatedOptionCategoryNameException;
import com.cnb.vo.OptionCategory;

public interface OptionCategoryService {

	/**
	 * 1개의 매장에 1개의 옵션카테고리 정보 추가
	 * @param optionCategory
	 * @throws DuplicatedIdException 한 매장에 등록하려는 옵션카테고리가 이미 등록되 있는 경우 발생
	 */
	 void addOptionCategory(List<OptionCategory> optionCategoryList) throws DuplicatedOptionCategoryNameException;	
	
	 /**
	 * 1개의 매장에 있는 1개의 옵션카테고리 정보 수정
	 * @param optionCategory
	 */
	 void modifyOptionCategory(List<OptionCategory> optionCategoryList);
	
	 /**
	* 1개의 매장에 있는 1개의 옵션카테고리 정보 삭제
	* @param storeId optionId
		 */
	 int removeOptionCategory(String storeId,int optionId);
	 
	 int removeOptionCategoryByStoreId(String storeId);
	 List<OptionCategory> findOptionCategoryList(String storeId);
	 
	 String findOptionCategoryByOptionId(int optionId);
}
