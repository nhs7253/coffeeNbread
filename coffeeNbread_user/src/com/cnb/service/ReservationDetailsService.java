package com.cnb.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.cnb.exception.NotInputTradeHopeDateException;
import com.cnb.exception.NotInsertTradeDateException;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ReservationDetails;

/*김형주
 * 2017-07-03
 * 기능 추가
 * 
 * 
 * 최민희
 * 2017-07-01
 * 생성
 */
public interface ReservationDetailsService {
	
	
	/** 
	 * 매장이 확인버튼 누르면 유저가 예약 확인 목록을 볼떄 date값 받아온다.
	 */
	 void addReservationDetailsByPaymentDetails(List<PaymentDetails> paymentDetailsList,String userId,String storeId,Date tradeHopeDate)throws NotInsertTradeDateException, NotInputTradeHopeDateException;
	
	

/*	int modifyReservationDetails(ReservationDetails reservationDetails);*/
	
	

	HashMap<String, Object> findReservationDetailsListByUserIdAndStoreId(int page, String storeId, String userId);
	
	/**
	 * 예약시간으로 1개의 매장의 예약 정보 select
	 * @param storeId, reservationTime
	 */
	HashMap<String, Object> findReservationDetailsListByStoreIdAndReservationTime(int page, String storeId, Date reservationTime);
	
	/**
	 * 유저입장에서 유저아이디로 예약내역 조회 //결제내역에 담긴 유저아이디를통해 유저가 예약한 예약내역들 조회.
	 * @param userId
	 */
	HashMap<String, Object> findReservationDetailsListByUserId(int page, String userId);
	
	/**
	 * 1개의 매장의 예약 정보 select
	 * @param storeId
	 */
	HashMap<String, Object> findReservationDetailsListByStoreId(int page, String storeId);
	
	/**
	 * 제품수령희망시간으로 1개의 매장의 예약 정보 select
	 * @param storeId, productHopeTime
	 */
	HashMap<String, Object> findReservationDetailsListByStoreIdAndProductHopeTime(int page, String storeId, Date productHopeTime);


}
