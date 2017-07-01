package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.ShoppingBasketProductDao;
import com.cnb.vo.ShoppingBasketProduct;

/*김형주
 *2017-06-30 수정 
 *
 * 김형주 
 * 2017-06-26 생성
 */
@Repository //name : shoppingBasketProductDaoImpl
public class ShoppingBasketProductDaoImpl implements ShoppingBasketProductDao {
    @Autowired
    	private SqlSessionTemplate session;

    private String makeSql(String tagId){
		return "com.cnb.config.mybatis.mapper.ShoppingBasketProductMapper."+tagId;
	}

	@Override
	public int deleteShoppingBasketProductByProductIdAndUserId(String productId, String userId) {
		Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("productId", productId);
		return session.delete(makeSql("deleteShoppingBasketProductByProductIdAndUserId"),info);
	}

	@Override
	public int insertShoppingBasketProduct(ShoppingBasketProduct shoppingBasketProduct) {
		
		return session.insert(makeSql("insertShoppingBasketProduct"), shoppingBasketProduct);
	}

	@Override
	public int updateShoppingBasketProductCount(ShoppingBasketProduct shoppingBasketProduct) {
		return session.update(makeSql("updateShoppingBasketProductCount"), shoppingBasketProduct);
	}

	@Override
	public ShoppingBasketProduct selectShoppingBasketProductByProductNameAndUserId(String productName, String userId) {
		Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("productName", productName);
		return session.selectOne(makeSql("selectShoppingBasketProductByProductNameAndUserId"),info);
	}

	@Override
	public List<ShoppingBasketProduct> selectShoppingBasketProductListByStoreIdAndUserId(String storeId,String userId) {
		Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		return session.selectList(makeSql("selectShoppingBasketProductListByStoreIdAndUserId"),info);
		
	}

	@Override
	public String selectShoppingBasketProductNameByProductIdAndUserId(String productId,String userId) {
		Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("productId", productId);
		return session.selectOne(makeSql("selectShoppingBasketProductNameByProductIdAndUserId"),info);
	}
    
	@Override
	public ShoppingBasketProduct selectShoppingBasketProductByProductIdAndUserId(String productId,String userId) {
		Map<String, String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("productId", productId);
		return session.selectOne(makeSql("selectShoppingBasketProductByProductIdAndUserId"),info);
	}
   

        
	
}