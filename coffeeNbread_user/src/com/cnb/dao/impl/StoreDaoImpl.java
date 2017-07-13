package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.StoreDao;
import com.cnb.vo.Store;

/*
 * 노현식
 * 2017-07-09 
 * 페이징 관련 메서드 추가
 * 
 *  이진영
 * 2017-06-30
 * 
 * 이진영
 * 2017-06-27 생성
 * 
 */
@Repository
public class StoreDaoImpl implements StoreDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.StoreMapper."+id;
	}
	
	@Override
	public int insertStore(Store store) {
							   
		return session.insert(makeSqlId("insertStore"),store);
	}

	@Override
	public int updateStore(Store store) {
		
		return session.update(makeSqlId("updateStore"),store);
	}

	@Override
	public List<Store> selectStorePicture(String storeId) {
		return session.selectList(makeSqlId("selectStorePicture"),storeId);
	}

	@Override
	public List<Store> selectStoreEventList(String storeId) {
		return session.selectList(makeSqlId("selectStoreEventList"),storeId);
	}

	@Override
	public List<Store> selectStoreCategoryList(String storeId) {
		
		return session.selectList(makeSqlId("selectStoreCategoryList"),storeId);
	}

	@Override
	public int deleteStoreById(String storeId) {
		return session.delete(makeSqlId("deleteStoreById"),storeId);
	}

	@Override
	public Store selectStoreById(String storeId) {
		
		return session.selectOne(makeSqlId("selectStoreById"),storeId);
	}

	@Override
	public List<Store> selectOpionCategoryNDetailByIdList(String storeId) {
		return session.selectList(makeSqlId("selectOpionCategoryNDetailById"),storeId);
	}

	@Override
	public List<Store> selectStoreBySelectAndKeywordPagingList(String select, String keyword, int startIndex, int endIndex) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("select", select);
		input.put("keyword", keyword);
		input.put("startIndex", String.valueOf(startIndex));
		input.put("endIndex", String.valueOf(endIndex));	
		return session.selectList(makeSqlId("selectStoreBySelectAndKeywordPagingList"), input);
	}

	@Override
	public int selectStoreBySelectAndKeywordPagingCount(String select, String keyword) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("select", select);
		input.put("keyword", keyword);
		return session.selectOne(makeSqlId("selectStoreBySelectAndKeywordPagingCount"), input);
	}

	@Override
	public Store selectStroeJoinPicture(String storeId) {
		return session.selectOne(makeSqlId("selectStroeJoinPicture"),storeId);
	}

	@Override
	public int updateStorePermission(String storeId, String storePermission) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("storeId", storeId);
		input.put("storePermission", storePermission);
		return session.update(makeSqlId("updateStorePermission"), input);
	}
}
