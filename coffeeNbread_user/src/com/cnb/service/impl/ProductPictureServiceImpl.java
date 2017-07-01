package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.ProductPictureDao;
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
	public int addProductPicture(ProductPicture productPicture) {
		return 0;
	}

	@Override
	public int modifyProductPictureByProductPicture(ProductPicture productPictureVO, String productPicture) {
		return 0;
	}

	@Override
	public int removeProductPicture(ProductPicture productPicture) {
		return 0;
	}

	@Override
	public List<ProductPicture> findProductPictureListByProductIdAndStoreId(String productId, String storeId) {
		return null;
	}
	
}
