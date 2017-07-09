package com.cnb.service.impl.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnb.service.ProductGapService;

/*
 * 최민희
 * 2017-07-03
 * 생성
 */
public class ProductGapServiceImplTest {
	public static void main(String[] args) {
		//TODO ApplicationContext 객체 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml");
		
		//TODO Spring 컨테이너로 부터 ProductService bean 가져오기
		ProductGapService service =  (ProductGapService)ctx.getBean("productGapServiceImpl");
		
		
		//제품 증감폭 등록
		System.out.println("=============등록============");
		//service.addProductGap(new ProductGap("U", "3", "p-3", "s-1"));
		
		
		//제품 증감폭 수정
		System.out.println("=============수정=============");
		//service.modifyProductGap(new ProductGap("D", "5", "p-9", "s-3"));
		
		//제품 증감폭 조회
		System.out.println("=============조회==============");
		int page = 1;
		
		//매장 전체 제품의 증감폭 조회
		System.out.println("============매장전체=============");
		HashMap<String, Object> map1 = service.findProductGapListByStoreId(page, "s-1");

		Iterator iterator1 = map1.entrySet().iterator();
		while (iterator1.hasNext()) {
		   Entry entry1 = (Entry)iterator1.next();
		   if(entry1.getKey().equals("list")){
			   if(entry1.getValue() == null) {
				   System.out.println("s-1 매장에 제품 증감폭이 없습니다.");				   
			   }else{
				   System.out.println(entry1.getValue());				   
			   }
		   }
		}
		
		//식별코드로 매장 제품의 증감폭 조회
		System.out.println("============식별코드=============");
		HashMap<String, Object> map2 = service.findProductGapListByIdentifyCodeByStoreIdAndIdentifyCode(page, "s-1", "D");
		
		Iterator iterator2 = map2.entrySet().iterator();
		while (iterator2.hasNext()) {
		   Entry entry2 = (Entry)iterator2.next();
		   if(entry2.getKey().equals("list")){
			   if(entry2.getValue() == null) {
				   System.out.println("s-1 매장에 제품 증감폭이 없습니다.");				   
			   }else{
				   System.out.println(entry2.getValue());				   
			   }
		   }
		}
		
		System.out.println("이상 없음");
	}
}
