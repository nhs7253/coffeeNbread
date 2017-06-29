package com.cnb.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.OptionDetailDao;
import com.cnb.vo.OptionDetail;

/*
 * 이진영
 * 2017-06-28 생성
 */
@Repository
public class OptionDetailDaoImpl implements OptionDetailDao{

	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.OptionDetailMapper."+id;
	}
	@Override
	public int insertOptionDetail(OptionDetail optionDetail) {
		return session.insert(makeSqlId("insertOptionDetail"), optionDetail);
	}

	@Override
	public int updateOptionDetail(OptionDetail optionDetail) {
		return session.update(makeSqlId("updateOptionDetail"), optionDetail);

	}

	@Override
	public int deleteOptionDetail(int optionId) {
		return session.delete(makeSqlId("deleteOptionDetail"), optionId);

	}

}
