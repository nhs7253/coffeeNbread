package com.cnb.service.impl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnb.service.SalesVolumeService;
import com.cnb.vo.PaymentDetails;

/*
 * 최민희
 * 2017-07-04
 * 수정
 */
/*
 * 최민희
 * 2017-07-03
 * 생성
 */
public class SalesVolumeServiceImplTest {
	public static void main(String[] args) {
		//TODO ApplicationContext 객체 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml");
		
		//TODO Spring 컨테이너로 부터 ProductService bean 가져오기
		SalesVolumeService service =  (SalesVolumeService)ctx.getBean("salesVolumeServiceImpl");
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
	
		System.out.println("===================조회=================");
		System.out.println("------오늘------");
		try {
			List<PaymentDetails> list1 = service.findSalesVolumeByStoreIdAndTodayDate("s-1", dt.parse((new Date().getYear()+1900) + "-" + (new Date().getMonth()+1) + "-" + new Date().getDate()));
			if(list1.size() == 0) {
				System.out.println("오늘 판매량은 없습니다.");
			}else {
				System.out.println(list1);
			}
		} catch (ParseException e) {
			System.out.println("이상 발견1");
		}

		System.out.println("------1개월-------");
		List<PaymentDetails> list2 = service.findSalesVolumeByStoreIdAndMethod("s-1", "1개월");
		if(list2.size() == 0) {
			System.out.println("1개월 동안 판매량은 없습니다.");
		}else {
			System.out.println(list2);
		}
		
		
		System.out.println("------3개월-------");
		List<PaymentDetails> list3 = service.findSalesVolumeByStoreIdAndMethod("s-1", "3개월");
		if(list3.size() == 0) {
			System.out.println("3개월 동안 판매량은 없습니다.");
		}else {
			System.out.println(list3);
		}
		
		System.out.println("------6개월-------");
		List<PaymentDetails> list4 = service.findSalesVolumeByStoreIdAndMethod("s-1", "6개월");
		if(list4.size() == 0) {
			System.out.println("6개월 동안 판매량은 없습니다.");
		}else {
			System.out.println(list4);
		}
		
		System.out.println("------12개월-------");
		List<PaymentDetails> list5 = service.findSalesVolumeByStoreIdAndMethod("s-1", "12개월");
		if(list5.size() == 0) {
			System.out.println("12개월 동안 판매량은 없습니다.");
		}else {
			System.out.println(list5);
		}
		
		System.out.println("------직접 지정-------");
		try {
			List<PaymentDetails> list6 = service.findSalesVolumeByStoreIdAndStoreIdAndMethodAndStartDateAndEndDate("s-1", dt.parse("2016-08-04"), dt.parse("2017-07-04"));
			if(list6.size() == 0) {
				System.out.println("오늘 판매량은 없습니다.");
			}else {
				System.out.println(list6);
			}
		} catch (ParseException e) {
			System.out.println("이상 발견6");
		} 
		
		System.out.println("------제품 종류------");
		List list7 = service.findSalesVolumeByStoreIdAndProductCategory("s-1", "빵");
		System.out.println(list7);
		
		System.out.println("------제품명------");
		List list8 = service.findSalesVolumeByStoreIdAndProductName("s-1", "제품1");
		System.out.println(list8);

		System.out.println("------예상생산량 (제품종류)------");
		System.out.println(service.findRecommendSalesVolumeByStoreIdAndTodayDateAndMethod("s-1", "productCategory", "빵"));
		
		System.out.println("------예상생산량 (제품명)------");
		System.out.println(service.findRecommendSalesVolumeByStoreIdAndTodayDateAndMethod("s-1", "productName", "제품3"));

		System.out.println("-----비율 비교 후 상승/하락세 정보 update-----");
		try {
			service.findTotalSalesVolumeByStoreIdAndProductCategoryAndTodayDate("s-1", "빵", dt.parse("2017-07-05"));
		} catch (ParseException e) {
			System.out.println("이상 발생");
		}
	}
}
