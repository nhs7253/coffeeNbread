package com.cnb.dao;


import java.util.List;

import com.cnb.vo.OptionCategory;

import com.cnb.vo.OptionDetail;

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
public interface OptionDetailDao {
	/**
	 * 1개의 옵션디테일 정보 insert
	 * @param OptionDetail
	 * @return 처리 개수
	 */
	int insertOptionDetail(OptionDetail optionDetail);
	
	/**
	 * 1개의 옵션디테일 정보 update
	 * @param OptionDetail
	 * @return 처리 개수
	 */
	int updateOptionDetail(OptionDetail optionDetail);
	
	/**
	 * 1개의 매장에 있는 1개의 옵션디테일 정보 delete
	 * @param OptionDetail 
	 * @return 처리 개수
	 */
	int deleteOptionDetail(String storeId,int optionId);
	
	/**
	 * 제품아이디로 옵션디테일정보 삭제 
	 * @param storeId
	 * @param productId
	 * @return
	 */
	int deleteOptionDetailByProductId(String storeId,String productId);
	
	/**
		 * 옵션카테고리로 옵션 디테일  정보리스트 select
		 * @param storeId, OptionId
		 * @return 조회된 옵션 디테일
		 */
	List<OptionDetail> selectOptionDetailListByOptionCategory(String storeId,int OptionId);

	/**
	 * 옵션디테일 이름으로 옵션 디테일  정보 select
	 * @param storeId, OptionId
	 * @return 조회된 옵션 디테일
	 */
	OptionDetail selectOptionDetailByOptionDetailName(String storeId,int optionId ,String optionCategoryDetail);

	/**
	 * 제품아이디로 옵션 디테일 정보 select
	 * @param storeId, optionId, optionCategoryDetail
	 * @return 조회된 옵션 디테일
	 */
	OptionDetail selectOptionDetailByProductId(String storeId,String productId);

}
