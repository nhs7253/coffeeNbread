package com.cnb.dao;

import java.util.List;


import com.cnb.vo.ShoppingBasketProduct;
import com.cnb.vo.StoreVisitHistory;

/*김형주
 * 2017-07-02
 * 수정.
 * 
 * 
 * 김형주
 * 2017-06-27
 * 생성, 초기구현
 */


public interface ShoppingBasketProductDao {

	
	
	
	   /**
     * 매장아이디와 유저아이디로 단순 장바구니테이블조회- > 결제내역테이블에 쓰이기 위해.
     * 
     * @param storeId
     * @param userId
     * @return
     */
    List<ShoppingBasketProduct> selectShoppingBasketProductList(String storeId,String userId);
	
    
    /**
	  * 세션정보로 장바구니에 넣은정보를 세션이 아웃되기전까지 확인가능. 결제직전에 추가로 장바구니에 넣을수도있으니 필요가 있으니 확인 가능하게 할것.
	  * @param userId
	  * @return
	  */
    List<ShoppingBasketProduct> selectShoppingBasketProductListByStoreIdAndUserId(String storeId,String userId);
    
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
      * 유저아이디와 제품아이디로 장바구니목록 조회.
      * 
      * @param productId
      * @param userId
      * @return
      */
     ShoppingBasketProduct selectShoppingBasketProductByProductIdAndUserId(String productId,String userId); 
    
     
     
     /*---------------------------------------------페이징 ----------------------------------------*/
     /**
     * 유저가 매장에 넣은 장바구니 목록 개수조회 - int 형
     * @param userId
     * @param storeId
     * @return
     */
 	int selectShoppingBasketProductCountForPagingCount(String userId, String storeId,int startIndex, int endIndex );
	
 	   
 	int selectShoppingBasketProductCountForPagingToProductCategoryCount(String userId,String storeId, String productCategory,int startIndex, int endIndex);
 	

 	List<ShoppingBasketProduct> selectShoppingBasketProductListForPaging(String userId,String storeId, int startIndex, int endIndex);


 	List<ShoppingBasketProduct> selectShoppingBasketProductListForPagingToProductCategory(String userId,String storeId, String productCategory, int startIndex, int endIndex);

}
