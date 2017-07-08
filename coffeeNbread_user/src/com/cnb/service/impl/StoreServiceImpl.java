package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.StoreDao;
import com.cnb.exception.DuplicatedOptionCategoryNameException;
import com.cnb.exception.DuplicatedStoreCategorytNameException;
import com.cnb.exception.DuplicatedStoreIdException;
import com.cnb.exception.DuplicatedStorePictureException;
import com.cnb.exception.StorePictureNotFoundException;
import com.cnb.service.OptionCategoryService;
import com.cnb.service.StoreCategoryService;
import com.cnb.service.StorePictureService;
import com.cnb.service.StoreService;
import com.cnb.vo.OptionCategory;
import com.cnb.vo.Store;
import com.cnb.vo.StoreCategory;
import com.cnb.vo.StorePicture;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreDao storedao; 
	
	@Autowired
	private StoreCategoryService storeCategoryService;
	
	@Autowired 
	private OptionCategoryService optionCategoryService;
	
	@Autowired
	private StorePictureService storePictureService;
	
	
	@Override
	public void addStore(Store store,List<StoreCategory> storeCategory,StorePicture storePicture) throws DuplicatedStoreIdException, DuplicatedOptionCategoryNameException, DuplicatedStoreCategorytNameException, DuplicatedStorePictureException{
		//storeId 중복확인
		if(storedao.selectStoreById(store.getStoreId())!=null){
			throw new DuplicatedStoreIdException(store.getStoreId()+" 는 이미 등록된 ID입니다.");
		}
		//store 추가
		storedao.insertStore(store);
		
		//매장 분류 추가
		storeCategoryService.addStoreCategory(storeCategory);

		
		//매장 사진 추가 
		storePictureService.addStorePicture(storePicture);
		
		
		
		
	}

	/*@Override
	public int modifyStore(Store store) {
		return storedao.updateStore(store);
		
	}*/
	@Override
	public void modifyStore(Store store,List<StoreCategory> storeCategory,List<StorePicture> storePicture) throws DuplicatedStoreIdException, StorePictureNotFoundException {
		 if(storedao.selectStoreById(store.getStoreId())==null){
			 storedao.updateStore(store);
		 }else{
				throw new DuplicatedStoreIdException(store.getStoreId()+" 는 이미 등록된 ID입니다.");
		 }
		 
		 storeCategoryService.modifyStoreCategory(storeCategory);
		 
		 storePictureService.modifyStorePictureByStorePicture(storePicture.get(0));
		 
		 
		 
	}
		
	@Override
	public int removeStoretById(String storeId) {
		System.out.println("service들어옴");
		System.out.println("storeId = "+storeId);
		storeCategoryService.removeStoreCategoryById(storeId);
		System.out.println("매장분류 삭제");
		storePictureService.removeStorePictureById(storeId);
		System.out.println("사진 삭제");

		int cnt = storedao.deleteStoreById(storeId);
		System.out.println("매장삭제");

		return cnt;
		
	}

	@Override
	public Store findStoreById(String storeId) {
		
		return storedao.selectStoreById(storeId);
	}

	@Override
	public List<Store> findStorePicture(String storeId) {
		
		return storedao.selectStorePicture(storeId);
	}

	@Override
	public List<Store> findStoreEventList(String storeId) {
		
		return storedao.selectStoreEventList(storeId);
	}

	@Override
	public List<Store> findStoreCategoryList(String storeId) {
		
		return storedao.selectStoreCategoryList(storeId);
	}

	@Override
	public List<Store> findOpionCategoryNDetailByIdList(String storeId) {
		
		return storedao.selectOpionCategoryNDetailByIdList(storeId);
	}


}
