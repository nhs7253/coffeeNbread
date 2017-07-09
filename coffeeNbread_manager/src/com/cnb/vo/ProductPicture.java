package com.cnb.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/*
 * 김형주
 * 2017-06-26 생성
 * 
 */

public class ProductPicture implements Serializable{

	private String productPicture;	//PRIMARY KEY
	private String productId;
	private String storeId;
	private List<MultipartFile> productPictureList; 
	
	public ProductPicture() {
	}

	public ProductPicture(String productPicture, String productId, String storeId) {
		super();
		this.productPicture = productPicture;
		this.productId = productId;
		this.storeId = storeId;
	}

	public String getProductPicture() {
		return productPicture;
	}

	public void setProductPicture(String productPicture) {
		this.productPicture = productPicture;
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

	
	
	public List<MultipartFile> getProductPictureList() {
		return productPictureList;
	}

	public void setProductPictureList(List<MultipartFile> productPictureList) {
		this.productPictureList = productPictureList;
	}

	@Override
	public String toString() {
		return "ProductPicture [productPicture=" + productPicture + ", productId=" + productId + ", storeId=" + storeId
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productPicture == null) ? 0 : productPicture.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
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
		ProductPicture other = (ProductPicture) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productPicture == null) {
			if (other.productPicture != null)
				return false;
		} else if (!productPicture.equals(other.productPicture))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		return true;
	}
}
