package com.cnb.dao.impl.test;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.ShoppingBasketProductDao;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.Product;
import com.cnb.vo.ShoppingBasketProduct;
import com.cnb.vo.Store;

/*
 * 김형주
 * 2017-06-27
 * 테스트 완료
 * 
 * 김형주
 * 2017-06-27 
 * 생성
 */
@Component
public class ShoppingBasketProductDaoImplTest {
   
   @Autowired
   private ShoppingBasketProductDao dao;
   
   public ShoppingBasketProductDaoImplTest() {
   }
   
   public ShoppingBasketProductDaoImplTest(ShoppingBasketProductDao dao) {
      this.dao = dao;
   }

   public void Test(){
	   
     System.out.println("--------장바구니 목록 조회------");
      System.out.println(dao.selectShoppingBasketProductList("s-7", "u-1"));
      
     System.out.println("------장바구니 목록 카운트 수정------");     
     System.out.println(dao.updateShoppingBasketProductCount(new ShoppingBasketProduct("u-1","s-7","p-1",100,"s-7") ));
     /* System.out.println("---------장바구니 목록 삭제------");
       System.out.println(dao.deleteShoppingBasketProductByProductIdAndUserId("p-20", "u-1"));
    
    */
   /*  System.out.println("--------- 장바구니 목록 등록-------");
      System.out.println(dao.insertShoppingBasketProduct(new ShoppingBasketProduct("u-1","s-7","p-20",10,"s-7"))); */
      
/*      System.out.println("----------제품이름으로 부분일치되는 장바구니 목록 조회");
      System.out.println(dao.selectShoppingBasketProductByProductNameAndUserId("4", "u-1"));
      
    
      System.out.println("----------장바구니 목록 리스트 조회-------");
      System.out.println(dao.selectShoppingBasketProductListByStoreIdAndUserId("s-1","u-1"));
      System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!"); 
      
      System.out.println("------------장바구니 이름 검색 By ProductId-------");  
      System.out.println(dao.selectShoppingBasketProductNameByProductIdAndUserId("p-1","u-1"));*/
   }


   public static void main(String [] args){
	   ShoppingBasketProductDaoImplTest sbpd = (ShoppingBasketProductDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("shoppingBasketProductDaoImplTest");
      sbpd.Test();
       
   }
}