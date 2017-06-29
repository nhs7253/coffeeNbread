package com.cnb.dao;

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
	 * @param productPictureVO, productPicture
	 * @return 처리 개수
	 */
	
	
	/**
	 * 1개의 이벤트 제품 정보 delete
	 * @param productPicture
	 * @return 처리 개수
	 */
	
	
	/**
	 * 1개의 매장에 있는 1개의 제품정보로 제품 사진 정보들 select
	 * @param productId, storeId
	 * @return 조회된 제품 사진 정보들
	 */
}
