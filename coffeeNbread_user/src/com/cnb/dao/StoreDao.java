package com.cnb.dao;

import java.util.List;

import com.cnb.vo.Store;

/*
 * 이진영
 * 2017-06-28 수정 조인 메소드 추가
 * 
 * 이진영
 * 2017-06-27 생성
 */
public interface StoreDao {

	 int insertStore(Store store);
	 
	 int updateStore(Store store);
	 
	 List<Store> selectStore(String storeId);
	 
	 List<Store> selectStoreEventList(String storeId);
}
