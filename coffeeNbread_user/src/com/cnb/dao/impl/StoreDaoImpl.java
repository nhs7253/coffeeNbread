package com.cnb.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.StoreDao;
import com.cnb.vo.Store;

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
	public Store selectStore(String storeId) {
		return session.selectOne("com.cnb.config.mybatis.mapper.StoreMapper.selectStore",storeId);
	}

}
