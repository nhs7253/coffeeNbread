package com.cnb.service;

import java.util.List;
import java.util.Map;

import com.cnb.vo.StoreBookmark;

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
	 */
	void addStoreBookmark(StoreBookmark storeBookmark);
	
	/**
	 * 유저의 모든 북마크를 삭제 (회원 탈퇴 시 사용)
	 * @param userId 탈퇴하는 유저의 ID
	 */
	void removeAllStoreBookmark(String userId);
	
	/**
	 * 유저가 선택한 매점 북마크 들을 삭제 (storeIdList에 있는 매장인지 확인 후 삭제)
	 * @param userId 삭제를 요청하는 유저의 ID
	 * @param storeIdList 삭제 당할 매장의 ID 목록
	 */
	void selectRemoveStoreBookmark(String userId, List<String> storeIdList);
	
	/**
	 * 유저가 입력한 키워드를 통해 조회한 데이터를 페이징하여 보여줌
	 * @param page 보려는 페이지번호
	 * @param keyword 부분일치 조회로 검색할 키워드
	 * @return 페이징을 위한 정보 결과
	 */
	Map<String, Object> findStoreBookmarkListByKeyowrd(int page, String keyword);
	
	
	
	/************** 즐겨찾기 **************/
	
	

	/************** 조회 수별 추천 가게 **************/
	/************** 조회 수별 추천 가게 **************/
	
	
	
	
	/************** 최근 조회 매장 **************/
	/************** 최근 조회 매장 **************/
	
}
