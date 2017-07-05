package com.cnb.service;

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
 * 생성
 */
/**
 * 판매량 계산 service
 * @author minhee
 *
 */
public interface SalesVolumeService {
	
	/**
	 * 오늘 날짜 판매량 조회
	 * @param storeId, todayDate
	 */
	List<PaymentDetails> findSalesVolumeByStoreIdAndTodayDate(String storeId, Date todayDate);
	
	
	/**
	 * 여러 조건으로 날짜별 판매량 조회 (1주일, 1개월, 3개월, 6개월, 12개월)
	 * @param storeId, method
	 */
	List<PaymentDetails> findSalesVolumeByStoreIdAndMethod(String storeId, String method);
	
	
	/**
	 * 직접 날짜 지정으로 판매량 조회
	 * @param storeId, startDate, endDate
	 */
	List<PaymentDetails> findSalesVolumeByStoreIdAndStoreIdAndMethodAndStartDateAndEndDate(String storeId, Date startDate, Date endDate);
	
	
	/**
	 * 제품 종류로 판매량 조회
	 * @param storeId, productCategory
	 */
	List findSalesVolumeByStoreIdAndProductCategory(String storeId, String productCategory);
	
	
	/**
	 * 제품 이름으로 판매량 조회
	 * @param storeId, productName
	 */
	List<PaymentDetails> findSalesVolumeByStoreIdAndProductName(String storeId, String productName);
	
	
	/**
	 * 추천 제품 개수 조회 (예상 생산량 - 당일 판매량) - 종류/이름
	 * @param storeId, method, methodContent
	 */
	List<Integer> findRecommendSalesVolumeByStoreIdAndTodayDateAndMethod(String storeId, String method, String methodContent);
	
	/**
	 * (전체-(일주일전~어제))와 (~어제)를 비교한 모든 제품의 총 판매량 조회  - 상승세/하락세에 이용 - 종류별
	 * @param storeId, todayDate(오늘이 월요일인지 비교하기 위해), productCategory
	 */
	void findTotalSalesVolumeByStoreIdAndProductCategoryAndTodayDate(String storeId, String productCategory, Date todayDate);
}
