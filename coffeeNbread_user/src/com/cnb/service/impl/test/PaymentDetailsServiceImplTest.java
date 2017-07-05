package com.cnb.service.impl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.exception.UserManageException;
import com.cnb.service.PaymentDetailsService;
import com.cnb.service.ShoppingBasketProductService;
import com.cnb.vo.ShoppingBasketProduct;

/*
 * 김형주
 * 2017-07-02 
 * 초기 구현
 * 
 * 김형주 
 * 2017-07-02 
 * 생성
 */
@Component
public class PaymentDetailsServiceImplTest {
	
	@Autowired
	private PaymentDetailsService service;
 	@Autowired
	private ShoppingBasketProductService sbpservice;

 	public void Test() throws UserManageException {
		
		
		System.out.println("------------결제내역 테이블 추가 전 조회--------------");
		System.out.println(service.findPaymentDetailsListByStoreIdAndUserId("s-7", "u-1"));
		
		
	      System.out.println("-----------결제테이블 조회----");
	      
	      List<ShoppingBasketProduct> list=Arrays.asList(
					new ShoppingBasketProduct("u-1","s-7","p-18",4,"s-7"),
					new ShoppingBasketProduct("u-1","s-7","p-19",4,"s-7"),
					new ShoppingBasketProduct("u-1","s-7","p-20",4,"s-7"),
					new ShoppingBasketProduct("u-1","s-7","p-21",4,"s-7")

					);
	 //   sbpservice.addShoppingBasketProduct(list);
	      
	   //  service.addPaymentDetails(sbpservice.findShoppingBasketProductList("s-7", "u-1"));
	
 	    System.out.println("--------------결제테이블 추가후 조회------------");
 	    System.out.println(service.findPaymentDetailsListByStoreIdAndUserId("s-7", "u-1"));

 	  
 	    System.out.println("------------ 총금액 조회---------------------");
 	    System.out.println(service.findAllProductPrice(list));
 	    
 	    System.out.println("-------------------------------------------");
 	    System.out.println("한 매장의 특정 제품의 결제 내역 조회 - 판매량에 사용");
 	    System.out.println(service.findPaymentDetailsListByStoreIdAndProductId("s-1", "p-1"));
 	    
 	    System.out.println("-------------------------------------------");
 	    System.out.println("한 매장의 결제 날짜에 따른 결제 내역 조회 - 판매량에 사용");
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
 	    try {
			System.out.println(service.findPaymentDetailsListByStoreIdAndTradeDate("s-1", dt.parse("2016-08-03")));
		} catch (ParseException e) {
			System.out.println("이상발생");
		}
 	    
 	    System.out.println("-------------------------------------------");
 	    System.out.println("한 매장의 특정 제품의 현장 결제 내역 조회 - 판매시스템(포스)에 사용");
 	    System.out.println(service.findPaymentDetailsListByStoreIdAndProductIdAndSellMethod("s-1", "p-1", "f"));
 	    
 	}

	public static void main(String[] args) throws UserManageException {
		
		PaymentDetailsServiceImplTest pds = 
				(PaymentDetailsServiceImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("paymentDetailsServiceImplTest");
		pds.Test();
		

	}
}
