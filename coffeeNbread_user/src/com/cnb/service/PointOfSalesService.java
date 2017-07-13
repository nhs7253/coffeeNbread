package com.cnb.service;

import java.util.List;

import com.cnb.vo.Product;

/*
 * 노현식
 * 2017-07-11
 * 생성, 초기 구현
 */
/**
 * POS(Point of sales, 판매시점 정보관리)
 */
public interface PointOfSalesService {
	
	/**
	 * POS에서 사용할 해당 매장의 제품 목록을 제공하는 서비스
	 * @param storeId 제품들을 가진 매장 ID
	 * @param select - productName(제품 이름), productCategory(제품 종류) 
	 * @param keyword 검색할 내용
	 * @return List<Product> 검색된 제품과 제품 사진 목록들
	 */
	List<Product> findProductListToPOSService(String storeId, String select, String keyword);
	
}
