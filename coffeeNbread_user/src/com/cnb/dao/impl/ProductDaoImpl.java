package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.ProductDao;
import com.cnb.vo.Product;

/*
 * 최민희
 * 2017-06-27 생성
 */
@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.ProductMapper."+id;
	}
	
	@Override
	public int insertProduct(String storeId, Product product) {
		return session.insert(makeSqlId("insertProduct"), product);
	}

	@Override
	public int updateProduct(String storeId, Product product) {
		return session.update(makeSqlId("updateProduct"), product);
	}

	@Override
	public int deleteProductById(String storeId, String productId) {
		Map<String, String> deleteInfo = new HashMap<>();
		deleteInfo.put("storeId", storeId);
		deleteInfo.put("productId", productId);
		return session.delete(makeSqlId("deleteProductById"), deleteInfo);
	}

	@Override
	public List<Product> selectProductByCategory(String storeId, String productCategory) {
		return session.selectList(makeSqlId("selectProductByCategory"), productCategory);
	}

	@Override
	public Product selectProductByName(String storeId, String productName) {
		return session.selectOne(makeSqlId("selectProductByName"), productName);
	}

}
