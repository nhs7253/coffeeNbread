package com.cnb.dao.impl.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.StorePaymentOptionListDao;
import com.cnb.vo.StorePaymentOptionList;

/*
 * 김형주
 * 2017-06-29 
 * 
 */
@Component
public class StorePaymentOptionListDaoImplTest {

	@Autowired
	private StorePaymentOptionListDao dao;
	
	private StorePaymentOptionListDaoImplTest(StorePaymentOptionListDao dao){
		this.dao = dao;
	}
	
	public void examTest() {
		System.out.println("---------매장별 결제 수단 조회----------");
		System.out.println(dao.selectStorePaymentOptionListByStoreId("s-10000000"));
		
		System.out.println(dao.insertStorePaymentOptionList(new StorePaymentOptionList("qqq", "A")));
		
		
		/*System.out.println("----------예약만 가능했던 s-4 매장 현금 기능 추가 ----------");
		System.out.println(dao.insertStorePaymentOptionList(new StorePaymentOptionList("s-4","p",new PaymentOptionList("p","현금"))));*/
		
		/*System.out.println("----------카드와 현금이 모두 가능했던 s-1 매장을  현금기능 삭제 ---------");
		System.out.println(dao.deleteStorePaymentOptionListByStoreIdAndPaymentId("s-1", "p")); */
	/*	
		System.out.println(dao.insertStorePaymentOptionList(new StorePaymentOptionList("erreg","M")));
		System.out.println("이상없음");*/
	}
     
	public static void main(String[] args) throws IOException {
		StorePaymentOptionListDaoImplTest spod = (StorePaymentOptionListDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("storePaymentOptionListDaoImplTest");
		spod.examTest();
	}
}