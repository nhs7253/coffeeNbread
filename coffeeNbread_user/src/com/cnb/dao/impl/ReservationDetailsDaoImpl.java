package com.cnb.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.ReservationDetailsDao;
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
 * 2017-06-27 생성
 */
@Repository
public class ReservationDetailsDaoImpl implements ReservationDetailsDao {

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.cnb.config.mybatis.mapper.ReservationDetailsMapper." + id;
	}
	@Override
	public int insertReservationDetails(ReservationDetails reservationDetails) {
		return session.insert(makeSqlId("insertReservationDetails"), reservationDetails);
	}

	@Override
	public List<ReservationDetails> selectReservationDetailsListByUserIdAndStoreId(String storeId, String userId) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("userId", userId);
		return session.selectList(makeSqlId("selectReservationDetailsListByUserIdAndStoreId"), info);
	}

	@Override
	public List<ReservationDetails> selectReservationDetailsListByStoreIdAndReservationTime(String storeId, Date reservationTime) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("reservationTime", reservationTime);
		return session.selectList(makeSqlId("selectReservationDetailsListByStoreIdAndReservationTime"), info);
	}
	/*
	 * 김형주 DAO 기능 추가 <6.28>
	 * @see com.cnb.dao.ReservationDetailsDao#selectReservationDetailsByUserId(com.cnb.vo.PaymentDetails)
	 */
	@Override
	public List<ReservationDetails> selectReservationDetailsListByUserId(String userId) {
		return session.selectList(makeSqlId("selectReservationDetailsListByUserId"), userId);
	}
	
	@Override
	public List<ReservationDetails> selectReservationDetailsListByStoreId(String storeId) {
		return session.selectList(makeSqlId("selectReservationDetailsListByStoreId"), storeId);
	}
	
	@Override
	public List<ReservationDetails> selectReservationDetailsListByStoreIdAndProductHopeTime(String storeId, Date productHopeTime) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productHopeTime", productHopeTime);
		return session.selectList(makeSqlId("selectReservationDetailsListByStoreIdAndProductHopeTime"), info);
	}	
}
