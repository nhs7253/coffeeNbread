package com.cnb.dao;

import com.cnb.vo.Product;
import com.cnb.vo.StoreCategory;

/*이진영
 * 2017-07-03
 * 수정
 * 
 * 이진영
 * 2017-06-28 생성
 */
/**
 * StoreCategory 테이블을 관리하는 Dao 인터페이스
 * @author jinyoung
 *
 */

public interface StoreCategoryDao {
	/**
	 * 1개의 매장분류 정보 insert
	 * @param StoreCategory
	 * @return 처리 개수
	 */
	int insertStoreCategory(StoreCategory storeCategory);
	
	/**
	 * 1개의 매장분류 정보 update
	 * @param StoreCategory
	 * @return 처리 개수
	 */
	int updateStoreCategory(StoreCategory storeCategory);
	
	/**
	 * 1개의 매장에 있는 1개의 매장분류 정보 delete
	 * @param storeId, storeCategoryNo
	 * @return 처리 개수
	 */
	int deleteStoreCategoryByNo(String storeId,int storeCategoryNo);
	

	/**
	 * 매장 카테고리 이름으로 1개의 매장에 있는 제품 정보 select
	 * @param storeId, storeCategory
	 * @return 조회된 제품 정보
	 */
	StoreCategory selectStoreCategoryByName(String storeId, String storeCategory);
	
	
}
