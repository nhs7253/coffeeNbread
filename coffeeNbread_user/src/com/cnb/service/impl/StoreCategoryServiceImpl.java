package com.cnb.service.impl;

import java.util.List;

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
	public void addStoreCategory(List<StoreCategory> storeCategoryList) throws DuplicatedStoreCategorytNameException {
		
		List<StoreCategory> storeCategoryList2 = dao.selectStoreCategoryListByStoreId(storeCategoryList.get(0).getStoreId());
		
		
		if(storeCategoryList2.size() == 0){
			for(int i = 0;i<storeCategoryList.size();i++)  
			dao.insertStoreCategory(storeCategoryList.get(i));
		}else{
			for(int i = 0; i<storeCategoryList.size();i++){
				for(int j = 0;j<storeCategoryList.size();j++){
					if((dao.selectStoreCategoryByName(storeCategoryList.get(j).getStoreId(), storeCategoryList.get(j).getStoreCategory()))!=null){ 
						if(((dao.selectStoreCategoryByName(storeCategoryList.get(j).getStoreId(), storeCategoryList.get(j).getStoreCategory())).getStoreCategory()).equals(storeCategoryList.get(i).getStoreCategory())){
							throw new DuplicatedStoreCategorytNameException(storeCategoryList.get(i).getStoreCategory()+"이미 등록되어 있습니다.");
						}
					}else 
					dao.insertStoreCategory(storeCategoryList.get(i));
				}
			}}
		
		
	}

	@Override
	public void modifyStoreCategory(List<StoreCategory> storeCategoryList) {
		for(int i = 0;i<storeCategoryList.size();i++)
		 dao.updateStoreCategory(storeCategoryList.get(i));
	}

	@Override
	public int removeStoreCategoryByNo(String storeId, int storeCategoryNo) {
		return dao.deleteStoreCategoryByNo(storeId, storeCategoryNo);
	}

	@Override
	public int removeStoreCategoryById(String storeId) {
		
		return dao.deleteStoreCategoryById(storeId);
	}

}
