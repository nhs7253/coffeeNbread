package com.cnb.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cnb.exception.DuplicatedProductIdOrProductNameException;
import com.cnb.exception.DuplicatedProductPictureException;
import com.cnb.exception.ProductNotFoundException;
import com.cnb.vo.OptionDetail;
import com.cnb.vo.Product;

/*
 * 최민희
 * 2017-07-09
 * 수정
 */
/*
 * 최민희
 * 2017-07-08
 * 수정
 */
/*
 * 최민희
 * 2017-06-30
 * 수정
 */
public interface ProductService {
	/**
	 * 1개의 매장에 1개의 제품 정보 추가
	 * @param product
	 * @throws DuplicatedIdException 한 매장에 등록하려는 제품 아이디나 이름이 이미 등록되 있는 경우 발생
	 * - 제품 등록시 사진, 제품증감폭도 함께 등록해야함
	 * - 제품 등록시 제품 카테고리 안에 제품을 등록해야함
	 */
	int addProduct(Product product, OptionDetail optionDetail) throws DuplicatedProductIdOrProductNameException, DuplicatedProductPictureException;
	
	/**
	 * 1개의 매장에 있는 1개의 제품 정보 수정
	 * @param product, fileName
	 * @throws ProductNotFoundException 수정할 제품이 등록되 있지 않은 경우 발생
	 */
	int modifyProduct(Product product,OptionDetail optionDetail, String fileName) throws ProductNotFoundException, DuplicatedProductPictureException;
	
	/**
	 * 제품 종류로 1개의 매장에 있는 제품 정보들 찾기
	 * @param storeId, productCategory, page
	 */
	HashMap<String, Object> findProductListByCategory(int page, String storeId, String productCategory);
	
	/**
	 * 제품 이름으로 1개의 매장에 있는 제품 정보 찾기
	 * @param storeId, productName, page
	 */
	HashMap<String, Object> findProductListByName(int page, String storeId, String productName);
	
	/**
	 * 제품 이름으로 1개의 매장에 있는 제품 정보들 찾기
	 * @param storeId, productName
	 */
	Product findProductByName(String storeId, String productName);
	
	/**
	 * 제품 아이디로 1개의 매장에 있는 제품 정보 찾기
	 * @param storeId, productId
	 */
	Product findProductById(String storeId, String productId);

	/**
	 * 판매여부 1개의 매장에 있는 제품 정보들 select
	 * @param storeId, sellingOption, page
	 * @return 조회된 제품 정보들
	 */
	HashMap<String, Object> findProductListBySellingOption(int page, String storeId, String sellingOption);
	
	
	/**
	 * 1개의 매장에 있는 제품 정보들 찾기
	 * @param storeId, page
	 */
	HashMap<String, Object> findProductList(int page, String storeId);


	/**
	 * 1개의 제품 판매 상태로 1개의 옵션상세 삭제하기 
	 * @param product,optionDetail
	 */
	void removeOptionDetail(Product product,OptionDetail optionDetail);

	/**
	 * 선택한 제품들을 삭제 
	 * @param storeId 삭제를 요청하는 매장 ID
	 * @param productIdList 삭제 당할 제품의 ID 목록
	 */
	void findRemoveProduct(String storeId, List<String> productIdList);

	/**
	 * 1개의 매장에 있는 모든 제품들 조회 - 페이징x
	 * @param
	 */
	List<Product> findProductListNoPaging(String storeId);
	
	
	/**
	 * 1의 매장에있는 제품카테고리와 제품명을 기준으로 조회- 페이징
	 * 
	 */
	
	HashMap<String, Object> findProductListByMethod(int page,String storeId,String select, String keyword);
	
	
	
	
	
	
	
	
	
	
	
}
