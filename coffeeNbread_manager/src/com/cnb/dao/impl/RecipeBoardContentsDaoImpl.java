package com.cnb.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.RecipeBoardContentsDao;
import com.cnb.vo.RecipeBoardContents;

/*
 * 김형주
 * 2017-07-04 
 * 구현
 * 
 *  김형주
 * 2017-07-03 생성
 */
@Repository
public class RecipeBoardContentsDaoImpl implements RecipeBoardContentsDao {

	@Autowired
	private SqlSessionTemplate session;

	private String makeSqlId(String id) {
		return "com.cnb.config.mybatis.mapper.RecipeBoardContentsMapper." + id;
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
	public int deleteRecipeBoardContentsByRecipeBoardNo(String userId, int recipeBoardNo) {
		Map<String, Object> info = new HashMap<>();
		info.put("userId", userId);
		info.put("recipeBoardNo", recipeBoardNo);
		return session.delete(makeSqlId("deleteRecipeBoardContentsByRecipeBoardNo"), info);

	}

	@Override
	public int deleteRecipeBoardContentsByRecipeBoardNoAndStoreId(String userId, String storeId, int recipeBoardNo) {
		Map<String, Object> info = new HashMap<>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		info.put("recipeBoardNo", recipeBoardNo);

		return session.delete(makeSqlId("deleteRecipeBoardContentsByRecipeBoardNoAndStoreId"), info);
	}

	/* 비회원, 회원 -전체개수-방법 */
	@Override
	public int countSelectRecipeBoardContentsByMethod(String select, Object keyword) {
		Map<String, Object> info = new HashMap<>();
		info.put("select", select);
		info.put("keyword", keyword);

		return session.selectOne(makeSqlId("countSelectRecipeBoardContentsByMethod"), info);
	}

	/* 비회원,유저-매장별개수-방법 */
	@Override
	public int countSelectRecipeBoardContentsByStoreIdAndMethod(String storeId, String select, Object keyword) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("select", select);
		info.put("keyword", keyword);
		return session.selectOne(makeSqlId("countSelectRecipeBoardContentsByStoreIdAndMethod"), info);
	}

	/* 유저가 전체게시글에서 자신이 쓴글 조회개수-방법별. */
	@Override
	public int countSelectRecipeBoardContentsByUserIdAndMethod(String userId, String select, Object keyword) {
		Map<String, Object> info = new HashMap<>();
		info.put("userId", userId);
		info.put("select", select);
		info.put("keyword", keyword);
		return session.selectOne(makeSqlId("countSelectRecipeBoardContentsByUserIdAndMethod"), info);
	}

	/* 유저가 매장별 자신이 쓴글 조회개수- 방법별 */
	@Override
	public int countSelectRecipeBoardContentsByUserIdAndStoreIdAndMethod(String userId, String storeId, String select,
			Object keyword) {
		Map<String, Object> info = new HashMap<>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		info.put("select", select);
		info.put("keyword", keyword);
		return session.selectOne(makeSqlId("countSelectRecipeBoardContentsByUserIdAndStoreIdAndMethod"), info);
	}

	/* 비회원, 회원 전체게시글에서 방법별로 보여주는것. */
	@Override
	public List<RecipeBoardContents> selectRecipeBoardContentsListByMethod(String select, Object keyword,
			int startIndex, int endIndex) {
		Map<String, Object> info = new HashMap<>();
		info.put("select", select);
		info.put("keyword", keyword);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectRecipeBoardContentsListByMethod"), info);

	}

	/* 비회원, 회원 -매장별 방법별로 보여주는것 */
	@Override
	public List<RecipeBoardContents> selectRecipeBoardContentsListByStoreIdAndMethod(String storeId, String select,
			Object keyword, int startIndex, int endIndex) {
		Map<String, Object> info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("select", select);
		info.put("keyword", keyword);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectRecipeBoardContentsListByStoreIdAndMethod"), info);
	}

	/* 유저별 방법별로 전체게시글 조회. */
	@Override
	public List<RecipeBoardContents> selectRecipeBoardContentsListByUserIdAndMethod(String userId, String select,
			Object keyword, int startIndex, int endIndex) {
		Map<String, Object> info = new HashMap<>();
		info.put("userId", userId);
		info.put("select", select);
		info.put("keyword", keyword);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectRecipeBoardContentsListByUserIdAndMethod"), info);

	}

	/* 유저가 매장에서 방법별 게시글 조회 */
	@Override
	public List<RecipeBoardContents> selectRecipeBoardContentsListByUserIdAndStoreIdAndMethod(String userId,
			String storeId, String select, Object keyword, int startIndex, int endIndex) {
		Map<String, Object> info = new HashMap<>();
		info.put("userId", userId);
		info.put("storeId", storeId);
		info.put("select", select);
		info.put("keyword", keyword);
		info.put("startIndex", String.valueOf(startIndex));
		info.put("endIndex", String.valueOf(endIndex));
		return session.selectList(makeSqlId("selectRecipeBoardContentsListByUserIdAndStoreIdAndMethod"), info);

	}

	 /* 레시피 게시번호를 통해 레시피게시객체를 가져오는것.*/
	@Override
	public RecipeBoardContents selectRecipeBoardContentsByrecipeBoardNo(int recipeBoardNo) {
		
		
		return session.selectOne(makeSqlId("selectRecipeBoardContentsByrecipeBoardNo"), recipeBoardNo);
	}

}
