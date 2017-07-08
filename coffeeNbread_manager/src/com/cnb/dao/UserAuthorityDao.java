package com.cnb.dao;

import java.util.List;

import com.cnb.vo.UserAuthority;

/*
 * 노현식
 * 2017-06-27
 * 생성, 최초 구현
 */
/**
 * 모든 사용자의 권한을 관리하는 DAO
 * 관리자 - CNB_ADMIN
 * 매점 - CNB_STORE
 * 일반 유저 - CNB_USER
 */
public interface UserAuthorityDao {
	
	/**
	 * 매개변수로 받은 userAuthority를 insert 한다.
	 * @param userAuthority insert할 개체
	 * @return 처리 개수
	 */
	int insertUserAuthority(UserAuthority userAuthority);
	
	/**
	 * 매개변수로 받은 userId에 해당하는 모든 권한 제거
	 * @param userId 제거할 대상의 ID
	 * @return 처리 개수
	 */
	int deleteUserAuthorityByUserId(String userId);
	
	/**
	 * 해당 유저의 특정 유저 권한 만을 삭제 (매장 -> 일반 유저)
	 * @param userAuthority 삭제할 유저와 권한
	 * @return 처리 개수
	 */
	int deleteUserAuthorityByUserAuthorityData(UserAuthority userAuthority);
	
	/**
	 * 해당 유저의 관리 권한을 변경 (매장 유저를 일반유저로 변경)
	 * @param userAuthority 변경한 유저 객체
	 * @return 처리 개수
	 */
	int updateUserAuthorityByUserId(UserAuthority userAuthority);
	
	/**
	 * 테이블의 전체 컬럼을 반환
	 * @return 전체 데이터
	 */
	List<UserAuthority> selectUserAuthorityList();
	
	/**
	 * userId로 해당 유저가 가진 권한을 조회 (다중 권한으로 변경 시 반환형 List<UserAuthority>로 변경 필요)
	 * @param userId 조회할 유저
	 * @return 조회한 userId가 가진 권한들
	 */
	UserAuthority selectUserAuthorityByUserId(String userId);
}
