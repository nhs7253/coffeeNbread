package com.cnb.service;

import java.util.List;

import com.cnb.vo.Product;

/*
 * 최민희
 * 2017-06-27
 * 생성
 */
public interface ProductService {
	/**
	 * 1개의 매장에 1개의 제품 정보 추가
	 * @param product
	 * @return 처리 개수
	 */
	int registerProduct(String storeId, Product product);
	
	/**
	 * 1개의 매장에 있는 1개의 제품 정보 수정
	 * @param product
	 * @return 처리 개수
	 */
	int modifyProduct(String storeId, Product product);
	
	/**
	 * 1개의 매장에 있는 1개의 제품 정보 삭제
	 * @param productId
	 * @return 처리 개수
	 */
	int removeProductById(String storeId, String productId);
	
	/**
	 * 제품 종류로 1개의 매장에 있는 제품 정보들 찾기
	 * @param productCategory
	 * @return 조회된 제품 정보들
	 */
	List<Product> searchProductByCategory(String storeId, String productCategory);
	
	/**
	 * 제품 이름으로 1개의 매장에 있는 제품 정보 찾기
	 * @param productName
	 * @return 조회된 제품 정보
	 */
	Product searchProductByName(String storeId, String productName);
}
