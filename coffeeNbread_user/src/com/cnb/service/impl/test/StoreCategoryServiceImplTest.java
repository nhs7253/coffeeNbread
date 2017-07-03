package com.cnb.service.impl.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnb.exception.DuplicatedStoreCategorytNameException;
import com.cnb.exception.DuplicatedStoreIdException;
import com.cnb.service.StoreCategoryService;
import com.cnb.vo.Store;
import com.cnb.vo.StoreCategory;

public class StoreCategoryServiceImplTest {
	public static void main(String[] args) {
		

	// TODO ApplicationContext 객체 생성
			ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml");

			// TODO Spring 컨테이너로 부터 ProductService bean 가져오기
			StoreCategoryService service = (StoreCategoryService) ctx.getBean("storeCategoryServiceImpl");

			// 매장 카테고리 
			// 겹치는 거 없는 경우 + 겹칠때 예외처리
			
			/*StoreCategory sc1=new StoreCategory(3, "빵집", "s-2");
			
			try {
				
				service.addStoreCategory(sc1); 
				// service.addProduct(p3);
				System.out.println("등록 성공");
			} catch (DuplicatedStoreCategorytNameException e) {
				System.err.println(e.getMessage());
			}

			// 매장카테고리 수정
			StoreCategory sc2 = new StoreCategory(3,"커피집","s-2");
			System.out.println(service.modifyStoreCategory(sc2));
			System.out.println("수정 성공");
		*/
			System.out.println("==매장삭제==");
			System.out.println(service.removeStoreCategoryByNo("s-2",4));
			
			System.out.println("-------------------완료 ---------------");
		}
}
