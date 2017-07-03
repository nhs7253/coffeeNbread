package com.cnb.service.impl.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.exception.NotInputTradeHopeDateException;
import com.cnb.exception.NotInsertTradeDateException;
import com.cnb.exception.UserManageException;
import com.cnb.service.PaymentDetailsService;
import com.cnb.service.ReservationDetailsService;

/*  유저가 예약내역 서비스 */
@Component
public class ReservationDetailsServiceImplTest_user {

	@Autowired
	private PaymentDetailsService pdService;
	@Autowired
	private ReservationDetailsService rdService;

	public void Test() throws NotInsertTradeDateException, NotInputTradeHopeDateException {

		System.out.println("------------u-1에 대한 결제내역 테이블 추가 전 조회--------------");
		System.out.println(pdService.findPaymentDetailsListByUserId("u-1"));

		
		System.out.println("------------u-1이 예약한 내역등록----------------------");
		rdService.addReservationDetailsByPaymentDetails(pdService.findPaymentDetailsListByUserId("u-1"),"u-1","s-7",new Date());
		
		
		


	}

	public static void main(String[] args) throws UserManageException, NotInsertTradeDateException, NotInputTradeHopeDateException {

		ReservationDetailsServiceImplTest_user pds = (ReservationDetailsServiceImplTest_user) new ClassPathXmlApplicationContext(
				"com/cnb/config/spring/model-context.xml").getBean("reservationDetailsServiceImplTest_user");
		pds.Test();

	}

}
