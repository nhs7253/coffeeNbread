package com.cnb.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * 노현식
 * 2017-06-28
 * 생성, 초기구현
 */
@Repository
public class UserPreferenceStoreDaoImpl {
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.UserPreferenceStoreMapper."+id;
	}

}
