package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.StoreVisitHistoryDao;
import com.cnb.vo.StoreVisitHistory;

/*
 * 노현식
 * 2017-06-28
 * 생성, 초기구현
 */
@Repository
public class StoreVisitHistoryDaoImpl implements StoreVisitHistoryDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.StoreVisitHistoryMapper."+id;
	}
	
	@Override
	public int insertStoreVisitHistory(StoreVisitHistory storeVisitHistory) {
		return session.insert(makeSqlId("insertStoreVisitHistory"), storeVisitHistory);
	}
	
	@Override
	public int deleteStoreVisitHistoryByUserId(String userId) {
		return session.delete(makeSqlId("deleteStoreVisitHistoryByUserId"), userId);
	}

	@Override
	public int deleteStoreVisitHistoryByStoreVisitHistory(StoreVisitHistory storeVisitHistory) {
		return session.delete(makeSqlId("deleteStoreVisitHistoryByStoreVisitHistory"), storeVisitHistory);
	}

	@Override
	public int deleteStoreVisitHistoryByStoreVisitHistoryList(String userId, List<String> storeIdList) {
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("userId", userId);
		input.put("storeIdList", storeIdList);
		return session.delete(makeSqlId("deleteStoreVisitHistoryByStoreVisitHistoryList"), input);
	}

	@Override
	public List<StoreVisitHistory> selectStoreVisitHistoryList() {
		return session.selectList(makeSqlId("selectStoreVisitHistoryList"));
	}

	@Override
	public List<String> selectStoreVisitHistoryByUserId(String userId) {
		return session.selectList(makeSqlId("selectStoreVisitHistoryByUserId"), userId);
	}

	@Override
	public List<StoreVisitHistory> selectStoreVisitHistoryByUserIdJoinStoreList(String userId) {
		return session.selectList(makeSqlId("selectStoreVisitHistoryByUserIdJoinStoreList"), userId);
	}

	@Override
	public int selectStoreVisitHistoryByUserIdJoinStoreListCount(String userId) {
		return session.selectOne(makeSqlId("selectStoreVisitHistoryByUserIdJoinStoreListCount"), userId);
	}
	
	@Override
	public int selectStoreVisitHistoryByUserIdJoinStoreListPagingCount(String userId, int startIndex, int endIndex) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("userId", userId);
		input.put("startIndex", String.valueOf(startIndex));
		input.put("endIndex", String.valueOf(endIndex));
		return session.selectOne(makeSqlId("selectStoreVisitHistoryByUserIdJoinStoreListPagingCount"), input);
	}

	@Override
	public List<StoreVisitHistory> selectStoreVisitHistoryByUserIdJoinStoreListPaging(String userId, String keyword, int startIndex, int endIndex) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("userId", userId);
		input.put("keyword", keyword);
		input.put("startIndex", String.valueOf(startIndex));
		input.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectStoreVisitHistoryByUserIdJoinStoreListPaging"), input);
	}	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
