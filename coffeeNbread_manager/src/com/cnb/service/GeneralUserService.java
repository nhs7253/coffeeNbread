package com.cnb.service;

import java.util.Map;

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
	 * 유저 정보 수정을 위한 Service
	 * @param generalUser 수정할 유저 정보
	 * @throws UserManageException 수정하고자 하는 유저 정보가 없음
	 */
	void modifyUser(GeneralUser generalUser) throws UserManageException;
	
	/**
	 * 해당 ID의 유저를 회원탈퇴 시키는 Service
	 * @param userId 탈퇴하는 유저 ID
	 * @throws UserManageException 탈퇴 오류 발생
	 */
	void removeUser(String userId) throws UserManageException;
	
	/**
	 * 유저가 입력한 키워드를 통해 조회한 데이터를 페이징하여 보여주는 Service
	 * @param select 검색 카테고리 userId, userName
	 * @param keyword 검색할 키워드
	 * @param page 보려는 페이지 번호
	 * @return Map<String, Object> 페이징을 위한 정보 결과
	 */
	Map<String, Object> findUserListBySelectToKeyword(String select, String keyword, int page);
	
	
	/**
	 * userId로 해당 유저를 삭제 (실제로는 사용되지 않으며, Service 테스트 용으로 사용)
	 * @param userId 삭제할 유저 ID
	 */
	void RealRemoveUser(String userId);
}
