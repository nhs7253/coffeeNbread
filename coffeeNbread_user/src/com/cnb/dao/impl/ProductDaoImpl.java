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
 * 2017-07-01
 * 수정
 */
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
	public List<Product> selectProductListByCategoryNoPaging(String storeId, String productCategory) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productCategory", productCategory);
		return session.selectList(makeSqlId("selectProductListByCategoryNoPaging"), info);
	}
	
	@Override
	public List<Product> selectProductListByName(String storeId, String productName, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productName", productName);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectProductListByName"), info);
	}

	@Override
	public Product selectProductByName(String storeId, String productName) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productName", productName);
		return session.selectOne(makeSqlId("selectProductByName"), info);
	}

	@Override
	public Product selectProductById(String storeId, String productId) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productId", productId);
		return session.selectOne(makeSqlId("selectProductById"), info);
	}

	@Override
	public List<Product> selectProductListBySellingOption(String storeId, String sellingOption, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("sellingOption", sellingOption);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectProductListBySellingOption"), info);
	}
	
	@Override
	public List<Product> selectProductList(String storeId, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectProductList"), info);
	
	}
	
	@Override
	public Product selectProductBySellingOption(String storeId, String sellingOption,String productName) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("sellingOption", sellingOption);
		info.put("productName", productName);
		return session.selectOne(makeSqlId("selectProductBySellingOption"), info);
	}

	@Override
	public int deleteProductByProductList(String storeId, List<String> productIdList) {
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("storeId", storeId);
		info.put("productIdList", productIdList);
		return session.delete(makeSqlId("deleteProductByProductList"), info);
	}

	@Override
	public List<Product> selectProductListNoPaging(String storeId) {
		return session.selectList(makeSqlId("selectProductListNoPaging"), storeId);
	}
}
