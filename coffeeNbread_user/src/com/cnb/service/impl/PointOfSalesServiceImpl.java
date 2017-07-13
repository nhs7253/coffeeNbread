package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.ProductDao;
import com.cnb.service.PointOfSalesService;
import com.cnb.vo.Product;

/*
 * 노현식
 * 2017-07-13
 * 생성, 초기 구현
 */
@Service
public class PointOfSalesServiceImpl implements PointOfSalesService{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findProductListToPOSService(String storeId, String select, String keyword) {
		return productDao.selectProductListToPOS(storeId, select, keyword);
	}

}
