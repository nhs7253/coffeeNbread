package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.StorePaymentOptionListDao;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.PaymentOptionList;
import com.cnb.vo.StorePaymentOptionList;

/*
 * 김형주
 * 06.29 구현
 * 
 * 
 * 김형주
 * 06.29 초기생성
 */
@Repository
public class StorePaymentOptionListDaoImpl implements StorePaymentOptionListDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.StorePaymentOptionListMapper."+id;
	}

	/* 매장이 결제종류테이블에서 매장 결제종류 테이블로 삽입 */
	@Override                  
	public int insertStorePaymentOptionList(StorePaymentOptionList storePaymentOptionList) {
		
		return session.insert(makeSqlId("insertStorePaymentOptionList"), storePaymentOptionList);
	}

    /* 매장이 매장아이디와 결제아이디를 통해 매장결제종류테이블 삭제 */
	@Override
	public int deleteStorePaymentOptionListByStoreIdAndPaymentId(String storeId, String paymentId) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("paymentId", paymentId);
		return session.delete(makeSqlId("deleteStorePaymentOptionListByStoreIdAndPaymentId"), info);
	}


	/* 매장이 자신이 등록해놓은 매장 결제종류 값들 조회 */ 
	@Override
	public List<StorePaymentOptionList> selectStorePaymentOptionListByStoreId(String storeId) {
		return session.selectList(makeSqlId("selectStorePaymentOptionListByStoreId"), storeId);

	}

	

	

}