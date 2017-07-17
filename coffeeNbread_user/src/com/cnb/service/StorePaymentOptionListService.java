package com.cnb.service;

import java.util.List;

import com.cnb.vo.StorePaymentOptionList;

/*
 * 2017-07-16
 * 김형주 생성및 구현.
 */
public interface StorePaymentOptionListService {

	/**
	 *매장이 등록시  결정한  결제 수단 가지고옴.
	 * @return
	 */
	List<StorePaymentOptionList> findStorePaymentOptionList(String storeId);
}
