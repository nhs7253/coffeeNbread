package com.cnb.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.NullShoppingBasketProductException;
import com.cnb.exception.ProductNotFoundException;
import com.cnb.service.BookMarkCardNumService;
import com.cnb.service.GeneralUserService;
import com.cnb.service.PaymentDetailsService;
import com.cnb.service.ReservationDetailsService;
import com.cnb.service.ShoppingBasketProductService;
import com.cnb.service.StorePaymentOptionListService;
import com.cnb.validation.annotation.PaymentDetailsForm;
import com.cnb.validation.annotation.PaymentDetailsViewForm;
import com.cnb.vo.BookMarkCardNum;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ReservationDetails;
import com.cnb.vo.ShoppingBasketProduct;
import com.cnb.vo.Store;
import com.cnb.vo.StorePaymentOptionList;

/*
 * 김형주
 * 2017-07-09 생성
 */

@Controller
public class PaymentDetailsController {

	@Autowired
	private PaymentDetailsService service;

	@Autowired
	private GeneralUserService generalUserService;

	@Autowired
	private ReservationDetailsService rdService;
	
	@Autowired
	private StorePaymentOptionListService spoService;

	@Autowired
	private BookMarkCardNumService  bmService;
	
	@Autowired
	private ShoppingBasketProductService  sbpService;
	

	
	// 결제완료 버튼 눌러야 들어가는 것.
	@RequestMapping("/user/addPaymentDetailsController")

