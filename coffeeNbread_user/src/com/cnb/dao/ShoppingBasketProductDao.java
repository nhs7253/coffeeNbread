package com.cnb.dao;

import java.util.ArrayList;

import com.cnb.vo.Product;

/*
 * 노현식
 * 2017-06-23 생성
 */


public interface ShoppingBasketProductDao {

	/**
	 * 장바구니 목록 조회
	 * 
	 */
	
	Product selectProductByProductId (String productId);
	
	/**
	 * 장바구니 목록 삭제
	 */
	
	int deleteProductByProductId(String productId);
	
	
     
	
	
	
}
