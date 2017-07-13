package com.cnb.dao;

import java.util.List;

import com.cnb.vo.Store;

/*
 * 노현식
 * 2017-07-09 
 * 페이징 관련 메서드 추가
 * 
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
	 
	 /* 매장목록을 페이징 하여, 그 범위 만큼 내용을 반환  (paging) - content
	 * @param select 검색 종류 - 매장 이름(storeName), 매장 소개(storeIntro), 매장 주소(storeAddress), 카테고리(storeCategory)
	 * @param keyword 검색할 키워드
	 * @param startIndex 시작 컬럼 번호
	 * @param endIndex 끝 컬럼 번호
	 * @return 지정한 수만큼의 페이징한 결과
	 */
	 List<Store> selectStoreBySelectAndKeywordPagingList(String select, String keyword, int startIndex, int endIndex);
	 
	/**
	* 매장목록을 페이징 하여, 매장목록 페이징을 위한 검색 결과 개수를 리턴 (paging) - count
	* @param select 검색 종류 - 매장 이름(storeName), 매장 소개(storeIntro), 매장 주소(storeAddress), 카테고리(storeCategory)
	* @param keyword 검색할 키워드
	* @return int 검색 결과 개수
	*/
	int selectStoreBySelectAndKeywordPagingCount(String select, String keyword);
	
	/**
	 * 해당 아이디로 매장과 그 사진을 반환
	 * @param storeId 찾을 매장 ID
	 * @return 사진과 해당 매장 객체
	 */
	Store selectStroeJoinPicture(String storeId);
	
	/**
	 * 매장 허가 여부 변경 기능을 제공
	 * @param storeId 여부를 변경할 매장 ID
	 * @param storePermission 변경 여부 사항
	 * @return int 처리 개수
	 */
	int updateStorePermission(String storeId, String storePermission);
	
}
