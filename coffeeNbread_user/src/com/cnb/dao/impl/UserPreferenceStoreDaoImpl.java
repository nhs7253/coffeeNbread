package com.cnb.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.UserPreferenceStoreDao;
import com.cnb.vo.UserPreferenceStore;

/*
 * 노현식
 * 2017-06-29
 * 초기구현
 * 
 * 노현식
 * 2017-06-28
 * 생성
 */
@Repository
public class UserPreferenceStoreDaoImpl implements UserPreferenceStoreDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.UserPreferenceStoreMapper."+id;
	}

	@Override
	public int insertUserPreferenceStore(UserPreferenceStore userPreferenceStore) {
		return session.insert(makeSqlId("insertUserPreferenceStore"), userPreferenceStore);
	}

	@Override
	public int deleteUserPreferenceStore(String userId) {
		return session.delete(makeSqlId("deleteUserPreferenceStore"), userId);
	}

	@Override
	public int updateUserPreferenceStoreByUserPreferenceStoreUpPreferenceHits(UserPreferenceStore userPreferenceStore) {
		return session.update(makeSqlId("updateUserPreferenceStoreByUserPreferenceStoreUpPreferenceHits"), userPreferenceStore);
	}

	@Override
	public List<UserPreferenceStore> selectUserPreferenceJoinStoreSort(String userId) {
		return session.selectList(makeSqlId("selectUserPreferenceJoinStoreSort"), userId);
	}

	@Override
	public List<UserPreferenceStore> selectUserPreferenceList() {
		return session.selectList(makeSqlId("selectUserPreferenceList"));
	}

}
