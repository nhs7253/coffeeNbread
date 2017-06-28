package com.cnb.dao;

import java.util.ArrayList;

import com.cnb.vo.Product;
import com.cnb.vo.ShoppingBasketProduct;

/*
 *김형주
 * 2017-06-26 생성
 */


public interface ShoppingBasketProductDao {

	/**
	 * 장바구니 목록 조회
	 * 
	 */
	
	 ShoppingBasketProduct selectShoppingBasketProductByProductId (String productId);
	
	/**
	 * 장바구니 목록 삭제
	 */
	
	int deleteProductByProductId(String productId);
	
	
     
	
	
	
}
