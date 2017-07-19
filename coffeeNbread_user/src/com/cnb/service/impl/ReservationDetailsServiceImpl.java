package com.cnb.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.PaymentDetailsDao;
import com.cnb.dao.ReservationDetailsDao;
import com.cnb.dao.StoreDao;
import com.cnb.exception.NotInsertTradeDateException;
import com.cnb.service.ReservationDetailsService;
import com.cnb.util.PagingBean;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ReservationDetails;
import com.cnb.vo.Store;

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
 * 2017-07-01
 * 생성
 */
@Service
public class ReservationDetailsServiceImpl implements ReservationDetailsService {

	@Autowired
	private ReservationDetailsDao dao;

	@Autowired
	private PaymentDetailsDao pdDao;

	@Autowired
	private StoreDao sDao;


	@Override
	public void addReservationDetailsByPaymentDetails(List<PaymentDetails> paymentDetailsList,Date productHopeTime) {
		
		for(int i=0;i<paymentDetailsList.size();i++){
			
			dao.insertReservationDetails(new ReservationDetails(0,new Date(),paymentDetailsList.get(i).getReservationOrderCount(),null,productHopeTime,paymentDetailsList.get(i).getUserId(),paymentDetailsList.get(i).getProductId(),paymentDetailsList.get(i).getStoreId()));
		
		}
		
	}
	

/*	@Override
	public int addReservationDetailsByPaymentDetails(List<PaymentDetails> paymentDetailsList) {
		
		for(int i=0;i<paymentDetailsList.size();i++){
			
			dao.insertReservationDetails(new ReservationDetails(0,new Date(),paymentDetailsList.get(i).getReservationOrderCount(),null,));
		}
		return 0;
	}*/

	@Override
	public HashMap<String, Object> findReservationDetailsListByUserIdAndStoreId(int page, String storeId,
			String userId) {
		HashMap<String, Object> map = new HashMap<>();
		String method = "userId";
		String methodContent = userId;

		// item 수
		int totalCount = dao.selectReservationDetailsListCountByMethod(storeId, method, methodContent);
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		List<ReservationDetails> list = dao.selectReservationDetailsListByUserIdAndStoreId(storeId, userId,
				pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}

	Date from = new Date();
	SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public HashMap<String, Object> findReservationDetailsListByStoreIdAndReservationTime(int page, String storeId,
			Date reservationTime) {
		HashMap<String, Object> map = new HashMap<>();
		String method = "reservationTime";
		String methodContent = dt.format(reservationTime);

		// item 수
		int totalCount = dao.selectReservationDetailsListCountByMethod(storeId, method, methodContent);

		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);

		List<ReservationDetails> list = dao.selectReservationDetailsListByStoreIdAndReservationTime(storeId,
				reservationTime, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}

	@Override
	public HashMap<String, Object> findReservationDetailsListByUserId(int page, String userId) {
		HashMap<String, Object> map = new HashMap<>();
		// item 수
		int totalCount = dao.selectReservationDetailsListCountByUserId(userId);
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		List<ReservationDetails> list = dao.selectReservationDetailsListByUserId(userId, pageBean.getBeginItemInPage(),
				pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}

	@Override
	public HashMap<String, Object> findReservationDetailsListByStoreId(int page, String storeId) {
		HashMap<String, Object> map = new HashMap<>();

		// item 수
		int totalCount = dao.selectReservationDetailsListCountByStoreId(storeId);

		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);

		List<ReservationDetails> list = dao.selectReservationDetailsListByStoreId(storeId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
				
		System.out.println(totalCount);
		System.out.println("service : " + list);
		System.out.println("confirm : " + list.get(0).getReservationConfirm());
		map.put("list", list);
		return map;
	}

	@Override
	public HashMap<String, Object> findReservationDetailsListByStoreIdAndProductHopeTime(int page, String storeId,
			Date productHopeTime) {
		HashMap<String, Object> map = new HashMap<>();
		String method = "productHopeTime";
		String methodContent = dt.format(productHopeTime);

		// item 수
		int totalCount = dao.selectReservationDetailsListCountByMethod(storeId, method, methodContent);

		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);

		List<ReservationDetails> list = dao.selectReservationDetailsListByStoreIdAndProductHopeTime(storeId,
				productHopeTime, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}

	@Override
	public void addUserHopedGetProductDate(PaymentDetails paymentDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public int addReservationDetails(ReservationDetails reservationDetails) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReservationDetails> findReservationDetailByStoreIdAndReservationTimeAndUserId(String storeId, Date reservationTime, String userId) {		
		return dao.selectReservationDetailByStoreIdAndReservationTimeAndUserId(storeId, reservationTime, userId);
	}


	@Override
	public void modifyReservationConfirmDate(List<ReservationDetails> reservationList) {
		for(int i=0; i<reservationList.size(); i++) {
			dao.updateReservationConfirmDate(reservationList.get(i));
		}
	}

	@Override
	public void findRemoveReservationDetails(String storeId, List<ReservationDetails> reservationDetailsList) {
		for(int i=0; i<reservationDetailsList.size(); i++){
			dao.deleteReservationDetails(storeId, reservationDetailsList.get(i));
		}
	}

	@Override
	public ReservationDetails findReservationDetailsByReservationNo(String storeId, int reservationNo) {
		return dao.selectReservationDetailsByReservationNo(storeId, reservationNo);
	}


	@Override
	public List<ReservationDetails> findReservationDetailsListNoPagingByUserIdAndStoreId(String userId, String storeId) {
		return dao.selectReservationDetailsListNoPagingByUserIdAndStoreId(userId, storeId);
	}
}
