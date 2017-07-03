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
import com.cnb.vo.ShoppingBasketProduct;

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

	@Override
	public List<PaymentDetails>selectPaymentDetailsListByUserIdAndStoreId(String userId,String storeId){
		Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		return session.selectList(makeSqlId("selectPaymentDetailsListByUserIdAndStoreId"), info);
	}

  public  List<ShoppingBasketProduct> selectAllProductPriceByUserIdAndStoreId(String userId, String storeId){
	  
	  Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		return session.selectList("com.cnb.config.mybatis.mapper.ShoppingBasketProductMapper.selectAllProductPriceByUserIdAndStoreId", info);
	  
  }


@Override
public PaymentDetails selectPaymentDetailsByStoreIdAndProductId(String storeId, String productId) {
    
	Map<String, String> info = new HashMap<>();
	info.put("storeId", storeId);
	info.put("productId", productId);
	return session.selectOne(makeSqlId("selectPaymentDetailsByStoreIdAndProductId"), info);
}

/**
 * 동일한 시간에 결제한 제품들 조회하려고 함
 * 2017 -07-03 추가
 */
@Override
public List<PaymentDetails> selectPaymentDetailsListByTradeDate(Date tradeDate) {
	return session.selectList(makeSqlId("selectPaymentDetailsListByTradeDate"), tradeDate);

}

/**
 * 유저아이디로 결제내역에 있는 제품들 조회
 */
@Override
public List<PaymentDetails> selectPaymentDetailsListByUserId(String userId) {
	return session.selectList(makeSqlId("selectPaymentDetailsListByUserId"), userId);
}


	
	
	


	

}