package com.cnb.service;

import java.util.HashMap;

import com.cnb.exception.DuplicatedProudctIdOrProductNameException;
import com.cnb.exception.ProductNotFoundException;
import com.cnb.vo.Product;

/*
 * 최민희
 * 2017-06-30
 * 수정
 */
public interface ProductService {
	/**
	 * 1개의 매장에 1개의 제품 정보 추가
	 * @param product
	 * @throws DuplicatedIdException 한 매장에 등록하려는 제품 아이디나 이름이 이미 등록되 있는 경우 발생
	 */
	int addProduct(Product product) throws DuplicatedProudctIdOrProductNameException;
	
	/**
	 * 1개의 매장에 있는 1개의 제품 정보 수정
	 * @param product
	 * @throws ProductNotFoundException 수정할 제품이 등록되 있지 않은 경우 발생
	 */
	int modifyProduct(Product product) throws ProductNotFoundException;
	
	/**
	 * 제품 종류로 1개의 매장에 있는 제품 정보들 찾기
	 * @param storeId, productCategory
	 */
	HashMap<String, Object> findProductListByCategory(int page, String storeId, String productCategory);
	
	/**
	 * 제품 이름으로 1개의 매장에 있는 제품 정보 찾기
	 * @param storeId, productName
	 */
	Product findProductByName(String storeId, String productName);
	
	/**
	 * 제품 아이디로 1개의 매장에 있는 제품 정보 찾기
	 * @param storeId, productId
	 */
	Product findProductById(String storeId, String productId);

	/**
	 * 판매여부 1개의 매장에 있는 제품 정보들 select
	 * @param storeId, sellingOption
	 * @return 조회된 제품 정보들
	 */
	HashMap<String, Object> findProductListBySellingOption(int page, String storeId, String sellingOption);
	
	
	/**
	 * 1개의 매장에 있는 제품 정보들 찾기
	 * @param storeId
	 */
	HashMap<String, Object> findProductList(int page, String storeId);
}
