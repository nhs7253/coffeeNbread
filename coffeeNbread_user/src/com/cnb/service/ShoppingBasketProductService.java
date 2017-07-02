package com.cnb.service;

import java.util.List;

import com.cnb.exception.EmptyShoppingBasketProductListByProductNameException;
import com.cnb.exception.EmptyShoppingBasketProductListException;
import com.cnb.exception.NoUpdateShoppingBasketProductException;
import com.cnb.vo.Product;
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
	
	
	/**
	 * 	  장바구니 목록에 여러 제품 추가 - 결제직전 제품목록으로 가서 다시 추가할수 있게 하기위해.
     *                                          제품 아이디 같은걸 조회할떄는 비교해서 넣고 , 다른걸 넣을떄는 바로등록.
	 * @param shoppingBasketProduct
	 * @return
	 */
	void addShoppingBasketProduct(List<ShoppingBasketProduct> shoppingBasketProduct);
	
	
	

    /**
     * 장바구니 목록에 있는 제품들 총가격- 결제 내역창 보여줄때  총가격 보여주기위해 쿼리 미리 짜놓음.
     */
     
     int findShoppingBasketProductAllPrice(List<ShoppingBasketProduct> shoppingBasketProduct);

}
