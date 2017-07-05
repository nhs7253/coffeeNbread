package com.cnb.dao;

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
	int deleteOptionCategory(int optionId);
	
}
