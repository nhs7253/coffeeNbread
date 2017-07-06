package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.BoardRecommendDao;
import com.cnb.vo.BoardRecommend;
import com.cnb.vo.RecipeBoardContents;

/*김형주
 * 2017-07-06
 * 
 * 김형주
 * 2017-07-05
 * 생성
 */
@Repository
public class BoardRecommendDaoImpl implements BoardRecommendDao {

	@Autowired
	private SqlSessionTemplate session;

	private String makeSqlId(String id) {
		return "com.cnb.config.mybatis.mapper.BoardRecommendMapper." + id;
	}

	@Override
	public int updatePlusBoardRecommend(int recommendCount,int recipeBoardNo, String recommendWriterId) {
		Map<String, Object> info = new HashMap<>();
		info.put("recommendCount", recommendCount);
		info.put("recipeBoardNo", recipeBoardNo);
		info.put("recommendWriterId", recommendWriterId); 
		return session.update(makeSqlId("updatePlusBoardRecommend"), info);
	}

	@Override
	public int updateMinusBoardRecommend(int recommendCount,int recipeBoardNo,String recommendWriterId) {
		Map<String, Object> info = new HashMap<>();
		info.put("recommendCount", recommendCount);
		info.put("recipeBoardNo", recipeBoardNo);
		info.put("recommendWriterId", recommendWriterId); 
		return session.update(makeSqlId("updateMinusBoardRecommend"), info);
 
	}

	

	
	
}
