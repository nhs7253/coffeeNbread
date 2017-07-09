package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

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
	public int updateProductPictureByProductPicture(String productPicture, String productId, String storeId) {
		Map<String, String> info = new HashMap<>();
		info.put("productPicture", productPicture);
		info.put("productIdByVO", productId);
		info.put("storeIdByVO", storeId);
		return session.update(makeSqlId("updateProductPictureByProductPicture"), info);
	}

	@Override
	public int deleteProductPicture(ProductPicture productPicture) {
		return session.delete(makeSqlId("deleteProductPictureByProductIdAndStoreId"), productPicture);
	}

	@Override
	public ProductPicture selectProductPictureByProductIdAndStoreId(String productId, String storeId) {
		Map<String, String> info = new HashMap<>();
		info.put("productId", productId);
		info.put("storeId", storeId);
		return session.selectOne(makeSqlId("selectProductPictureByProductIdAndStoreId"), info);
	}

	@Override
	public ProductPicture selectProductPictureListByProductPictureAndStoreId(String productPicture, String storeId) {
		Map<String, String> info = new HashMap<>();
		info.put("productPicture", productPicture);
		info.put("storeId", storeId);
		return session.selectOne(makeSqlId("selectProductPictureListByProductPictureAndStoreId"), info);
	}
}
