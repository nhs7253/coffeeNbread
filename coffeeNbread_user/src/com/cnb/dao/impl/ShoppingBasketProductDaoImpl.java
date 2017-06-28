package com.cnb.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.ShoppingBasketProductDao;
import com.cnb.vo.Product;
import com.cnb.vo.ShoppingBasketProduct;

/*
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
	//한제품은 여러개 선택할수 있고 제품개수라는 컬럼이 따로 있으므로 한제품당 장바구니 하나의 목록에 들어감.
	public ShoppingBasketProduct selectShoppingBasketProductByProductId(String productId) {
	
		return session.selectOne(makeSql("selectShoppingBasketProductByProductId"), productId);
	}
		
		
	
	@Override
	public int deleteProductByProductId(String productId) {
		
		return session.delete(makeSql("deleteProductByProductId"),productId);
	}



        
	
}