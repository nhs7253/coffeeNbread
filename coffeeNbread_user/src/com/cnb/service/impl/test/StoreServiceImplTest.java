package com.cnb.service.impl.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnb.exception.DuplicatedStoreIdException;
import com.cnb.service.ProductService;
import com.cnb.service.StoreService;
import com.cnb.vo.OptionCategory;
import com.cnb.vo.Product;
import com.cnb.vo.Store;
import com.cnb.vo.StoreCategory;
import com.cnb.vo.StorePicture;

public class StoreServiceImplTest {
	public static void main(String[] args) throws Exception {
		// TODO ApplicationContext 객체 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml");

		// TODO Spring 컨테이너로 부터 ProductService bean 가져오기
		StoreService service = (StoreService) ctx.getBean("storeServiceImpl");

		// 매장 등록
		// 겹치는 거 없는 경우
		Store s1 = new Store("s-22", "매장이다", "매장소개다", "01011112222", "매장주소다", "매장이메일", new Date(), new Date(), "Y");

		StoreCategory sc1 = new StoreCategory();
		OptionCategory op1 = new OptionCategory();
		StorePicture sp1 = new StorePicture();
		try {
			// service.addProduct(p1);
			service.addStore(s1, sc1, op1, sp1); // PRIMARY KEY unique예외 처리해야함!
			// service.addProduct(p3);
			System.out.println("등록 성공");
		} catch (DuplicatedStoreIdException e) {
			System.err.println(e.getMessage());
		}
		/*
		// 매장 수정
		Store s2 = new Store("s-5", "매장수정이다", "매장소개다", "01011112222", "매장주소다", "매장이메일", new Date(), new Date(), "Y");

		service.modifyStore(s2);
		System.out.println("수정 성공");

		// 매장 조회
		System.out.println("==========조회==========");

		String storeId = "s-2";
		Store store = service.findStoreById(storeId);
		System.out.println(store);

		
		System.out.println("=======매장 삭제 ======");
		
		System.out.println(service.removeStoretById("s-3"));
		// 매장아이디로 매장사진 조회
		System.out.println("==========매장사진==========");

		List<Store> list1 = service.findStorePicture(storeId);

		for (Store storepicture : list1) {
			System.out.println(storepicture);
		}

		// 매장명으로 이벤트리스트 조회
		System.out.println("==========이벤트리스트==========");

		List<Store> eventlist = service.findStoreEventList(storeId);
		for (Store event : eventlist) {
			System.out.println(event);
		}

		// 매장명으로 매장카테고리 조회
		System.out.println("==========카테고리리스트==========");

		List<Store> categorylist = service.findStoreCategoryList(storeId);
		for (Store store2 : categorylist) {
			System.out.println(store2);
		}*/

		// 매장명으로 매장카테고리 조회
	/*	System.out.println("==========옵션 및 디테일==========");

		List<Store> optionlist = service.findOpionCategoryNDetailByIdList("s-2");
		for (Store store3 : optionlist) {
			System.out.println(store3);
		}
	*/
		System.out.println("-------------------완료 ---------------");
	}

}
