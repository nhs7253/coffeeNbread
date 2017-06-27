package com.cnb.dao.impl.test;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.ShoppingBasketProductDao;

/*
 * 노현식
 * 2017-06-27
 * 초기 구현
 * 
 * 노현식 
 * 2017-06-23 
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
    /*  System.out.println("장바구니 목록 조회");
      System.out.println(dao.selectProductByProductId("p-1"));*/
      
       
      System.out.println("장바구니 목록 삭제");
       System.out.println(dao.deleteProductByProductId("p-2"));
    
      
      
      System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
   }


   public static void main(String [] args){
	   ShoppingBasketProductDaoImplTest gudit = (ShoppingBasketProductDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("shoppingBasketProductDaoImplTest");
      gudit.Test();
       
   }
}