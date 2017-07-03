package com.cnb.dao.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.RecipeBoardContentsDao;
import com.cnb.vo.RecipeBoardContents;

/*
 * 최민희
 * 2017-06-28 생성
 */
@Repository
public class RecipeBoardContentsDaoImpl implements RecipeBoardContentsDao {

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.cnb.config.mybatis.mapper.RecipeBoardContentsMapper."+id;
	}
	
	@Override
	public int insertRecipeBoardContents(RecipeBoardContents recipeBoardContents) {
		return session.insert(makeSqlId("insertRecipeBoardContents"), recipeBoardContents);
	}

	@Override
	public int updateRecipeBoardContents(RecipeBoardContents recipeBoardContents) {
		return session.update(makeSqlId("updateRecipeBoardContents"), recipeBoardContents);
	}

	@Override
	public int deleteRecipeBoardContentsByRecipeBoardNo(String recipeBoardNo) {
		return session.delete(makeSqlId("deleteRecipeBoardContentsByRecipeBoardNo"), recipeBoardNo);
	}
	

	@Override
	public List<RecipeBoardContents> selectRecipeBoardContentsListByRecipeBoardContent(String recipeBoardContent) {
		return session.selectList(makeSqlId("selectRecipeBoardContentsListByRecipeBoardContent"), recipeBoardContent);

	}

	@Override
	public List<RecipeBoardContents> selectRecipeBoardContentsListByRecipeBoardTitle(String recipeBoardTitle) {
		return session.selectList(makeSqlId("selectRecipeBoardContentsListByRecipeBoardTitle"), recipeBoardTitle);

	}

	@Override
	public List<RecipeBoardContents> selectRecipeBoardContentsListByRecipeBoardDate(Date recipeBoardDate) {
		return session.selectList(makeSqlId("selectRecipeBoardContentsListByRecipeBoardDate"), recipeBoardDate);

	}

	@Override
	public List<RecipeBoardContents> selectRecipeBoardContentsListByRecipeBoardHits(int recipeBoardHits) {
		return session.selectList(makeSqlId("selectRecipeBoardContentsListByRecipeBoardHits"), recipeBoardHits);

	}

	@Override
	public List<RecipeBoardContents> selectRecipeBoardContentsList() {
		return session.selectList(makeSqlId("selectRecipeBoardContentsList"));

	}



}
