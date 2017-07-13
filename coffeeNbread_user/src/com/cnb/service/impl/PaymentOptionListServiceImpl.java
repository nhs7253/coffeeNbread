package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.PaymentOptionListDao;
import com.cnb.service.PaymentOptionListService;
import com.cnb.vo.PaymentOptionList;

/*
 * 노현식
 * 2017-07-10
 * 생성, 초기구현
 */
@Service
public class PaymentOptionListServiceImpl implements PaymentOptionListService{
	
	@Autowired
	private PaymentOptionListDao paymentOptionListDao;

	@Override
	public void addPaymentOptionList(PaymentOptionList paymentOptionList) {
		paymentOptionListDao.insertPaymentOptionList(paymentOptionList);
	}

	@Override
	public void removePaymentOptionListByPaymentId(String paymentId) {
		paymentOptionListDao.deletePaymentOptionListByPaymentId(paymentId);
	}

	@Override
	public List<PaymentOptionList> findpaymentOptionList() {
		return paymentOptionListDao.paymentOptionListAll();
	}
	

}
