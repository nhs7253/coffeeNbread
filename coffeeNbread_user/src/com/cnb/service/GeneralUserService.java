package com.cnb.service;

import com.cnb.exception.UserManageException;
import com.cnb.vo.GeneralUser;

/*
 * 노현식
 * 2017-06-30
 * 회원가입 추가
 * 
 * 노현식 
 * 2017-06-23 
 * 생성
 */
/**
 * 회원 관리의 전체 서비스를 지원 하는 서비스 클래스
 */
public interface GeneralUserService {

	/**
	 * 회원가입
	 * @param generalUser 회원가입할 유저 객체
	 * @throws UserManageException 이미 해당 ID로 회원이 존재 할 경우
	 */
	void addUser(GeneralUser generalUser) throws UserManageException;
	
	/**
	 * userId로 해당 유저 정보 조회
	 * @param userId 조회할 유저 ID
	 * @return GeneralUser 조회된 유저 객체
	 */
	GeneralUser findUser(String userId);
	
	/**
	 * userId로 해당 유저를 삭제 (실제로는 사용되지 않으며, Service 테스트 용으로 사용)
	 * @param userId 삭제할 유저 ID
	 */
	void removeUser(String userId);
}
