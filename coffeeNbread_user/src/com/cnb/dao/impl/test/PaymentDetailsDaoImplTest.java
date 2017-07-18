package com.cnb.dao.impl.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.PaymentDetailsDao;
import com.cnb.vo.PaymentDetails;

/*
 * 최민희
 * 2017-07-03
 * 추가
 */
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
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

		//매장에서 총 결제내역 조회
		System.out.println("최초 조회");
      /*  System.out.println(dao.selectPaymentDetailsListByUserIdAndStoreId("u-1", "s-1"));
*/
	
//    System.out.println( dao.selectPaymentDetailsListByUserId("u-1"));
        // 유저입장에서 장바구니에있는걸 결제내역 테이블에 넣을것.
	
        
		System.out.println(dao.findSelectPaymentDetailsListByUserId("test", 1, 10));
		 
		 
		 
		 
	  /* System.out.println(dao.insertPaymentDetails(new PaymentDetails(0, "c", new Date(), "f", 0, "u-1", "p-1", "s-1", 5)));
		 System.out.println(dao.insertPaymentDetails(new PaymentDetails(0, "p", new Date(), "r", 0, "u-1", "p-1", "s-1", 10)));
		try {
			System.out.println(dao.insertPaymentDetails(new PaymentDetails(0, "p", dt.parse("2017-07-04"), "r", 0, "u-3", "p-2", "s-1", 10)));
			System.out.println(dao.insertPaymentDetails(new PaymentDetails(0, "p", dt.parse("2017-07-04"), "f", 2, "u-4", "p-2", "s-1", 0)));
			System.out.println(dao.insertPaymentDetails(new PaymentDetails(0, "p", dt.parse("2017-07-04"), "f", 12, "u-4", "p-3", "s-1", 0)));
			System.out.println(dao.insertPaymentDetails(new PaymentDetails(0, "p", dt.parse("2017-07-05"), "f", 10, "u-4", "p-3", "s-1", 0)));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}*/

        
        
        
		/*System.out.println("-------------------------");
		
		
		System.out.println("selectPaymentDetailsListByStoreIdAndProductId");
		System.out.println(dao.selectPaymentDetailsListByStoreIdAndProductId("s-1", "p-1"));
		System.out.println("-------------------------");

		
		System.out.println("selectPaymentDetailsListByStoreIdAndTradeDate");
		try {
			System.out.println(dao.selectPaymentDetailsListByStoreIdAndTradeDate("s-1", dt.parse("2016-08-03")));
		} catch (ParseException e) {	
			System.out.println("이상발생");
		}
		
		System.out.println("-------------------------");
		
		System.out.println("selectPaymentDetailsListByStoreIdAndProductIdAndSellMethod");
		System.out.println(dao.selectPaymentDetailsListByStoreIdAndProductIdAndSellMethod("s-1", "p-1", "f"));
		
		
		System.out.println("-------------------------");
		System.out.println("selectPaymentDetailsListByStoreIdAndMethod");
		
		System.out.println("1주일");
		System.out.println(dao.selectPaymentDetailsListByStoreIdAndMethod("s-1", "1주일"));
		
		System.out.println("1개월");
		System.out.println(dao.selectPaymentDetailsListByStoreIdAndMethod("s-1", "1개월"));

		System.out.println("3개월");
		System.out.println(dao.selectPaymentDetailsListByStoreIdAndMethod("s-1", "3개월"));

		System.out.println("6개월");
		System.out.println(dao.selectPaymentDetailsListByStoreIdAndMethod("s-1", "6개월"));

		System.out.println("12개월");
		System.out.println(dao.selectPaymentDetailsListByStoreIdAndMethod("s-1", "12개월"));

		
		System.out.println("-------------------------");
		System.out.println("selectPaymentDetailsListByStoreIdAndMethodAndStartDateAndEndDate");
		try {
			System.out.println(dao.selectPaymentDetailsListByStoreIdAndMethodAndStartDateAndEndDate("s-1", dt.parse("2016-08-02"), dt.parse("2016-08-04")));
		} catch (ParseException e) {
			System.out.println("이상 발생");
		}
		
		System.out.println("--------------------------");
		System.out.println("selectPaymentDetailsListByStoreIdAndProductIdAndSellMethod");
		System.out.println(dao.selectPaymentDetailsListByStoreIdAndProductIdAndSellMethod("s-1", "p-1", "f"));
		
		System.out.println("--------------------------");
		System.out.println("selectPaymentDetailsListByStoreIdAndProductCategory");
		System.out.println(dao.selectPaymentDetailsListByStoreIdAndProductCategory("s-1", "빵"));
		
		System.out.println("--------------------------");
		System.out.println("selectPaymentDetailsListByStoreIdAndProductName");
		System.out.println(dao.selectPaymentDetailsListByStoreIdAndProductName("s-1", "제품3"));
		
		System.out.println("--------------------------");
		System.out.println("selectRecommendSalesVolumeByStoreIdAndTodayDateAndMethod - 종류");
		System.out.println(dao.selectRecommendSalesVolumeByStoreIdAndTodayDateAndMethod("s-1", "productCategory", "빵"));
		
		System.out.println("--------------------------");
		System.out.println("selectRecommendSalesVolumeByStoreIdAndTodayDateAndMethod - 이름");
		System.out.println(dao.selectRecommendSalesVolumeByStoreIdAndTodayDateAndMethod("s-1", "productName", "제품3"));
		
		System.out.println("--------------------------");
		System.out.println("selectTotalSalesVolumeFor7Days");
		try {
			System.out.println(dao.selectTotalSalesVolumeFor7Days("s-1", "빵", dt.parse((new Date().getYear()+1900) + "-" + (new Date().getMonth()+1) + "-" + new Date().getDate())));
		} catch (ParseException e) {
			System.out.println("이상 발견");
		}
		
		System.out.println("--------------------------");
		System.out.println("selectTotalSalesVolumeForAllDays");
		try {
			System.out.println(dao.selectTotalSalesVolumeForAllDays("s-1", "빵", dt.parse((new Date().getYear()+1900) + "-" + (new Date().getMonth()+1) + "-" + new Date().getDate())));
		} catch (ParseException e) {
			System.out.println("이상 발견");
		}
		
		
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");*/
	}
		
     
	public static void main(String[] args) throws IOException {
		PaymentDetailsDaoImplTest pdd = (PaymentDetailsDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("paymentDetailsDaoImplTest");
		pdd.Test();
	}
	
}

