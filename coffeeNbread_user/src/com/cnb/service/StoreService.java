package com.cnb.service;

import java.util.List;

import com.cnb.exception.DuplicatedOptionCategoryNameException;
import com.cnb.exception.DuplicatedStoreCategorytNameException;
import com.cnb.exception.DuplicatedStoreIdException;

import com.cnb.exception.DuplicatedStorePictureException;
import com.cnb.exception.StorePictureNotFoundException;
import com.cnb.vo.OptionCategory;
import com.cnb.vo.Product;
import com.cnb.vo.Store;
import com.cnb.vo.StoreCategory;
import com.cnb.vo.StorePicture;

/*
 * 이진영
 * 2017-06-30
 * 생성
 */
public interface StoreService {
	/**
	 * 1개의 매장 추가
	 * @param Store
	 * @return 
	 * 
	 * @throws DuplicatedStoreIdException 
	 * @throws DuplicatedStoreCategorytNameException 
	 * @throws DuplicatedStorePictureException 
	 */
	 void addStore(Store store,List<OptionCategory> optionCategory,StorePicture storePicture) throws DuplicatedStoreIdException, DuplicatedOptionCategoryNameException, DuplicatedStoreCategorytNameException, DuplicatedStorePictureException;
	/**
	 * 매장수정
	 * @param store
	 * @throws DuplicatedStoreIdException 
	 * @throws StorePictureNotFoundException 
	 *
	 */
	void modifyStore(Store store,List<OptionCategory> optionCategory,List<StorePicture> storePicture) throws DuplicatedStoreIdException, StorePictureNotFoundException;
	
	/**
	 * 매장삭제
	 * @param storeId
	 * 
	 */
	int removeStoretById(String storeId);
	
	
	/**
	 * 매장 조회
	 * @param storeId
	 * @return 조회된 매장 정보
	 */
	Store findStoreById(String storeId);
	
	
	/**
	 * 매장사진 조회
	 * @param storeId
	 * @return 조회된 매장사진 정보
	 */
	 List<Store> findStorePicture(String storeId);
	
	 
	 /**
		 * 여러개의 매장이벤트 정보 select
		 * @param storeId
		 * @return list
		 */
	 List<Store> findStoreEventList(String storeId);
	
	 /**
		 * 여러개의 매장카테고리 정보 select
		 * @param storeId
		 * @return list
		 */
	 List<Store> findStoreCategoryList(String storeId);
	 
	 
	 /**
		 * 매장정보옵션 종류 상세 select
		 * @param storeId
		 * @return list
		 */
	 List<Store> findOpionCategoryNDetailByIdList(String storeId);

	 
	 /**
		 * 모든 매장 아이디 select
		 * @param 
		 * @return list
		 */
	 List<String> findAllStoreIdList(); 
}
