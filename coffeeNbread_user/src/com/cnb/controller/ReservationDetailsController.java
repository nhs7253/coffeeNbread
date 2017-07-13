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
import com.cnb.service.GeneralUserService;
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
	private ReservationDetailsService rdService;

	@Autowired
	private GeneralUserService generalUserService;

	// 유저가 예약한 예약내역 보기. - 페이징 필요할듯. - 페이징 추가.
	@RequestMapping("/user/findReservationDetailsController")
	public ModelAndView findReservationDetailsController(
			@ModelAttribute("reservationDetails") @Valid ReservationDetailsViewForm reservationDetailsViewForm,
			BindingResult errors, HttpServletRequest request)  {
         System.out.println("-----------reservation---------------진입");
        ModelAndView modelAndView = new ModelAndView();
		if (errors.hasErrors()) {
			System.out.println("-----------------오류발생----------------");
			modelAndView.setViewName("index.tiles"); // 임시로 해둠.
			return modelAndView; // 에러 발생
		}
		Map<String, Object> map = new HashMap<>();
       map=rdService.findReservationDetailsListByUserId(reservationDetailsViewForm.getPage(), ((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());                
		System.out.println("뽑으려는 것 :"+map.get("list"));
	  modelAndView.setViewName("user/user_reservation_List.tiles");
	modelAndView.addObject("list", map.get("list"));
		//유저이름 보내기
	GeneralUser generalUser=generalUserService.findUser(((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());

	modelAndView.addObject("userName",generalUser.getUserName() );
 
		//pageBean
		modelAndView.addObject("pageBean", map.get("pageBean"));
		
		return modelAndView;

	}

}