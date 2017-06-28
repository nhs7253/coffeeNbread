package com.cnb.vo;

import java.io.Serializable;
import java.util.List;

/*
 * 김형주
 * 2017-06-27 변경
 * 제품사진 List로 담는 컬럼 추가
 * 
 */

/*
 * 최민희
 * 2017-06-26 생성
 * 초기 구현
 */
public class Product implements Serializable {
	private String productId;	//PRIMARY KEY
	private String productName;
	private int productPrice;
	private String productCategory;
	private String productDetail;
	private String sellingOption;
	private int todayProductCount;
	private int recommendProductCount;
	
	/*********************************************************************
	 * 부모 테이블 : Store, 자식 테이블 : Product
	 * 제품 한 개는 한 매장에 소속되어있다.
	 * 자신이 소속된 매장정보를 저장할 Instance 변수를 선언한다.
	 *********************************************************************/
	private String storeId;	 //PRODUCT 테이블의 STORE_ID 칼럼과 연결된 변수
	private Store store;	//매장 정보를 담기 위함
	
	/*********************************************************************
	 * 부모 테이블 : Product, 자식 테이블 : ProductPicture
	 * 제품 한 개에 여러 개의 제품 사진들이 포함된다. 
	 * 제품 사진들을 저장할 Instance 변수를 선언해야 한다.
	 *********************************************************************/
	private List<ProductPicture> productPictureList; 

	public Product() {
		super();
	}

	public Product(String productId, String storeId, String productName, int productPrice, String productCategory,
			String productDetail, String sellingOption, int todayProductCount, int recommendProductCount) {
		super();
		this.productId = productId;
		this.storeId = storeId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productDetail = productDetail;
		this.sellingOption = sellingOption;
		this.todayProductCount = todayProductCount;
		this.recommendProductCount = recommendProductCount;
	}
	
	public Product(String productId, String storeId, String productName, int productPrice, String productCategory,
			String productDetail, String sellingOption, int todayProductCount, int recommendProductCount,
			List<ProductPicture> productPictureList) {
		super();
		this.productId = productId;
		this.storeId = storeId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productDetail = productDetail;
		this.sellingOption = sellingOption;
		this.todayProductCount = todayProductCount;
		this.recommendProductCount = recommendProductCount;
		this.productPictureList = productPictureList;
	}

	public Product(String productId, String productName, int productPrice, String productCategory, String productDetail,
			String sellingOption, int todayProductCount, int recommendProductCount, String storeId, Store store,
			List<ProductPicture> productPictureList) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productDetail = productDetail;
		this.sellingOption = sellingOption;
		this.todayProductCount = todayProductCount;
		this.recommendProductCount = recommendProductCount;
		this.storeId = storeId;
		this.store = store;
		this.productPictureList = productPictureList;
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

	public int getRecommendProductCount() {
		return recommendProductCount;
	}

	public void setRecommendProductCount(int recommendProductCount) {
		this.recommendProductCount = recommendProductCount;
	}
	
	public List<ProductPicture> getProductPictureList() {
		return productPictureList;
	}

	public void setProductPictureList(List<ProductPicture> productPictureList) {
		this.productPictureList = productPictureList;
	}
	
	public int getTodayProductCount() {
		return todayProductCount;
	}

	public void setTodayProductCount(int todayProductCount) {
		this.todayProductCount = todayProductCount;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
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
		result = prime * result + todayProductCount;
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
		if (todayProductCount != other.todayProductCount)
			return false;
		return true;
	}
}
