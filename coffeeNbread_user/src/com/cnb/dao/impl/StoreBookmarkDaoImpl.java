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
 * 2017-07-01
 * selectStoreBookmarkByUserIdJoinStoreListPagingCount
 * selectStoreBookmarkByUserIdJoinStoreListPaging
 * 부분 일치 조회 추가
 * 
 * 노현식
 * 2017-06-29
 * 페이징을 위한 추가
 * selectStoreBookmarkByUserIdJoinStoreListCount
 * selectStoreBookmarkByUserIdJoinStoreListPagingCount
 * selectStoreBookmarkByUserIdJoinStoreListPaging
 * 
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

	@Override
	public int selectStoreBookmarkByUserIdJoinStoreListCount(String userId) {
		return session.selectOne(makeSqlId("selectStoreBookmarkByUserIdJoinStoreListCount"), userId);
	}
	
	@Override
	public int selectStoreBookmarkByUserIdJoinStoreListPagingCount(String userId, String keyword, int startIndex, int endIndex) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("userId", userId);
		input.put("keyword", keyword);
		input.put("startIndex", String.valueOf(startIndex));
		input.put("endIndex", String.valueOf(endIndex));
		return session.selectOne(makeSqlId("selectStoreBookmarkByUserIdJoinStoreListPagingCount"), input);
	}

	@Override
	public List<StoreBookmark> selectStoreBookmarkByUserIdJoinStoreListPaging(String userId, String keyword, int startIndex, int endIndex) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("userId", userId);
		input.put("keyword", keyword);
		input.put("startIndex", String.valueOf(startIndex));
		input.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectStoreBookmarkByUserIdJoinStoreListPaging"), input);
	}	
}
