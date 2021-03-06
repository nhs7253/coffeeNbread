package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.ProductPictureDao;
import com.cnb.exception.DuplicatedProductPictureException;
import com.cnb.exception.ProductPictureNotFoundException;
import com.cnb.service.ProductPictureService;
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
@Service
public class ProductPictureServiceImpl implements ProductPictureService {
	
	@Autowired
	private ProductPictureDao dao;

	@Override
	public int addProductPicture(ProductPicture productPicture) throws DuplicatedProductPictureException {
		if(dao.selectProductPictureListByProductPictureAndStoreId(productPicture.getProductPicture(), productPicture.getStoreId()) != null) {
			throw new DuplicatedProductPictureException(productPicture.getProductPicture() + "은 이미 등록된 사진 정보입니다.");
		}
		return dao.insertProductPicture(productPicture);
	}

	@Override
	public int modifyProductPictureByProductPicture(String productPicture, String productId, String storeId) throws ProductPictureNotFoundException {
		if(dao.selectProductPictureListByProductPictureAndStoreId(productPicture, storeId) == null) {
			throw new ProductPictureNotFoundException(String.format("제품 사진 정보가 %s 인 제품이 없습니다.", productPicture));
		}
		return dao.updateProductPictureByProductPicture(productPicture, productId, storeId);
	}

	@Override
	public int removeProductPicture(ProductPicture productPicture) throws ProductPictureNotFoundException {
		if(dao.selectProductPictureListByProductPictureAndStoreId(productPicture.getProductPicture(), productPicture.getStoreId()) == null) {
			throw new ProductPictureNotFoundException(String.format("제품 사진 정보가 %s 인 제품이 없습니다.", productPicture.getProductPicture()));
		}
		return dao.deleteProductPicture(productPicture);
	}

	@Override
	public ProductPicture findProductPictureByProductIdAndStoreId(String productId, String storeId) {
		return dao.selectProductPictureByProductIdAndStoreId(productId, storeId);
	}
	
	
}
