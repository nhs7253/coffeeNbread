package com.cnb.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.StoreCategoryDao;
import com.cnb.vo.StoreCategory;

/*
 * 이진영
 * 2017-06-28 생성
 */
@Repository
public class StoreCategoryDaoImpl implements StoreCategoryDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.StoreCategoryMapper."+id;
	}
	@Override
	public int insertStoreCategory(StoreCategory storeCategory) {
		return session.insert(makeSqlId("insertStoreCategory"),storeCategory);
		
	}

	@Override
	public int updateStoreCategory(StoreCategory storeCategoryNo) {
		
		return session.update(makeSqlId("updateStoreCategory"),storeCategoryNo);
		
	}

	@Override
	public int deleteStoreCategoryById(int storeCategoryNo) {
		
		return session.delete(makeSqlId("deleteStoreCategoryById"), storeCategoryNo);
	}

}
