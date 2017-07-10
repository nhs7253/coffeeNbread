package com.cnb.dao;

import java.util.List;

import com.cnb.vo.PaymentOptionList;

/*
 * 김형주
 * 2017-06-29
 * 생성
 */
/**
 * 결제내역테이블에 들어갈 결제종류 테이블 생성.
 * 매장에서 결제종류에따라 매출량 조회가능.
 * @author 김형주
 *
 */
public interface PaymentOptionListDao {
	/**
	 * 결제 종류 insert
	 * 매장이 paymentOptionList 를 추가.
	 * @param noticeBoardContents
	 * @return 처리 개수
	 */
	int insertPaymentOptionList(PaymentOptionList paymentOptionList);
	
			
	/**
	 * 결제 종류 삭제.  결제 종류 삭제되면 그 종류를 판매하는 매장에서 매장결제종류 지워지게 하고싶음.
	 * @param paymentId
	 * @return
	 */
	int deletePaymentOptionListByPaymentId(String paymentId);
	
	/**
	 * 결제 내역의 전체 목록을 조회
	 * @return List<PaymentOptionList> 전체 결제 내역 목록
	 */
	List<PaymentOptionList> paymentOptionListAll();
	
}
