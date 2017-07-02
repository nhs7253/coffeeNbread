package com.cnb.dao.impl.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.PaymentDetailsDao;
import com.cnb.dao.ReservationDetailsDao;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.PaymentDetails;
/*
 * 김형주
 * 2017-06-28 수정
 */
/*
 * 김형주
 * 2017-06-28 생성
 */
@Component
public class PaymentDetailsDaoImplTest {

	@Autowired
	private PaymentDetailsDao dao;
	
	private PaymentDetailsDaoImplTest(PaymentDetailsDao dao){
		this.dao = dao;
	}
	

	
	public void Test(){
		
		//매장에서 총 결제내역 조회
		System.out.println("최초 조회");
        System.out.println(dao.selectPaymentDetailsListByUserIdAndStoreId("u-1", "s-1"));

		//유저입장에서 장바구니에있는걸 결제내역 테이블에 넣을것.
	    System.out.println("--추가된 결제테이블 내역--");
		System.out.println(dao.insertPaymentDetails(new PaymentDetails(4,"c",new Date(),"r",5,"u-1","p-1","s-1",0)));
		System.out.println("-------------------------");
		
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
	
	
	
		
		
		
		
     
	public static void main(String[] args) throws IOException {
		PaymentDetailsDaoImplTest pdd = (PaymentDetailsDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("paymentDetailsDaoImplTest");
		pdd.Test();
	}
	
}

