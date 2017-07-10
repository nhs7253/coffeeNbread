package com.cnb.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.PaymentDetailsDao;
import com.cnb.exception.NotInsertTradeDateException;
import com.cnb.exception.NullShoppingBasketProductException;
import com.cnb.service.PaymentDetailsService;
import com.cnb.util.PagingBean;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ReservationDetails;
import com.cnb.vo.ShoppingBasketProduct;
import com.cnb.vo.Store;

/*김형주
 * 2017-07-03 수정
 * 
 * 김형주
 * 2017-07-01 생성
 */
@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService {
	@Autowired
	private PaymentDetailsDao paymentDetailsDao;


  /* 장바구니에 있는거 결제내역에 등록 */
	@Override
	public void addPaymentDetails(List<ShoppingBasketProduct> shoppingBasketProduct) throws NullShoppingBasketProductException {

		System.out.println(shoppingBasketProduct);
		
		if(shoppingBasketProduct==null){
			throw new NullShoppingBasketProductException("장바구니가 비어있어 결제할 품목이 없습니다.");
		}
		else {
			for (int i = 0; i < shoppingBasketProduct.size(); i++) {

				paymentDetailsDao.insertPaymentDetails(new PaymentDetails(0, "c", new Date(), "r",
						shoppingBasketProduct.get(i).getProductCount(), shoppingBasketProduct.get(i).getUserId(),
						shoppingBasketProduct.get(i).getProductId(), shoppingBasketProduct.get(i).getStoreId(), 0));

			}

		}

	}

	
/*	*//**
	 * 매장의 오픈시간과 닫은시간안에 제품수령시간을 적는다면 그떄 가능, 아니면 안됨.
	 * 
	 * @throws NotInsertTradeDateException
	 *//*

	public void addUserHopedGetProductDate(List<PaymentDetails> paymentDetailsList, String userId, String storeId,
			Date tradeHopeDate) throws NotInsertTradeDateException {

		Store store = sDao.selectStoreById(storeId);
		paymentDetailsList = pdDao.selectPaymentDetailsListByUserIdAndStoreId(userId, storeId);
		
		 원하는 제품수령시간이 매장의 닫는시간 이후거나 , 매장의 오픈시간 이전이면 예외 생성 
		if (tradeHopeDate.compareTo(store.getStoreClose()) > 0 || tradeHopeDate.compareTo(store.getStoreOpen()) < 0) {
			throw new NotInsertTradeDateException("매장 운영시간에 맞지 않아 수령할수있는 시간이아닙니다.");
		}
		for (int i = 0; i < paymentDetailsList.size(); i++) {
           update로 수정해야 함. 
			dao.insertReservationDetails(new ReservationDetails(0, paymentDetailsList.get(i).getTradeDate(),
					paymentDetailsList.get(i).getReservationOrderCount(), null, tradeHopeDate,
					paymentDetailsList.get(i).getUserId(), paymentDetailsList.get(i).getProductId(),
					paymentDetailsList.get(i).getStoreId()));
		}
		
	}
	*/
	
	
	
	
	
	
    /*   장바구니에 있는거 총 금액 구하기 */
	@Override
	public int findAllProductPrice(List<ShoppingBasketProduct> shoppingBasketProduct) {
		// TODO Auto-generated method stub
		return 0;
	}

    /*  유저가 등록한 결제내역 조회 - 페이징 */
	@Override
	public HashMap<String, Object> findPaymentDetailsListByStoreIdAndUserId(int page, String storeId,
			String userId) {
		HashMap<String, Object> map = new HashMap<>();

		// item 수
		int totalCount =paymentDetailsDao.countSelectPaymentDetailsByUserIdAndStoreId(userId, storeId);
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);

		List<PaymentDetails> list=paymentDetailsDao.selectPaymentDetailsListByUserIdAndStoreId(userId, storeId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}
	/*----------------------------------------------매장 ---------------------------------------------*/
	
	@Override
	public List<PaymentDetails> findPaymentDetailsListByStoreIdAndProductId(String storeId, String productId) {
		return paymentDetailsDao.selectPaymentDetailsListByStoreIdAndProductId(storeId, productId);
	}

	@Override
	public List<PaymentDetails> findPaymentDetailsListByStoreIdAndTradeDate(String storeId, Date tradeDate) {
		return paymentDetailsDao.selectPaymentDetailsListByStoreIdAndTradeDate(storeId, tradeDate);
	}

	@Override
	public List<PaymentDetails> findPaymentDetailsListByStoreIdAndProductIdAndSellMethod(String storeId,
			String productId, String sellMethod) {
		return paymentDetailsDao.selectPaymentDetailsListByStoreIdAndProductIdAndSellMethod(storeId, productId,
				sellMethod);
	}





}
