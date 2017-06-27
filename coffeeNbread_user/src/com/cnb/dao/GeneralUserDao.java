package com.cnb.dao;

import java.util.List;

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
	 * 받은 userId와 일치하는 컬럼 삭제 (테스트 용)
	 * @param userId 삭제할 컬럼의 PK인 userId
	 * @return 처리 개수
	 */
	int deleteGeneralUserByUserId(String userId);
	
	/**
	 * 받은 generalUser 객체의 userId와 일치하는 컬럼 정보들 수정 - (유저의 개인정보를 수정)
	 * @param generalUser 수정할 컬럼의 PK인 userId
	 * @return 처리 개수
	 */
	int updateGeneralUserByUserIdToInfo(GeneralUser generalUser);
	
	/**
	 * 받은 userId와 일치하는 컬럼의 userActiveState를 수정 - (유저 탈퇴)
	 * @param userId 수정할 컬럼의 PK인 userId
	 * @return 처리 개수
	 */
	int updateGeneralUserByUserIdToUserActiveState(String userId);
	
	/**
	 * GeneralUser의 전체 목록을 받아 옴
	 * @return 전체 목록
	 */
	List<GeneralUser> selectGeneralUserList();
	
	/**
	 * GeneralUser의 전체 목록 중 활동 중이거나, 탈퇴된 회원의 정보를 받아 옴
	 * @param userActiveState Y - 활동, N - 탈퇴
	 * @return 활동/탈퇴 상태인 회원 목록
	 */
	List<GeneralUser> selectGeneralUserByUserActiveState(String userActiveState);

	/**
	 * PK인 userId로 전체 회원 중 해당 인원을 조회
	 * @param userId 조회할 유저의 userId
	 * @return 해당userId의 유저
	 */
	GeneralUser selectGeneralUserByUserId(String userId);
	
	/**
	 * 전체 GeneralUser 칼럼 수를 반환
	 * @return 테이블 전체 컬럼 수
	 */
	int selectGeneralUserCount();
	
	/**
	 * GeneralUser의 전체 목록 중 활동 중이거나, 탈퇴된 회원의 수를 받아 옴
	 * @param userActiveState Y - 활동, N - 탈퇴
	 * @return 활동/탈퇴 상태인 회원의 수
	 */
	int selectGeneralUserByUserActiveStateCount(String userActiveState);
}
