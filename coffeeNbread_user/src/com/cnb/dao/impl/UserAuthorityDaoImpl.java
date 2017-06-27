package com.cnb.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.UserAuthorityDao;
import com.cnb.vo.UserAuthority;

@Repository
/*
 * 노현식
 * 2017-06-27
 * 생성, 초기 구현
 */
public class UserAuthorityDaoImpl implements UserAuthorityDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.UserAuthorityMapper."+id;
	}
	
	@Override
	public int insertUserAuthority(UserAuthority userAuthority) {
		return session.insert(makeSqlId("insertUserAuthority"), userAuthority);
	}

	@Override
	public int deleteUserAuthorityByUserId(String userId) {
		return session.delete(makeSqlId("deleteUserAuthorityByUserId"), userId);
	}

	@Override
	public int deleteUserAuthorityByUserAuthorityData(UserAuthority userAuthority) {
		return session.delete(makeSqlId("deleteUserAuthorityByUserAuthorityData"), userAuthority);
	}

	@Override
	public int updateUserAuthorityByUserId(UserAuthority userAuthority) {
		return session.update(makeSqlId("updateUserAuthorityByUserId"), userAuthority);
	}

	@Override
	public List<UserAuthority> selectUserAuthorityList() {
		return session.selectList(makeSqlId("selectUserAuthorityList"));
	}

	@Override
	public UserAuthority selectUserAuthorityByUserId(String userId) {
		return session.selectOne(makeSqlId("selectUserAuthorityByUserId"), userId);
	}

}
