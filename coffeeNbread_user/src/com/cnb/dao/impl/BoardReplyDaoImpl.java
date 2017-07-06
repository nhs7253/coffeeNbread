package com.cnb.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.BoardReplyDao;
import com.cnb.vo.BoardReply;
import com.cnb.vo.RecipeBoardContents;

/*
 * 김형주
 * 2017-07-05
 * 생성
 */
@Repository
public class BoardReplyDaoImpl implements BoardReplyDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.BoardReplyMapper."+id;
	}

	
	@Override
	public int insertBoardReplyToRecipeBoardNo(BoardReply boardReply) {
	
		return session.insert(makeSqlId("insertBoardReplyToRecipeBoardNo"), boardReply);
	}

	
	
	@Override
	public int insertBoardReplyToQnaBoardNo(BoardReply boardReply) {
		return session.insert(makeSqlId("insertBoardReplyToQnaBoardNo"), boardReply);
	}

	@Override
	public int updateBoardReplyToRecipeBoardNo(BoardReply boardReply) {
		return session.update(makeSqlId("updateBoardReplyToRecipeBoardNo"), boardReply);

	}

	@Override
	public int updateBoardReplyToQnaBoardNo(BoardReply boardReply) {
		return session.update(makeSqlId("updateBoardReplyToQnaBoardNo"), boardReply);

	}

	@Override
	public int deleteBoardReplyByRecipeBoardNo(int replyNo, int recipeBoardNo) {
		Map<String, Object> info = new HashMap<>();
		info.put("replyNo", replyNo);
		info.put("recipeBoardNo", recipeBoardNo);
	return session.delete(makeSqlId("deleteBoardReplyByRecipeBoardNo"), info);

	}

	@Override
	public int deleteBoardReplyByQnaBoardNo(int replyNo, int qnaBoardNo) {
		Map<String, Object> info = new HashMap<>();
		info.put("replyNo", replyNo);
		info.put("qnaBoardNo", qnaBoardNo);
	return session.delete(makeSqlId("deleteBoardReplyByQnaBoardNo"), info);
	}

	
	public List<BoardReply> selectBoardReplyListByRecipeBoardNo(int recipeBoardNo,
			int startIndex, int endIndex) {
		Map<String, Object> info = new HashMap<>();
		info.put("recipeBoardNo", recipeBoardNo);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectBoardReplyListByRecipeBoardNo"), info);

	}

	public List<BoardReply> selectBoardReplyListByQnaBoardNo(int qnaBoardNo,
			int startIndex, int endIndex) {
		Map<String, Object> info = new HashMap<>();
		info.put("qnaBoardNo", qnaBoardNo);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectBoardReplyListByQnaBoardNo"), info);

	}


	@Override
	public int countReplyBoardByRecipeBoardNo(int recipeBoardNo) {
	
	return session.selectOne(makeSqlId("countReplyBoardByRecipeBoardNo"),  recipeBoardNo);	
	}


	@Override
	public int countReplyBoardByQnaBoardNo(int QnaBoardNo) {
		return session.selectOne(makeSqlId("countReplyBoardByQnaBoardNo"),  QnaBoardNo);	

	}


	

	

	

}
