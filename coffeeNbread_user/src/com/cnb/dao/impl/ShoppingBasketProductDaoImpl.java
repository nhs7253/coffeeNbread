package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.ShoppingBasketProductDao;
import com.cnb.vo.ShoppingBasketProduct;

/* 김형주
 * 2017-07-02 수정
 * 
 * 
 * 김형주
 *2017-06-30 수정 
 *
 * 김형주 
 * 2017-06-26 생성
 */
@Repository // name : shoppingBasketProductDaoImpl
public class ShoppingBasketProductDaoImpl implements ShoppingBasketProductDao {
	@Autowired
	private SqlSessionTemplate session;

	private String makeSql(String tagId) {
		return "com.cnb.config.mybatis.mapper.ShoppingBasketProductMapper." + tagId;
	}

	/* 단순히 장바구니 테이블에 담긴 객체 갖고오기 */
	public List<ShoppingBasketProduct> selectShoppingBasketProductList(String storeId, String userId) {
		Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		return session.selectList(makeSql("selectShoppingBasketProductList"), info);
	}

	/* 장바구니에 담긴 목록 - 원하는 것 찾기위해 조인해놓은 쿼리문 가져오기 */
	@Override
	public List<ShoppingBasketProduct> selectShoppingBasketProductListByStoreIdAndUserId(String storeId,
			String userId) {
		Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		return session.selectList(makeSql("selectShoppingBasketProductListByStoreIdAndUserId"), info);

	}

	/* 유저아이디와 제품아이디로 장바구니목록 삭제 */
	@Override
	public int deleteShoppingBasketProductByProductIdAndUserId(String productId, String userId) {
		Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("productId", productId);
		return session.delete(makeSql("deleteShoppingBasketProductByProductIdAndUserId"), info);
	}

	/* 장바구니 목록 넣을떄 쓰이는 쿼리문 */
	@Override
	public int insertShoppingBasketProduct(ShoppingBasketProduct shoppingBasketProduct) {

		return session.insert(makeSql("insertShoppingBasketProduct"), shoppingBasketProduct);
	}

	/* 장바구니 목록에 넣어진 제품 개수 수정할떄 쓰이고/ 만약 세션정보 남아있을떄 동일 제품추가할떄도 쓰인다 */
	@Override
	public int updateShoppingBasketProductCount(ShoppingBasketProduct shoppingBasketProduct) {
		return session.update(makeSql("updateShoppingBasketProductCount"), shoppingBasketProduct);
	}

	/* 제품아이디와 유저아이디로 장바구니 목록 선택 */
	@Override                              
	public ShoppingBasketProduct selectShoppingBasketProductByProductIdAndUserId(String productId, String userId) {
		Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("productId", productId);
		return session.selectOne(makeSql("selectShoppingBasketProductByProductIdAndUserId"), info);
	}

	/* 유저가 해당매장에서 넣어놓은 장바구니목록에서 제품아이디로 장바구니 목록 조회 */
	@Override
	public ShoppingBasketProduct selectShoppingBasketProductByProductId(String userId, String storeId,
			String productId) {
		Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		info.put("productId", productId);
		return session.selectOne(makeSql("selectShoppingBasketProductByProductId"), info);
	}

	/*
	 * ------------------------------------------ 페이징
	 * -----------------------------------------------------
	 */

	@Override
	public int selectShoppingBasketProductCountForPagingCount(String userId, String storeId, int startIndex,
			int endIndex) {
		Map<String, String> info = new HashMap<String, String>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectOne(makeSql("selectShoppingBasketProductCountForPagingCount"), info);
	}

	@Override
	public int selectShoppingBasketProductCountForPagingToProductCategoryCount(String userId, String storeId,
			String productCategory, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<String, String>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		info.put("productCategory", productCategory);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));

		return session.selectOne(makeSql("selectShoppingBasketProductCountForPagingToProductCategoryCount"), info);
	}

	@Override
	public List<ShoppingBasketProduct> selectShoppingBasketProductListForPaging(String userId, String storeId,
			int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<String, String>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSql("selectShoppingBasketProductListForPaging"), info);
	}

	@Override
	public List<ShoppingBasketProduct> selectShoppingBasketProductListForPagingToProductCategory(String userId,
			String storeId, String productCategory, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<String, String>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		info.put("productCategory", productCategory);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));

		return session.selectList(makeSql("selectShoppingBasketProductListForPagingToProductCategory"), info);
	}

	@Override
	public int selectAllProductPriceByUserIdAndStoreId(String userId, String storeId) {
		Map<String, String> info = new HashMap<String, String>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		return session.selectOne(makeSql("selectAllProductPriceByUserIdAndStoreId"), info);
	}

	@Override
	public int selectProductPriceByUserIdAndStoreId(String userId, String storeId) {
		Map<String, String> info = new HashMap<String, String>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		return session.selectOne(makeSql("selectProductPriceByUserIdAndStoreId"), info);
	}


}