package com.cnb.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.StorePositionDao;
import com.cnb.vo.StorePosition;

/*
 * 노현식
 * 2017-06-28
 * 생성, 초기구현
 */
@Repository
public class StorePositionDaoImpl implements StorePositionDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.StorePositionMapper."+id;
	}

	@Override
	public int insertStorePosition(StorePosition storePosition) {
		return session.insert(makeSqlId("insertStorePosition"), storePosition);
	}

	@Override
	public int deleteStorePositionByStoreId(String storeId) {
		return session.delete(makeSqlId("deleteStorePositionByStoreId"), storeId);
	}

	@Override
	public int updateStorePosition(StorePosition storePosition) {
		return session.update(makeSqlId("updateStorePosition"), storePosition);
	}

	@Override
	public StorePosition selectStorePositionByStoreIdJoinStore(String storeId) {
		return session.selectOne(makeSqlId("selectStorePositionByStoreIdJoinStore"), storeId);
	}

	@Override
	public List<StorePosition> selectStorePositionJoinStoreList() {
		return session.selectList(makeSqlId("selectStorePositionJoinStoreList"));
	}
}
