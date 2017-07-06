package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.QnaBoardContentsDao;
import com.cnb.vo.QnaBoardContents;

/*
 * 노현식
 * 2017-07-05
 * 초기 구현
 * 
 * 김형주
 * 2017-06-29 
 * 생성
 */
@Repository
public class QnaBoardContentsDaoImpl implements QnaBoardContentsDao {
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.qnaBoardContentsMapper."+id;
	}

	@Override
	public int insertQnaBoardContents(QnaBoardContents qnaBoardContents) {
		return session.insert(makeSqlId("insertQnaBoardContents"), qnaBoardContents);
	}
	
	@Override
	public int deleteQnaBoardContents(int qnaBoardNo) {
		return session.insert(makeSqlId("deleteQnaBoardContents"), qnaBoardNo);
	}
	
	@Override
	public int deleteQnaBoardContentsAll() {
		return session.delete(makeSqlId("deleteQnaBoardContentsAll"));
	}

	@Override
	public int updateQnaBoardContents(QnaBoardContents qnaBoardContents) {
		return session.update(makeSqlId("updateQnaBoardContents"), qnaBoardContents);
	}
	
	@Override
	public List<QnaBoardContents> selectQnaBoardContentsList() {
		return session.selectList(makeSqlId("selectQnaBoardContentsList"));
	}

	@Override
	public int selectQnaBoardContentsPagingCount(String select, String keyword, String storeId) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("select", select);
		input.put("keyword", keyword);
		input.put("storeId", storeId);
		return session.selectOne(makeSqlId("selectQnaBoardContentsPagingCount"), input);
	}

	@Override
	public List<QnaBoardContents> selectQnaBoardContentsPagingList(String select, String keyword, String storeId, int startIndex, int endIndex) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("select", select);
		input.put("keyword", keyword);
		input.put("storeId", storeId);
		input.put("startIndex", String.valueOf(startIndex));
		input.put("endIndex", String.valueOf(endIndex));		
		return session.selectList(makeSqlId("selectQnaBoardContentsPagingList"), input);
	}
}
