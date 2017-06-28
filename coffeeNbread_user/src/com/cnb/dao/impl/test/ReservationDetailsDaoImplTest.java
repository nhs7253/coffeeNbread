package com.cnb.dao.impl.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.ReservationDetailsDao;
import com.cnb.vo.ReservationDetails;
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
	
	public ReservationDetailsDaoImplTest() {
	}
	
	public void examProductTest() {
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
		
		
		try {
			//dao.insertReservationDetails(new ReservationDetails(0, dt.parse("2017-06-27 08:00:00"), 10, dt.parse("2017-06-27 14:00:00"), dt.parse("2017-06-28 16:00:00"), "p-1", "m-1", "u-1"));
			//dao.insertReservationDetails(new ReservationDetails(0, dt.parse("2017-06-28 08:00:00"), 20, dt.parse("2017-06-28 14:00:00"), dt.parse("2017-06-28 16:00:00"), "p-2", "m-1", "u-1"));
			//dao.insertReservationDetails(new ReservationDetails(0, dt.parse("2017-06-29 08:00:00"), 20, dt.parse("2017-06-29 14:00:00"), dt.parse("2017-06-29 16:00:00"), "p-2", "m-1", "u-0"));
			System.out.println(dao.selectReservationDetailsByReservationTime("m-1", dt.parse("2017-06-28 08:00:00")));
		} catch (ParseException e) {
			System.out.println("이상발견");
		}
		//System.out.println(dao.selectReservationDetailsByUserId("m-1", "u-1"));
		System.out.println("이상없음");
	}
     
	public static void main(String[] args) throws IOException {
		ReservationDetailsDaoImplTest rdd = (ReservationDetailsDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("reservationDetailsDaoImplTest");
		rdd.examProductTest();
	}
	
}

