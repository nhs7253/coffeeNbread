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
 * 2017-06-30
 * 수정
 */
/*
 * 최민희
 * 2017-06-29
 * 수정
 */
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
	public int insertProduct(Product product) {
		return session.insert(makeSqlId("insertProduct"), product);
	}

	@Override
	public int updateProduct(Product product) {
		return session.update(makeSqlId("updateProduct"), product);
	}

	@Override
	public int selectProductListCount(String storeId) {
		return session.selectOne(makeSqlId("selectProductListCount"), storeId);
	}

	@Override
	public int selectProductListCountByMethod(String storeId, String method, String methodContent) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("method", method);
		info.put("methodContent", methodContent);
		return session.selectOne(makeSqlId("selectProductListCountByMethod"), info);

	}
	
	@Override
	public List<Product> selectProductListByCategory(String storeId, String productCategory, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productCategory", productCategory);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectProductListByCategory"), info);
	}

	@Override
	public Product selectProductByName(String storeId, String productName, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productName", productName);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectOne(makeSqlId("selectProductByName"), info);
	}

	@Override
	public Product selectProductById(String storeId, String productId, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productId", productId);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectOne(makeSqlId("selectProductById"), info);
	}

	@Override
	public List<Product> selectProductListBySellingOption(String storeId, String sellingOption, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("sellingOption", sellingOption);
		return session.selectList(makeSqlId("selectProductListBySellingOption"), info);
	}
	
	@Override
	public List<Product> selectProductList(String storeId, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<>();
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectProduct"), info);
	}
}
