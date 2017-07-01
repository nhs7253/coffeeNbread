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
	 * 장바구니 목록 리스트로 조회 -유저아이디와 매장아이디로 장바구니 목록 리스트 조회
	 * @param userId
	 * @return
	 */
	List<ShoppingBasketProduct> findShoppingBasketProductListByStoreIdAndUserId(String storeId,String userId);
	
	/**
	 *  장바구니에 여러개 넣어서 페이징 했을때 제품 이름으로 부분검색.
	 * @param productName
	 * @param userId
	 * @return
	 * @throws EmptyShoppingBasketProductListByProductNameException 
	 * @throws EmptyShoppingBasketProductListException 
	 */
	ShoppingBasketProduct findShoppingBasketProductByProductNameAndUserIdAndStoreId(String productName,String userId,String storeId)throws EmptyShoppingBasketProductListException, EmptyShoppingBasketProductListByProductNameException;
	
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
}
