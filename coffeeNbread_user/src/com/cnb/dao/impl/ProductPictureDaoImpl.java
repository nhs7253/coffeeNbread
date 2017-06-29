package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.ProductPictureDao;
import com.cnb.vo.ProductPicture;

/*
 * 최민희
 * 2017-06-29
 * 생성
 */
@Repository
public class ProductPictureDaoImpl implements ProductPictureDao {

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.ProductPictureMapper."+id;
	}
	
	@Override
	public int insertProductPicture(ProductPicture productPicture) {
		return session.insert(makeSqlId("insertProductPicture"), productPicture);
	}

	@Override
	public int updateProductPicture(ProductPicture productPicture) {
		return session.update(makeSqlId("updateProductPicture"), productPicture);
	}

	@Override
	public int deleteProductPictureByProductIdAndStoreId(String productId, String storeId) {
		Map<String, String> info = new HashMap<>();
		info.put("productId", productId);
		info.put("storeId", storeId);
		return session.delete(makeSqlId("deleteProductPictureByProductIdAndStoreId"), info);
	}

	@Override
	public List<ProductPicture> selectProductPictureListByProductIdAndStoreId(String productId, String storeId) {
		Map<String, String> info = new HashMap<>();
		info.put("productId", productId);
		info.put("storeId", storeId);
		return session.selectList(makeSqlId("selectProductPictureListByProductIdAndStoreId"), info);
	}



}
