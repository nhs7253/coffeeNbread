package com.cnb.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.StoreDao;
import com.cnb.vo.Store;
import com.cnb.vo.StorePicture;

/* 이진영
 * 2017-06-27 생성
 * 
 */
@Repository
public class StoreDaoImpl implements StoreDao{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertStore(Store store) {
							   
		return session.insert("com.cnb.config.mybatis.mapper.StoreMapper.insertStore",store);
	}

	@Override
	public int updateStore(Store store) {
		
		return session.update("com.cnb.config.mybatis.mapper.StoreMapper.updateStore",store);
	}

	@Override
	public List<Store> selectStore(String storeId) {
		return session.selectList("com.cnb.config.mybatis.mapper.StoreMapper.selectStore",storeId);
	}

	@Override
	public List<Store> selectStoreEventList(String storeId) {
		return session.selectList("com.cnb.config.mybatis.mapper.StoreMapper.selectStoreEventList",storeId);
	}

	@Override
	public List<Store> selectStoreCategoryList(String storeId) {
		
		return session.selectOne("com.cnb.config.mybatis.mapper.StoreMapper.selectStoreCategory",storeId);
	}

	@Override
	public int deleteStoreById(String storeId) {
		return session.delete("com.cnb.config.mybatis.mapper.StoreMapper.deleteStoreById",storeId);
	}
}
