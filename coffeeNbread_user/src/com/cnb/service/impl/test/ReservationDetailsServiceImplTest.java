package com.cnb.service.impl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.service.ReservationDetailsService;
import com.cnb.vo.ReservationDetails;

/*
 * 최민희
 * 2017-07-02
 * 수정
 */
/*
 * 최민희
 * 2017-07-01
 * 생성
 */

public class ReservationDetailsServiceImplTest {
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		//TODO ApplicationContext 객체 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml");
		
		//TODO Spring 컨테이너로 부터 ProductService bean 가져오기
		ReservationDetailsService service =  (ReservationDetailsService)ctx.getBean("reservationDetailsServiceImpl");
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		
		//예약 내역 등록
		try {
			ReservationDetails reservationDetails = new ReservationDetails(0, dt.parse("2016-08-03"), 4, new Date(), dt.parse("2016-08-04"), "p-8", "s-2", "u-1");
			//service.addReservationDetails(reservationDetails);
		} catch (ParseException e) {
			System.out.println("이상 발생1");
		}
		System.out.println("이상 없음");
		
		//예약 내역 조회
		System.out.println("====================조회======================");
		int page = 1;
		
		//매장아이디 & 유저아이디로 예약정보 조회
		System.out.println("=================매장아이디 & 유저아이디====================");
		HashMap<String, Object> map1 = service.findReservationDetailsListByUserIdAndStoreId(page, "s-1", "u-1");

		Iterator iterator1 = map1.entrySet().iterator();
		while (iterator1.hasNext()) {
		   Entry entry1 = (Entry)iterator1.next();
		   if(entry1.getKey().equals("list")){
			   if(entry1.getValue() == null) {
				   System.out.println("s-1 매장에 u-1 유저의 예약 내역은 없습니다.");				   
			   }else{
				   System.out.println(entry1.getValue());				   
			   }
		   }
		}
		
		//유저아이디로 예약정보 조회
		System.out.println("=================유저아이디====================");
		HashMap<String, Object> map2 = service.findReservationDetailsListByUserId(page, "u-1");
		
		Iterator iterator2 = map2.entrySet().iterator();
		while (iterator2.hasNext()) {
		   Entry entry2 = (Entry)iterator2.next();
		   if(entry2.getKey().equals("list")){
			   if(entry2.getValue() == null) {
				   System.out.println("u-1 유저의 예약 내역은 없습니다.");				   
			   }else{
				   System.out.println(entry2.getValue());				   
			   }
		   }
		}
		
		//매장아이디 & 예약시간으로 예약정보 조회
		System.out.println("=================매장아이디 & 예약시간====================");
		try {
			HashMap<String, Object> map3 = service.findReservationDetailsListByStoreIdAndReservationTime(page, "s-1", dt.parse("2016-08-03"));
			
			Iterator iterator3 = map3.entrySet().iterator();
			while (iterator3.hasNext()) {
			   Entry entry3 = (Entry)iterator3.next();
			   if(entry3.getKey().equals("list")){
				   if(entry3.getValue() == null) {
					   System.out.println("s-1매장에 예약시간이 일치하는 예약 내역은 없습니다.");				   
				   }else{
					   System.out.println(entry3.getValue());				   
				   }
			   }
			}
		} catch (ParseException e) {
			System.out.println("이상 발생2");
		}

		//매장아이디로 예약정보 조회
		System.out.println("=================매장아이디====================");
		HashMap<String, Object> map4 = service.findReservationDetailsListByStoreId(page, "s-1");
		
		Iterator iterator4 = map4.entrySet().iterator();
		while (iterator4.hasNext()) {
		   Entry entry4 = (Entry)iterator4.next();
		   if(entry4.getKey().equals("list")){
			   if(entry4.getValue() == null) {
				   System.out.println("s-1 매장의 예약 내역은 없습니다.");				   
			   }else{
				   System.out.println(entry4.getValue());				   
			   }
		   }
		}
		
		//매장아이디 & 제품수령희망시간으로 예약정보 조회
		System.out.println("=================매장아이디 & 제품수령희망시간====================");
		try {
			HashMap<String, Object> map5 = service.findReservationDetailsListByStoreIdAndProductHopeTime(page, "s-1", dt.parse("2016-08-04"));
		
			Iterator iterator5 = map5.entrySet().iterator();
			while (iterator5.hasNext()) {
			   Entry entry5 = (Entry)iterator5.next();
			   if(entry5.getKey().equals("list")){
				   if(entry5.getValue() == null) {
					   System.out.println("s-1 매장에 제품수령희망시간이 일치하는 예약 내역은 없습니다.");				   
				   }else{
					   System.out.println(entry5.getValue());				   
				   }
			   }
			}
		} catch (ParseException e) {
			System.out.println("이상발생3");
		}
		
		
	
		
		
		
		
		
		
	}
}
