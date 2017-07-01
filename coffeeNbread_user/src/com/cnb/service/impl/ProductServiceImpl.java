package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.ProductDao;
import com.cnb.exception.DuplicatedProductIdOrProductNameException;
import com.cnb.exception.ProductNotFoundException;
import com.cnb.service.ProductService;
import com.cnb.util.PagingBean;
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
	public int addProduct(Product product) throws DuplicatedProductIdOrProductNameException {
		if(dao.selectProductById(product.getStoreId(), product.getProductId()) != null) {
			throw new DuplicatedProductIdOrProductNameException(product.getProductId() + "은 이미 등록된 ID입니다.");
		}else if(dao.selectProductByName(product.getStoreId(), product.getProductName()) != null) {
			throw new DuplicatedProductIdOrProductNameException(product.getProductName() + "은 이미 등록된 이름입니다.");
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
	public HashMap<String, Object> findProductListByCategory(int page, String storeId, String productCategory) {
		HashMap<String, Object> map = new HashMap<>();
		String method ="category";
		String methodContent = productCategory;
		
		//item 수
		int totalCount = dao.selectProductListCountByMethod(storeId, method, methodContent);
		
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		List<Product> list = dao.selectProductListByCategory(storeId, productCategory, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
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
	public HashMap<String, Object> findProductListBySellingOption(int page, String storeId, String sellingOption) {
		HashMap<String, Object> map = new HashMap<>();
		String method ="sellingOption";
		String methodContent = sellingOption;
		
		//item 수
		int totalCount = dao.selectProductListCountByMethod(storeId, method, methodContent);
		
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		List<Product> list = dao.selectProductListBySellingOption(storeId, sellingOption, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}
	
	@Override
	public HashMap<String, Object> findProductList(int page, String storeId) {
		HashMap<String, Object> map = new HashMap<>();
		
		//item 수
		int totalCount = dao.selectProductListCount(storeId);
		
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		List<Product> list = dao.selectProductList(storeId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}
}
