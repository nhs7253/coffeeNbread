package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnb.dao.ShoppingBasketProductDao;
import com.cnb.exception.EmptyShoppingBasketProductListByProductNameException;
import com.cnb.exception.EmptyShoppingBasketProductListException;
import com.cnb.exception.NoUpdateShoppingBasketProductException;
import com.cnb.service.ShoppingBasketProductService;
import com.cnb.vo.ShoppingBasketProduct;

/*
 * 김형주
 * 2017-07-01 생성
 */
@Service
public class ShoppingBasketProductServiceImpl implements ShoppingBasketProductService {
	@Autowired
	private ShoppingBasketProductDao shoppingBasketProductDao;

	/* 장바구니 테이블 조회 - 결제내역에 담긴것 조회하기위함. */
	@Override
	public List<ShoppingBasketProduct> findShoppingBasketProductList(String storeId, String userId) {
		return shoppingBasketProductDao.selectShoppingBasketProductList(storeId, userId);
	}

	/**
	 * userId와 해당 매장아이디로 단순 자신의 장바구니담은 목록들 조회하는것이므로 다른 조치 취할거 없음.
	 */
	@Override
	public List<ShoppingBasketProduct> findShoppingBasketProductListByStoreIdAndUserId(String storeId, String userId) {

		return shoppingBasketProductDao.selectShoppingBasketProductListByStoreIdAndUserId(storeId, userId);
	}

	/**
	 * 장바구니에서 수정할거라면 해당제품을 목록에 넣어두고 제품개수 수정.
	 * 
	 * @throws NoUpdateShoppingBasketProductException
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int modifyShoppingBasketProduct(ShoppingBasketProduct shoppingBasketProduct)
			throws NoUpdateShoppingBasketProductException {

		return shoppingBasketProductDao.updateShoppingBasketProductCount(shoppingBasketProduct);

	}

	/**
	 * 장바구니에서 제품아이디와 유저아이디로 장바구니 물품 삭제. 어차피 productId 하나당 한목록을 차지하기때문에 따로 서비스처리
	 * 할필요없음. 단순 작업.
	 */
	@Override
	public int deleteShoppingBasketProductByProductIdAndUserId(String productId, String userId) {

		return shoppingBasketProductDao.deleteShoppingBasketProductByProductIdAndUserId(productId, userId);
	}

	/**
	 * 세션끝나기전 제품목록으로가서 다시 장바구니목록에 추가 서비스 작업: 같은 제품을 또 몇개 추가하고싶을때 기존제품의 개수에서 추가
	 * 똑같은 제품을 여러 유저가 샀을수 있으므로 UserId 제품을 구하면 매장아이디를 비식별로 갖고있으므로 매장아이디도 참조할수있으므로
	 * ProductId
	 */
	@Override
	public void addShoppingBasketProduct(List<ShoppingBasketProduct> shoppingBasketProductList) {
		List<ShoppingBasketProduct> sbp = null;
		ShoppingBasketProduct selectedSbp = null;
		for (int i = 0; i < shoppingBasketProductList.size(); i++) {
			selectedSbp = shoppingBasketProductDao.selectShoppingBasketProductByProductIdAndUserId(
					shoppingBasketProductList.get(i).getProductId(), shoppingBasketProductList.get(i).getUserId());
			if (selectedSbp != null) {
				selectedSbp.setProductCount(
						selectedSbp.getProductCount() + shoppingBasketProductList.get(i).getProductCount());
				System.out.println(shoppingBasketProductDao.updateShoppingBasketProductCount(selectedSbp));
			} else {
				shoppingBasketProductDao.insertShoppingBasketProduct(shoppingBasketProductList.get(i));
			}

		}

	}

	@Override
	public int findShoppingBasketProductAllPrice(List<ShoppingBasketProduct> shoppingBasketProduct) {
		// TODO Auto-generated method stub
		return 0;
	}
}
