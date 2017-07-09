package com.cnb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cnb.exception.DuplicatedProductPictureException;
import com.cnb.exception.ProductPictureNotFoundException;
import com.cnb.vo.ProductPicture;

/*
 * 최민희
 * 2017-07-01
 * 수정
 */
/*
 * 최민희
 * 2017-06-30
 * 생성
 */
public interface ProductPictureService {
	/**
	 * 1개의 제품 사진 정보 추가
	 * @param productPicture
	 * @throws DuplicatedProductPictureException 한 제품에 등록하려는 제품 사	진이 이미 등록되 있는 경우 발생
	 */
	int addProductPicture(ProductPicture productPicture) throws DuplicatedProductPictureException;
	
	/**
	 * 1개의 제품 사진 정보 수정
	 * @param productPicture
	 */
	int modifyProductPictureByProductPicture(String productPicture, String productId, String storeId) throws ProductPictureNotFoundException;
	
	/**
	 * 1개의 제품 사진 정보 삭제
	 * @param productPicture
	 */
	int removeProductPicture(ProductPicture productPicture) throws ProductPictureNotFoundException;
	
	/**
	 * 1개의 매장에 있는 1개의 제품정보로 제품 사진 정보들 찾기
	 * @param productId, storeId
	 */
	ProductPicture findProductPictureByProductIdAndStoreId(String productId, String storeId);

}
