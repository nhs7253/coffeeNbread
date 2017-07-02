package com.cnb.service;

import java.util.List;

import com.cnb.exception.EmptyShoppingBasketProductListByProductNameException;
import com.cnb.exception.EmptyShoppingBasketProductListException;
import com.cnb.exception.NoUpdateShoppingBasketProductException;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ShoppingBasketProduct;

/*
 * 김형주
 * 2017-07-02
 * 생성
 */
public interface PaymentDetailsService {

	
	
	/**
	 * 결제목록 목록 리스트로 조회 -유저아이디와 매장아이디로 장바구니 목록 리스트 조회
	 * @param userId
	 * @return
	 */
	List<PaymentDetails> findPaymentDetailsListByStoreIdAndUserId(String storeId,String userId);
	
  /**
   * 유저아이디와 해당 매장아이디로 조회한 장바구니 물품들 다 결제내역테이블에 등록.	
   * @param shoppingBasketProduct
   */
	 void addPaymentDetails(List<ShoppingBasketProduct> shoppingBasketProduct);
		
	 
	 
	 /**
	  * 장바구니에 담긴 목록을 조회한 다음 제품아이디를 통해 모든 가격 보여줄떄 필요.
	  * @param shoppingBasketProduct
	  * @return
	  */
      int findAllProductPrice(List<ShoppingBasketProduct> shoppingBasketProduct);
}
