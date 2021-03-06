package com.cnb.dao;

import java.util.Date;
import java.util.List;

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
	 * 매장에서 예약확인하면 그 시각을 예약확인테이블에 제품별로 확인시각 넣어줌.
	 * 시각이 없었다가 매장이 확인하면 그 시각으로 들어감.
	 * @param reservationDetails
	 * @return
	 */
	int updateReservationConfirmDate(ReservationDetails reservationDetails);

	
	/**
	 * 1개의 예약 정보 insert
	 * @param reservationDetails
	 * @return 처리 개수
	 */
	int insertReservationDetails(ReservationDetails reservationDetails);
	
	/** 
	 * 매장 당 조회된 예약 내역 수 (Paging 용 count)
	 * @param storeId
	 * @return 조회된 예약 내역 수
	 */
	int selectReservationDetailsListCountByStoreId(String storeId);

	/** 
	 * 유저당 조회된 예약 내역 수 (Paging 용 count)
	 * @param storeId
	 * @return 조회된 예약 내역 수
	 */
	int selectReservationDetailsListCountByUserId(String userId);
	
	
	/** 
	 * 여러 조건으로 조회된 예약 내역 수 (Paging 용 count)
	 * @param storeId, method, methodContent
	 * @return 조회된 예약 내역 수
	 */
	int selectReservationDetailsListCountByMethod(String storeId, String method, String methodContent);
	
	
	/**
	 *  2017-07-16 
	 *  김형주 추가 
	 *  페이징없이 유저가 매장에서 예약한 예약목록 보여주기 
	 */
	
	List<ReservationDetails> selectReservationDetailsListNoPagingByUserIdAndStoreId(String userId,String storeId);
	
	/**
	 * 예약자로 1개의 매장의 예약 정보 select
	 * @param storeId, userId, startIndex, endIndex
	 * @return 조회된 예약 정보들
	 */
	List<ReservationDetails> selectReservationDetailsListByUserIdAndStoreId(String storeId, String userId, int startIndex, int endIndex);
	
	/**
	 * 예약시간으로 1개의 매장의 예약 정보 select
	 * @param storeId, reservationTime, startIndex, endIndex
	 * @return 조회된 예약 정보들
	 */
	List<ReservationDetails> selectReservationDetailsListByStoreIdAndReservationTime(String storeId, Date reservationTime, int startIndex, int endIndex);
	
	/*
	 * 김형주- 유저입장에서 예약내역들 조회.
	 */
	/**
	 * 유저입장에서 유저아이디로 예약내역 조회 //결제내역에 담긴 유저아이디를통해 유저가 예약한 예약내역들 조회.
	 * @param userId, startIndex, endIndex
	 * @return 조회된 예약 정보들
	 */
	List<ReservationDetails> selectReservationDetailsListByUserId(String userId, int startIndex, int endIndex);
	
	/**
	 * 1개의 매장의 예약 정보 select
	 * @param storeId, startIndex, endIndex
	 * @return 조회된 예약 정보들
	 */
	List<ReservationDetails> selectReservationDetailsListByStoreId(String storeId, int startIndex, int endIndex);
	
	/**
	 * 제품수령희망시간으로 1개의 매장의 예약 정보 select
	 * @param storeId, productHopeTime, startIndex, endIndex
	 * @return 조회된 예약 정보들
	 */
	List<ReservationDetails> selectReservationDetailsListByStoreIdAndProductHopeTime(String storeId, Date productHopeTime, int startIndex, int endIndex);

	
	/**
	 * 한 매장에서 예약시간, 예약자로 상세 예약 정보 조회 
	 * @param storeId, reservationTime, userId
	 * @return 조회된 예약 상세 정보
	 */
	List<ReservationDetails> selectReservationDetailByStoreIdAndReservationTimeAndUserId(String storeId, Date reservationTime, String userId);

	/**
	 * 선택한 예약내역들을 delete
	 * @param storeId, reservationDetails
	 * @return 삭제된 제품 개수
	 */
	int deleteReservationDetails(String storeId, ReservationDetails reservation);

	/**
	 * reservationNo로 예약 내역 조회
	 * @param storeId, reservationNo
	 * @return 삭제된 제품 개수
	 */
	ReservationDetails selectReservationDetailsByReservationNo(String storeId, int reservationNo);

}
