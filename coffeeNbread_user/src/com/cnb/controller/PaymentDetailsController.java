package com.cnb.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.DuplicatedProductPictureException;
import com.cnb.exception.NullShoppingBasketProductException;
import com.cnb.exception.ProductNotFoundException;
import com.cnb.service.PaymentDetailsService;
import com.cnb.service.ShoppingBasketProductService;
import com.cnb.validation.annotation.PaymentDetailsForm;
import com.cnb.validation.annotation.PaymentDetailsViewForm;
import com.cnb.validation.annotation.ProductFindByMethodForm;
import com.cnb.validation.annotation.ProductFindForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.OptionDetail;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.Product;
import com.cnb.vo.ProductPicture;
import com.cnb.vo.ShoppingBasketProduct;

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

	// 결제완료 버튼 눌러야 들어가는 것.
	@RequestMapping("/user/addPaymentDetailsController")
	/**
	 * 결제내역 등록.
	 * 
	 * @param paymentDetailsform
	 * @param errors
	 * @return
	 */

	// 즐겨찾는카드번호에서 카드 입력후 결제내역에 등록될 controller
	public String addPaymentDetailsController(
			@ModelAttribute("paymentDetails") @Valid PaymentDetailsForm paymentDetailsform, BindingResult errors) {

		GeneralUser generalUser = (GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (errors.hasErrors()) {
			return "user/payment_register.tiles"; // 에러 발생
		}

		PaymentDetails paymentDetails = new PaymentDetails();
		BeanUtils.copyProperties(paymentDetailsform, paymentDetails);

		paymentDetails.setProductTradeCount(0);
		paymentDetails.setSellMethod("r");
		paymentDetails.setPaymentOption("c"); // 일단 카드로만 해놓음. 나중에 관리자가 추가하는거 봐서
												// service만들계획.
		paymentDetails.setUserId(generalUser.getUserId());
		paymentDetails.setTradeDate(new Date());

		// modifyShoppingBasketProductController에서 버튼누르면 결제폼으로 이동. ( 장바구니목록들 가지고
		// 옴.)
		//
		List<ShoppingBasketProduct> sbpList = sbpService.findShoppingBasketProductListByStoreIdAndUserId(
				paymentDetailsform.getStoreId(), generalUser.getUserId());
		try {
			service.addPaymentDetails(sbpList);
		} catch (NullShoppingBasketProductException e) {
			return "user/  ";// 결제 완료 하기전 페이지로.

		}
		return "user/payment_success.tiles"; // 결제 성공페이지.
	}

	// 유저가 결제한 결제내역 보기. - 페이징 필요할듯. - 페이징 추가.
	@RequestMapping("/user/findPaymentDetailsController")
	public ModelAndView findPaymentDetailsController(
			@ModelAttribute("paymentDetails") @Valid PaymentDetailsViewForm paymentDetailsViewform,
			BindingResult errors, HttpServletRequest request) throws ProductNotFoundException, Exception {

		ModelAndView modelAndView = new ModelAndView();

		if (errors.hasErrors()) {
			modelAndView.setViewName("user/payment_fail.tiles"); // 결제 내역눌렀을때 만약
																	// 요청파라미터값 잘
																	// 안넘어왔을떄
																	// 어디로 갈지는
																	// 추후 생각.
			return modelAndView; // 에러 발생
		}
		Map<String, Object> map = new HashMap<>();
		map = service.findPaymentDetailsListByStoreIdAndUserId(paymentDetailsViewform.getPage(),
				paymentDetailsViewform.getStoreId(),
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());

		modelAndView.setViewName("user/paymentDetails_list.tiles"); // 결제 내역보여주는
																	// 페이지.
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("storeId", paymentDetailsViewform.getStoreId());
		return modelAndView;

	}
}