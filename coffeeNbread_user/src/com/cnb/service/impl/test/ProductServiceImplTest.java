package com.cnb.service.impl.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnb.service.ProductService;
import com.cnb.vo.Product;

/*
 * 최민희
 * 2017-06-30
 * 생성
 */
public class ProductServiceImplTest {
	public static void main(String[] args) throws Exception {
		//TODO ApplicationContext 객체 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml");
		
		//TODO Spring 컨테이너로 부터 ProductService bean 가져오기
		ProductService service =  (ProductService)ctx.getBean("productServiceImpl");

/*		//제품 등록
		//겹치는 거 없는 경우
		Product p1 = new Product("p-30", "s-2", "제품30", 3000, "빵", "제품설명글30", "N", 100, 10);
		//제품 아이디 겹치는 경우
		Product p2 = new Product("p-2", "s-1", "제품33", 3000, "빵", "제품설명글33", "N", 100, 10);
		//제품 이름 겹치는 경우
		Product p3 = new Product("p-32", "s-2", "제품1", 3000, "빵", "제품설명글32", "N", 100, 10);

		try {
			//service.addProduct(p1);
			service.addProduct(p2);
			//service.addProduct(p3);
			System.out.println("등록 성공");
		} catch (DuplicatedProudctIdOrProductNameException e) {
			System.err.println(e.getMessage());
		}
*/
		
/*		
		//제품 수정
		Product p4 = new Product("p-30", "s-2", "제품31", 4000, "빵", "제품설명글31", "N", 150, 20);
		try {
			service.modifyProduct(p4);
			System.out.println("수정 성공");
		}catch(ProductNotFoundException e) {
			System.err.println(e.getMessage());
		}
*/
		
		//제품 조회
		System.out.println("==========조회==========");
		
		int page = 1;
		String storeId = "s-1";
		
		//제품 종류로 제품 조회
		System.out.println("==========제품 종류==========");
		String productCategory = "빵";
		HashMap<String, Object> map1 = service.findProductListByCategory(page, storeId, productCategory);
		Iterator iterator1 = map1.entrySet().iterator();
		
		while (iterator1.hasNext()) {
		   Entry entry1 = (Entry)iterator1.next();
		   if(entry1.getKey().equals("list")){
			   if(entry1.getValue() == null) {
				   System.out.printf("%s 종류의 제품이 없습니다.", productCategory);
				   System.out.println();
			   }else{
				   System.out.println(entry1.getValue());				   
			   }
		   	}
		}	
		
		
		//제품명으로 제품 조회
		System.out.println("==========제품명==========");
		String productName = "제품3";
		Product p5 = service.findProductByName(storeId, productName);
		if(p5 == null) {
			System.out.printf("%s 이름의 제품이 없습니다.", productName);
			System.out.println();
		}else System.out.println(p5);
		
		//제품 아이디로 제품 조회
		System.out.println("==========제품 아이디==========");
		String productId = "p-2";
		Product p6 = service.findProductById(storeId, productId);
		if(p6 == null) {
			System.out.printf("%s 아이디의 제품이 없습니다.", productId);
			System.out.println();
		}else System.out.println(p6);
		
		//판매 여부로 제품 조회
		System.out.println("==========판매 여부==========");
		String sellingOption = "Y";
		HashMap<String, Object> map2 = service.findProductListBySellingOption(page, storeId, sellingOption);
		Iterator iterator2 = map2.entrySet().iterator();
	

		while (iterator2.hasNext()) {
		   Entry entry2 = (Entry)iterator2.next();
		   if(entry2.getKey().equals("list")){
			   if(entry2.getValue() == null) {
				   System.out.printf("판매여부가 %s인 제품이 없습니다.", sellingOption);
				   System.out.println();
			   }else{
				   System.out.println(entry2.getValue());
			   }
		   }
		}	
		
		
		//한 매장의 모든 제품 조회
		System.out.println("==========모든 종류==========");
		HashMap<String, Object> map3 = service.findProductList(page, storeId);
		Iterator iterator3 = map3.entrySet().iterator();

		while (iterator3.hasNext()) {
		   Entry entry3 = (Entry)iterator3.next();
		   if(entry3.getKey().equals("list")){
			   if(entry3.getValue() == null) {
				   System.out.println("해당 매장에 제품이 없습니다.");
			   }else{
				   System.out.println(entry3.getValue());
			   }
		   }
		}
	}
}
