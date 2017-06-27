package com.cnb.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.ReservationDetailsDao;
import com.cnb.vo.ReservationDetails;

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
	public List<ReservationDetails> selectReservationDetailsByUserId(String storeId, String userId) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("userId", userId);
		return session.selectList(makeSqlId("selectReservationDetailsByUserId"), info);
	}

	@Override
	public List<ReservationDetails> selectReservationDetailsByReservationTime(String storeId, Date reservationTime) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("reservationTime", reservationTime);
		return session.selectList(makeSqlId("selectReservationDetailsByReservationTime"), info);
	}
}
