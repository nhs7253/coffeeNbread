package com.cnb.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.PaymentOptionListDao;
import com.cnb.vo.PaymentOptionList;

/*
 * 김형주
 * 2017-06-29
 * 수정
 */
/*
 * 김형주
 * 2017-06-29
 *  생성
 */

@Repository
public class PaymentOptionListDaoImpl implements PaymentOptionListDao {

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.cnb.config.mybatis.mapper.PaymentOptionListMapper."+id;
	}
	
		
    /* ADMIN  관리자가 결제 종류 추가   */
	@Override
	public int insertPaymentOptionList(PaymentOptionList paymentOptionList) {
		return session.insert(makeSqlId("insertPaymentOptionList"), paymentOptionList);
	}
	
	/* ADMIN  관리자가  결제 종류 삭제  */
	@Override
	public int deletePaymentOptionListByPaymentId(String paymentId) {
		return session.insert(makeSqlId("deletePaymentOptionListByPaymentId"), paymentId);
	}


	@Override
	public List<PaymentOptionList> paymentOptionListAll() {
		return session.selectList(makeSqlId("paymentOptionListAll"));
	}
	
}
