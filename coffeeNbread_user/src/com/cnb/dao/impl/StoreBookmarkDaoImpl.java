package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.StoreBookmarkDao;
import com.cnb.vo.StoreBookmark;

/*
 * 노현식
 * 2017-06-28
 * 생성, 초기구현
 */
@Repository
public class StoreBookmarkDaoImpl implements StoreBookmarkDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.StoreBookmarkMapper."+id;
	}

	@Override
	public int insertStoreBookmark(StoreBookmark storeBookmark) {
		return session.insert(makeSqlId("insertStoreBookmark"), storeBookmark);
	}
	
	@Override
	public int deleteStoreBookmarkByUserId(String userId) {
		return session.delete(makeSqlId("deleteStoreBookmarkByUserId"), userId);
	}

	@Override
	public int deleteStoreBookmarkByStoreBookmark(StoreBookmark storeBookmark) {
		return session.delete(makeSqlId("deleteStoreBookmarkByStoreBookmark"), storeBookmark);
	}

	@Override
	public int deleteStoreBookmarkByStoreBookmarkList(String userId, List<String> storeIdList) {
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("userId", userId);
		input.put("storeIdList", storeIdList);
		return session.delete(makeSqlId("deleteStoreBookmarkByStoreBookmarkList"), input);
	}

	@Override
	public int updateStoreBookmark(StoreBookmark storeBookmark) {
		return session.update(makeSqlId("updateStoreBookmark"), storeBookmark);
	}

	@Override
	public List<StoreBookmark> selectStoreBookmarkList() {
		return session.selectList(makeSqlId("selectStoreBookmarkList"));
	}

	@Override
	public List<String> selectStoreBookmarkByUserId(String userId) {
		return session.selectList(makeSqlId("selectStoreBookmarkByUserId"), userId);
	}

	@Override
	public List<StoreBookmark> selectStoreBookmarkByUserIdJoinStoreList(String userId) {
		return session.selectList(makeSqlId("selectStoreBookmarkByUserIdJoinStoreList"), userId);
	}
}
