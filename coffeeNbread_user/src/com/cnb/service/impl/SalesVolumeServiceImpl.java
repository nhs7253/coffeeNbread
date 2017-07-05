package com.cnb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.PaymentDetailsDao;
import com.cnb.dao.ProductDao;
import com.cnb.dao.ProductGapDao;
import com.cnb.service.SalesVolumeService;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ProductGap;

/*
 * 최민희
 * 2017-07-04
 * 수정
 */
/*
 * 최민희
 * 2017-07-03
 * 생성
 */
@Service
public class SalesVolumeServiceImpl implements SalesVolumeService {
	
	@Autowired
	private PaymentDetailsDao productPaymentDao;

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductGapDao productGapDao;
	
	@Override
	public List<PaymentDetails> findSalesVolumeByStoreIdAndTodayDate(String storeId, Date todayDate) {
		return productPaymentDao.selectPaymentDetailsListByStoreIdAndTradeDate(storeId, todayDate);
	}

	//여러 조건으로 날짜별 판매량 조회 (1주일, 1개월, 3개월, 6개월, 12개월)
	@Override
	public List<PaymentDetails> findSalesVolumeByStoreIdAndMethod(String storeId, String method) {
		return productPaymentDao.selectPaymentDetailsListByStoreIdAndMethod(storeId, method);
	}
	
	//직접 날짜 지정
	@Override
	public List<PaymentDetails> findSalesVolumeByStoreIdAndStoreIdAndMethodAndStartDateAndEndDate(String storeId, Date startDate, Date endDate) {
		return productPaymentDao.selectPaymentDetailsListByStoreIdAndMethodAndStartDateAndEndDate(storeId, startDate, endDate);
	}

	@Override
	public List findSalesVolumeByStoreIdAndProductCategory(String storeId, String productCategory) {
		return productPaymentDao.selectPaymentDetailsListByStoreIdAndProductCategory(storeId, productCategory);
	}

	@Override
	public List<PaymentDetails> findSalesVolumeByStoreIdAndProductName(String storeId, String productName) {
		return productPaymentDao.selectPaymentDetailsListByStoreIdAndProductName(storeId, productName);
	}

	@Override
	public List<Integer> findRecommendSalesVolumeByStoreIdAndTodayDateAndMethod(String storeId, String method, String methodContent) {
		//Product에 등록되어 있는 TodayProductCount(예상생산량)에서 ProductPaymentDetails에 저장되어있는 ProductTradeCount(현장)와 ReservationOrderCount(예약)를 뺴준다. 
		if(method.equals("productCategory")){	//제품 종류별
			List list = productPaymentDao.selectPaymentDetailsListByStoreIdAndProductCategory(storeId, methodContent);
			List<String> listId = new ArrayList<>();
			List<Integer> listCount = new ArrayList<>();		
			for(int i=0; i < list.size(); i++)
			{
				Map map = (HashMap)list.get(i);
				
				Set key = map.keySet();
				
				for (Iterator iterator = key.iterator(); iterator.hasNext();) {
				    String keyName = (String) iterator.next();
				    String valueName = String.valueOf(map.get(keyName));
				    if(keyName.equals("RESERVATION_ORDER_COUNT")) {
				    	listCount.add(productDao.selectProductListByCategoryNoPaging(storeId, methodContent).get(i).getTodayProductCount()
				    				- Integer.parseInt((String.valueOf(map.get("RESERVATION_ORDER_COUNT")))));
				
				    }
				    if(keyName.equals("PRODUCT_ID")) {
				    	listId.add(String.valueOf(map.get("PRODUCT_ID")));
				    }
				}
				System.out.println(listId);
			}
			return listCount;
		}else {	//method.equals("productName")	//제품 이름별
			List list = productPaymentDao.selectPaymentDetailsListByStoreIdAndProductName(storeId, methodContent);
			List<Integer> list1 = new ArrayList<>();
			for(int i=0; i < list.size(); i++)
			{
				Map map = (HashMap)list.get(i);
				
				Set key = map.keySet();
				  
				list1.add(productDao.selectProductByName(storeId, methodContent).getTodayProductCount()
				    		 	- Integer.parseInt((String.valueOf(map.get("RESERVATION_ORDER_COUNT")))));
				
				System.out.println(String.valueOf(map.get("PRODUCT_ID")));
			}
			return list1;
		}
	}

	public void findTotalSalesVolumeByStoreIdAndProductCategoryAndTodayDate(String storeId, String productCategory, Date todayDate) {
		List list7Days = productPaymentDao.selectTotalSalesVolumeFor7Days(storeId, productCategory, todayDate);	//일주일전~어제
		List listAll = productPaymentDao.selectTotalSalesVolumeForAllDays(storeId, productCategory, todayDate);	//~어제
		String s = "";
		for(int i=0; i < listAll.size(); i++)	//listAll.size() = 6
		{
			for (int j = 0; j < list7Days.size(); j++) { // list7Days.size() = 3
				Map map7Days = (HashMap) list7Days.get(j);
				Map mapAll = (HashMap) listAll.get(i);

				Set key7Days = map7Days.keySet();
				Set keyAll = mapAll.keySet();

				Iterator iterator1 = keyAll.iterator();
				Iterator iterator2 = key7Days.iterator();

				//현재 productId를 저장 후 해당 아이디의 증감폭을 D으로 바꿈 - 7Days에서 제품아이디가 같은 걸 찾지 못한 경우에는 일주일동안 팔린게 없다는 뜻이므로 D으로 지정되게 하기 위함
				s = String.valueOf(mapAll.get("PRODUCT_ID"));
				productGapDao.updateProductGap(new ProductGap("D", "10", s, storeId));

				String keyName1 = (String) iterator1.next();
				String valueName1 = String.valueOf(mapAll.get(keyName1));

				String keyName2 = (String) iterator2.next();
				String valueName2 = String.valueOf(map7Days.get(keyName2));

				//만약 AllDays의 제품아이디값과 7Days의 제품아이디 값이 같다면 비율 비교
				if (keyName2.equals("RESERVATION_ORDER_COUNT")) {
					if (String.valueOf(mapAll.get("PRODUCT_ID")).equals(String.valueOf(map7Days.get("PRODUCT_ID")))) {

						if ((Double.parseDouble((String.valueOf(mapAll.get("RESERVATION_ORDER_COUNT"))))) > (Double.parseDouble((String.valueOf(map7Days.get("RESERVATION_ORDER_COUNT")))))) {
							// 전체 > 일주일 -> 하락세 (D)
							productGapDao.updateProductGap(new ProductGap("D", "15", (String.valueOf(mapAll.get("PRODUCT_ID"))), storeId));
							break;
						} else if ((Double.parseDouble((String.valueOf(mapAll.get("RESERVATION_ORDER_COUNT"))))) < (Double.parseDouble((String.valueOf(map7Days.get("RESERVATION_ORDER_COUNT")))))) {
							// 전체 < 일주일 -> 상승세 (U)
							productGapDao.updateProductGap(new ProductGap("U", "15", (String.valueOf(mapAll.get("PRODUCT_ID"))), storeId));
							break;
						} else {
							// 전체 = 일주일 -> 유지 (K)
							productGapDao.updateProductGap(new ProductGap("K", "0", (String.valueOf(mapAll.get("PRODUCT_ID"))), storeId));
							break;
						}
					}
				}
			}
		}
	}
}
