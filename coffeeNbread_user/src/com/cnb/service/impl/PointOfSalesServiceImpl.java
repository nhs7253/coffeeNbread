package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnb.dao.PaymentDetailsDao;
import com.cnb.dao.ProductDao;
import com.cnb.dao.StorePaymentOptionListDao;
import com.cnb.service.PointOfSalesService;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.Product;
import com.cnb.vo.StorePaymentOptionList;

/*
 * 노현식
 * 2017-07-13
 * 생성, 초기 구현
 */
@Service
public class PointOfSalesServiceImpl implements PointOfSalesService{
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private PaymentDetailsDao paymentDetailsDao;
	
	@Autowired
	private StorePaymentOptionListDao storePaymentOptionListDao;

	@Override
	public List<Product> findProductListToPOSService(String storeId, String select, String keyword) {
		return productDao.selectProductListToPOS(storeId, select, keyword);
	}

	@Override
	@Transactional
	public void paymentExecuteService(List<PaymentDetails> paymentDetailsList) {
		if(paymentDetailsList != null){
			for(int i=0;i<paymentDetailsList.size();i++){
				paymentDetailsDao.insertPaymentDetails(paymentDetailsList.get(i));
			}
		}
	}

	@Override
	public List<StorePaymentOptionList> findStorePaymentOptionListByStoreIdService(String storeId) {
		return storePaymentOptionListDao.selectStorePaymentOptionListByStoreId(storeId);
	}
	
	

}
