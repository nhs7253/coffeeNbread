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
import com.cnb.validation.annotation.ReservationDetailsViewForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ReservationDetails;

/*
 * 김형주
 * 2017-07-09 생성
 */

@Controller
public class ReservationDetailsController {

	@Autowired
	private PaymentDetailsService service;

	@Autowired
	private ShoppingBasketProductService sbpService;

	@Autowired
	private ReservationDetailsService rdService;


	// 유저가 예약한 예약내역 보기. - 페이징 필요할듯. - 페이징 추가.
	@RequestMapping("/user/findReservationDetailsController")
	public ModelAndView findReservationDetailsController(
			@ModelAttribute("reservationDetails") @Valid ReservationDetailsViewForm reservationDetailsViewForm,
			BindingResult errors, HttpServletRequest request)  {

		ModelAndView modelAndView = new ModelAndView();
		System.out.println("reservationDetailsViewForm:" + reservationDetailsViewForm);
		if (errors.hasErrors()) {
			modelAndView.setViewName("user/payment_fail.tiles"); // 임시로 해둠.
			return modelAndView; // 에러 발생
		}
		Map<String, Object> map = new HashMap<>();
         map =   rdService.findReservationDetailsListByUserId(reservationDetailsViewForm.getPage(),((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId() );
		System.out.println("뽑으려는 것 :"+map.get("list"));
		modelAndView.setViewName("user/user_payment_List.tiles");
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		
		return modelAndView;

	}

}