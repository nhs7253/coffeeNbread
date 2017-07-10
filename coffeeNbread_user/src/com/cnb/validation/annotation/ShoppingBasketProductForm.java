package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.cnb.vo.GeneralUser;
import com.cnb.vo.OptionCategory;
import com.cnb.vo.Product;
import com.cnb.vo.Store;

public class ShoppingBasketProductForm implements Serializable {
	@NotEmpty
	private String userId;
	
	@NotEmpty
	private String storeId;
	
	@NotEmpty
	private String productId;
	
	@NotNull
	private int productCount;
	
	@NotEmpty
	private String productStoreId;  //-----> 실제로는 storeId랑 같은데 일단 넣어둠. 
	
 	private GeneralUser generalUser;
	private Store store;
 	private Product product;
 	
 	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public String getProductStoreId() {
		return productStoreId;
	}
	public void setProductStoreId(String productStoreId) {
		this.productStoreId = productStoreId;
	}
	public GeneralUser getGeneralUser() {
		return generalUser;
	}
	public void setGeneralUser(GeneralUser generalUser) {
		this.generalUser = generalUser;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	

	
	

}
