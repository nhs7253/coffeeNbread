package com.cnb.dao;

import java.util.List;

import com.cnb.vo.Product;
import com.cnb.vo.ProductGap;

/*
 * 최민희
 * 2017-06-29
 * 수정
 */
/*
 * 최민희
 * 2017-06-28
 * 생성
 */
/**
 * ProductGap 테이블을 관리하는 Dao 인터페이스
 * @author minhee
 *
 */
/**
 * 모든 제품의 증감폭을 관리하는 DAO
 * identifyCode
 * 하락 : D
 * 유지 : K
 * 증가 : U
 */
public interface ProductGapDao {
	/**
	 * 1개의 제품에 제품증감폭 insert
	 * @param productGap
	 * @return 처리 개수
	 */
	int insertProductGap(ProductGap productGap);
	
	/**
	 * 1개의 제품의 제품증감폭 update
	 * @param productGap
	 * @return 처리 개수
	 */
	int updateProductGap(ProductGap productGap);
	
	/**
	 * 제품 증감폭들 select
	 * 모든 제품 증감폭과 해당 제품 정보들을 조회한다.
	 * @param 
	 * @return 조회된 제품 증감폭 정보들
	 */
	List<ProductGap> selectProductGapList();
	
	/**
	 * 증감 식별코드로 해당 제품 정보들 select
	 * 제품 증감폭과 해당 제품 정보들을 조회한다.
	 * @param identifyCode
	 * @return 조회된 제품 증감폭 정보들
	 */
	List<ProductGap> selectProductGapListByIdentifyCode(String identifyCode);
	
}
