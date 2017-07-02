package com.cnb.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.ReservationDetailsDao;
import com.cnb.service.ReservationDetailsService;
import com.cnb.util.PagingBean;
import com.cnb.vo.ReservationDetails;

/*
 * 최민희
 * 2017-07-01
 * 생성
 */
@Service
public class ReservationDetailsServiceImpl implements ReservationDetailsService{

	@Autowired
	private ReservationDetailsDao dao;

	
	@Override
	public int addReservationDetails(ReservationDetails reservationDetails) {
		return dao.insertReservationDetails(reservationDetails);
	}
	
	@Override
	public HashMap<String, Object> findReservationDetailsListByUserIdAndStoreId(int page, String storeId, String userId) {
		HashMap<String, Object> map = new HashMap<>();
		String method = "userId";
		String methodContent = userId;
		
		//item 수
		int totalCount = dao.selectReservationDetailsListCountByMethod(storeId, method, methodContent);
		
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		List<ReservationDetails> list = dao.selectReservationDetailsListByUserIdAndStoreId(storeId, userId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}

	Date from = new Date();
	SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public HashMap<String, Object> findReservationDetailsListByStoreIdAndReservationTime(int page, String storeId, Date reservationTime) {
		HashMap<String, Object> map = new HashMap<>();
		String method = "reservationTime";
		String methodContent = dt.format(reservationTime);
		
		//item 수
		int totalCount = dao.selectReservationDetailsListCountByMethod(storeId, method, methodContent);
		
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		List<ReservationDetails> list = dao.selectReservationDetailsListByStoreIdAndReservationTime(storeId, reservationTime, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}

	@Override
	public HashMap<String, Object> findReservationDetailsListByUserId(int page, String userId) {
		HashMap<String, Object> map = new HashMap<>();
		
		//item 수
		int totalCount = dao.selectReservationDetailsListCountByUserId(userId);
		
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		List<ReservationDetails> list = dao.selectReservationDetailsListByUserId(userId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}
	
	@Override
	public HashMap<String, Object> findReservationDetailsListByStoreId(int page, String storeId) {
		HashMap<String, Object> map = new HashMap<>();
		
		//item 수
		int totalCount = dao.selectReservationDetailsListCountByStoreId(storeId);
		
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		List<ReservationDetails> list = dao.selectReservationDetailsListByStoreId(storeId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}

	@Override
	public HashMap<String, Object> findReservationDetailsListByStoreIdAndProductHopeTime(int page, String storeId, Date productHopeTime) {
		HashMap<String, Object> map = new HashMap<>();
		String method = "productHopeTime";
		String methodContent = dt.format(productHopeTime);
		
		//item 수
		int totalCount = dao.selectReservationDetailsListCountByMethod(storeId, method, methodContent);
		
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		List<ReservationDetails> list = dao.selectReservationDetailsListByStoreIdAndProductHopeTime(storeId, productHopeTime, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}
}
