package com.cnb.dao;

import java.util.Date;
import java.util.List;

import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ShoppingBasketProduct;

/*
 * 김형주
 * 2017-06-28
 * 초기 구현
 * 
 * 김형주
 * 2017-06-28 
 * 생성
 */
/**
 *payment_details 테이블을 관리하는 Dao 인터페이스
 */

/*
 * payment_option (결제수단) ->  카드: c  , 현금 :p
 * sell_method(판매방법) -> 예약: r, 현장 :f
 * 
 * ==> 웹에서는 예약뿐이므로  sell_method에 r로만 해놨고, 
 *                                   payment_option에 카드 c로만 넣어놨습니다.
 */


public interface PaymentDetailsDao {
	
	
	/**
	 * ShoppingBasket에 있는걸 조회한다음 바로 결제내역 테이블에 삽입.
	 * @param paymentDetails
	 * @return
	 */
	int insertPaymentDetails(PaymentDetails paymentDetails);
	
  
	
	
	/**
	 * 결제내역 조회. (유저가 그 매장에서 결제했을때 그 순간 내역) - 
	 *   - 개발자 확인용.(유저는 이걸 확인할이유는 없다)
	 */
	
	List<PaymentDetails>selectPaymentDetailsListByUserIdAndStoreId(String userId,String storeId);
		
		
		
	List<ShoppingBasketProduct> selectAllProductPriceByUserIdAndStoreId(String userId, String storeId);
	
	
	
	PaymentDetails selectPaymentDetailsByStoreIdAndProductId(String storeId,String productId);
	
	/**
	 * 유저아이디로 결제내역테이블에 넣은 목록들 조회.
	 * @param userId
	 * @return
	 */
	List<PaymentDetails> selectPaymentDetailsListByUserId(String userId);
	
	
	
	/**
	 * 결제내역테이블에 거래 시간을 통해 같은시간에 결제한 제품들 모두 가져옴.
	 * @param tradeDate
	 * @return
	 */
     List<PaymentDetails> selectPaymentDetailsListByTradeDate(Date tradeDate);
    	
    
	
	
	

}
