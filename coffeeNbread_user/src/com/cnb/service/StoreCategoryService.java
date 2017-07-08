package com.cnb.service;

import java.util.List;

import com.cnb.exception.DuplicatedStoreCategorytNameException;
import com.cnb.vo.Product;
import com.cnb.vo.StoreCategory;

/*
 * 이진영
 * 2017-07-01
 * 생성
 */
public interface StoreCategoryService {
	/**
	 * 1개의 매장에 1개의 매장카테고리 정보 추가
	 * @param StoreCategory
	 * @return 처리 개수
	 */
	void addStoreCategory(List<StoreCategory> storeCategoryList) throws DuplicatedStoreCategorytNameException;
	
	/**
	 * 1개의 매장에 있는 1개의 매장 카테고리 수정
	 * @param storeCategory
	 * @return 처리 개수
	 */
	void modifyStoreCategory(List<StoreCategory> storeCategory);
	
	/**
	 * 1개의 매장에 있는 1개의 제품 정보 삭제
	 * @param storeCategoryNo
	 * @return 처리 개수
	 */
	int removeStoreCategoryByNo(String storeId,int storeCategoryNo);
	
	int removeStoreCategoryById(String storeId);
	
}
