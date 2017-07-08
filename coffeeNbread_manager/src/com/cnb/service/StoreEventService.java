package com.cnb.service;

import java.util.List;

import com.cnb.vo.EventProduct;
import com.cnb.vo.StoreEvent;

/*
 * 이진영
 * 2017-7-03
 * 생성
 */
public interface StoreEventService {
	
	/**
	 * 1개의 매장이벤트 추가
	 * @param storeEvent,eventProduct
	 * @return
	 */
	int addStoreEvent(StoreEvent storeEvent,EventProduct eventProduct);
	
	/**
	 * 1개의 매장 이벤트 수정
	 * @param storeEvent  eventProductAfter eventProductBefore
	 * @return
	 */
	int modifyStoreEvent(StoreEvent storeEvent, EventProduct eventProductAfter,EventProduct eventProductBefore);
	
	/**
	 * 매장 이벤트 목록 조회
	 * @param storeId
	 * @return
	 */
	List<StoreEvent>findStoreEventList(String storeId);
}
