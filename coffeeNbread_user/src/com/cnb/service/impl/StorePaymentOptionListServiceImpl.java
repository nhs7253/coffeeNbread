package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.StorePaymentOptionListDao;
import com.cnb.dao.StorePictureDao;
import com.cnb.service.StorePaymentOptionListService;
import com.cnb.vo.PaymentOptionList;
import com.cnb.vo.StorePaymentOptionList;

/*
 * 김형주
 * 2017-07-16 구현
 */




@Service
public class StorePaymentOptionListServiceImpl implements StorePaymentOptionListService{
	
	@Autowired
	private StorePaymentOptionListDao spoDao;
	
	
	@Override
	public List<StorePaymentOptionList> findStorePaymentOptionList(String storeId) {
		return spoDao.selectStorePaymentOptionListByStoreId(storeId);
	}
	

}
