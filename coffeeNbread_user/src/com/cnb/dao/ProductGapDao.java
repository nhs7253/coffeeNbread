package com.cnb.dao;

import java.util.List;

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
 * 상승 : U
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
	 * 여러 조건으로 조회된 예약 내역 수 (Paging 용 count)
	 * @param storeId, method, methodContent
	 * @return 조회된 예약 내역 수
	 */
	int selectProductGapListCountByMethod(String storeId, String method, String methodContent);
	
	
	/**
	 * 한 매장에서의 제품 증감폭들 select
	 * 모든 제품 증감폭과 해당 제품 정보들을 조회한다.
	 * @param storeId, startIndex, endIndex
	 * @return 조회된 제품 증감폭 정보들
	 */
	List<ProductGap> selectProductGapListByStoreId(String storeId, int startIndex, int endIndex);
	
	/**
	 * 한 매장에서 증감 식별코드로 해당 제품 정보들 select
	 * 제품 증감폭과 해당 제품 정보들을 조회한다.
	 * @param storeId, identifyCode, startIndex, endIndex
	 * @return 조회된 제품 증감폭 정보들
	 */
	List<ProductGap> selectProductGapListByIdentifyCodeByStoreIdAndIdentifyCode(String storeId, String identifyCode, int startIndex, int endIndex);
	
	/**
	 * 한 제품의 증감 식별코드 조회
	 * @param storeId, productId
	 * @return 조회된 증감 식별코드
	 */
	String selectIdentifyCodeByProductId(String storeId, String productId);
}
