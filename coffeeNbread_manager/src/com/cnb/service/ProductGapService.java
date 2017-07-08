package com.cnb.service;

import java.util.HashMap;

import com.cnb.vo.ProductGap;

/*
 * 최민희
 * 2017-07-03
 * 생성
 */
public interface ProductGapService {
	/**
	 * 1개의 제품 증감폭 insert
	 * @param productGap
	 */
	int addProductGap(ProductGap productGap);
	
	/**
	 * 1개의 제품의 제품증감폭 update 
	 * - 제품의 증감폭에 변화가 있을 시 매장아이디, 제품아이디는 그대로이기 때문에 굳이 이전 제품 증감폭 정보를 가져오지 않아도 됨
	 * @param productGap
	 */
	int modifyProductGap(ProductGap productGap);
	
	/**
	 * 제품 증감폭들 select
	 * 모든 제품 증감폭과 해당 제품 정보들을 조회한다.
	 * @param storeId
	 */
	HashMap<String, Object> findProductGapListByStoreId(int page, String storeId);
	
	/**
	 * 증감 식별코드로 해당 제품 정보들 select
	 * 제품 증감폭과 해당 제품 정보들을 조회한다.
	 * @param storeId, identifyCode
	 */
	HashMap<String, Object> findProductGapListByIdentifyCodeByStoreIdAndIdentifyCode(int page, String storeId, String identifyCode);
	
}
