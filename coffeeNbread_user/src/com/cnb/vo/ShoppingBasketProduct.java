package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;

/*
 * 김형주 
 * 2017-06-26 생성
 * 초기 구현
 */
public class ShoppingBasketProduct implements Serializable{
	private String userId;
	private String storeId;
	private String productId;
	private String productStoreId;
	private int productCount;
	private GeneralUser generalUser;
	private Store store;
	private Product product;
	private ProductPicture productPicture;
	
	
		
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
	public ProductPicture getProductPicture() {
		return productPicture;
	}
	public void setProductPicture(ProductPicture productPicture) {
		this.productPicture = productPicture;
	}
	public ShoppingBasketProduct(String userId, String storeId, String productId, String productStoreId,
			int productCount, GeneralUser generalUser, Store store, Product product, ProductPicture productPicture) {
		super();
		this.userId = userId;
		this.storeId = storeId;
		this.productId = productId;
		this.productStoreId = productStoreId;
		this.productCount = productCount;
		this.generalUser = generalUser;
		this.store = store;
		this.product = product;
		this.productPicture = productPicture;
	}
	public ShoppingBasketProduct(String userId, String storeId, String productId, String productStoreId,
			int productCount, GeneralUser generalUser, Store store, Product product) {
		super();
		this.userId = userId;
		this.storeId = storeId;
		this.productId = productId;
		this.productStoreId = productStoreId;
		this.productCount = productCount;
		this.generalUser = generalUser;
		this.store = store;
		this.product = product;
	}
	public ShoppingBasketProduct(String userId, String storeId, String productId, String productStoreId,
			int productCount) {
		super();
		this.userId = userId;
		this.storeId = storeId;
		this.productId = productId;
		this.productStoreId = productStoreId;
		this.productCount = productCount;
	}
	public ShoppingBasketProduct() {
		super();
	}
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
	public String getProductStoreId() {
		return productStoreId;
	}
	public void setProductStoreId(String productStoreId) {
		this.productStoreId = productStoreId;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	@Override
	public String toString() {
		return "ShoppingBasketProduct [userId=" + userId + ", storeId=" + storeId + ", productId=" + productId
				+ ", productStoreId=" + productStoreId + ", productCount=" + productCount + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productCount;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productStoreId == null) ? 0 : productStoreId.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingBasketProduct other = (ShoppingBasketProduct) obj;
		if (productCount != other.productCount)
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productStoreId == null) {
			if (other.productStoreId != null)
				return false;
		} else if (!productStoreId.equals(other.productStoreId))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


}
