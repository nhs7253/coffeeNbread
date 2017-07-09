package com.cnb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.OptionDetailDao;
import com.cnb.exception.DuplicatedOptionDetailNameException;
import com.cnb.service.OptionDetailService;
import com.cnb.vo.OptionDetail;

@Service
public class OptionDetailServiceImpl implements OptionDetailService{

	@Autowired
	private OptionDetailDao dao;

	@Override
	public int addOptionDetail(OptionDetail optionDetail) throws DuplicatedOptionDetailNameException {
		if(dao.selectOptionDetailByOptionDetailName(optionDetail.getStoreId(), optionDetail.getOptionId(), optionDetail.getOptionCategoryDetail())!=null){
			throw new DuplicatedOptionDetailNameException(optionDetail.getOptionCategoryDetail()+"이미 등록되어 있음");
		}
		return dao.insertOptionDetail(optionDetail);
	}

	@Override
	public int modifyOptionDetail(OptionDetail optionDetail) throws DuplicatedOptionDetailNameException {
		if(dao.selectOptionDetailByOptionDetailName(optionDetail.getStoreId(), optionDetail.getOptionId(), optionDetail.getOptionCategoryDetail())!=null){
			throw new DuplicatedOptionDetailNameException(optionDetail.getOptionCategoryDetail()+"이미 등록되어 있음");
		}
		return dao.updateOptionDetail(optionDetail);
	}

	@Override
	public int removeOptionDetail(String storeId, int optionId) {
		
		return dao.deleteOptionDetail(storeId, optionId);
	}

	

}
