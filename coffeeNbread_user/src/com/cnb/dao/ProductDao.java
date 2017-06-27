package com.cnb.dao;

import java.util.List;

import com.cnb.vo.Product;

/*
 * 최민희
 * 2017-06-27
 * 생성
 */
/**
 * Product 테이블을 관리하는 Dao 인터페이스
 * @author minhee
 *
 */
public interface ProductDao {
	/**
	 * 1개의 제품 정보 insert
	 * @param product
	 * @return 처리 개수
	 */
	int insertProduct(Product product);
	
	/**
	 * 1개의 제품 정보 update
	 * @param product
	 * @return 처리 개수
	 */
	int updateProduct(Product product);
	
	/**
	 * 1개의 제품 정보 delete
	 * @param productId
	 * @return 처리 개수
	 */
	int deleteProduct(String productId);
	
	/**
	 * 제품 종류로 제품 정보들 select
	 * @param productCategory
	 * @return 조회된 제품 정보들
	 */
	List<Product> selectProductByCategory(String productCategory);
	
	/**
	 * 제품 이름으로 제품 정보 select
	 * @param productName
	 * @return 조회된 제품 정보
	 */
	Product selectProductByName(String productName);
	
	
}
