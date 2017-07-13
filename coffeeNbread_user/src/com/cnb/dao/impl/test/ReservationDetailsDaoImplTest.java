package com.cnb.dao.impl.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.PaymentDetailsDao;
import com.cnb.dao.ReservationDetailsDao;
import com.cnb.vo.ReservationDetails;

/*
 * 최민희
 * 2017-07-02 수정
 */
/*
 * 최민희
 * 2017-06-29 수정
 */
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
	
	@Autowired
	private PaymentDetailsDao pdDao;
	
	public void Test() {
		
		  
		System.out.println(dao.selectReservationDetailsListByUserId("u-1", 1, 1000));
		
		
/*
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("유저가 예약 내역 삽입"); 
		System.out.println(pdDao.selectPaymentDetailsByStoreIdAndProductId("s-7", "p-18"));
		System.out.println("거래날짜:"+pdDao.selectPaymentDetailsByStoreIdAndProductId("s-7", "p-18").getTradeDate());
		System.out.println("거래개수:"+pdDao.selectPaymentDetailsByStoreIdAndProductId("s-7", "p-18").getReservationOrderCount());

		System.out.println(dao.updateReservationConfirmDate
				(new ReservationDetails(0,pdDao.selectPaymentDetailsByStoreIdAndProductId("s-7", "p-18").getTradeDate(),
						pdDao.selectPaymentDetailsByStoreIdAndProductId("s-7", "p-18").getReservationOrderCount(),new Date(),new Date(),"p-18","s-7","u-1")));
		
*/		/*System.out.println("===============Count===================");
		System.out.println("매장의 전체 예약수 : " + dao.selectReservationDetailsListCountByStoreId("s-1"));
		System.out.println("유저의 전체 예약수 : " + dao.selectReservationDetailsListCountByUserId("u-1"));
		System.out.println("매장에서 유저아이디로 조회한 에약 수 : " + dao.selectReservationDetailsListCountByMethod("s-1", "userId", "u-1"));
		System.out.println("매장에서 예약시간으로 조회한 예약 수 : " + dao.selectReservationDetailsListCountByMethod("s-1", "reservationTime", "2016-08-04"));
		System.out.println("매장에서 제품수령희망시간으로 조회한 예약 수 : " + dao.selectReservationDetailsListCountByMethod("s-1", "productHopeTime", "2016-08-04"));
		
		System.out.println("===============List==================");

		System.out.println("------------------------------------------------------------------");
        System.out.println("매장에서 유저아이디로 조회");
        List list1 = dao.selectReservationDetailsListByUserIdAndStoreId("s-1", "u-1", 1, 4);
        for(int i=0; i<list1.size(); i++) {
        	System.out.println(list1.get(i));
        }
	
		System.out.println("---------------------------------------------------------------");
		System.out.println("유저입장에서 조회");
		List list2 = dao.selectReservationDetailsListByUserId("u-1", 1, 4);
        for(int i=0; i<list2.size(); i++) {
        	System.out.println(list2.get(i));
        }
        
		System.out.println("---------------------------------------------------------------");
		System.out.println("매장에서 예약시간으로 조회");  // new Date()로 해놨기떄문에 Test돌리는 시점에 예약한게 내역이없으므로 없게 나오는게 정상 
        List list3;
		try {
			list3 = dao.selectReservationDetailsListByStoreIdAndReservationTime("s-1", dt.parse("2016-08-03"), 1, 4);
	        for(int i=0; i<list3.size(); i++) {
	        	System.out.println(list3.get(i));
	        }
		} catch (ParseException e1) {
			System.out.println("이상발견");
			e1.printStackTrace();
		}

		
		System.out.println("---------------------------------------------------------------");
		System.out.println("매장아이디로 조회");
        List list4 = dao.selectReservationDetailsListByStoreId("s-1", 1, 4);
        for(int i=0; i<list4.size(); i++) {
        	System.out.println(list4.get(i));
        }
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("매장에서 제품희망수령시간으로 조회");
		try {
	        List list5 = dao.selectReservationDetailsListByStoreIdAndProductHopeTime("s-1", dt.parse("2016-08-04"), 1, 4);
	        for(int i=0; i<list5.size(); i++) {
	        	System.out.println(list5.get(i));
	        }
		} catch (ParseException e) {
			System.out.println("이상발견");
		}*/
		
		
	}
		
	public static void main(String[] args) throws IOException {
		ReservationDetailsDaoImplTest rdd = (ReservationDetailsDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("reservationDetailsDaoImplTest");
		rdd.Test();
	}
	
}

