package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.ProductGapDao;
import com.cnb.service.ProductGapService;
import com.cnb.util.PagingBean;
import com.cnb.vo.ProductGap;

/*
 * 최민희
 * 2017-07-03
 * 생성
 */

@Service
public class ProductGapServiceImpl implements ProductGapService {
	
	@Autowired
	private ProductGapDao dao;

	@Override
	public int addProductGap(ProductGap productGap) {
		return dao.insertProductGap(productGap);
	}

	@Override
	public int modifyProductGap(ProductGap productGap) {
		return dao.insertProductGap(productGap);
	}

	@Override
	public HashMap<String, Object> findProductGapListByStoreId(int page, String storeId) {
		HashMap<String, Object> map = new HashMap<>();
		String method = "";
		String methodContent = "";
		
		//item 수
		int totalCount = dao.selectProductGapListCountByMethod(storeId, method, methodContent);
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		List<ProductGap> list = dao.selectProductGapListByStoreId(storeId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}

	@Override
	public HashMap<String, Object> findProductGapListByIdentifyCodeByStoreIdAndIdentifyCode(int page, String storeId, String identifyCode) {
		HashMap<String, Object> map = new HashMap<>();
		String method = "identifyCode";
		String methodContent = identifyCode;
		
		//item 수
		int totalCount = dao.selectProductGapListCountByMethod(storeId, method, methodContent);
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		List<ProductGap> list = dao.selectProductGapListByIdentifyCodeByStoreIdAndIdentifyCode(storeId, identifyCode, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}

	@Override
	public String findIdentifyCodeByProductId(String storeId, String productId) {
		return dao.selectIdentifyCodeByProductId(storeId, productId);
	}
	
}
