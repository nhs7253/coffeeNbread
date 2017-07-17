package com.cnb.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.service.GeneralUserService;
import com.cnb.service.ProductService;
import com.cnb.service.ReservationDetailsService;
import com.cnb.validation.annotation.FindReservationDetailsForm;
import com.cnb.validation.annotation.ReservationDetailsSelectForDeleteForm;
import com.cnb.validation.annotation.ReservationDetailsViewForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.Product;
import com.cnb.vo.ReservationDetails;

/*
 * 최민희
 * 2017-07-11
 * 생성
 */
@Controller
public class ReservationDetailsController {
	
	@Autowired
	private ReservationDetailsService service;
	
	@Autowired
	private GeneralUserService userService;
	
	@Autowired
	private ProductService productService;

	@Autowired
	private ReservationDetailsService rdService;
	
	//매장의 모든 예약 내역 조회
	@RequestMapping("findReservationDetailsController")
	public ModelAndView findReservationDetailsController(@ModelAttribute("findReservationDetails") @Valid FindReservationDetailsForm findReservationDetailsForm , BindingResult errors) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()) {
			modelAndView.setViewName("index.tiles");
			return modelAndView;	
		}
		
		Map<String, Object> map = service.findReservationDetailsListByStoreId(findReservationDetailsForm.getPage(), ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
	
		List reservationList = (List)map.get("list");
			
		List<String> userNameList = new ArrayList<>();
		List<String> phoneNumList = new ArrayList<>();
		
		
		for(int i=0; i<reservationList.size(); i++) {
//			((ReservationDetails)reservationList.get(i)).setReservationConfirm(findReservationDetailsForm.getReservationConfirm());
			
			GeneralUser user = userService.findUser(((ReservationDetails)reservationList.get(i)).getUserId());
			String userName = user.getUserName();
			userNameList.add(userName);
			
			String phoneNum = user.getUserPhone();
			phoneNumList.add(phoneNum);
		}
		
		modelAndView.setViewName("store/reservation_list.tiles");
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("userNameList", userNameList);
		modelAndView.addObject("phoneNumList", phoneNumList);
		modelAndView.addObject("pageBean", map.get("pageBean"));
		
		return modelAndView;
	}
	
	//예약자로 예약 상세 내용 조회
	@RequestMapping("findReservationDetailController")
	public ModelAndView findReservationDetailController(@RequestParam(value="userId", required=false) String userId, @RequestParam(value="reservationTime", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date reservationTime) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(userId == null || reservationTime == null) {
			modelAndView.setViewName("store/reservation_list.tiles");
			return modelAndView;
		}
		
		List<ReservationDetails> reservationDetail = service.findReservationDetailByStoreIdAndReservationTimeAndUserId(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), reservationTime, userId);
		
		GeneralUser user = userService.findUser(reservationDetail.get(0).getUserId());
		String userName = user.getUserName();

		Date time = reservationDetail.get(0).getReservationTime();

		List<String> productNameList = new ArrayList<>();
		List<String> countList = new ArrayList<>();
		
		for(int i=0; i<reservationDetail.size(); i++) {
			Product product = productService.findProductById(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), reservationDetail.get(i).getProductId());
			productNameList.add(product.getProductName());
			
			countList.add(String.valueOf(reservationDetail.get(i).getReservationCount()));
		}
		
		Date hopeTime = reservationDetail.get(0).getProductHopeTime();
		
		modelAndView.setViewName("store/reservation_detail.tiles");
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("time", time);
		modelAndView.addObject("productNameList", productNameList);
		modelAndView.addObject("countList", countList);
		modelAndView.addObject("hopeTime", hopeTime);
		return modelAndView;
	}
	
	//알림전송 버튼 클릭시 해당 예약 내역의 확인 유무를 현재 시간으로 바꿔줌
	@RequestMapping("changeReservationConfirmByClickButtonController")
	@ResponseBody
	public Object changeReservationConfirmByClickButtonController(@RequestParam(value="userId", required=false) String userId, @RequestParam(value="reservationTime", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date reservationTime) {
		
		List<ReservationDetails> reservationDetails = service.findReservationDetailByStoreIdAndReservationTimeAndUserId(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), reservationTime, userId);
		for(int i=0; i<reservationDetails.size(); i++) {
			reservationDetails.get(i).setReservationConfirm(new Date());
		}
		
		service.modifyReservationConfirmDate(reservationDetails);
		
		Date confirmTime = reservationDetails.get(0).getReservationConfirm();
		String cofirmTimeString = new SimpleDateFormat("yyyy-MM-dd").format(confirmTime);
		
		return cofirmTimeString;
	}
	
	//삭제할 예약 내역 선택
	@RequestMapping("selectRemoveReservationDetailsController")
	public String selectRemoveReservationDetailsController(@ModelAttribute("reservationDetailsSelectForDelete") @Valid ReservationDetailsSelectForDeleteForm reservationDetailsSelectForDeleteForm, BindingResult errors) {
		
		if(errors.hasErrors()) {
			System.out.println(errors.getAllErrors());
			return "redirect:/findReservationDetailsController.do";
		}
		
		System.out.println("ReservationTimeList : " + reservationDetailsSelectForDeleteForm.getReservationNoList());
		
		List list = reservationDetailsSelectForDeleteForm.getReservationNoList();
		List<ReservationDetails> reservationList = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			ReservationDetails detail = service.findReservationDetailsByReservationNo(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), Integer.parseInt(String.valueOf(list.get(i))));
			System.out.println("detail : " + detail);
			reservationList.add(detail);
		}
		System.out.println("reservationList : " + reservationList);
		
		service.findRemoveReservationDetails(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), reservationList);
		return "redirect:/findReservationDetailsController.do";
	}

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

