package com.cnb.dao;

import java.util.List;

import com.cnb.vo.UserPreferenceStore;

/*
 * 노현식
 * 2017-06-29
 * 초기구현
 * 
 * 노현식
 * 2017-06-28
 * 생성
 */
/**
 * 방문 빈도 수를 기준으로 매장을 추천 해줌
 */
public interface UserPreferenceStoreDao {

	/**
	 * userPreferenceStore객체를 테이블에 insert함
	 * @param userPreferenceStore insert할 객체
	 * @return 처리 개수
	 */
	int insertUserPreferenceStore(UserPreferenceStore userPreferenceStore);
	
	/**
	 * 해당 유저 ID로 저장된 모든 컬럼 삭제 (유저 탈퇴 시 삭제 용도)
	 * @param userId 탈퇴하는 유저의 ID
	 * @return 처리 개수
	 */
	int deleteUserPreferenceStore(String userId);
	
	/**
	 * preferenceHits의 수를 1씩 증가 시킴
	 * @param userPreferenceStore 증가 시킬 preferenceHits를 가진 userPreferenceStore객체
	 * @return 처리 개수
	 */
	int updateUserPreferenceStoreByUserPreferenceStoreUpPreferenceHits(UserPreferenceStore userPreferenceStore);
	
	/**
	 * 매개변수로 받은 userPreferenceStore객체의 userId와 storeId가 같은 UserPreferenceStore를 조회
	 * @param userPreferenceStore 검색할 userId와 storeId를 가진 UserPreferenceStore 객체
	 * @return UserPreferenceStore 검색한 UserPreferenceStore 객체 
	 */
	UserPreferenceStore selectUserPreferenceByUserPreferenceStore(UserPreferenceStore userPreferenceStore);
	
	/**
	 * userId를 기준으로 UserPreferenceStore와 Store의 Join 결과를 preferenceHits수가 높은 순으로 정렬하여 5개 까지 보여줌
	 * @param userId 매장을 추천해줄 유저의 ID
	 * @return List<UserPreferenceStore> 유저에게의 추천 매장 목록
	 */
	List<UserPreferenceStore> selectUserPreferenceJoinStoreSort(String userId);
	
	/**
	 * 전체 컬럼 조회 (DAO 테스트 용)
	 * @return List<UserPreferenceStore>
	 */
	List<UserPreferenceStore> selectUserPreferenceList();
	
}
