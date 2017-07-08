package com.cnb.dao;

import java.util.List;

import com.cnb.vo.StorePosition;

/*
 * 노현식
 * 2017-06-28
 * 생성, 초기구현
 */
public interface StorePositionDao {

	/**
	 * 전달 받은 객체를 insert
	 * @param storePosition insert할 매장 좌표 객체
	 * @return 처리 개수
	 */
	int insertStorePosition(StorePosition storePosition);
	
	/**
	 * 삭제할  매장 좌표의 ID
	 * @param storeId 삭제할 가게의 ID
	 * @return 처리 개수
	 */
	int deleteStorePositionByStoreId(String storeId);
	
	/**
	 * 변경할 매장 좌표의 ID
	 * @param storePosition update할 매장 좌표 객체
	 * @return 처리 개수
	 */
	int updateStorePosition(StorePosition storePosition);
	
	/**
	 * 등록된 매장 전체 좌표 목록을 반환
	 * @return List<StorePosition> - 매장 좌표 목록
	 */
	//List<StorePosition> selectStorePositionList();
	
	/**
	 * 해당 ID의 매장 자표를 조회 (목록에서 매장 클릭 시, 맵에 띄어 줄때 사용)
	 * @param storeId 검색할 매장 ID
	 * @return StorePosition - 해당 ID의 매장 좌표 객체
	 */
	//StorePosition selectStorePositionByStoreId(String storeId);
	
	/**
	 * 해당 ID의 매장 자표를 조회 (목록에서 매장 클릭 시, 맵에 띄어 줄때 사용 - 세부 내용 구현 시 사용)
	 * @param storeId storeId 검색할 매장 ID
	 * @return StorePosition - 해당 ID의 매장 좌표 객체
	 */
	StorePosition selectStorePositionByStoreIdJoinStore(String storeId);
	
	/**
	 * 등록된 매장 전체 좌표 목록과 세부 사항을 반환
	 * @return List<StorePosition> - 매장 좌표 목록과 세부 사항
	 */
	List<StorePosition> selectStorePositionJoinStoreList();
}
