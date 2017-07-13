package com.cnb.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ReservationDetails;

/*
 * 최민희
 * 2017-07-12
 * 수정
 */
/*
 * 최민희
 * 2017-07-11
 * 수정
 */
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
	 * 사용자가 원하는 시간 입력하면  예약테이블에 제품수령희망시간 넣을  서비스 
	 */
	void addUserHopedGetProductDate(PaymentDetails paymentDetails);
	
	
	 int addReservationDetailsByPaymentDetails(List<PaymentDetails> paymentDetailsList);
	
	
	/** 
	 * 매장이 확인버튼 누르면 유저가 예약 확인 목록을 볼떄 date값 받아온다.
	 */
    /*	int modifyReservationDetails(ReservationDetails reservationDetails);*/
	
	
	/**
	 * 1개의 예약 정보 insert
	 * @param reservationDetails
	 */
	int addReservationDetails(ReservationDetails reservationDetails);
	
	/**
	 * 예약자로 1개의 매장의 예약 정보 select
	 * @param storeId, userId
	 */
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

	/**
	 * 한 매장에서 예약시간, 예약자로 상세 예약 정보 조회 
	 * @param storeId, productHopeTime, userId
	 */
	List<ReservationDetails> findReservationDetailByStoreIdAndReservationTimeAndUserId(String storeId, Date reservationTime, String userId);
	
	/**
	 * 한 매장에서 같은 유저가 같은 시간에 구매한 예약 내역들의 확인 유무 시간 수정
	 * @param reservationList
	 */
	void modifyReservationConfirmDate(List<ReservationDetails> reservationList);
	
	/**
	 * 선택한 예약 내역들을 삭제 
	 * @param storeId 삭제를 요청하는 매장 ID
	 * @param reservationDetailsList 삭제 당할 예약 내역의 목록
	 */
	void findRemoveReservationDetails(String storeId, List<ReservationDetails> reservationDetailsList);

	/**
	 * eservationNo로 예약 내역 조회
	 * @param storeId 삭제를 요청하는 매장 ID
	 * @param reservationNo 삭제 당할 예약 내역의 번호
	 */
	ReservationDetails findReservationDetailsByReservationNo(String storeId, int reservationNo);
}
