package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnb.dao.ShoppingBasketProductDao;
import com.cnb.exception.NoUpdateShoppingBasketProductException;
import com.cnb.exception.addShoppingCountZeroException;
import com.cnb.service.ShoppingBasketProductService;
import com.cnb.util.PagingBean;
import com.cnb.vo.NoticeBoardContents;
import com.cnb.vo.Product;
import com.cnb.vo.ShoppingBasketProduct;

/*
 * 김형주
 * 2017-07-01 생성
 */
@Service
public class ShoppingBasketProductServiceImpl implements ShoppingBasketProductService {
	@Autowired
	private ShoppingBasketProductDao shoppingBasketProductDao;

	/**
	 * 단순히 장바구니 테이블에 담긴것.
	 */
	@Override
	public List<ShoppingBasketProduct> findShoppingBasketProductList(String storeId, String userId) {
		return shoppingBasketProductDao.selectShoppingBasketProductList(storeId, userId);
	}

	/**
	 * userId와 해당 매장아이디로 단순 자신의 장바구니담은 목록들 조회(제품사진, 매장, 제품 과 조인)
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
	 * 유저가 매장에 들어와서 제품별로 장바구니 버튼눌렀을때 장바구니 목록에 등록 과정. // 만약 기존에 내가 장바구니 목록에 넣어둔게
	 * 있다면 안됨. 추후 작업: 예약확인에서 유저가 매장에서 예약한 내역에서 예약확인유무 날짜가 만약 null이라면 개수 추가 만약
	 * 예약확인유무 날짜가있다면 내가 새로등록하려는 제품개수그대로 반영.
	 * 
	 * @throws addShoppingCountZeroException
	 */
	@Override
	public void addShoppingBasketProduct(ShoppingBasketProduct shoppingBasketProduct)
			throws addShoppingCountZeroException {

		// shoppingBasketProduct에는 userid, storeId,productStoreId(권한으로 세션처리함),
		// 제품, 제품개수등등 세션에서 가져옴

		System.out.println("addShoppingBasketProduct = " + shoppingBasketProduct);

		// shoppingBasketProductDao.insertShoppingBasketProduct(shoppingBasketProduct);

		// 유저가 매장에서 등록한 장바구니 목록들.

		// 유저가 매장에서 그 제품을 넣었냐 라고 물어봐야함.
		ShoppingBasketProduct sbp = shoppingBasketProductDao.selectShoppingBasketProductByProductId(
				shoppingBasketProduct.getUserId(), shoppingBasketProduct.getStoreId(),
				shoppingBasketProduct.getProductId());
		System.out.println("sbp:" + sbp);

		
			if (sbp==null) {
				
				shoppingBasketProductDao.insertShoppingBasketProduct(shoppingBasketProduct);
				
			} else {
				sbp.setProductCount(sbp.getProductCount() + shoppingBasketProduct.getProductCount());
				shoppingBasketProductDao.updateShoppingBasketProductCount(sbp);
			}

		}

		/*
		 * if (shoppingBasketProduct.getProductCount() == 0) {
		 * 
		 * } else { System.out.println("여기 까지 옴");
		 * System.out.println(sbpList!=null); if (sbpList != null) {
		 * System.out.println("하나 더 있네 : " + sbpList.size()); for (int i = 0; i
		 * < sbpList.size(); i++) { System.out.println("행방 불명"); if
		 * (sbpList.get(i).getProductId().equals(shoppingBasketProduct.
		 * getProductId())) { System.out.println("다음다음");
		 * sbpList.get(i).setProductCount( sbpList.get(i).getProductCount() +
		 * shoppingBasketProduct.getProductCount());
		 * shoppingBasketProductDao.updateShoppingBasketProductCount(sbpList.get
		 * (i)); System.out.println("새로운 제품"); } else {
		 * shoppingBasketProductDao.insertShoppingBasketProduct(
		 * shoppingBasketProduct); System.out.println("추가된 제품"); }
		 * 
		 * } System.out.println("마지막"); } else {
		 * shoppingBasketProductDao.insertShoppingBasketProduct(
		 * shoppingBasketProduct); System.out.println("새로운 제품2"); } }
		 */
	

	/**
	 * 장바구니에서 결제페이지 넘어갈때 총가격 부를수 있는 서비스.
	 * 
	 * @param shoppingBasketProduct
	 * @return
	 */
	@Override
	public int findAllProductPrice(String storeId, String userId) {
		List<ShoppingBasketProduct> list = null;
		int totalPrice = 0;
		list = shoppingBasketProductDao.selectShoppingBasketProductListByStoreIdAndUserId(storeId, userId);
         System.out.println("Service:"+list);
         System.out.println("list.size:"+list.size());
		for (int i = 0; i < list.size(); i++) {
               System.out.println(list.get(i).getProduct().getProductPrice()*list.get(i).getProductCount());
			totalPrice += list.get(i).getProduct().getProductPrice() * list.get(i).getProductCount();
		}
		System.out.println("totalPrice:"+totalPrice);
		return totalPrice;
	}

	/**
	 * 장바구니에있는 제품의 가격 * 제품개수
	 * 
	 */
	public int findProductPrice(String storeId, String userId, String productId) {

		int price = 0;
		shoppingBasketProductDao.selectShoppingBasketProductByProductId(userId, storeId, productId);
		return price;
	}

	/*
	 * @Override public HashMap<String, Object> userFindProductList(int
	 * page,String userId, String storeId) { HashMap<String, Object> map = new
	 * HashMap<>();
	 * 
	 * //item 수 int totalCount = shoppingBasketProductDao.;
	 * 
	 * PagingBean pageBean = new PagingBean(totalCount, page);
	 * map.put("pageBean", pageBean);
	 * 
	 * List<Product> list = dao.selectProductList(storeId,
	 * pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
	 * map.put("list", list); return map; }
	 */
}
