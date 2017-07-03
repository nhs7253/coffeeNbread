package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.PaymentDetailsDao;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ShoppingBasketProduct;

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


	
	
	


	

}