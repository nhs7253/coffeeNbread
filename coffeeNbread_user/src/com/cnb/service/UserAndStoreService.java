package com.cnb.service;

import java.util.List;
import java.util.Map;

import com.cnb.exception.UserAndStoreServiceException;
import com.cnb.vo.StoreBookmark;
import com.cnb.vo.StoreVisitHistory;

/*
 * 노현식
 * 2017-06-30
 * 생성, 기본구현
 */
/**
 * 유저가 매장에 대해 받는 보조적인 서비스 집합 - 
 * 즐겨찾기, 조회 수별 추천가게, 최근 조회 매장
 */
public interface UserAndStoreService {
	
	/************** 즐겨찾기 **************/
	
	/**
	 * 해당 매장을 즐겨찾기에 추가함 (storeId로 중복 조회 후 추가)
	 * @param storeBookmark StoreBookmark(String userId, String storeId) 추가할 즐겨찾기 정보
	 * @throws UserAndStoreServiceException 이미 등록된 매장 일경우 예외 발생
	 */
	void addStoreBookmark(StoreBookmark storeBookmark) throws UserAndStoreServiceException;
	
	/**
	 * 유저의 모든 북마크를 삭제 (회원 탈퇴 시 사용)
	 * @param userId 탈퇴하는 유저의 ID
	 */
	void removeAllStoreBookmark(String userId);
	
	/**
	 * 유저가 선택한 매점 북마크 들을 삭제 
	 * @param userId 삭제를 요청하는 유저의 ID
	 * @param storeIdList 삭제 당할 매장의 ID 목록
	 */
	void selectRemoveStoreBookmark(String userId, List<String> storeIdList);
	
	/**
	 * 유저가 입력한 키워드를 통해 조회한 데이터를 페이징하여 보여줌
	 * @param userId 검색하는 유저의 ID
	 * @param page 보려는 페이지번호
	 * @param keyword 부분일치 조회로 검색할 키워드
	 * @return 페이징을 위한 정보 결과
	 */
	Map<String, Object> findStoreBookmarkListByKeyword(String userId, int page, String keyword);
	
	
	
	/************** 즐겨찾기 **************/
	
	

	/************** 조회 수별 추천 가게 **************/
	
	/**
	 * 유저가 방문한 내역을 저장
	 * @param storeVisitHistory StoreVisitHistory(String userId, String storeId) 방문한 유저 ID, 방문한 매장 ID
	 */
	void addStoreVisitHistory(StoreVisitHistory storeVisitHistory);
	
	/**
	 * 탈퇴하는 유저의 방문 했던 내용을 모두 삭제
	 * @param userId 탈퇴하는 유저의 ID
	 */
	void removeAllStoreVisitHistory(String userId);
	
	/**
	 * 유저가 선택한 방문 매장 기록들을 삭제
	 * @param userId 해당 방문 매장 목록을 가진 유저 ID
	 * @param storeIdList 삭제할 방문 매장 ID 목록
	 */
	void selectRemoveStoreVisitHistory(String userId, List<String> storeIdList);
	
	/**
	 * 유저가 입력한 키워드를 통해 조회한 데이터를 페이징하여 보여줌
	 * @param userId 검색하는 유저의 ID
	 * @param page 보려는 페이지번호
	 * @param keyword 부분일치 조회로 검색할 키워드
	 * @return 페이징을 위한 정보 결과
	 */
	Map<String, Object> findStoreVisitHistoryListByKeyword(String userId, int page, String keyword);
	/************** 조회 수별 추천 가게 **************/
	
	
	
	
	/************** 최근 조회 매장 **************/
	/************** 최근 조회 매장 **************/
	
}
