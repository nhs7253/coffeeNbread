package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	private PaymentOptionListService paymentOptionListService;

	@Override
	public int addPaymentOptionList(PaymentOptionList paymentOptionList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removePaymentOptionListByPaymentId(String paymentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PaymentOptionList> findpaymentOptionList() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
