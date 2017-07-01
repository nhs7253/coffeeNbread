package com.cnb.dao;

import java.util.List;


import com.cnb.vo.ShoppingBasketProduct;

/*
 * 김형주
 * 2017-06-27
 * 생성, 초기구현
 */


public interface ShoppingBasketProductDao {

	
	/**
	 * 장바구니 목록 삭제 -productId가 끝날때까지  그 productId로 장바구니에 있는거 삭제 .- 서비스에서 처리
	 */
	 int deleteShoppingBasketProductByProductIdAndUserId(String productId,String userId);
	
	/**
	 * 장바구니 목록 등록 - productId가 끝날때까지 그 productId로 장바구니에 삽입.- 서비스에서 처리.
	 * @param productId
	 * @param userId
	 * @return
	 */
     int insertShoppingBasketProduct(ShoppingBasketProduct shoppingBasketProduct);	
	
    /**
     * 장바구니 목록중에서 제품개수 수정가능. 장바구니목록에서 개수 수정가능.
     * 개수 받아서 다시 수정하여 업데이트.
     * @param shoppingBasketProduct
     * @return
     */
     int updateShoppingBasketProductCount(ShoppingBasketProduct shoppingBasketProduct);
 		
          
     /**
      * 제품 이름 부분일치로 해당 제품의  장바구니 목록 조회( 1개만 조회)  - 서비스에서  제품아이디 같다면 둘이 합쳐서 count만 증가시키고 한컬럼만 보이게 할 계획
      * @param productId
      * @param userId
      * @return
      */
 	 ShoppingBasketProduct selectShoppingBasketProductByProductNameAndUserId (String productName,String userId);
     
 	 
 	 
 	 /**
 	  * 세션정보로 장바구니에 넣은정보를 세션이 아웃되기전까지 확인가능. 결제직전에 추가로 장바구니에 넣을수도있으니 필요가 있으니 확인 가능하게 할것.
 	  * @param userId
 	  * @return
 	  */
     List<ShoppingBasketProduct> selectShoppingBasketProductListByStoreIdAndUserId(String storeId,String userId);
     
     /**
      * productId로 productName select
      * @param productId
      * @return
      */
     String selectShoppingBasketProductNameByProductIdAndUserId(String productId,String userId);
     
     ShoppingBasketProduct selectShoppingBasketProductByProductIdAndUserId(String productId,String userId); 
     
     
     
     
}
