package com.cnb.service.impl.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnb.exception.DuplicatedProudctIdOrProductNameException;
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

		//제품 등록
		//겹치는 거 없는 경우
		Product p1 = new Product("p-30", "s-2", "제품30", 3000, "빵", "제품설명글30", "N", 100, 10);
		//제품 아이디 겹치는 경우
		Product p2 = new Product("p-2", "s-1", "제품33", 3000, "빵", "제품설명글33", "N", 100, 10);
		//제품 이름 겹치는 경우
		Product p3 = new Product("p-32", "s-2", "제품1", 3000, "빵", "제품설명글32", "N", 100, 10);

		try {
			//service.addProduct(p1);
			service.addProduct(p2);	//PRIMARY KEY unique예외 처리해야함!
			//service.addProduct(p3);
			System.out.println("등록 성공");
		} catch (DuplicatedProudctIdOrProductNameException e) {
			System.err.println(e.getMessage());
		}


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
		
		String storeId = "s-1";
		
		//제품 종류로 제품 조회
		System.out.println("==========제품 종류==========");
		String productCategory = "빵";
		List<Product> list1 = service.findProductListByCategory(storeId, productCategory);
		if(list1.size()==0){
			System.out.printf("%s 종류의 제품이 없습니다.", productCategory);
		}else{
			for(Product product : list1){
				System.out.println(product);
			}
		}
		
		//제품명으로 제품 조회
		System.out.println("==========제품명==========");
		String productName = "제품3";
		Product p5 = service.findProductByName(storeId, productName);
		if(p5 == null) {
			System.out.printf("%s 이름의 제품이 없습니다.", productName);
		}else System.out.println(p5);
		
		//제품 아이디로 제품 조회
		System.out.println("==========제품 아이디==========");
		String productId = "p-2";
		Product p6 = service.findProductById(storeId, productId);
		if(p6 == null) {
			System.out.printf("%s 아이디의 제품이 없습니다.", productId);
		}else System.out.println(p6);
		
		//판매 여부로 제품 조회
		System.out.println("==========판매 여부==========");
		String sellingOption = "Y";
		List<Product> list2 = service.findProductListBySellingOption(storeId, sellingOption);
		if(list2.size()==0){
			System.out.printf("판매여부가 %s인 제품이 없습니다.", sellingOption);
		}else{
			for(Product product : list2){
				System.out.println(product);
			}
		}
		
		//한 매장의 모든 제품 조회
		System.out.println("==========모든 종류==========");
		List<Product> list3 = service.findProductList(storeId);
		if(list3.size()==0){
			System.out.println("해당 매장에 제품이 없습니다.");
		}else{
			for(Product product : list3){
				System.out.println(product);
			}
		}
	}
}
