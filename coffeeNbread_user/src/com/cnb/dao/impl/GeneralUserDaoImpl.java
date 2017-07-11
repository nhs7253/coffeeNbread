package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.GeneralUserDao;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.Store;

/*
 * 노현식
 * 2017-07-03
 * 페이징 관련 메서드 추가
 * 
 * 노현식
 * 2017-06-27
 * 초기 구현
 * 
 * 노현식 
 * 2017-06-23 
 * 생성
 */
@Repository
public class GeneralUserDaoImpl implements GeneralUserDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.GeneralUserMapper."+id;
	}
	
	@Override
	public int insertGeneralUser(GeneralUser generalUser) {
		return session.insert(makeSqlId("insertGeneralUser"), generalUser);
	}

	@Override
	public int deleteGeneralUserByUserId(String userId) {
		return session.delete(makeSqlId("deleteGeneralUserByUserId"), userId);
	}

	@Override
	public int updateGeneralUserByUserIdToInfo(GeneralUser generalUser) {
		return session.update(makeSqlId("updateGeneralUserByUserIdToInfo"), generalUser);
	}

	@Override
	public int updateGeneralUserByUserIdToUserActiveState(String userId) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("userId", userId);
		input.put("userActiveState", "N"); // 현재는 활동 탈퇴만 있으나, 추후 정지 등의 상태 추가의 확장을 위해 쿼리가 아닌 DAO에서 값전달
		return session.update(makeSqlId("updateGeneralUserByUserIdToUserActiveState"), input);
	}

	@Override
	public List<GeneralUser> selectGeneralUserList() {
		return session.selectList(makeSqlId("selectGeneralUserList"));
	}

	@Override
	public List<GeneralUser> selectGeneralUserByUserActiveState(String userActiveState) {
		return session.selectList(makeSqlId("selectGeneralUserByUserActiveState"), userActiveState);
	}

	@Override
	public GeneralUser selectGeneralUserByUserId(String userId) {
		return session.selectOne(makeSqlId("selectGeneralUserByUserId"), userId);
	}

	@Override
	public int selectGeneralUserCount() {
		return session.selectOne(makeSqlId("selectGeneralUserCount"));
	}

	@Override
	public int selectGeneralUserByUserActiveStateCount(String userActiveState) {
		return session.selectOne(makeSqlId("selectGeneralUserByUserActiveStateCount"), userActiveState);
	}

	@Override
	public List<GeneralUser> selectGeneralUserListBySelectToKeyword(String select, String keyword, int startIndex, int endIndex) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("select", select);
		input.put("keyword", keyword);
		input.put("startIndex", String.valueOf(startIndex));
		input.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectGeneralUserListBySelectToKeyword"), input);
	}

	@Override
	public int selectGeneralUserListBySelectToKeywordCount(String select, String keyword) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("select", select);
		input.put("keyword", keyword);
		return session.selectOne(makeSqlId("selectGeneralUserListBySelectToKeywordCount"), input);
	}

	@Override
	public List<GeneralUser> selectGeneralUserListBySelectToKeywordJoinStoreContent(String select, String keyword, int startIndex, int endIndex) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("select", select);
		input.put("keyword", keyword);
		input.put("startIndex", String.valueOf(startIndex));
		input.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectGeneralUserListBySelectToKeywordJoinStoreContent"), input);
	}

	@Override
	public int selectGeneralUserListBySelectToKeywordJoinStoreCount(String select, String keyword) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("select", select);
		input.put("keyword", keyword);
		return session.selectOne(makeSqlId("selectGeneralUserListBySelectToKeywordJoinStoreCount"), input);
	}

}