package com.cnb.dao;

import java.util.List;
import java.util.Map;

import com.cnb.vo.PaymentDetails;

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
 * 제품별 결제내역
 * @param paymentDetails
 * @return
 */
	
	int insertPaymentDetails(PaymentDetails paymentDetails);
	
  
  
	/**
	 * 결제자가 매장아이디와 매장
	 * @param userId
	 * @param storeId
	 * @return
	 */
	List<PaymentDetails> selectPaymentDetailsByUserIdAndStoreIdAndProductId(String userId,String storeId,String productId);
	


	
	

}
