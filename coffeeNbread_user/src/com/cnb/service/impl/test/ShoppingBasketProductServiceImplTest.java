package com.cnb.service.impl.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.exception.EmptyShoppingBasketProductListByProductNameException;
import com.cnb.exception.EmptyShoppingBasketProductListException;
import com.cnb.exception.NoUpdateShoppingBasketProductException;
import com.cnb.exception.UserManageException;
import com.cnb.service.ShoppingBasketProductService;
import com.cnb.vo.ShoppingBasketProduct;


/*
 * 김형주
 * 2017-07-01 
 * 초기 구현
 * 
 * 김형주  
 * 2017-07-01 
 * 생성
 */
@Component
public class ShoppingBasketProductServiceImplTest {

	@Autowired
	private ShoppingBasketProductService service;

	public void Test() throws UserManageException, EmptyShoppingBasketProductListException,
			EmptyShoppingBasketProductListByProductNameException, NoUpdateShoppingBasketProductException {
		System.out.println("-----------장바구니 목록 조회--------"); 
	System.out.println(service.findShoppingBasketProductListByStoreIdAndUserId("s-7","u-1"));
//
//		System.out.println("--------- 장바구니 목록중 제품명 부분일치해서 해당되는 장바구니 목록 리턴 ---------");
//		
 //    	System.out.println(service.findShoppingBasketProductByProductNameAndUserIdAndStoreId("20", "u-1", "s-7"));
//		
//			
//		
//
//		
//		System.out.println("---------장바구니 카운트개수 수정-------");  --테스트완료
//		
//		System.out.println(service.modifyShoppingBasketProduct(new ShoppingBasketProduct("u-1","s-7","p-18",15,"s-7")));
//	
//			
//		System.out.println("--------------장바구니 목록 삭제-----------"); --테스트 완료.
//		System.out.println(service.deleteShoppingBasketProductByProductIdAndUserId("p-1", "u-1"));
		
		
		System.out.println("-----------장바구니 등록 서비스--------------");                
		List<ShoppingBasketProduct> list=Arrays.asList(
				new ShoppingBasketProduct("u-1","s-7","p-18",500,"s-7"),
				new ShoppingBasketProduct("u-1","s-7","p-19",500,"s-7"),
				new ShoppingBasketProduct("u-1","s-7","p-20",500,"s-7"),
				new ShoppingBasketProduct("u-1","s-7","p-21",500,"s-7"),
				new ShoppingBasketProduct("u-2","s-7","p-22",500,"s-7")

				);
		  /*  
		     service.addShoppingBasketProduct(list);*/
			System.out.println("------------이상 없음----------------");
	}

	public static void main(String[] args) throws UserManageException, EmptyShoppingBasketProductListException,
			EmptyShoppingBasketProductListByProductNameException, NoUpdateShoppingBasketProductException {

		ShoppingBasketProductServiceImplTest sbp = (ShoppingBasketProductServiceImplTest) new ClassPathXmlApplicationContext(
				"com/cnb/config/spring/model-context.xml").getBean("shoppingBasketProductServiceImplTest");
	          sbp.Test();

	}
}
