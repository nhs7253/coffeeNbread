package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;

/*김형주 
 * 2017-06-30 수정
 * 
 * 김형주 
 * 2017-06-26 생성
 * 초기 구현
 */
public class ShoppingBasketProduct implements Serializable{
	private String userId;  //pk ,foreign key
	private String storeId; //pk ,foreign key
	private String productId;//pk,foreign key
	private int productCount;
	private String productStoreId; //pk
	
	private GeneralUser generalUser;
	private Store store;
	private Product product;
	
	
	
	
	
	
	public ShoppingBasketProduct(String userId, String storeId, String productId, int productCount) {
		super();
		this.userId = userId;
		this.storeId = storeId;
		this.productId = productId;
		this.productCount = productCount;
	}
	public ShoppingBasketProduct(String userId, String storeId, String productId, int productCount,
			String productStoreId) {
		super();
		this.userId = userId;
		this.storeId = storeId;
		this.productId = productId;
		this.productCount = productCount;
		this.productStoreId = productStoreId;
	}
	public ShoppingBasketProduct(String userId, String storeId, String productId, int productCount,
			String productStoreId, GeneralUser generalUser, Store store, Product product) {
		super();
		this.userId = userId;
		this.storeId = storeId;
		this.productId = productId;
		this.productCount = productCount;
		this.productStoreId = productStoreId;
		this.generalUser = generalUser;
		this.store = store;
		this.product = product;
	}
	public ShoppingBasketProduct() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((generalUser == null) ? 0 : generalUser.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + productCount;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productStoreId == null) ? 0 : productStoreId.hashCode());
		result = prime * result + ((store == null) ? 0 : store.hashCode());
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
		if (generalUser == null) {
			if (other.generalUser != null)
				return false;
		} else if (!generalUser.equals(other.generalUser))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
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
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
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
	@Override
	public String toString() {
		return "ShoppingBasketProduct [userId=" + userId + ", storeId=" + storeId + ", productId=" + productId
				+ ", productCount=" + productCount + ", productStoreId=" + productStoreId + ", generalUser="
				+ generalUser + ", store=" + store + ", product=" + product + "]";
	}

	
	
}
