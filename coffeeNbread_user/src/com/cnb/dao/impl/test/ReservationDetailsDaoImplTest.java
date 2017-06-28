package com.cnb.dao.impl.test;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.ReservationDetailsDao;
import com.cnb.vo.ReservationDetails;
/*
 * 김형주
 * 2017-06-28 기능 추가후 수정.
 * 
 */
/*
 * 최민희
 * 2017-06-28 수정
 */
/*
 * 최민희
 * 2017-06-27 생성
 */
@Component
public class ReservationDetailsDaoImplTest {

	@Autowired
	private ReservationDetailsDao dao;
	
	private ReservationDetailsDaoImplTest(ReservationDetailsDao dao){
		this.dao = dao;
	}
	
	
	public void Test() {
	//  민희가 한부분 일단 주석 처리함.	
		//SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
		

		/*try {
			//dao.insertReservationDetails(new ReservationDetails(0, dt.parse("2017-06-27 08:00:00"), 10, dt.parse("2017-06-27 14:00:00"), dt.parse("2017-06-28 16:00:00"), "p-1", "m-1", "u-1"));
			//dao.insertReservationDetails(new ReservationDetails(0, dt.parse("2017-06-28 08:00:00"), 20, dt.parse("2017-06-28 14:00:00"), dt.parse("2017-06-28 16:00:00"), "p-2", "m-1", "u-1"));
			//dao.insertReservationDetails(new ReservationDetails(0, dt.parse("2017-06-29 08:00:00"), 20, dt.parse("2017-06-29 14:00:00"), dt.parse("2017-06-29 16:00:00"), "p-2", "m-1", "u-0"));
			System.out.println(dao.selectReservationDetailsByReservationTime("m-1", dt.parse("2017-06-28 08:00:00")));
=======
		
		try {
			System.out.println(dao.selectReservationDetailsByReservationTime("s-1", dt.parse("2017-06-28 08:00:00")));
>>>>>>> branch 'master' of https://github.com/nhs7253/coffeeNbread.git
		} catch (ParseException e) {
			System.out.println("이상발견");
		}
		//System.out.println(dao.selectReservationDetailsByUserId("s-1", "u-1"));
		System.out.println("이상없음");
	}*/
		System.out.println("매장에서 유저 예약시간으로 예약내역 조회");  /* new Date()로 해놨기떄문에 Test돌리는 시점에 예약한게 내역이없으므로 없게 나오는게 정상 */
		System.out.println(dao.selectReservationDetailsListByReservationTime("s-1", new Date()));

		
		System.out.println("유저가 예약 내역 삽입");
		System.out.println(dao.insertReservationDetails(new ReservationDetails(0,new Date(),4,new Date(),new Date(),"p-1","s-1","u-1")));
		
		System.out.println("------------------------------------------------------------------");
         System.out.println("매장입장에서 유저예약내역 확인하고자 할때");
       	System.out.println(dao.selectReservationDetailsListByUserIdAndStoreId("s-1", "u-1"));
		
		
		/* 김형주- 6.29 dao 기능 추가- */
		System.out.println("---------------------------------------------------------------");
		  System.out.println("유저입장에서 예약내역 조회");
		System.out.println(dao.selectReservationDetailsListByUserId("u-1"));
		
	}
		
		
	public static void main(String[] args) throws IOException {
		ReservationDetailsDaoImplTest rdd = (ReservationDetailsDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("reservationDetailsDaoImplTest");
		rdd.Test();
	}
	
}

