package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.StoreDao;
import com.cnb.exception.DuplicatedStoreIdException;
import com.cnb.service.StoreService;
import com.cnb.vo.Store;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreDao dao; 
	
	@Override
	public int addStore(Store store) throws DuplicatedStoreIdException{
		if(dao.selectStoreById(store.getStoreId())!=null){
			throw new DuplicatedStoreIdException(store.getStoreId()+" 는 이미 등록된 ID입니다.");
		}
		return dao.insertStore(store);
		
	}

	@Override
	public int modifyStore(Store store) {
		return dao.updateStore(store);
		
	}

	@Override
	public int removeStoretById(String storeId) {
		return dao.deleteStoreById(storeId);
		
	}

	@Override
	public Store findStoreById(String storeId) {
		
		return dao.selectStoreById(storeId);
	}

	@Override
	public List<Store> findStorePicture(String storeId) {
		
		return dao.selectStorePicture(storeId);
	}

	@Override
	public List<Store> findStoreEventList(String storeId) {
		
		return dao.selectStoreEventList(storeId);
	}

	@Override
	public List<Store> findStoreCategoryList(String storeId) {
		
		return dao.selectStoreCategoryList(storeId);
	}

	@Override
	public List<Store> findOpionCategoryNDetailByIdList(String storeId) {
		
		return dao.selectOpionCategoryNDetailByIdList(storeId);
	}


}
