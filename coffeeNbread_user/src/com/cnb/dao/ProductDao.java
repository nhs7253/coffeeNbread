package com.cnb.dao;

import java.util.List;

import com.cnb.vo.Product;
import com.cnb.vo.QnaBoardContents;

/*
 * 노현식
 * 2017-07-13
 * POS용  selectProductListToPOS() 추가
 */
/*
 * 최민희
 * 2017-07-09
 * 수정
 */
/*
 * 최민희
 * 2017-07-01
 * 수정
 */
/*
 * 최민희
 * 2017-06-30
 * 수정
 */
/*
 * 최민희
 * 2017-06-29
 * 수정
 */
/*
 * 최민희
 * 2017-06-27
 * 생성
 */
/**
 * Product 테이블을 관리하는 Dao 인터페이스
 * @author minhee
 *
 */
/**
 * 모든 제품의 판매여부를 관리하는 DAO
 * sellingOption
 * 판매 O : Y
 * 판매 X : N
 */
public interface ProductDao {
	/**
	 * 1개의 제품 정보 insert
	 * @param product
	 * @return 처리 개수
	 */
	int insertProduct(Product product);
	
	/**
	 * 1개의 제품 정보 update
	 * @param product
	 * @return 처리 개수
	 */
	int updateProduct(Product product);
	
	
	/** 
	 * 조회된 제품 수 (Paging 용 count)
	 * @param storeId
	 * @return 조회된 제품 수
	 */
	int selectProductListCount(String storeId);

	/** 
	 * 여러 조건으로 조회된 제품 수 (Paging 용 count) - method : category, name, sellingOption
	 * @param storeId, method, methodContent
	 * @return 조회된 제품 수
	 */
	int selectProductListCountByMethod(String storeId, String method, String methodContent);
	
	/**
	 * 제품 종류로 1개의 매장에 있는 제품 정보들 select
	 * @param storeId, productCategory, startIndex, endIndex
	 * @return 조회된 제품 정보들
	 */
	List<Product> selectProductListByCategory(String storeId, String productCategory, int startIndex, int endIndex);
	
	/**
	 * 제품 종류로 1개의 매장에 있는 제품 정보들 select - 페이징 없는거 (판매량에 사용)
	 * @param storeId, productCategory
	 * @return 조회된 제품 정보들
	 */
	List<Product> selectProductListByCategoryNoPaging(String storeId, String productCategory);
	
	/**
	 * 제품 이름으로 1개의 매장에 있는 제품 정보들 select
	 * @param storeId, productName, startIndex, endIndex
	 * @return 조회된 제품 정보
	 */
	List<Product> selectProductListByName(String storeId, String productName, int startIndex, int endIndex);
	
	Product selectProductByName(String storeId, String productName);
	
	/**
	 * 제품 아이디로 1개의 매장에 있는 제품 정보 select
	 * @param storeId, productId
	 * @return 조회된 제품 정보
	 */
	Product selectProductById(String storeId, String productId);

	/**
	 * 판매여부 1개의 매장에 있는 제품 정보들 select
	 * @param storeId, sellingOption, startIndex, endIndex
	 * @return 조회된 제품 정보들
	 */
	List<Product> selectProductListBySellingOption(String storeId, String sellingOption, int startIndex, int endIndex);

	/**
	 * 판매여부 1개의 매장에 있는 제품 정보 select
	 * @param storeId, sellingOption,productName
	 * @return 조회된 제품 정보
	 */
	Product selectProductBySellingOption(String storeId, String sellingOption,String productName);

	
	/**
	 * 1개의 매장에 있는 모든 제품 정보 select
	 * @param storeId, startIndex, endIndex
	 * @return 조회된 제품 정보
	 */
	List<Product> selectProductList(String storeId, int startIndex, int endIndex);
	
	
	/**
	 * 선택한 제품들을 delete
	 * @param storeId, productIdList
	 * @return 삭제된 제품 개수
	 */
	int deleteProductByProductList(String storeId, List<String> productIdList);


	
	/**
	 * 제품과 제품사진의 조인결과를 페이징 하지 않고 보여줌 (POS)
	 * @param storeId 제품들을 가진 매장 ID
	 * @param select - productName(제품 이름), productCategory(제품 종류) 
	 * @param keyword 검색할 내용
	 * @return List<Product> 검색된 제품과 제품 사진 목록들
	 */
	List<Product> selectProductListToPOS(String storeId, String select, String keyword);

	/**
	 * 1개의 매장에 있는 모든 제품 정보 select - 페이징x
	 * @param storeId
	 * @return 조회된 제품 정보
	 */
	List<Product> selectProductListNoPaging(String storeId);
	
	
	/**
	 * 1개의 매장에있는 제품들  방법별로 페이징
	 */
	List<Product> selectProductListPagingByMethod(String select, String keyword, String storeId, int startIndex, int endIndex);
	
	
	
}
