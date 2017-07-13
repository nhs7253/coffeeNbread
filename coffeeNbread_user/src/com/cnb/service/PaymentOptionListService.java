package com.cnb.service;

import java.util.List;
import java.util.Map;

import com.cnb.exception.UserManageException;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.PaymentOptionList;

/*
 * 노현식
 * 2017-07-10
 * 생성, 초기 구현
 */
/**
 * 회원 관리의 전체 서비스를 지원 하는 서비스 클래스
 */
public interface PaymentOptionListService {

	/**
	 * 플렛폼에서 지원할 1개의 결제 방법을 추가
	 * @param paymentOptionList
	 */
	void addPaymentOptionList(PaymentOptionList paymentOptionList);
	
	/**
	 * 플렛폼에서 지원하던 1개의 결제 방법을 삭제
	 * @param paymentId
	 */
	void removePaymentOptionListByPaymentId(String paymentId);
	
	/**
	 * 지원하는 모든 결제 방법을 보여줌
	 * @return
	 */
	List<PaymentOptionList> findpaymentOptionList();
}
