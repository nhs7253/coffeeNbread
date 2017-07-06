package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.OptionCategoryDao;
import com.cnb.dao.OptionDetailDao;
import com.cnb.exception.DuplicatedOptionCategoryNameException;
import com.cnb.service.OptionCategoryService;
import com.cnb.vo.OptionCategory;
/*
 * 이진영
 * 2017-07-01
 * 생성
 */
@Service
public class OptionCategoryServiceImpl implements OptionCategoryService{

	@Autowired
	private OptionCategoryDao dao;
	
	@Autowired
	private OptionDetailDao detailDao;
	
	@Override
	public void addOptionCategory(List<OptionCategory> optionCategoryList) throws DuplicatedOptionCategoryNameException {
		List<OptionCategory> optionCategoryList2 = dao.selectOptionCategoryListByStoreId(optionCategoryList.get(0).getStoreId());
				
		if(optionCategoryList2.size() == 0){
			for(int i = 0;i<optionCategoryList.size();i++){
			 dao.insertOptionCategory(optionCategoryList.get(i));
			}
		}else{
			for(int i = 0;i<optionCategoryList.size();i++){
				for(int j = 0;j<optionCategoryList.size();j++)
				if((dao.selectOptionCategoryByName(optionCategoryList.get(j).getStoreId(),optionCategoryList.get(j).getOptionCategory()).getOptionCategory().equals(optionCategoryList.get(i).getOptionCategory()))){
					throw new DuplicatedOptionCategoryNameException(optionCategoryList.get(i).getOptionCategory()+"는 이미 등록되어 있습니다.");
				}
				dao.insertOptionCategory(optionCategoryList.get(i));
			}
		}		

	}

	@Override
	public int modifyOptionCategory(OptionCategory optionCategory) {
		//소분류 있을 경우 소분류 삭제 후 수정
		if(detailDao.selectOptionDetailListByOptionCategory(optionCategory.getStoreId(), optionCategory.getOptionId()).size()>0){
			detailDao.deleteOptionDetail(optionCategory.getStoreId(), optionCategory.getOptionId());
			return dao.updateOptionCategory(optionCategory);
		}else{
		return dao.updateOptionCategory(optionCategory);
		}
	}

	@Override
	public int removeOptionCategory(String storeId,int optionId) {
		//소분류 있을 경우 소분류 삭제 후 대분류 삭제 
		if(detailDao.selectOptionDetailListByOptionCategory(storeId, optionId).size()>0){
			detailDao.deleteOptionDetail(storeId, optionId);
			return dao.deleteOptionCategory(storeId, optionId);
		}else{
		return dao.deleteOptionCategory(storeId, optionId);
		}
	}

}
