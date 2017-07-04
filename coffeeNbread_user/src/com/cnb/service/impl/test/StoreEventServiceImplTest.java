package com.cnb.service.impl.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnb.exception.ProductNotFoundException;
import com.cnb.service.StoreEventService;
import com.cnb.vo.EventProduct;
import com.cnb.vo.OptionDetail;
import com.cnb.vo.Product;
import com.cnb.vo.StoreEvent;

public class StoreEventServiceImplTest {
	public static void main(String[] args) throws Exception {
		//TODO ApplicationContext 객체 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml");
		
		//TODO Spring 컨테이너로 부터 bean 가져오기
		StoreEventService service =  (StoreEventService)ctx.getBean("storeEventServiceImpl");

		EventProduct ep1 = new EventProduct("p-1", "s-2",2);
	/*	
		//매장 이벤트 등록 + 이벤트 제품 등록
		
		StoreEvent se1 = new StoreEvent(2,"이벤트 제목3",new Date(),new Date(),"Y","이벤트 상세","Y",30,"사진","Y","Y","s-2");
		
		System.out.println(se1);
		System.out.println(service.addStoreEvent(se1, ep1));
		System.out.println("등록 완료 ");
*/
		
		//매장 이벤트 수정 + 전 이벤트 제품 목록에서 삭제...? +이벤트 제품 수정
		StoreEvent se2  = new StoreEvent(2,"이벤트 제목1수정",new Date(),new Date(),"Y","이벤트 상세","Y",20,"사진","Y","Y","s-2");
		EventProduct ep2 = new EventProduct("p-6", "s-2", 2);
		System.out.println(service.modifyStoreEvent(se2, ep2, ep1));
		
		//이벤트 목록 조회
		System.out.println("==목록조회==");
		System.out.println(service.findStoreEventList("s-2"));
	
	}
}
