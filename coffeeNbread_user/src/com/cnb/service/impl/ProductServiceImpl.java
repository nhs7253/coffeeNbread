package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.ProductDao;
import com.cnb.exception.DuplicatedProudctIdOrProductNameException;
import com.cnb.exception.ProductNotFoundException;
import com.cnb.service.ProductService;
import com.cnb.vo.Product;

/*
 * 최민희
 * 2017-06-30
 * 생성
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public int addProduct(Product product) throws DuplicatedProudctIdOrProductNameException {
		if(dao.selectProductById(product.getStoreId(), product.getProductId()) != null) {
			throw new DuplicatedProudctIdOrProductNameException(product.getProductId() + "은 이미 등록된 ID입니다.");
		}else if(dao.selectProductByName(product.getStoreId(), product.getProductName()) != null) {
			throw new DuplicatedProudctIdOrProductNameException(product.getProductName() + "은 이미 등록된 이름입니다.");
		}
		return dao.insertProduct(product);
	}

	@Override
	public int modifyProduct(Product product) throws ProductNotFoundException{
		if(dao.selectProductById(product.getStoreId(), product.getProductId()) == null) {
			throw new ProductNotFoundException(String.format("ID가 %s 인 제품이 없습니다.", product.getProductId()));
		}
		return dao.updateProduct(product);
	}

	@Override
	public List<Product> findProductListByCategory(String storeId, String productCategory) {
		return dao.selectProductListByCategory(storeId, productCategory);
	}

	@Override
	public Product findProductByName(String storeId, String productName) {
		return dao.selectProductByName(storeId, productName);
	}

	@Override
	public Product findProductById(String storeId, String productId) {
		return dao.selectProductById(storeId, productId);
	}

	@Override
	public List<Product> findProductListBySellingOption(String storeId, String sellingOption) {
		return dao.selectProductListBySellingOption(storeId, sellingOption);
	}
	
	@Override
	public List<Product> findProductList(String storeId) {
		return dao.selectProductList(storeId);
	}
	
}
