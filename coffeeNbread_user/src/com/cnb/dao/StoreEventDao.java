package com.cnb.dao;

import java.util.List;

import com.cnb.vo.StoreEvent;

/*
 * 이진영
 * 2017-06-28 생성
 */
/**
 * StoreEvent 테이블을 관리하는 Dao 인터페이스
 * @author jinyoung
 *
 */
public interface StoreEventDao {

	/**
	 * 1개의 매장이벤트 정보 insert
	 * @param StoreEvent
	 * @return 처리 개수
	 */
	int insertStoreEvent(StoreEvent storeEvent);
	
	/**
	 * 1개의 매장이벤트 정보 update
	 * @param StoreEvent
	 * @return 처리 개수
	 */
	int updateStoreEvent(StoreEvent storeEvent);
	
	/**
	 * 1개의 매장이벤트 정보 delete
	 * @param eventNo
	 * @return 처리 개수
	 */
	int deleteStoreEvent(int eventNo);
	
	/**
	 * 매장이벤트들 정보 select
	 * @param storeId
	 * @return 처리 개수
	 */
	List<StoreEvent> selectStoreEventList(String storeId);
}
