package com.cnb.dao;

import java.util.List;

import com.cnb.vo.StoreBookmark;

/*
 * 노현식
 * 2017-06-29
 * 페이징을 위한 추가
 * selectStoreBookmarkByUserIdJoinStoreListCount
 * selectStoreBookmarkByUserIdJoinStoreListPagingCount
 * selectStoreBookmarkByUserIdJoinStoreListPaging
 * 
 * 노현식
 * 2017-06-28
 * 생성, 초기구현
 */
public interface StoreBookmarkDao {

	/**
	 * storeBookmark객체를 받아 해당 정보를 추가
	 * @param storeBookmark StoreBookmark(String userId, String storeId)
	 * @return 처리 개수
	 */
	int insertStoreBookmark(StoreBookmark storeBookmark);
	
	/**
	 * 유저 탈퇴 시 사용, 해당 유저 아이디로 등록된 북마크 모두 제거
	 * @param userId 탈퇴하는 유저 ID
	 * @return 처리 개수
	 */
	int deleteStoreBookmarkByUserId(String userId);
	
	/**
	 * 삭제할 즐겨찾기 매장. 복합 기본키이므로 전체 객체를 넘김 (사용하지 않은 가능성 높음)
	 * @param storeBookmark StoreBookmark(String userId, String storeId)
	 * @return 처리 개수
	 */
	int deleteStoreBookmarkByStoreBookmark(StoreBookmark storeBookmark);
	
	/**
	 * 해당 유저의 삭제할 즐겨찾기 매장들을 제거
	 * @param userId 삭제할 매장들을 즐겨찾기한 userId
	 * @param storeIdList List<String> storeIdList 삭제할 storeId 목록
	 * @return 처리 개수
	 */
	int deleteStoreBookmarkByStoreBookmarkList(String userId, List<String> storeIdList);
	
	/**
	 * storeBookmark의 유저 아이디를 기준으로 매장 아이디를 변경
	 * @param storeBookmark StoreBookmark(String userId, String storeId)
	 * @return 처리 개수
	 */
	int updateStoreBookmark(StoreBookmark storeBookmark);
	
	/**
	 * StoreBookmark 테이블의 전체 정보 조회
	 * @return 테이블의 전체 정보
	 */
	List<StoreBookmark> selectStoreBookmarkList();
	
	/**
	 * 해당 유저가 즐겨찾기한 매장 아이디들 조회
	 * @return List<String> 매장 아이디 목록
	 */
	List<String> selectStoreBookmarkByUserId(String userId);
	
	/** 
	 * 해당 유저가 즐겨찾기한 매장 목록 조회
	 * @param userId 해당 목록을 찾을 유저 ID
	 * @return List<StoreBookmark> - 유저가 즐겨 찾기한 매장 목록
	 */
	List<StoreBookmark> selectStoreBookmarkByUserIdJoinStoreList(String userId);
	
	/** 
	 * 해당 유저가 즐겨찾기한 매장 목록 수 (Paging 용 count - 전체 조회 수)
	 * @param userId 해당 목록을 찾을 유저 ID
	 * @return int - 유저가 즐겨 찾기한 매장 목록 수
	 */
	int selectStoreBookmarkByUserIdJoinStoreListCount(String userId);
	
	/**
	 * 해당 유저가 즐겨찾기한 매장 목록 수를 일정 크기만큼 조회 (Paging 용 count - 부분 조회 수 - 매장 이름 순 정렬)
	 * @param userId 해당 목록을 찾을 유저 ID
	 * @param startIndex 페이징 시작 컬럼
	 * @param endIndex 페이징 끝 컬럼
	 * @return int - 유저가 즐겨 찾기한 매장 목록의 일정 조회 수 수
	 */
	int selectStoreBookmarkByUserIdJoinStoreListPagingCount(String userId, int startIndex, int endIndex);
	
	/**
	 * 해당 유저가 즐겨찾기한 매장 목록 수를 일정 크기만큼 조회 (Paging)
	 * @param userId 해당 목록을 찾을 유저 ID
	 * @param startIndex 페이징 시작 컬럼
	 * @param endIndex 페이징 끝 컬럼
	 * @return List<StoreBookmark> - 유저가 즐겨 찾기한 매장 목록 일정량
	 */
	List<StoreBookmark> selectStoreBookmarkByUserIdJoinStoreListPaging(String userId, int startIndex, int endIndex);
}
