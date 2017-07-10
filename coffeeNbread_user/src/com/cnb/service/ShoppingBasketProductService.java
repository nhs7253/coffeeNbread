package com.cnb.service;

import java.util.List;

import com.cnb.exception.NoUpdateShoppingBasketProductException;
import com.cnb.exception.addShoppingCountZeroException;
import com.cnb.vo.ShoppingBasketProduct;

/*
 * 김형주
 * 2017-06-30
 * 생성
 */
public interface ShoppingBasketProductService {

	
	/**
	 * 장바구니 테이블에 무엇이 들어있는지 확인용. -> 결제 내역으로 넘어갈때 조회하기위함.
	 * @param storeId
	 * @param userId
	 * @return
	 */
	
	List<ShoppingBasketProduct> findShoppingBasketProductList(String storeId,String userId);
	
	/**
	 * 내가 보여줄 장바구니 목록 리스트로 조회 -유저아이디와 매장아이디로 장바구니 목록 리스트 조회
	 * @param userId
	 * @return
	 */
	List<ShoppingBasketProduct> findShoppingBasketProductListByStoreIdAndUserId(String storeId,String userId);
	
		
	/**
	 * 장바구니 목록에 넣은 제품들  개수 늘릴수 있게 함.-장바구니 목록에서의 수정사항은 개수뿐. 이거 제외하고는 삭제를 해야함.
	 * @param shoppingBasketProduct
	 * @return
	 */
	int modifyShoppingBasketProduct(ShoppingBasketProduct shoppingBasketProduct)throws NoUpdateShoppingBasketProductException;

		
	/**
	 * 장바구니 목록에 제품아이디와 유저아이디로  제품 삭제.
	 * @param productId
	 * @param userId
	 * @return
	 */
	int deleteShoppingBasketProductByProductIdAndUserId(String productId, String userId);
	
	
	
	
	void addShoppingBasketProduct(ShoppingBasketProduct shoppingBasketProduct)throws addShoppingCountZeroException;
	
	
	
   /*
	void addShoppingBasketProductList(List<ShoppingBasketProduct> shoppingBasketProduct);
	*/
    
	/**
	 * 장바구니에서 결제페이지로 이동 누를때 장바구니목록 리스트들 가져가서 목록에있는 전체  총가격 구하기.
	 * @param shoppingBasketProduct
	 * @return
	 */
	 int findAllProductPrice(String storeId,String userId);

	 
	 /**
	  * 장바구니에서 제품별 제품가격 * 제품개수 구하기
	  * 
	  */
	 int findProductPrice(String storeId,String userId,String productId);
	 
}
