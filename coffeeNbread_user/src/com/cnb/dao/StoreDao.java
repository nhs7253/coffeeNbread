package com.cnb.dao;

import java.util.List;

import com.cnb.vo.Store;
import com.cnb.vo.StorePicture;

/*
 * 이진영
 * 2017-06-27 생성
 */
public interface StoreDao {

	 int insertStore(Store store);
	 
	 int updateStore(Store store);
	 
	 List<Store> selectStore(String storeId);
	 List<Store> selectStoreEventList(String storeId);
	 Store selectStoreCategory(String storeId);
}
