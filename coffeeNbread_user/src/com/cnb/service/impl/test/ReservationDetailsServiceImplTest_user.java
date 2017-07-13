package com.cnb.service.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

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

	public void Test() {

/*		System.out.println("------------u-1에 대한 결제내역 테이블 추가 전 조회--------------");
		System.out.println(pdService.findPaymentDetailsListByUserId("u-1"));
*/
		
		System.out.println("------------u-1이 예약한 내역등록----------------------");
		/*rdService.addReservationDetails(pdService.findPaymentDetailsListByUserId("u-1"));*/
		/*
		 * System.out.println("-----------결제테이블 조회----");
		 * 
		 * List<ShoppingBasketProduct> list=Arrays.asList( new
		 * ShoppingBasketProduct("u-1","s-7","p-18",4,"s-7"), new
		 * ShoppingBasketProduct("u-1","s-7","p-19",4,"s-7"), new
		 * ShoppingBasketProduct("u-1","s-7","p-20",4,"s-7"), new
		 * ShoppingBasketProduct("u-1","s-7","p-21",4,"s-7"), new
		 * ShoppingBasketProduct("u-1","s-7","p-22",4,"s-7")
		 * 
		 * ); sbpservice.addShoppingBasketProduct(list);
		 * 
		 * service.addPaymentDetails(sbpservice.findShoppingBasketProductList(
		 * "s-7", "u-1"));
		 * 
		 * 
		 * System.out.println("--------------결제테이블 추가후 조회------------");
		 * System.out.println(service.findPaymentDetailsListByStoreIdAndUserId(
		 * "s-7", "u-1"));
		 * 
		 * 
		 * System.out.println("------------ 총금액 조회---------------------");
		 * System.out.println(service.findAllProductPrice(list));
		 * 
		 * }
		 * 
		 */

	}

	public static void main(String[] args) throws UserManageException {

		ReservationDetailsServiceImplTest_user pds = (ReservationDetailsServiceImplTest_user) new ClassPathXmlApplicationContext(
				"com/cnb/config/spring/model-context.xml").getBean("reservationDetailsServiceImplTest_user");
		pds.Test();

	}

}
