package com.cnb.dao.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.NoticeBoardContentsDao;
import com.cnb.vo.NoticeBoardContents;

/*
 * 최민희
 * 2017-06-28 생성
 */
@Repository
public class NoticeBoardContentsDaoImpl implements NoticeBoardContentsDao {

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.cnb.config.mybatis.mapper.NoticeBoardContentsMapper."+id;
	}
	
	@Override
	public int insertNoticeBoardContents(NoticeBoardContents noticeBoardContents) {
		return session.insert(makeSqlId("insertNoticeBoardContents"), noticeBoardContents);
	}

	@Override
	public int updateNoticeBoardContents(NoticeBoardContents noticeBoardContents) {
		return session.update(makeSqlId("updateNoticeBoardContents"), noticeBoardContents);
	}

	@Override
	public int deleteNoticeBoardContentsByNoticeBoardNo(String noticeBoardNo) {
		return session.delete(makeSqlId("deleteNoticeBoardContentsByNoticeBoardNo"), noticeBoardNo);
	}

	@Override
	public List<NoticeBoardContents> selectNoticeBoardContentsListByNoticeBoardContent(String noticeBoardContent) {
		return session.selectList(makeSqlId("selectNoticeBoardContentsListByNoticeBoardContent"), noticeBoardContent);
	}

	@Override
	public List<NoticeBoardContents> selectNoticeBoardContentsListByNoticeBoardTitle(String noticeBoardTitle) {
		return session.selectList(makeSqlId("selectNoticeBoardContentsListByNoticeBoardTitle"), noticeBoardTitle);
	}

	@Override
	public List<NoticeBoardContents> selectNoticeBoardContentsListByNoticeBoardDate(Date noticeBoardDate) {
		return session.selectList(makeSqlId("selectNoticeBoardContentsListByNoticeBoardDate"), noticeBoardDate);
	}

	@Override
	public List<NoticeBoardContents> selectNoticeBoardContentsListByNoticeBoardHits(int noticeBoardHits) {
		return session.selectList(makeSqlId("selectNoticeBoardContentsListByNoticeBoardHits"), noticeBoardHits);
	}

	@Override
	public List<NoticeBoardContents> selectNoticeBoardContentsList() {
		return session.selectList(makeSqlId("selectNoticeBoardContentsList"));
	}

}
