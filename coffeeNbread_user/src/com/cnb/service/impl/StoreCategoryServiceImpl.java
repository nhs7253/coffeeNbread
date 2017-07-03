package com.cnb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.StoreCategoryDao;

import com.cnb.exception.DuplicatedStoreCategorytNameException;
import com.cnb.service.StoreCategoryService;
import com.cnb.vo.StoreCategory;

/*
 * 2017-07-01
 * 생성
 */
@Service
public class StoreCategoryServiceImpl implements StoreCategoryService{

	@Autowired
	private StoreCategoryDao dao;
	

	@Override
	public int addStoreCategory(StoreCategory storeCategory) throws DuplicatedStoreCategorytNameException {
		if(dao.selectStoreCategoryByName(storeCategory.getStoreId(), storeCategory.getStoreCategory())!= null){
			throw new DuplicatedStoreCategorytNameException(storeCategory.getStoreCategory()+"이미 등록되어 있습니다.");
		}
		return dao.insertStoreCategory(storeCategory);
	}

	@Override
	public int modifyStoreCategory(StoreCategory storeCategory) {
		
		return dao.updateStoreCategory(storeCategory);
	}

	@Override
	public int removeStoreCategoryByNo(String storeId, int storeCategoryNo) {
		return dao.deleteStoreCategoryByNo(storeId, storeCategoryNo);
	}

}