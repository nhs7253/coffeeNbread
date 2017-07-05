package com.cnb.dao;

import java.util.List;

import com.cnb.vo.OptionCategory;

/*
 * 이진영
 * 2017-06-29
 * 생성
 */
/**
 * OptionCategory 테이블을 관리하는 Dao 인터페이스
 * @author jinyoung
 *
 */
public interface OptionCategoryDao {
	/**
	 * 1개의 옵션카테고리 정보 insert
	 * @param OptionCategory
	 * @return 처리 개수
	 */
	int insertOptionCategory(OptionCategory optionCategory);
	
	/**
	 * 1개의 옵션카테고리 정보 update
	 * @param OptionCategory
	 * @return 처리 개수
	 */
	int updateOptionCategory(OptionCategory optionCategory);
	
	/**
	 * 1개의 매장에 있는 1개의 옵션카테고리 정보 delete
	 * @param OptionCategory 
	 * @return 처리 개수
	 */
	int deleteOptionCategory(String storeId,int optionId);
	

	/**
	 * 1개 매장 아이디로 1개의 옵션카테고리 정보 select
	 * @param storeId, OptionCategory
	 * @return 조회된 카테고리정보
	 */
	OptionCategory selectOptionCategoryByName(String storeId, String OptionCategory);
	
	/**
	 * 1개 매장 아이디로 1개의 옵션카테고리 정보 select
	 * @param storeId, OptionCategory
	 * @return 조회된 카테고리정보
	 */
	List<OptionCategory> selectOptionCategoryListByStoreId(String storeId);
	
	
	/**
	 * 옵션카테고리로 옵션 디테일  정보리스트 select
	 * @param storeId, OptionId
	 * @return 조회된 옵션 디테일
	 *//*
	List<OptionCategory> selectOptionDetailListByOptionCategory(String storeId,int OptionId);
*/
}
