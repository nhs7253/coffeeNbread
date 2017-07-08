package com.cnb.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.StoreEventDao;
import com.cnb.vo.StoreEvent;

/* 이진영
 * 2017-06-28 생성
 * 초기구현
 */
@Repository
public class StoreEventDaoImpl implements StoreEventDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.StoreEventMapper."+id;
	}
	
	@Override
	public int insertStoreEvent(StoreEvent storeEvent) {
		
		return session.insert(makeSqlId("insertStoreEvent"), storeEvent);
	}

	@Override
	public int updateStoreEvent(StoreEvent storeEvent) {
		
		return session.update(makeSqlId("updateStoreEvent"), storeEvent);
	}

	@Override
	public int deleteStoreEvent(int eventNo) {
		
		return session.delete(makeSqlId("deleteStoreEvent"), eventNo);
	}

	@Override
	public List<StoreEvent> selectStoreEventList(String storeId) {
		
		return session.selectList(makeSqlId("selectStoreEventList"), storeId);
	}

}
