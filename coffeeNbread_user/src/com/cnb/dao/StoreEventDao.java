package com.cnb.dao;

import java.util.List;

import com.cnb.vo.StoreEvent;

public interface StoreEventDao {


	int insertStoreEvent(StoreEvent storeEvent);
	
	int updateStoreEvent(StoreEvent storeEvent);
	
	int deleteStoreEvent(int eventNo);
	
	List<StoreEvent> selectStoreEventList(String storeId);
}
