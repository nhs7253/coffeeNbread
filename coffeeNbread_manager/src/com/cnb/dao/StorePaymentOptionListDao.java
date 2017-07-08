package com.cnb.dao;

import java.util.List;

import com.cnb.vo.StorePaymentOptionList;



/*
 * 김형주
 * 6.29 
 * 생성 및 구현.
 * 
 */
/**
 * StorePaymentOptionList 테이블을 관리하는 Dao 인터페이스
 * 
 *
 */
public interface StorePaymentOptionListDao {

	/**
	 * 매장 주인이 관리자가 운영하는 결제종류테이블에서 1개를 가져와서 StorePaymentOptionList테이블에 삽입.
	 * @param paymentOptionList
	 * @return
	 */
	
	
	int insertStorePaymentOptionList(StorePaymentOptionList storePaymentOptionList);
	
   /**
     * 매장주인이 결제종류아이디로 삭제  
     * @param storeId
     * @param paymentId
     * @return
     */
	int deleteStorePaymentOptionListByStoreIdAndPaymentId(String storeId,String paymentId);	
	
	
	/**
	 * 매장입장에서 결제종류아이디로 조회.// 매장아이디로  매장별  결제 종류 조회
	 * @param storeId
	 * @param reservationTime
	 * @return
	 */
	List<StorePaymentOptionList> selectStorePaymentOptionListByStoreId(String storeId);
	
	
	
}
