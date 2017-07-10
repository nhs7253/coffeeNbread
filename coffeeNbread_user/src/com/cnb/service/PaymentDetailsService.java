package com.cnb.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.cnb.exception.NullShoppingBasketProductException;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ShoppingBasketProduct;

/*
 * 최민희
 * 2017-07-03
 * 추가
 */
/*
 * 김형주
 * 2017-07-02
 * 생성
 */
public interface PaymentDetailsService {
	

	
	
	
	
	/**
	 * 유저아이디와 해당 매장아이디로 조회한 장바구니 물품들 다 결제내역테이블에 등록.
	 * 
	 * @param shoppingBasketProduct
	 */
	void addPaymentDetails(List<ShoppingBasketProduct> shoppingBasketProduct) throws NullShoppingBasketProductException;

	/**
	 * 장바구니에 담긴 목록을 조회한 다음 제품아이디를 통해 모든 가격 보여줄떄 필요.
	 * 
	 * @param shoppingBasketProduct
	 */
	int findAllProductPrice(List<ShoppingBasketProduct> shoppingBasketProduct);

	HashMap<String, Object> findPaymentDetailsListByStoreIdAndUserId(int page, String storeId,
			String userId);
	
	
	
/*----------------------------------------------------------매장 -------------------------------------------------*/	
	
	
	
	/**
	 * 한 매장의 특정 제품의 결제 내역 조회 - 판매량에 사용
	 * @param storeId, productId
	 */
	List<PaymentDetails> findPaymentDetailsListByStoreIdAndProductId(String storeId, String productId);

	/**
	 * 한 매장의 결제 날짜에 따른 결제 내역 조회 - 판매량에 사용
	 * @param storeId, tradeDate
	 */
	List<PaymentDetails> findPaymentDetailsListByStoreIdAndTradeDate(String storeId, Date tradeDate);
	

	/**
	 * 한 매장의 특정 제품의 현장 결제 내역 조회 - 판매시스템(포스)에 사용
	 * @param storeId, productId, sellMethod
	 */
	List<PaymentDetails> findPaymentDetailsListByStoreIdAndProductIdAndSellMethod(String storeId, String productId, String sellMethod);
	

}
