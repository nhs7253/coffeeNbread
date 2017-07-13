package com.cnb.dao;

import java.util.Date;
import java.util.List;

import com.cnb.vo.PaymentDetails;

/*
 * 최민희
 * 2017-07-04
 * 수정
 */
/*
 * 최민희
 * 2017-07-03
 * 추가
 */
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
 * payment_details 테이블을 관리하는 Dao 인터페이스
 */

/*
 * payment_option (결제수단) -> 카드: c , 현금 :p sell_method(판매방법) -> 예약: r, 현장 :f
 * 
 * ==> 웹에서는 예약뿐이므로 sell_method에 r로만 해놨고, payment_option에 카드 c로만 넣어놨습니다.
 */

public interface PaymentDetailsDao {

	/*-----------------------------------------------------유저 -----------------------------------------------------*/

	/**
	 * ShoppingBasket에 있는걸 조회한다음 바로 결제내역 테이블에 삽입.
	 * 
	 * @param paymentDetails
	 * @return
	 */
	int insertPaymentDetails(PaymentDetails paymentDetails);

	/**
	 * 결제내역 조회. (유저가 그 매장에서 결제했을때 그 순간 내역) -
	 * 
	 */

/*	List<PaymentDetails> selectPaymentDetailsListByUserIdAndStoreId(String userId, String storeId);*/

	/*-------------------------------------------유저 결제내역 조회 페이징 ----------------------------------------*/

    
	/**
	 * 유저가 결제한내역들  count - 매장아이디가 null이라면 매장아이디빼고 
	 * @param userId
	 * @param storeId
	 * @return
	 */
	int countSelectPaymentDetailsByUserIdAndStoreId(String userId, String storeId);

	/**
	 * 유저가 결제한 내역들 조회 - 매장아이디가 null이라면 매장아이디 빼고 조회.
	 * 
	 * @param userId
	 * @param storeId
	 * @param select
	 * @param keyword
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	List<PaymentDetails> selectPaymentDetailsListByUserIdAndStoreId(String userId, String storeId,
			 int startIndex, int endIndex);

/*
 * ------------------------------------------------------매장--------------------------------------------------------
 */

	/**
	 * 한 매장의 특정 제품의 결제 내역 조회 - 판매량에 사용
	 * 
	 * @param storeId,
	 *            productId
	 * @return 조회된 결제 내역
	 */
	List<PaymentDetails> selectPaymentDetailsListByStoreIdAndProductId(String storeId, String productId);

	/**
	 * 한 매장의 결제 날짜에 따른 결제 내역 조회 - 판매량에 사용 (오늘 날짜)
	 * 
	 * @param storeId,
	 *            tradeDate
	 * @return 조회된 결제 내역
	 */
	List<PaymentDetails> selectPaymentDetailsListByStoreIdAndTradeDate(String storeId, Date tradeDate);

	/**
	 * 한 매장의 날짜별에 따른 결제 내역 조회 (1주일, 1개월, 3개월, 6개월, 12개월) - 판매량에 사용
	 * 
	 * @param storeId,
	 *            method
	 * @return 조회된 결제 내역
	 */
	List<PaymentDetails> selectPaymentDetailsListByStoreIdAndMethod(String storeId, String method);

	/**
	 * 한 매장의 날짜별에 따른 결제 내역 조회 - 직접 지정
	 * 
	 * @param storeId,
	 *            startDate, endDate
	 * @return 조회된 결제 내역
	 */
	List<PaymentDetails> selectPaymentDetailsListByStoreIdAndMethodAndStartDateAndEndDate(String storeId,
			Date startDate, Date endDate);

	/**
	 * 한 매장의 특정 제품의 현장 결제 내역 조회 - 판매시스템(포스)에 사용
	 * 
	 * @param storeId,
	 *            productId, sellMethod
	 * @return 조회된 결제 내역
	 */
	List<PaymentDetails> selectPaymentDetailsListByStoreIdAndProductIdAndSellMethod(String storeId, String productId,
			String sellMethod);

	/**
	 * 한 매장의 제품 종류에 따른 결제 내역 조회 - 판매량에 사용
	 * 
	 * @param storeId,
	 *            productCategory
	 * @return 조회된 결제 내역
	 */
	List<PaymentDetails> selectPaymentDetailsListByStoreIdAndProductCategory(String storeId, String productCategory);

	/**
	 * 한 매장의 제품 이름에 따른 결제 내역 조회 - 판매량에 사용
	 * 
	 * @param storeId,
	 *            productName
	 * @return 조회된 결제 내역
	 */
	List<PaymentDetails> selectPaymentDetailsListByStoreIdAndProductName(String storeId, String productName);

	/**
	 * 추천 제품 개수 조회 (예상 생산량 - 당일 판매량) - 종류/이름 - 예상 생산량에 사용 - 무조건 당일이기 때문에 굳이
	 * 매개변수로 date를 주지 않아도 됨 (mapper에서 처리) - method = productCategory,
	 * productName
	 * 
	 * @param storeId,
	 *            method, methodContent
	 * @return 조회된 결제 내역
	 */
	List<PaymentDetails> selectRecommendSalesVolumeByStoreIdAndTodayDateAndMethod(String storeId, String method,
			String methodContent);

	/**
	 * 비율 조회 7일전~어제 모든 제품의 총 판매량 조회 - 상승세/하락세에 이용 - 종류별
	 * 
	 * @param storeId,
	 *            productCategory, todayDate
	 * @return 조회된 결제 내역
	 */
	List<PaymentDetails> selectTotalSalesVolumeFor7Days(String storeId, String productCategory, Date todayDate);

	/**
	 * 비율 조회 첫판매일~어제 모든 제품의 총 판매량 조회 - 상승세/하락세에 이용 - 종류별
	 * 
	 * @param storeId,
	 *            productCategory, todayDate
	 * @return 조회된 결제 내역
	 */
	List<PaymentDetails> selectTotalSalesVolumeForAllDays(String storeId, String productCategory, Date todayDate);

	// 필요없을 것 같은데 확인 필요
	PaymentDetails selectPaymentDetailsByStoreIdAndProductId(String storeId, String productId);

	/**
	 * 결제내역테이블에 거래 시간을 통해 같은시간에 결제한 제품들 모두 가져옴.
	 * 
	 * @param tradeDate
	 * @return
	 */
	List<PaymentDetails> selectPaymentDetailsListByTradeDate(Date tradeDate);

	/**
	 * 유저아이디로 결제내역테이블에 넣은 목록들 조회.
	 * 
	 * @param userId
	 * @return
	 */
	List<PaymentDetails> selectPaymentDetailsListByUserId(String userId);
}
