package com.cnb.dao;

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
	int deleteOptionDetail(int optionId);
	
}
