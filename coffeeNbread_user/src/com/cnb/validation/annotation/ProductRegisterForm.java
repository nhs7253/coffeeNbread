package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import com.cnb.vo.OptionCategory;
import com.cnb.vo.OptionDetail;
import com.cnb.vo.ProductPicture;
import com.cnb.vo.Store;

public class ProductRegisterForm implements Serializable {
	@NotEmpty
	private String productId;
	
	@NotEmpty
	private String productName;
	
	@NotNull
	private int productPrice;
	private String productCategory;
	
	@NotEmpty
	private String productDetail;
	private String sellingOption;

	@NotNull
	private int todayProductCount;
	
	@NotNull
	private int recommendProductCount;
	
	private String storeId;
	
	private OptionCategory optionCategoryVO;
	
	private int optionId;
	private String optionCategoryString;
	private String optionCategoryDetail;
	
	private String imageName;
	private MultipartFile productPicture;
	private List<MultipartFile> productPictureList;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
	public int getTodayProductCount() {
		return todayProductCount;
	}
	public void setTodayProductCount(int todayProductCount) {
		this.todayProductCount = todayProductCount;
	}
	public int getRecommendProductCount() {
		return recommendProductCount;
	}
	public void setRecommendProductCount(int recommendProductCount) {
		this.recommendProductCount = recommendProductCount;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public OptionCategory getOptionCategoryVO() {
		return optionCategoryVO;
	}
	public void setOptionCategoryVO(OptionCategory optionCategory) {
		this.optionCategoryVO = optionCategory;
	}
	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public String getOptionCategoryString() {
		return optionCategoryString;
	}
	public void setOptionCategoryString(String optionCategorySting) {
		this.optionCategoryString = optionCategorySting;
	}
	public String getOptionCategoryDetail() {
		return optionCategoryDetail;
	}
	public void setOptionCategoryDetail(String optionCategoryDetail) {
		this.optionCategoryDetail = optionCategoryDetail;
	}
	public MultipartFile getProductPicture() {
		return productPicture;
	}
	public void setProductPicture(MultipartFile productPicture) {
		this.productPicture = productPicture;
	}
	public List<MultipartFile> getProductPictureList() {
		return productPictureList;
	}
	public void setProductPictureList(List<MultipartFile> productPictureList) {
		this.productPictureList = productPictureList;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	
}
