package com.cnb.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.OptionCategoryDao;
import com.cnb.vo.OptionCategory;

/*
 * 이진영
 * 2017-06-28 생성
 */
@Repository
public class OptionCategoryDaoImpl implements OptionCategoryDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.OptionCategoryMapper."+id;
	}
	@Override
	public int insertOptionCategory(OptionCategory optionCategory) {
		return session.insert(makeSqlId("insertOptionCategory"), optionCategory);
	}

	@Override
	public int updateOptionCategory(OptionCategory optionCategory) {
		return session.update(makeSqlId("updateOptionCategory"), optionCategory);
	}

	@Override
	public int deleteOptionCategory(int optionId) {
		return session.delete(makeSqlId("deleteOptionCategory"), optionId);
	}

}
