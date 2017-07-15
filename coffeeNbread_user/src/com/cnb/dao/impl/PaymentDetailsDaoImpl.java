package com.cnb.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.PaymentDetailsDao;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.RecipeBoardContents;
import com.cnb.vo.ShoppingBasketProduct;


/*
 * 최민희
 * 2017-07-04
 * 수정
 */
/*
 * 최민희
 * 2017-07-03
 * 추가
 */
/*
/*김형주
 * 
 * 07.02 수정
 * 
 * 
 * 김형주
 * 06.28 구현
 * 
 * 
 * 김형주
 * 06.28 초기생성
 */
@Repository
public class PaymentDetailsDaoImpl implements PaymentDetailsDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.PaymentDetailsMapper."+id;
	}

	
	@Override
	public int insertPaymentDetails(PaymentDetails paymentDetails) {
		return session.insert(makeSqlId("insertPaymentDetails"), paymentDetails);
	}

/*	@Override
	public List<PaymentDetails> selectPaymentDetailsListByUserIdAndStoreId(String userId,String storeId){
		Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		return session.selectList(makeSqlId("selectPaymentDetailsListByUserIdAndStoreId"), info);
	}
*/
	

	@Override
	public List<PaymentDetails> selectPaymentDetailsListByUserId(String userId) {
		return session.selectList(makeSqlId("selectPaymentDetailsListByUserId"), userId);
	}

 
   /**
    * 유저가 결제한 결제내역들 개수 페이징 -매장아이디가 null이라면 빼고 조회
    */
	@Override
	public int countSelectPaymentDetailsByUserId(String userId) {
		Map<String, Object> info = new HashMap<>();
		info.put("userId", userId);
		
		return session.selectOne(makeSqlId("countSelectPaymentDetailsByUserId"), info);
	}

	/**
	 * 유저아이디로 결제내역에 있는 제품들 조회 -매장아이디가 null이라면 빼고 조회 
	 */
	@Override
	public List<PaymentDetails> findSelectPaymentDetailsListByUserId(String userId,
			int startIndex, int endIndex) {
		Map<String, Object> info = new HashMap<>();
		info.put("userId", userId);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("findSelectPaymentDetailsListByUserId"), info);
	}
	
	
	
	
	
	
	
	
	
	@Override
	public List<PaymentDetails> selectPaymentDetailsListByStoreIdAndProductId(String storeId, String productId) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productId", productId);
		return session.selectList(makeSqlId("selectPaymentDetailsListByStoreIdAndProductId"), info);
	}

	@Override
	public List<PaymentDetails> selectPaymentDetailsListByStoreIdAndTradeDate(String storeId, Date tradeDate) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("tradeDate", tradeDate);
		return session.selectList(makeSqlId("selectPaymentDetailsListByStoreIdAndTradeDate"), info);
	}
	
	@Override
	public List<PaymentDetails> selectPaymentDetailsListByStoreIdAndMethod(String storeId, String method) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("method", method);
		return session.selectList(makeSqlId("selectPaymentDetailsListByStoreIdAndMethod"), info);
	}

	@Override
	public List<PaymentDetails> selectPaymentDetailsListByStoreIdAndMethodAndStartDateAndEndDate(String storeId, Date startDate, Date endDate) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("startDate", startDate);
		info.put("endDate", endDate);
		return session.selectList(makeSqlId("selectPaymentDetailsListByStoreIdAndMethodAndStartDateAndEndDate"), info);
	}

	@Override
	public List<PaymentDetails> selectPaymentDetailsListByStoreIdAndProductIdAndSellMethod(String storeId, String productId, String sellMethod) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productId", productId);
		info.put("sellMethod", sellMethod);
		return session.selectList(makeSqlId("selectPaymentDetailsListByStoreIdAndProductIdAndSellMethod"), info);
	}

	@Override
	public List<PaymentDetails> selectPaymentDetailsListByStoreIdAndProductCategory(String storeId, String productCategory) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productCategory", productCategory);
		return session.selectList(makeSqlId("selectPaymentDetailsListByStoreIdAndProductCategory"), info);
	}

	@Override
	public List<PaymentDetails> selectPaymentDetailsListByStoreIdAndProductName(String storeId, String productName) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productName", productName);
		return session.selectList(makeSqlId("selectPaymentDetailsListByStoreIdAndProductName"), info);
	}

	@Override
	public List<PaymentDetails> selectRecommendSalesVolumeByStoreIdAndTodayDateAndMethod(String storeId, String method, String methodContent) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("method", method);
		info.put("methodContent", methodContent);
		return session.selectList(makeSqlId("selectRecommendSalesVolumeByStoreIdAndTodayDateAndMethod"), info);
	}

	@Override
	public List<PaymentDetails> selectTotalSalesVolumeFor7Days(String storeId, String productCategory, Date todayDate) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productCategory", productCategory);
		info.put("todayDate", todayDate);
		return session.selectList(makeSqlId("selectTotalSalesVolumeFor7Days"), info);
	}

	@Override
	public List<PaymentDetails> selectTotalSalesVolumeForAllDays(String storeId, String productCategory, Date todayDate) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productCategory", productCategory);
		info.put("todayDate", todayDate);
		return session.selectList(makeSqlId("selectTotalSalesVolumeForAllDays"), info);
	}

	@Override
	public PaymentDetails selectPaymentDetailsByStoreIdAndProductId(String storeId, String productId) {

		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productId", productId);
		return session.selectOne(makeSqlId("selectPaymentDetailsByStoreIdAndProductId"), info);
	}

	/**
	 * 동일한 시간에 결제한 제품들 조회하려고 함 2017 -07-03 추가
	 */
	@Override
	public List<PaymentDetails> selectPaymentDetailsListByTradeDate(Date tradeDate) {
		return session.selectList(makeSqlId("selectPaymentDetailsListByTradeDate"), tradeDate);

	}




	
}