	// 즐겨찾는카드번호에서 카드 입력후 결제내역에 등록될 controller
	public ModelAndView addPaymentDetailsController(
			@ModelAttribute("paymentDetails") @Valid PaymentDetailsForm paymentDetailsform, BindingResult errors, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		
		System.out.println("paymentDetailsform:" + paymentDetailsform);
		GeneralUser generalUser = (GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (errors.hasErrors()) {
			System.out.println("에러 : " + errors.getAllErrors());
			modelAndView.setViewName("index.tiles");
			return modelAndView; // 에러 발생
		}
		List<PaymentDetails> paymentDetailsList = new ArrayList<PaymentDetails>();

		PaymentDetails paymentDetails = new PaymentDetails();
		BeanUtils.copyProperties(paymentDetailsform, paymentDetails);
		System.out.println("add-paymentDetailsform:" + paymentDetailsform);
		System.out.println("add-paymentDetailsform:" + paymentDetailsform);
		
		String storeId = ((Store) session.getAttribute("storeInfo")).getStoreId();
        

		System.out.println("-------paymentDetailsform---:" + paymentDetailsform.getProductIdList().size());
		for (int i = 0; i < paymentDetailsform.getProductIdList().size(); i++) {
			paymentDetails.setUserId(generalUser.getUserId());
			paymentDetails.setStoreId(storeId);
			paymentDetails.setProductId(paymentDetailsform.getProductIdList().get(i));
			paymentDetails.setReservationOrderCount(paymentDetailsform.getReservationOrderCount().get(i));
			paymentDetails.setProductTradeCount(0);
			paymentDetails.setSellMethod("r");
			paymentDetails.setPaymentOption(paymentDetailsform.getPaymentOption());
			paymentDetails.setUserId(generalUser.getUserId());
			paymentDetails.setTradeDate(new Date());

					
			try {
				System.out.println("----추가----");
				paymentDetailsList.add(paymentDetails);
				service.addPaymentDetails(paymentDetails);

			} catch (NullShoppingBasketProductException e) {
				// TODO Auto-generated catch block
				modelAndView.setViewName("user/user_payment_process.tiles");
				return modelAndView;
			}

		}
           
		rdService.addReservationDetailsByPaymentDetails(paymentDetailsList,paymentDetailsform.getProductHopeTime() );

		List<ReservationDetails>reservationList= rdService.findReservationDetailsListNoPagingByUserIdAndStoreId(generalUser.getUserId(), storeId);
		modelAndView.addObject("userName", generalUserService.findUser(generalUser.getUserId()).getUserName());
		modelAndView.addObject("reservationList", reservationList);
		modelAndView.setViewName("user/payment_success.tiles");
		
		
		return modelAndView; // 결제 성공페이지.
	}

	// 유저가 결제한 결제내역 보기. - 페이징 필요할듯. - 페이징 추가.
	@RequestMapping("/user/findPaymentDetailsController")
	public ModelAndView findPaymentDetailsController(
			@ModelAttribute("paymentDetails") @Valid PaymentDetailsViewForm paymentDetailsViewform,
			BindingResult errors, HttpSession session) throws ProductNotFoundException, Exception {
     System.out.println("--------결제 내역 진입 1--------------");
		GeneralUser generalUser = (GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
     ModelAndView modelAndView = new ModelAndView();
		System.out.println("paymentDetailsViewform:" + paymentDetailsViewform);
		if (errors.hasErrors()) {
			modelAndView.setViewName("user/payment_fail.tiles"); // 임시로 해둠.
			return modelAndView; // 에러 발생
		}
	     System.out.println("--------결제 내역 진입 2--------------");

		Map<String, Object> map = new HashMap<>();
		map = service.findPaymentDetailsListByUserId(paymentDetailsViewform.getPage(), generalUser.getUserId());
	    
		System.out.println("--------결제 내역 진입 3--------------");
         System.out.println("뽑고자 하는것:"+map.get("list"));
		modelAndView.setViewName("user/user_payment_List.tiles");
		modelAndView.addObject("userName", generalUserService.findUser(generalUser.getUserId()).getUserName());
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		return modelAndView;

	}

	// 유저가 결제할때 등록할떄 적용했던 매장 결제option 가지고 보여준다.
	// 유저가 등록한 카드까지 같이 넘긴다.
		@RequestMapping("/user/paymentProcessController")
		public ModelAndView paymentProcessController(
				@ModelAttribute("paymentDetails") @Valid PaymentDetailsViewForm paymentDetailsViewform,
				BindingResult errors, HttpSession session) throws ProductNotFoundException, Exception {
	     System.out.println("--------결제 과정 진입1--------------");
			GeneralUser generalUser = (GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    ModelAndView modelAndView = new ModelAndView();
			System.out.println("paymentDetailsViewform:" + paymentDetailsViewform);
			if (errors.hasErrors()) {
				modelAndView.setViewName("user/shoppingBasketProduct_list.tiles"); // 임시로 해둠.
				return modelAndView; // 에러 발생
			}
		     System.out.println("--------결제 과정 진입 2--------------");

			Map<String, Object> map = new HashMap<>();
			//매장이 가지고 있는 결제 수단 들 가져오기. - session에 해당되는 것
			String storeId = ((Store) session.getAttribute("storeInfo")).getStoreId();
			  List<StorePaymentOptionList> spoList=  spoService.findStorePaymentOptionList(storeId); //매장이 가지고 있는 결제목록.
			  
			 //기존 유저가 등록해놓은 즐겨찾는 카드번호  
			 List<BookMarkCardNum>bmList= bmService.findBookMarkCardNumListByUserId(generalUser.getUserId());
           
			//내가 매장에서 최종적으로 넣어둔 제품목록의 가격 한번더 불러옴.
			int totalPrice=sbpService.findAllProductPrice(storeId, generalUser.getUserId());
			
			//내가 최종적으로 결제한 목록들 보여줌.
			List<ShoppingBasketProduct>sbpList=sbpService.findShoppingBasketProductListByStoreIdAndUserId(storeId, generalUser.getUserId());
/*			map = service.findPaymentDetailsListByUserId(paymentDetailsViewform.getPage(), generalUser.getUserId());
 */		   System.out.println("sbpList:"+sbpList);
			System.out.println("---------결제과정 진입 3----------------");
			modelAndView.setViewName("user/user_payment_process.tiles");
			modelAndView.addObject("userName", generalUserService.findUser(generalUser.getUserId()).getUserName());
			modelAndView.addObject("spoList", spoList);
			modelAndView.addObject("bmlist", bmList);
			modelAndView.addObject("totalPrice", totalPrice);
			modelAndView.addObject("sbpList", sbpList);
			return modelAndView;

		}
	
	
}