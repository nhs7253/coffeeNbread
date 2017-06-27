package com.cnb.dao;

import com.cnb.vo.GeneralUser;

/*
 * 노현식
 * 2017-06-27
 * 초기 구현
 * 
 * 노현식
 * 2017-06-23 
 * 생성
 */
/**
 * GeneralUser 테이블을 관리하는 Dao 인터페이스
 */
public interface GeneralUserDao {
	
	/**
	 * 1개의 GeneralUser객체를 DB에 insert
	 * @param generalUser insert할 GeneralUser 객체
	 * @return 처리 개수
	 */
	int insertGeneralUser(GeneralUser generalUser);
	
	/**
	 * 
	 * @param userId 삭제할 
	 * @return 처리 개수
	 */
	int deleteGeneralUserByUserId(String userId);
	
	
}
