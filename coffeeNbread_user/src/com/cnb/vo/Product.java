package com.cnb.vo;

import java.io.Serializable;

/*
 * 최민희
 * 2017-06-26 생성
 * 초기 구현
 */
public class Product implements Serializable {
	private String productId;
	private String storeId;
	private String productName;
	private int productPrice;
	private String productCategory;
	private String productDetail;
	private String sellingOption;
	private int totalProductCount;
	private int recommendProductCount;
	
	public Product() {
		super();
	}

	public Product(String productId, String storeId, String productName, int productPrice, String productCategory,
			String productDetail, String sellingOption, int totalProductCount, int recommendProductCount) {
		super();
		this.productId = productId;
		this.storeId = storeId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productDetail = productDetail;
		this.sellingOption = sellingOption;
		this.totalProductCount = totalProductCount;
		this.recommendProductCount = recommendProductCount;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public String getSellingOption() {
		return sellingOption;
	}

	public void setSellingOption(String sellingOption) {
		this.sellingOption = sellingOption;
	}

	public int getTotalProductCount() {
		return totalProductCount;
	}

	public void setTotalProductCount(int totalProductCount) {
		this.totalProductCount = totalProductCount;
	}

	public int getRecommendProductCount() {
		return recommendProductCount;
	}

	public void setRecommendProductCount(int recommendProductCount) {
		this.recommendProductCount = recommendProductCount;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", storeId=" + storeId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productCategory=" + productCategory + ", productDetail="
				+ productDetail + ", sellingOption=" + sellingOption + ", totalProductCount=" + totalProductCount
				+ ", recommendProductCount=" + recommendProductCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productCategory == null) ? 0 : productCategory.hashCode());
		result = prime * result + ((productDetail == null) ? 0 : productDetail.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + productPrice;
		result = prime * result + recommendProductCount;
		result = prime * result + ((sellingOption == null) ? 0 : sellingOption.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
		result = prime * result + totalProductCount;
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
		Product other = (Product) obj;
		if (productCategory == null) {
			if (other.productCategory != null)
				return false;
		} else if (!productCategory.equals(other.productCategory))
			return false;
		if (productDetail == null) {
			if (other.productDetail != null)
				return false;
		} else if (!productDetail.equals(other.productDetail))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPrice != other.productPrice)
			return false;
		if (recommendProductCount != other.recommendProductCount)
			return false;
		if (sellingOption == null) {
			if (other.sellingOption != null)
				return false;
		} else if (!sellingOption.equals(other.sellingOption))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		if (totalProductCount != other.totalProductCount)
			return false;
		return true;
	}
}
