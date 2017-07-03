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
 * 2017-07-02
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
	public int selectReservationDetailsListCountByStoreId(String storeId) {
		return session.selectOne(makeSqlId("selectReservationDetailsListCountByStoreId"), storeId);
	}
	@Override
	public int selectReservationDetailsListCountByUserId(String userId) {
		return session.selectOne(makeSqlId("selectReservationDetailsListCountByUserId"), userId);
	}
	
	@Override
	public int selectReservationDetailsListCountByMethod(String storeId, String method, String methodContent) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("method", method);
		info.put("methodContent", methodContent);
		return session.selectOne(makeSqlId("selectReservationDetailsListCountByMethod"), info);
	}
	
	@Override
	public List<ReservationDetails> selectReservationDetailsListByUserIdAndStoreId(String storeId, String userId, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("userId", userId);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectReservationDetailsListByUserIdAndStoreId"), info);
	}

	@Override
	public List<ReservationDetails> selectReservationDetailsListByStoreIdAndReservationTime(String storeId, Date reservationTime, int startIndex, int endIndex) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("reservationTime", reservationTime);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectReservationDetailsListByStoreIdAndReservationTime"), info);
	}
	/*
	 * 김형주 DAO 기능 추가 <6.28>
	 * @see com.cnb.dao.ReservationDetailsDao#selectReservationDetailsByUserId(com.cnb.vo.PaymentDetails)
	 */
	@Override
	public List<ReservationDetails> selectReservationDetailsListByUserId(String userId, int startIndex, int endIndex) {
		Map<String, Object> info = new HashMap<>();
		info.put("userId", userId);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectReservationDetailsListByUserId"), info);
	}
	
	@Override
	public List<ReservationDetails> selectReservationDetailsListByStoreId(String storeId, int startIndex, int endIndex) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectReservationDetailsListByStoreId"), info);
	}
	
	@Override
	public List<ReservationDetails> selectReservationDetailsListByStoreIdAndProductHopeTime(String storeId, Date productHopeTime, int startIndex, int endIndex) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productHopeTime", productHopeTime);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectReservationDetailsListByStoreIdAndProductHopeTime"), info);
	}

	
	
}
