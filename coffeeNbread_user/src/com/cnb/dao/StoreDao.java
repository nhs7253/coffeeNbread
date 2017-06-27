package com.cnb.dao;

import com.cnb.vo.Store;

/*
 * 이진영
 * 2017-06-27 생성
 */
public interface StoreDao {

	 int insertStore(Store store);
	 
	 int updateStore(Store store);
	 
	 Store selectStore(String storeId);
}
