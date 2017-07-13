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

	/**
	 * 매장의 오픈시간과 닫은시간안에 제품수령시간을 적는다면 그떄 가능, 아니면 안됨.
	 * 
	 * @throws NotInsertTradeDateException
	 */

	public void addUserHopedGetProductDate(List<PaymentDetails> paymentDetailsList, String userId, String storeId,
			Date tradeHopeDate) throws NotInsertTradeDateException {

		Store store = sDao.selectStoreById(storeId);
		paymentDetailsList = pdDao.selectPaymentDetailsListByUserIdAndStoreId(userId, storeId);
		System.out.println("paymentDetailsList:" + paymentDetailsList);
		/* 원하는 제품수령시간이 매장의 닫는시간 이후거나 , 매장의 오픈시간 이전이면 예외 생성 */
		if (tradeHopeDate.compareTo(store.getStoreClose()) > 0 || tradeHopeDate.compareTo(store.getStoreOpen()) < 0) {
			throw new NotInsertTradeDateException("매장 운영시간에 맞지 않아 수령할수있는 시간이아닙니다.");
		}
		for (int i = 0; i < paymentDetailsList.size(); i++) {
          /* update로 수정해야 함. */
			dao.insertReservationDetails(new ReservationDetails(0, paymentDetailsList.get(i).getTradeDate(),
					paymentDetailsList.get(i).getReservationOrderCount(), null, tradeHopeDate,
					paymentDetailsList.get(i).getUserId(), paymentDetailsList.get(i).getProductId(),
					paymentDetailsList.get(i).getStoreId()));
		}
		
	}
	
	
	
	
/*    예약확인내역에서 매장에서 확인하기 전에는 수령희망시간 수정 가능 
	@Override
	public int modifyReservationDetails(List<PaymentDetails> paymentDetailsList,ReservationDetails reservationDetails) {

		return 0;
	}
*/
	@Override
	public int addReservationDetailsByPaymentDetails(List<PaymentDetails> paymentDetailsList) {
		return 0;
	}

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
}
