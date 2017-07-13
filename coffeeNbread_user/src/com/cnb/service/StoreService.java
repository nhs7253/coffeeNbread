package com.cnb.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;

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
	 void addStore(Store store,List<OptionCategory> optionCategory,StorePicture storePicture, String userId, List<String> paymentIdList) throws DuplicatedStoreIdException, DuplicatedOptionCategoryNameException, DuplicatedStoreCategorytNameException, DuplicatedStorePictureException;
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
	int removeStoretById(String storeId, String userId);
	
	
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
	 * 유저가 입력한 키워드를 통해 조회한 매장목록을 페이징하여 보여주는 Service
	 * @param select 검색 종류 - 매장 이름(storeName), 매장 소개(storeIntro), 매장 주소(storeAddress), 카테고리(storeCategory)
	 * @param keyword 검색할 키워드
	 * @param page 보려는 페이지 번호
	 * @return Map<String, Object> 페이징을 위한 정보 결과
	 */
	 Map<String, Object> findStorePagingList(String select, String keyword, int page);
	 
	 /**
	  * 매장의 세부 정보를 반환하는 서비스, 동시에 매장 방문 수와, 방문 내역을 1 증가 시킴
	  * @param storeId 방문할 매장 ID
	  * @param authentication 유저 로그인 정보
	  * @return Store 방문할 매장 객체
	  */
	 Store viewStore(String storeId, Authentication authentication);
	 
}
