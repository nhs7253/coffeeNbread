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
	public int deleteNoticeBoardContents(String noticeBoardNo) {
		return session.delete(makeSqlId("deleteNoticeBoardContents"), noticeBoardNo);
	}

	@Override
	public List<NoticeBoardContents> selectNoticeBoardContentsByNoticeBoardContent(String noticeBoardContent) {
		return session.selectList(makeSqlId("selectNoticeBoardContentsByNoticeBoardContent"), noticeBoardContent);
	}

	@Override
	public List<NoticeBoardContents> selectNoticeBoardContentsByNoticeBoardTitle(String noticeBoardTitle) {
		return session.selectList(makeSqlId("selectNoticeBoardContentsByNoticeBoardTitle"), noticeBoardTitle);
	}

	@Override
	public List<NoticeBoardContents> selectNoticeBoardContentsByNoticeBoardDate(Date noticeBoardDate) {
		return session.selectList(makeSqlId("selectNoticeBoardContentsByNoticeBoardDate"), noticeBoardDate);
	}

	@Override
	public List<NoticeBoardContents> selectNoticeBoardContentsByNoticeBoardHits(int noticeBoardHits) {
		return session.selectList(makeSqlId("selectNoticeBoardContentsByNoticeBoardHits"), noticeBoardHits);
	}

	@Override
	public List<NoticeBoardContents> selectAllNoticeBoardContents() {
		return session.selectList(makeSqlId("insertNoticeBoardContents"));
	}

}
