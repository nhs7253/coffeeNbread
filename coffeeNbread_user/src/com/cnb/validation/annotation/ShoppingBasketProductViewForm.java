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

public class ShoppingBasketProductViewForm implements Serializable {
	
	private String userId;
	
	private String storeId;
	
  	private String productId;

	private Product product;

	private int productCount;
	private List<Integer> productCountList;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public List<Integer> getProductCountList() {
		return productCountList;
	}
	public void setProductCountList(List<Integer> productCountList) {
		this.productCountList = productCountList;
	}
	@Override
	public String toString() {
		return "ShoppingBasketProductViewForm [userId=" + userId + ", storeId=" + storeId + ", productId=" + productId
				+ ", product=" + product + ", productCount=" + productCount + ", productCountList=" + productCountList
				+ "]";
	}



}
