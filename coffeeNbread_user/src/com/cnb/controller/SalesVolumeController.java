package com.cnb.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.service.OptionCategoryService;
import com.cnb.service.PaymentDetailsService;
import com.cnb.service.ProductGapService;
import com.cnb.service.ProductService;
import com.cnb.service.SalesVolumeService;
import com.cnb.service.StoreService;
import com.cnb.validation.annotation.ProductFindFormForPos;
import com.cnb.validation.annotation.TodaySalesVolumeForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.OptionCategory;
import com.cnb.vo.Product;

/*
 * 최민희
 * 2017-07-11
 * 수정
 */
/*
 * 최민희
 * 2017-07-10
 * 수정
 */
/*
 * 최민희
 * 2017-07-09
 * 생성
 */

@Controller
public class SalesVolumeController {
		
	@Autowired
	private SalesVolumeService service;
	
	@Autowired
	private ProductService productService;

	@Autowired
	private OptionCategoryService optionCategoryService;
	
	@Autowired
	private ProductGapService productGapService;
	
	@Autowired
	private PaymentDetailsService paymentDetailsSerivce;
	
	@Autowired
	private StoreService storeService;
	
	//오늘 날짜 판매량 조회 - 판매량 조회 메뉴 들어갔을시 맨 처음에 보여줌
	@RequestMapping("findSalesVolumeTodayController")
	public ModelAndView findSalesVolumeTodayController(@ModelAttribute("toaySalesVolume") @Valid TodaySalesVolumeForm todaysalesVolumeForm, BindingResult errors) throws ParseException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()) {
			modelAndView.setViewName("index.tiles");
			return modelAndView;
		}

		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

		List list = service.findSalesVolumeByStoreIdAndTodayDate(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(),  dt.parse((new Date().getYear()+1900) + "-" + (new Date().getMonth()+1) + "-" + new Date().getDate()));
		
		//카테고리 가져오기
		List<OptionCategory> optionList = optionCategoryService.findOptionCategoryList(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
		
		//하루마다 모든 카테고리의 제품 증감폭 변경해줌 (K, U, D)
		for(int i=0; i<optionList.size(); i++) {
			service.findTotalSalesVolumeByStoreIdAndProductCategoryAndTodayDate(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), optionList.get(i).getOptionCategory(), dt.parse((new Date().getYear()+1900) + "-" + (new Date().getMonth()+1) + "-" + new Date().getDate()));
		}
		
		//상승세 제품 목록 - 전체
		List<Product> upProductList = service.findProductGapByIdentifyCode(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), "U");
		
		//하락세 제품 목록 - 전체
		List<Product> downProductList = service.findProductGapByIdentifyCode(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), "D");
		
		//유지 제품 목록 - 전체
		List<Product> keepProductList = service.findProductGapByIdentifyCode(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), "K");

		//모든 제품 목록 조회
		List<Product> productList = productService.findProductListNoPaging(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
		
		//모든 제품의 오늘 예상 생산량 조회
		List<String> allProductNameList = new ArrayList<>();
		List<String> todayCountList = new ArrayList<>();
		
		for(int i=0; i<productList.size(); i++) {
			allProductNameList.add(productList.get(i).getProductName());
			todayCountList.add(String.valueOf(productList.get(i).getTodayProductCount()));
		}
		
		List<String> productNameList = new ArrayList<>();
		List<String> countList = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			Map map = (HashMap)list.get(i);
			Set key = map.keySet();
			
			Iterator iterator = key.iterator();
			
			while(iterator.hasNext()) {
				String keyName = (String)iterator.next();				
				if(keyName.equals("RESERVATION_ORDER_COUNT")) {
					countList.add(String.valueOf(map.get("RESERVATION_ORDER_COUNT")));
				}else if(keyName.equals("PRODUCT_ID")) {
					String productName = productService.findProductById(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), String.valueOf(map.get("PRODUCT_ID"))).getProductName();
					productNameList.add(productName);
				}
			}
		}
		
		modelAndView.setViewName("store/salesVolume_view.tiles");
		modelAndView.addObject("productNameList", productNameList);
		modelAndView.addObject("countList", countList);
		modelAndView.addObject("upProductList", upProductList);
		modelAndView.addObject("downProductList", downProductList);
		modelAndView.addObject("keepProductList", keepProductList);
		modelAndView.addObject("allProductNameList", allProductNameList);
		modelAndView.addObject("todayCountList", todayCountList);
		return modelAndView;
	}
	
	//1주일/1개월/3개월/6개월/12개월 선택시 해당 날짜 범위의 판매량 조회
	@RequestMapping("findSalesVolumeByMethodController")
	@ResponseBody	
	public Object findSalesVolumeByMethodController(String method) throws ParseException {
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

		List list = service.findSalesVolumeByStoreIdAndMethod(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), method);

		List<String> productNameList = new ArrayList<>();
		List<String> countList = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			Map map = (HashMap)list.get(i);
			Set key = map.keySet();
			
			Iterator iterator = key.iterator();
			
			while(iterator.hasNext()) {
				String keyName = (String)iterator.next();				
				if(keyName.equals("RESERVATION_ORDER_COUNT")) {
					countList.add(String.valueOf(map.get("RESERVATION_ORDER_COUNT")));
				}else if(keyName.equals("PRODUCT_ID")) {
					String productName = productService.findProductById(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), String.valueOf(map.get("PRODUCT_ID"))).getProductName();
					productNameList.add(productName);
				}
			}
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("productNameList", productNameList);
		map.put("countList", countList);
		
		return map;
	}
	
	//직접 지정한 날짜 범위의 판매량 조회
	@RequestMapping("findSalesVolumeByStartEndDateController")
	@ResponseBody	
	public Object findSalesVolumeByStartEndDateController(String startDate, String endDate) throws ParseException {
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

		List list = service.findSalesVolumeByStoreIdAndStoreIdAndMethodAndStartDateAndEndDate(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), dt.parse(startDate), dt.parse(endDate));
		
		List<String> productNameList = new ArrayList<>();
		List<String> countList = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			Map map = (HashMap)list.get(i);
			Set key = map.keySet();
			
			Iterator iterator = key.iterator();
			
			while(iterator.hasNext()) {
				String keyName = (String)iterator.next();				
				if(keyName.equals("RESERVATION_ORDER_COUNT")) {
					countList.add(String.valueOf(map.get("RESERVATION_ORDER_COUNT")));
				}else if(keyName.equals("PRODUCT_ID")) {
					String productName = productService.findProductById(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), String.valueOf(map.get("PRODUCT_ID"))).getProductName();
					productNameList.add(productName);
				}
			}
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("productNameList", productNameList);
		map.put("countList", countList);
		
		return map;
	}
	
	//종류별 판매량 조회
	@RequestMapping("findSalesVolumeByCategoryController")
	@ResponseBody	
	public Object findSalesVolumeByCategoryController(String productCategory) {

		List list = service.findSalesVolumeByStoreIdAndProductCategory(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productCategory);
		
		List<String> productNameList = new ArrayList<>();
		List<String> countList = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			Map map = (HashMap)list.get(i);
			Set key = map.keySet();
			
			Iterator iterator = key.iterator();
			
			while(iterator.hasNext()) {
				String keyName = (String)iterator.next();				
				if(keyName.equals("RESERVATION_ORDER_COUNT")) {
					countList.add(String.valueOf(map.get("RESERVATION_ORDER_COUNT")));
				}else if(keyName.equals("PRODUCT_ID")) {
					String productName = productService.findProductById(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), String.valueOf(map.get("PRODUCT_ID"))).getProductName();
					productNameList.add(productName);
				}
			}
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("productNameList", productNameList);
		map.put("countList", countList);
		
		return map;
	}
	
	//제품명 판매량 조회
	@RequestMapping("findSalesVolumeByNameController")
	@ResponseBody	
	public Object findSalesVolumeByNameController(String productName) {

		List list = service.findSalesVolumeByStoreIdAndProductName(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productName);
		
		List<String> productNameList = new ArrayList<>();
		List<String> countList = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			Map map = (HashMap)list.get(i);
			Set key = map.keySet();
			
			Iterator iterator = key.iterator();
			
			while(iterator.hasNext()) {
				String keyName = (String)iterator.next();				
				if(keyName.equals("RESERVATION_ORDER_COUNT")) {
					countList.add(String.valueOf(map.get("RESERVATION_ORDER_COUNT")));
				}else if(keyName.equals("PRODUCT_NAME")) {
					productNameList.add(String.valueOf(map.get("PRODUCT_NAME")));
				}
			}
		}

		Map<String, Object> map = new HashMap<>();
		map.put("productNameList", productNameList);
		map.put("countList", countList);

		return map;
	}

	//전체 판매량 조회 (오늘 날짜) - 전체 버튼 클릭시
	@RequestMapping("findSalesVolumeTotalController")
	@ResponseBody
	public Object findSalesVolumeTotalController() throws ParseException {

		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		
		List list = service.findSalesVolumeByStoreIdAndTodayDate(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(),  dt.parse((new Date().getYear()+1900) + "-" + (new Date().getMonth()+1) + "-" + new Date().getDate()));
		
		List<String> productNameList = new ArrayList<>();
		List<String> countList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			Map map = (HashMap) list.get(i);
			Set key = map.keySet();

			Iterator iterator = key.iterator();

			while(iterator.hasNext()) {
				String keyName = (String)iterator.next();				
				if(keyName.equals("RESERVATION_ORDER_COUNT")) {
					countList.add(String.valueOf(map.get("RESERVATION_ORDER_COUNT")));
				}else if(keyName.equals("PRODUCT_ID")) {
					String productName = productService.findProductById(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), String.valueOf(map.get("PRODUCT_ID"))).getProductName();
					productNameList.add(productName);
				}
			}
		}

		Map<String, Object> map = new HashMap<>();
		map.put("productNameList", productNameList);
		map.put("countList", countList);

		return map;
	}
	
	/*
	 * 두 번 실행되는 오류 발생됨
	 * web.xml에서 <load-on-startup>1</load-on-startup> 삭제
	 * Server의 server.xml의 <Host appBase="webapps" autoDeploy="true" name="localhost" unpackWARs="true">에서 문제 발생
	 * 방법  1. appBase를 수정
	 *     2. autoDeploy 옵션을 false로 바꿈
	 * => autoDeploy와 unpackWARs를 false로 수정
	 */
	/*
	 * @Scheduled 사용하기 위해서 web-context.xml에 몇 가지 추가
	 * 	xmlns:task="http://www.springframework.org/schema/task" (shema 추가하면됨)
	 *  <context:component-scan base-package="com.crontab" /> 
	 *  <task:scheduler id="jobScheduler" pool-size="10" /> 
	 *  <task:annotation-driven scheduler="jobScheduler" />
	 */
	@Scheduled(cron = "0 30 18 * * *") //초 분 시 일 월 요일 (*=모든)
	public void changeMakeVolumeEveryDay() {
		//상승세&하락세에 따라서 5%씩 증감하도록 함
		//모든 제품 목록 조회
		
		List<String> storeIdList = storeService.findAllStoreIdList();
		List<Product> productList = new ArrayList<>();
		
		for(int i=0; i<storeIdList.size(); i++) {
			productList = productService.findProductListNoPaging(storeIdList.get(i));
			
			for(int j=0; j<productList.size(); j++) {		
				String identifyCode = productGapService.findIdentifyCodeByProductId(storeIdList.get(i), productList.get(j).getProductId());
				System.out.println("identifyCode : " + identifyCode);
				service.modifyProductTodayCountByGap(storeIdList.get(i), productList.get(j).getProductId(), identifyCode);
			}
		}
	}
	
	//*******************
	//제품 목록 조회 - 포스용
	@RequestMapping("findProductListForPosController")
	public ModelAndView findProductListForPosController(@ModelAttribute("productFindForPos") @Valid ProductFindFormForPos productFindFormForPos, BindingResult errors) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()) {
			modelAndView.setViewName("index.tiles");
			return modelAndView;
		}

		//모든 제품 목록 조회
		Map<String, Object> map = productService.findProductList(productFindFormForPos.getPage(), ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
		
		List list = (List) map.get("list");
		List productIdList = new ArrayList();
		
		//paymentDetailsSerivce.findPaymentDetailsListByStoreIdAndProductIdAndSellMethod(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productId, sellMethod);
		
		//모든 제품 아이디 목록 조회
		for(int i=0; i<list.size(); i++) {
			productIdList.add(((Product)list.get(i)).getProductId());
		}
		
		modelAndView.setViewName("store/product_pos.tiles");
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("storeId", ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
		
		return modelAndView;
	}

	//상승세/하락세 그래프를 위한 일주일치 값
	@RequestMapping("findSalesVolumeWeekController")
	@ResponseBody
	public Object findSalesVolumeWeekController(String productId) throws ParseException {

		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Integer> countList = new ArrayList<>();
		List<String> dateList = new ArrayList<>();
		
		//7일전
		int seven = service.findSalesVolumeByStoreIdAndProductIdAndTradeDate(((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productId, dt.parse((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-7)));
		countList.add(seven);
		dateList.add((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-7));
		
		//6일전
		int six = service.findSalesVolumeByStoreIdAndProductIdAndTradeDate(((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productId, dt.parse((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-6)));
		countList.add(six);
		dateList.add((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-6));
	
		//5일전
		int five = service.findSalesVolumeByStoreIdAndProductIdAndTradeDate(((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productId, dt.parse((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-5)));
		countList.add(five);
		dateList.add((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-5));
		
		//4일전
		int four = service.findSalesVolumeByStoreIdAndProductIdAndTradeDate(((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productId, dt.parse((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-4)));
		countList.add(four);
		dateList.add((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-4));
		
		//3일전
		int three = service.findSalesVolumeByStoreIdAndProductIdAndTradeDate(((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productId, dt.parse((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-3)));
		countList.add(three);
		dateList.add((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-3));
		
		//2일전
		int two = service.findSalesVolumeByStoreIdAndProductIdAndTradeDate(((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productId, dt.parse((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-2)));
		countList.add(two);
		dateList.add((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-2));
		
		//1일전
		int one = service.findSalesVolumeByStoreIdAndProductIdAndTradeDate(((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productId, dt.parse((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-1)));
		countList.add(one);
		dateList.add((new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getDate()-1));
		
		Map<String, Object> map = new HashMap<>();
		map.put("countList", countList);
		map.put("dateList", dateList);

		return map;
	}
}
