package com.cnb.dao;

import java.util.List;

import com.cnb.vo.StorePicture;

/*
 * 최민희
 * 2017-06-29
 * 생성
 */
/**
 * StorePicture 테이블을 관리하는 Dao 인터페이스
 * @author minhee
 *
 */
public interface StorePictureDao {
	/**
	 * 1개의 매장 사진 정보 insert
	 * @param storePicture
	 * @return 처리 개수
	 */
	int insertStorePicture(StorePicture storePicture);
	
	/**
	 * 1개의 매장 사진 정보 update (원래 매장 사진 경로를 이용)
	 * @param storePictureVO, storePicture
	 * @return 처리 개수
	 */
	int updateStorePictureByStorePicture(StorePicture storePictureVO);
	
	/**
	 * 1개의 매장 사진 정보 delete
	 * @param storeId
	 * @return 처리 개수
	 */
	int deleteStorePicture(StorePicture storePicture);
	

	/**
	 * 1개의 매장 사진 정보들 select
	 * @param StoreId, storeId
	 * @return 조회된 제품 사진 정보들
	 */
	StorePicture selectStorePictureByStoreIdAndStorePicture(String storePicture,String storeId);	

	
	/**
	 * 1개의 매장 사진 정보들 select
	 * @param  storeId
	 * @return 조회된 제품 사진 정보들
	 */
	List<StorePicture> selectStorePictureListByStoreId(String storeId);	
	
}
