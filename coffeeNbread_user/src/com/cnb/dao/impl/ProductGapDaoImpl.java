package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.ProductGapDao;
import com.cnb.vo.ProductGap;

/*
 * 최민희
 * 2017-06-29
 * 수정
 */
/*
 * 최민희
 * 2017-06-28 수정
 */
/*
 * 최민희
 * 2017-06-27 생성
 */
@Repository
public class ProductGapDaoImpl implements ProductGapDao {

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.cnb.config.mybatis.mapper.ProductGapMapper."+id;
	}
	
	@Override
	public int insertProductGap(ProductGap productGap) {
		return session.insert(makeSqlId("insertProductGap"), productGap);
	}

	@Override
	public int updateProductGap(ProductGap productGap) {
		return session.update(makeSqlId("updateProductGap"), productGap);
	}

	@Override
	public int selectProductGapListCountByMethod(String storeId, String method, String methodContent) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("method", method);
		info.put("methodContent", methodContent);
		return session.selectOne(makeSqlId("selectProductGapListCountByMethod"), info);
	}

	@Override
	public List<ProductGap> selectProductGapListByStoreId(String storeId, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectProductGapListByStoreId"), info);
	}

	@Override
	public List<ProductGap> selectProductGapListByIdentifyCodeByStoreIdAndIdentifyCode(String storeId, String identifyCode, int startIndex, int endIndex) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("identifyCode", identifyCode);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectProductGapListByIdentifyCodeByStoreIdAndIdentifyCode"), info);
	}

	@Override
	public String selectIdentifyCodeByProductId(String storeId, String productId) {
		Map<String, String> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productId", productId);
		return session.selectOne(makeSqlId("findIdentifyCodeByProductId"), info);
	}
	
	
}
