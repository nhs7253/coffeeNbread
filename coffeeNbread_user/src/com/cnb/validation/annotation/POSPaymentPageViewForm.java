package com.cnb.validation.annotation;

import java.util.List;

/*
 * 노현식
 * 2017-07-13
 * 생성, 초기 구현
 */
public class POSPaymentPageViewForm {
	
	private List<String> productIdList; 
	private List<String> productNameList;
	private List<Integer> productTradeCountList;
	private List<Integer> productPriceList;
	private int total;
	public List<String> getProductIdList() {
		return productIdList;
	}
	public void setProductIdList(List<String> productIdList) {
		this.productIdList = productIdList;
	}
	public List<String> getProductNameList() {
		return productNameList;
	}
	public void setProductNameList(List<String> productNameList) {
		this.productNameList = productNameList;
	}
	public List<Integer> getProductTradeCountList() {
		return productTradeCountList;
	}
	public void setProductTradeCountList(List<Integer> productTradeCountList) {
		this.productTradeCountList = productTradeCountList;
	}
	public List<Integer> getProductPriceList() {
		return productPriceList;
	}
	public void setProductPriceList(List<Integer> productPriceList) {
		this.productPriceList = productPriceList;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "POSPaymentPageViewForm [productIdList=" + productIdList + ", productNameList=" + productNameList
				+ ", productTradeCountList=" + productTradeCountList + ", productPriceList=" + productPriceList
				+ ", total=" + total + "]";
	}
	
	
}
