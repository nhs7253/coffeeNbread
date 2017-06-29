package com.cnb.dao;

import java.util.List;

import com.cnb.vo.EventProduct;

/*
 * 최민희
 * 2017-06-29
 * 생성
 */
/**
 * EventProductDao 테이블을 관리하는 Dao 인터페이스
 * @author minhee
 *
 */
public interface EventProductDao {
	/**
	 * 1개의 이벤트 제품 정보 insert
	 * @param eventProduct
	 * @return 처리 개수
	 */
	int insertEventProduct(EventProduct eventProduct);
	
	/**
	 * 1개의 이벤트 제품 정보 update
	 * @param eventProduct
	 * @return 처리 개수
	 */
	int updateEventProduct(EventProduct eventProduct);
	
	/**
	 * 1개의 이벤트 제품 정보 delete
	 * @param eventProduct
	 * @return 처리 개수
	 */
	int deleteEventProduct(EventProduct eventProduct);
	
	/**
	 * 1개의 이벤트에 해당되는 이벤트 제품 select
	 * @param eventNo
	 * @return 조회된 제품 사진 정보들
	 */
	List<EventProduct> selectEventProductListByEventNo(String eventNo);
	
}
