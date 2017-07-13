package com.cnb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import com.cnb.service.PaymentDetailsService;
import com.cnb.service.ReservationDetailsService;
import com.cnb.service.ShoppingBasketProductService;
import com.cnb.validation.annotation.PaymentDetailsForm;
import com.cnb.validation.annotation.PaymentDetailsViewForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ReservationDetails;

/*
 * 김형주
 * 2017-07-09 생성
 */

@Controller
public class PaymentDetailsController {

	@Autowired
	private PaymentDetailsService service;

	@Autowired
	private ShoppingBasketProductService sbpService;

	@Autowired
	private ReservationDetailsService rdService;

	// 결제완료 버튼 눌러야 들어가는 것.
	@RequestMapping("/user/addPaymentDetailsController")

	// 즐겨찾는카드번호에서 카드 입력후 결제내역에 등록될 controller
	public String addPaymentDetailsController(
			@ModelAttribute("paymentDetails") @Valid PaymentDetailsForm paymentDetailsform, BindingResult errors) {

		System.out.println("paymentDetailsform:" + paymentDetailsform);
		GeneralUser generalUser = (GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (errors.hasErrors()) {
			return "user/payment_view.tiles"; // 에러 발생
		}
		List<PaymentDetails> paymentDetailsList = new ArrayList<PaymentDetails>();

		PaymentDetails paymentDetails = new PaymentDetails();
		BeanUtils.copyProperties(paymentDetailsform, paymentDetails);
		System.out.println("add-paymentDetailsform:" + paymentDetailsform);
		System.out.println("add-paymentDetailsform:" + paymentDetailsform);

		
		System.out.println("-------paymentDetailsform---:"+paymentDetailsform.getProductIdList().size());
		for (int i = 0; i < paymentDetailsform.getProductIdList().size(); i++) {
			paymentDetails.setStoreId(paymentDetailsform.getStoreIdList().get(i));
			paymentDetails.setProductId(paymentDetailsform.getProductIdList().get(i));
			paymentDetails.setReservationOrderCount(paymentDetailsform.getReservationOrderCount().get(i));
			paymentDetails.setProductTradeCount(0);
			paymentDetails.setSellMethod("r");
			paymentDetails.setPaymentOption("c");
			paymentDetails.setUserId(generalUser.getUserId());
			paymentDetails.setTradeDate(new Date());
     
			try {
				System.out.println("----추가----");
				paymentDetailsList.add(paymentDetails);
				service.addPaymentDetails(paymentDetails);

			} catch (NullShoppingBasketProductException e) {
				// TODO Auto-generated catch block
				return "user/payment_view.tiles"; // 결제하는 페이지
			}
		}
		// 예약내역 넣기.
	rdService.addReservationDetailsByPaymentDetails(paymentDetailsList,paymentDetailsform.getProductHopeTime());
		return "user/user_payment_List.tiles"; // 결제 성공페이지.
	}

	// 유저가 결제한 결제내역 보기. - 페이징 필요할듯. - 페이징 추가.
	@RequestMapping("/user/findPaymentDetailsController")
	public ModelAndView findPaymentDetailsController(
			@ModelAttribute("paymentDetails") @Valid PaymentDetailsViewForm paymentDetailsViewform,
			BindingResult errors, HttpServletRequest request) throws ProductNotFoundException, Exception {

		ModelAndView modelAndView = new ModelAndView();
		System.out.println("paymentDetailsViewform:" + paymentDetailsViewform);
		if (errors.hasErrors()) {
			modelAndView.setViewName("user/payment_fail.tiles"); // 임시로 해둠.
			return modelAndView; // 에러 발생
		}
		Map<String, Object> map = new HashMap<>();
		map = service.findPaymentDetailsListByStoreIdAndUserId(paymentDetailsViewform.getPage(),
				paymentDetailsViewform.getStoreId(),
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());

		modelAndView.setViewName("user/user_payment_list.tiles");
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("storeId", paymentDetailsViewform.getStoreId());
		return modelAndView;

	}

}