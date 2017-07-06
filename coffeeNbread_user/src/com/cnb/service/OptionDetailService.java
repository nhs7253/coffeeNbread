package com.cnb.service;

import com.cnb.exception.DuplicatedOptionDetailNameException;
import com.cnb.vo.OptionDetail;

public interface OptionDetailService {


	/**
	 * 1개의 옵션카테고리에 1개의 옵션디테일 정보 추가
	 * @param optionCategory
	 * @throws DuplicatedOptionDetailNameException 한 카테고리에 등록하려는 옵션디테일이 이미 등록되 있는 경우 발생
	 */
	 int addOptionDetail(OptionDetail optionDetail) throws DuplicatedOptionDetailNameException;	
	
	 /**
	 * 1개의 옵션카테고리에 있는 1개의 옵션디테일 정보 수정
	 * @param optionCategory
	 */
	 int modifyOptionDetail(OptionDetail optionDetail)throws DuplicatedOptionDetailNameException;
	
	 /**
	*  1개의 옵션카테고리에 있는 1개의 옵션디테일 정보 삭제
	* @param storeId optionId
		 */
	 int removeOptionDetail(String storeId,int optionId);
	 
}
