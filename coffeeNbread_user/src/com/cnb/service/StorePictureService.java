package com.cnb.service;


import java.util.List;

import com.cnb.exception.DuplicatedStorePictureException;
import com.cnb.exception.StorePictureNotFoundException;
import com.cnb.vo.StorePicture;

/*
 * 이진영
 * 2017-07-01
 * 생성
 */
public interface StorePictureService {
	/**
	 * 1개의 매장 사진 정보 추가
	 * @param StorePicture
	 * @throws DuplicatedProductPictureException 한 제품에 등록하려는 제품 사	진이 이미 등록되 있는 경우 발생
	 */
	void addStorePicture(StorePicture storePicture) throws DuplicatedStorePictureException;
	
	/**
	 * 1개의 매장 사진 정보 수정
	 * @param StorePictureVO, StorePicture
	 */
	int modifyStorePictureByStorePicture(StorePicture storePictureVO) throws StorePictureNotFoundException;
	
	/**
	 * 1개의 매장 사진 정보 삭제
	 * @param StorePicture
	 */
	int removeStorePicture(StorePicture storePicture) throws StorePictureNotFoundException;
	
	int removeStorePictureById(String storeId);
}
