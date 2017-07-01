package com.cnb.dao;

import java.util.List;

import com.cnb.vo.ProductPicture;

/*
 * 최민희
 * 2017-06-29
 * 생성
 */
/**
 * ProductPicture 테이블을 관리하는 Dao 인터페이스
 * @author minhee
 *
 */
public interface ProductPictureDao {
	/**
	 * 1개의 제품 사진 정보 insert
	 * @param productPicture
	 * @return 처리 개수
	 */
	int insertProductPicture(ProductPicture productPicture);
	
	/**
	 * 1개의 제품 사진 정보 update
	 * @param productPictureVO, productPicture
	 * @return 처리 개수
	 */
	int updateProductPictureByProductPicture(ProductPicture productPictureVO, String productPicture);
	
	/**
	 * 1개의 제품 사진 정보 delete
	 * @param productPicture
	 * @return 처리 개수
	 */
	int deleteProductPicture(ProductPicture productPicture);
	
	/**
	 * 1개의 매장에 있는 1개의 제품아이디로 제품 사진 정보들 select
	 * @param productId, storeId
	 * @return 조회된 제품 사진 정보들
	 */
	List<ProductPicture> selectProductPictureListByProductIdAndStoreId(String productId, String storeId);
	
	/**
	 * 1개의 매장에 있는 1개의 제품정보로 제품 사진 정보들 select
	 * @param ProductPicture, storeId
	 * @return 조회된 제품 사진 정보
	 */
	ProductPicture selectProductPictureListByProductPictureAndStoreId(String ProductPicture, String storeId);
	
}
