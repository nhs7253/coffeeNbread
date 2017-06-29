package com.cnb.dao;

import java.util.Date;
import java.util.List;

import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ReservationDetails;

/*
 * 최민희
 * 2017-06-29 수정
 * selectReservationDetailsListByStoreId 추가
 * selectReservationDetailsListByStoreIdAndProductHopeTime 추가
 */
/*
 * 최민희
 * 2017-06-27
 * 생성
 */
/**
 * ReservationDetails 테이블을 관리하는 Dao 인터페이스
 * @author minhee
 *
 */
public interface ReservationDetailsDao {
	/**
	 * 1개의 예약 정보 insert
	 * @param reservationDetails
	 * @return 처리 개수
	 */
	int insertReservationDetails(ReservationDetails reservationDetails);
	
	/**
	 * 예약자로 1개의 매장의 예약 정보 select
	 * @param storeId, userId
	 * @return 조회된 예약 정보들
	 */
	List<ReservationDetails> selectReservationDetailsListByUserIdAndStoreId(String storeId, String userId);
	
	/**
	 * 예약시간으로 1개의 매장의 예약 정보 select
	 * @param storeId, reservationTime
	 * @return 조회된 예약 정보들
	 */
	List<ReservationDetails> selectReservationDetailsListByStoreIdAndReservationTime(String storeId, Date reservationTime);
	
	/*
	 * 김형주- 유저입장에서 예약내역들 조회.
	 */
	/**
	 * 유저입장에서 유저아이디로 예약내역 조회 //결제내역에 담긴 유저아이디를통해 유저가 예약한 예약내역들 조회.
	 */
	List<ReservationDetails> selectReservationDetailsListByUserId(String userId);
	
	/**
	 * 1개의 매장의 예약 정보 select
	 * @param storeId
	 * @return 조회된 예약 정보들
	 */
	List<ReservationDetails> selectReservationDetailsListByStoreId(String storeId);
	
	/**
	 * 제품수령희망시간으로 1개의 매장의 예약 정보 select
	 * @param productHopeTime
	 * @return 조회된 예약 정보들
	 */
	List<ReservationDetails> selectReservationDetailsListByStoreIdAndProductHopeTime(String storeId, Date productHopeTime);

	
}
