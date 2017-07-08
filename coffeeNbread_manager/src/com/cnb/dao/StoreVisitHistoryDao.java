package com.cnb.dao;

import java.util.List;

import com.cnb.vo.StoreVisitHistory;

/*
 * 노현식
 * 2017-06-29
 * 초기구현
 * 
 * 노현식
 * 2017-06-28
 * 생성
 */
public interface StoreVisitHistoryDao {
	
	/**
	 * storeVisitHistory객체를 받아 해당 정보를 추가
	 * @param storeVisitHistory StoreVisitHistory(String userId, String storeId) 방문한 유저 ID, 방문한 매장 ID
	 * @return 처리 개수
	 */
	int insertStoreVisitHistory(StoreVisitHistory storeVisitHistory);
	
	/**
	 * 유저 탈퇴 시 사용, 해당 유저 아이디로 기록된 방문 내역 모두 제거
	 * @param userId 탈퇴하는 유저 ID
	 * @return 처리 개수
	 */
	int deleteStoreVisitHistoryByUserId(String userId);
	
	/**
	 * 삭제할 방문 기록 매장. 복합 기본키이므로 전체 객체를 넘김 (사용하지 않은 가능성 높음)
	 * @param StoreVisitHistory storeVisitHistory(String userId, String storeId)
	 * @return 처리 개수
	 */
	int deleteStoreVisitHistoryByStoreVisitHistory(StoreVisitHistory storeVisitHistory);
	
	/**
	 * 해당 유저의 삭제할 방문 매장들을 제거
	 * @param userId 삭제할 방문 매장들을 가진 userId
	 * @param storeIdList List<String> storeIdList 삭제할 storeId 목록
	 * @return 처리 개수
	 */
	int deleteStoreVisitHistoryByStoreVisitHistoryList(String userId, List<String> storeIdList);
	
	
	/**
	 * StoreVisitHistory 테이블의 전체 정보 조회
	 * @return 테이블의 전체 정보
	 */
	List<StoreVisitHistory> selectStoreVisitHistoryList();
	
	/**
	 * 해당 유저가 방문한 매장 아이디들 조회 (가장 마지막에 방문한 매장 부터 조회)
	 * @return List<String> 매장 아이디 목록
	 */
	List<String> selectStoreVisitHistoryByUserId(String userId);
	
	/** 
	 * 해당 유저가 방문한 매장 목록 조회  (가장 마지막에 방문한 매장 부터 조회)
	 * @param userId 해당 목록을 찾을 유저 ID
	 * @return List<StoreVisitHistory> - 유저가 방문한 매장 목록
	 */
	List<StoreVisitHistory> selectStoreVisitHistoryByUserIdJoinStoreList(String userId);
	
	/** 
	 * 해당 유저가 방문한 매장 목록 수 (Paging 용 count - 전체 조회 수)
	 * @param userId 해당 목록을 찾을 유저 ID
	 * @return int - 유저가 방문한 매장 목록 수
	 */
	int selectStoreVisitHistoryByUserIdJoinStoreListCount(String userId);
	
	/**
	 * 해당 유저가 방문한 매장 목록 수를 일정 크기만큼 조회 (Paging 용 count - 부분 조회 수 - 매장 이름 순 정렬) - (가장 마지막에 방문한 매장 부터 조회)  - 사용X
	 * @param userId 해당 목록을 찾을 유저 ID
	 * @param startIndex 페이징 시작 컬럼
	 * @param endIndex 페이징 끝 컬럼
	 * @return int - 유저가 방문한 매장 목록의 일정 조회 수
	 */
	int selectStoreVisitHistoryByUserIdJoinStoreListPagingCount(String userId, int startIndex, int endIndex);
	
	/**
	 * 해당 유저가 방문한 매장 목록 수를 일정 크기만큼 조회 (Paging) -  (가장 마지막에 방문한 매장 부터 조회)
	 * @param userId 해당 목록을 찾을 유저 ID
	 * @param keyword 검색할 키워드
	 * @param startIndex 페이징 시작 컬럼
	 * @param endIndex 페이징 끝 컬럼
	 * @return List<StoreVisitHistory> - 유저가 방문한 매장 목록 일정량
	 */
	List<StoreVisitHistory> selectStoreVisitHistoryByUserIdJoinStoreListPaging(String userId, String keyword, int startIndex, int endIndex);


}
