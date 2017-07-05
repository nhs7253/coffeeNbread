package com.cnb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.PaymentDetailsDao;
import com.cnb.service.PaymentDetailsService;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ShoppingBasketProduct;

/*
 * 김형주
 * 2017-07-01 생성
 */
@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService {
	@Autowired
	private PaymentDetailsDao paymentDetailsDao;
	
//
//	@Autowired
//	private ShoppingBasketProductDao shoppingBasketProductDao;
//
//	
	
	@Override
	public List<PaymentDetails> findPaymentDetailsListByStoreIdAndUserId(String storeId, String userId) {

		return paymentDetailsDao.selectPaymentDetailsListByUserIdAndStoreId("u-1", "s-7");
	}

	@Override
	public void addPaymentDetails(List<ShoppingBasketProduct> shoppingBasketProduct) {

		System.out.println(shoppingBasketProduct);
		if (shoppingBasketProduct != null) {
			System.out.println("shoppingBasketProduct.size():" + shoppingBasketProduct.size());
			for (int i = 0; i < shoppingBasketProduct.size(); i++) {

				paymentDetailsDao.insertPaymentDetails(new PaymentDetails(0, "c", new Date(), "r",
						shoppingBasketProduct.get(i).getProductCount(), shoppingBasketProduct.get(i).getUserId(),
						shoppingBasketProduct.get(i).getProductId(), shoppingBasketProduct.get(i).getStoreId(), 0));

			}

		}

	}

	/* 총금액 */
	@Override
	public int findAllProductPrice(List<ShoppingBasketProduct> shoppingBasketProduct) {
		List<ShoppingBasketProduct> list=null;
		int totalPrice=0;
		System.out.println(shoppingBasketProduct.size());
		for (int i = 0; i < shoppingBasketProduct.size(); i++) {
			 list= paymentDetailsDao.selectAllProductPriceByUserIdAndStoreId(shoppingBasketProduct.get(i).getUserId(), shoppingBasketProduct.get(i).getStoreId());
			System.out.println("shoppingBasketProduct"+shoppingBasketProduct);
			 System.out.println("list:"+list);
			System.out.println("------------------------------------------------------------------");
			 System.out.println("shoppingBasketProduct.get(i).getProductCount():"+shoppingBasketProduct.get(i).getProductCount());
			 System.out.println("list.get(i).getProductPrice():"+list.get(i).getProduct().getProductPrice());
			totalPrice+=  shoppingBasketProduct.get(i).getProductCount()*list.get(i).getProduct().getProductPrice();
		}
		return totalPrice;
	}

	@Override
	public List<PaymentDetails> findPaymentDetailsListByStoreIdAndProductId(String storeId, String productId) {
		return paymentDetailsDao.selectPaymentDetailsListByStoreIdAndProductId(storeId, productId);
	}
	
	@Override
	public List<PaymentDetails> findPaymentDetailsListByStoreIdAndTradeDate(String storeId, Date tradeDate) {
		return paymentDetailsDao.selectPaymentDetailsListByStoreIdAndTradeDate(storeId, tradeDate);
	}

	@Override
	public List<PaymentDetails> findPaymentDetailsListByStoreIdAndProductIdAndSellMethod(String storeId, String productId, String sellMethod) {
		return paymentDetailsDao.selectPaymentDetailsListByStoreIdAndProductIdAndSellMethod(storeId, productId, sellMethod);
	}
	
}
