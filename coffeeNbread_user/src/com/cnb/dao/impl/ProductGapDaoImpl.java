package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.ProductGapDao;
import com.cnb.vo.Product;
import com.cnb.vo.ProductGap;
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
	public List<ProductGap> selectProductGap() {
		return session.selectList(makeSqlId("selectProductGap"));
	}

	@Override
	public List<ProductGap> selectProductGapByIdentifyCode(String identifyCode) {
		return session.selectList(makeSqlId("selectProductGapByIdentifyCode"), identifyCode);
	}
}
