package com.cnb.dao;

import java.util.List;

import com.cnb.vo.Store;

/*
 * 이진영
 * 2017-06-30 추가
 * 
 * 이진영
 * 2017-06-27 생성
 */
/**
 * Store테이블을 관리하는 Dao 인터페이스
 * @author jinyoung
 *
 */
public interface StoreDao {
	
	/**
	 * 1개의 매장 정보 insert
	 * @param Store
	 * @return 처리 개수
	 */
	 int insertStore(Store store);
	 
	 /**
		 * 1개의 매장 정보 update
		 * @param Store
		 * @return 처리 개수
		 */
	 int updateStore(Store store);
	 
	 /**
		 * 매장사진 정보 select
		 * @param storeId
		 * @return list
		 */
	 List<Store> selectStorePicture(String storeId);
	 
	 /**
		 * 여러개의 매장이벤트 정보 select
		 * @param storeId
		 * @return list
		 */
	 List<Store> selectStoreEventList(String storeId);
	
	 /**
		 * 여러개의 매장카테고리 정보 select
		 * @param storeId
		 * @return list
		 */
	 List<Store> selectStoreCategoryList(String storeId);
	 
	 /**
		 * 매장 정보 delete
		 * @param storeId
		 * @return int
		 */
	 int deleteStoreById(String storeId);
	 
	 /**
		 * 매장정보 select
		 * @param storeId
		 * @return store
		 */
	 Store selectStoreById(String storeId);
	 
	 
	 /**
		 * 매장정보옵션 종류 상세 select
		 * @param storeId
		 * @return list
		 */
	 List<Store> selectOpionCategoryNDetailByIdList(String storeId);
	 
	 /**
		 * 모든 매장 아이디 select
		 * @param 
		 * @return list
		 */
	 List<String> selectAllStoreIdList(); 
}
