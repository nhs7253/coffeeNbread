package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cnb.dao.OptionDetailDao;
import com.cnb.dao.ProductDao;
import com.cnb.dao.ProductGapDao;
import com.cnb.dao.ProductPictureDao;
import com.cnb.dao.ShoppingBasketProductDao;
import com.cnb.exception.DuplicatedProductIdOrProductNameException;
import com.cnb.exception.DuplicatedProductPictureException;
import com.cnb.exception.ProductNotFoundException;
import com.cnb.service.ProductService;
import com.cnb.util.PagingBean;
import com.cnb.vo.OptionDetail;
import com.cnb.vo.Product;
import com.cnb.vo.ProductGap;
import com.cnb.vo.ProductPicture;
import com.cnb.vo.RecipeBoardContents;
import com.cnb.vo.ShoppingBasketProduct;

/*
 * 최민희
 * 2017-06-30
 * 생성
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Autowired
	private OptionDetailDao optionDetailDao;
	
	@Autowired
	private ProductGapDao productGapDao;
	
	@Autowired
	private ProductPictureDao productPictureDao;
	
	@Autowired
	private ShoppingBasketProductDao shoppingBasketProductDao;
	
	@Override
	public int addProduct(Product product,OptionDetail optionDetail) throws DuplicatedProductIdOrProductNameException, DuplicatedProductPictureException {
		if(dao.selectProductById(product.getStoreId(), product.getProductId()) != null) {
			throw new DuplicatedProductIdOrProductNameException(product.getProductId() + "은 이미 등록된 ID입니다.");
		}else if(dao.selectProductByName(product.getStoreId(), product.getProductName()) != null) {
			throw new DuplicatedProductIdOrProductNameException(product.getProductName() + "은 이미 등록된 이름입니다.");
		}else {
			int cnt = dao.insertProduct(product);
			
			optionDetailDao.insertOptionDetail(optionDetail);
			
			//제품 등록시에는 모두 제품 등록폼을 유지, 0%로 등록
			productGapDao.insertProductGap(new ProductGap("K", "0", product.getProductId(), product.getStoreId()));
			
	
			if(productPictureDao.selectProductPictureListByProductPictureAndStoreId(product.getProductPicture(), product.getStoreId()) != null) {
				throw new DuplicatedProductPictureException("제품 사진이 중복되었습니다.");
			}else{
				productPictureDao.insertProductPicture(new ProductPicture(product.getProductPicture(), product.getProductId(), product.getStoreId()));				
			}
			
			return cnt;
		}
	}

	@Override
	public int modifyProduct(Product product, OptionDetail optionDetail, String fileName) throws ProductNotFoundException, DuplicatedProductPictureException{
		
		if(dao.selectProductById(product.getStoreId(), product.getProductId()) == null) {
			throw new ProductNotFoundException(String.format("ID가 %s 인 제품이 없습니다.", product.getProductId()));
		}else{
			int cnt =  dao.updateProduct(product);
			optionDetailDao.updateOptionDetail(optionDetail);
			
			if(productPictureDao.selectProductPictureListByProductPictureAndStoreId(product.getProductPicture() ,product.getStoreId()) != null) {
				throw new DuplicatedProductPictureException("제품 사진이 중복되었습니다.");
			}else{			
				productPictureDao.updateProductPictureByProductPicture(fileName, product.getProductId(), product.getStoreId());
			}
			return cnt;
		}
	}

	@Override
	public HashMap<String, Object> findProductListByCategory(int page, String storeId, String productCategory) {
		HashMap<String, Object> map = new HashMap<>();
		String method ="category";
		String methodContent = productCategory;
		
		//item 수
		int totalCount = dao.selectProductListCountByMethodManager(storeId, method, methodContent);
		System.out.println(totalCount);
		
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);

		List<Product> list = dao.selectProductListByCategory(storeId, productCategory, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		
		return map;
	}

	@Override
	public HashMap<String, Object> findProductListByName(int page, String storeId, String productName) {
		HashMap<String, Object> map = new HashMap<>();
		String method ="name";
		String methodContent = productName;
		
		//item 수
		int totalCount = dao.selectProductListCountByMethodManager(storeId, method, methodContent);
		
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		List<Product> list = dao.selectProductListByName(storeId, productName, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
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
		int totalCount = dao.selectProductListCountByMethodManager(storeId, method, methodContent);
		
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
	
	
	/* 유저가 제품목록 보기 */
	@Override
	public HashMap<String, Object> findProductListByMethod(int page,String storeId,String select, String keyword) {
		HashMap<String, Object> map = new HashMap<>();
		
		//item 수                          
		int totalCount = dao.selectProductListCountByMethod(storeId, select, keyword);
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		System.out.println("----------------------");
		System.out.println(page+"----");
		System.out.println(storeId+"----");
		System.out.println(select+"----");
		System.out.println(keyword+"----");
		System.out.println("----------------------");
		
		//List<Product> list = dao.selectProductListPagingByMethod("category","빵", "s-1", pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
       List<Product> list = dao.selectProductListPagingByMethod(select, keyword, storeId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		System.out.println("service-list:"+list);
		
		map.put("list", list);
		
		System.out.println("service-list:"+map);
		return map;
	}
	
	

	
	@Override
	public void removeOptionDetail(Product product, OptionDetail optionDetail) {
		if(dao.selectProductBySellingOption(product.getStoreId(),"N", product.getProductName())!=null){
			optionDetailDao.deleteOptionDetailByProductId(optionDetail.getStoreId(), optionDetail.getProductId());

		}
	}

	@Override
	public void findRemoveProduct(String storeId, List<String> productIdList) {
		dao.deleteProductByProductList(storeId, productIdList);
	}

	@Override
	public List<Product> findProductListNoPaging(String storeId) {
		return dao.selectProductListNoPaging(storeId);
	}


}
