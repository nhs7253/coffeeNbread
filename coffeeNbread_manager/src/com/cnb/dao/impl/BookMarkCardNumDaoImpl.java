package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.BookMarkCardNumDao;
import com.cnb.vo.BookMarkCardNum;

/*
 * 김형주
 * 06.28 구현
 * 
 * 
 * 김형주
 * 06.28 초기생성
 */
@Repository
public class BookMarkCardNumDaoImpl implements BookMarkCardNumDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.BookMarkCardNumMapper."+id;
	}

	@Override
	public int insertCardNum(BookMarkCardNum bookMarkCardNum) {
		
	return session.insert(makeSqlId("insertCardNum"), bookMarkCardNum);

	}

	@Override
	public List<BookMarkCardNum> selectCardNumListByUserId(String userId) {
	return session.selectList(makeSqlId("selectCardNumListByUserId"),userId);

	}

	@Override
	public int deleteCardNumByCardNumAndUserId(String cardNum,String userId) {
		Map<String, String> info = new HashMap<>();
		info.put("cardNum", cardNum);
		info.put("userId", userId);
		return session.delete(makeSqlId("deleteCardNumByCardNumAndUserId"),info);
	}



	
	

}