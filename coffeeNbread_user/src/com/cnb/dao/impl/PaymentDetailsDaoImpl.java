package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.PaymentDetailsDao;
import com.cnb.vo.BookMarkCardNum;
import com.cnb.vo.PaymentDetails;

/*
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
	public List<PaymentDetails> selectPaymentDetailsByUserIdAndStoreIdAndProductId(String userId, String storeId,
		String productId	) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("userId", userId);
		info.put("productId", productId);
		return session.selectList(makeSqlId("selectPaymentDetailsByUserIdAndStoreIdAndProductId"),info);
	}


	

}