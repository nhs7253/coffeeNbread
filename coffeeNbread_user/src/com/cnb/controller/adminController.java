package com.cnb.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.UserManageException;
import com.cnb.service.AdminService;
import com.cnb.service.GeneralUserService;
import com.cnb.service.PaymentOptionListService;
import com.cnb.validation.annotation.PaymentOptionListForm;
import com.cnb.validation.annotation.UserManagementListViewForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.PaymentOptionList;

/*
 * 노현식 
 * 2017-07-04 
 * modifyUserController 비밀번호 검증 추가 및 테스트
 * removeUserController 탈퇴시 비밀번호 확인 후 탈퇴
 * 
 * 노현식 
 * 2017-07-03 
 * 회원정보 수정, 회원탈퇴, 회원 목록 조회 추가
 * 
 * 노현식 
 * 2017-06-30 
 * 회원가입 구현
 * 
 * 노현식 
 * 2017-06-27 
 * 생성
 */
/**
 * 유저 관련 요청을 처리하는 Controller class
 */
@Controller
public class adminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private GeneralUserService generalUserService;
	
	@Autowired
	private PaymentOptionListService paymentOptionListService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * 관리자가 입력한 키워드를 통해 조회한 회원과 매장의 조인 데이터를 페이징하여 보여주는 컨트롤러 (주로 매장 관리)
	 * @param userManagementListViewForm
	 * @param errors 요청 파라미터 에러 처리
	 * @return String 반환 경로
	 */
	@RequestMapping("/admin/userManagementListController")
	public ModelAndView userManagementListController(@ModelAttribute("userManagementListView") @Valid UserManagementListViewForm userManagementListViewForm, BindingResult errors){
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()){
			modelAndView.setViewName("index.tiles");
			return modelAndView; //에러 발생 시 이동할 경로
		}
		
		Map<String, Object> map = adminService.userManagementListService(userManagementListViewForm.getSelect(), userManagementListViewForm.getKeyword(), userManagementListViewForm.getPage());
		modelAndView.setViewName("admin/store_manage_list.tiles"); //성공 시 이동할 경로
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("keyword", userManagementListViewForm.getKeyword());
		modelAndView.addObject("select", userManagementListViewForm.getSelect());
		return modelAndView;
	}
	
	/**
	 * 매장 허가 여부를 변경 해주는 컨트롤러 (유저 권한도 함깨 변경) -> 권한과 허가여부가 토글 됨
	 * @param userId 권한을 변경할 유저ID (매장 신청자)
	 * @param storeId 허가 여부를 결정할 매장
	 * @param storePermission 현제 매장 허가 여부
	 * @return String 반환 경로
	 */
	@RequestMapping("/admin/storeApproveController")
	public String storeApproveController(String userId, String storeId, String storePermission){
		
		adminService.storeApproveService(userId, storeId, storePermission);
		return "redirect:/admin/userManagementListController.do";
	}
	
	/**
	 * 플랫폼에서 지원하는 결제 방법 추가
	 * @param paymentOptionListForm 결제 방법이 담긴 객체
	 * @param errors 요청파리미터 에러 처리
	 * @return String 반환 경로
	 */
	@RequestMapping("/admin/addPaymentOptionListController")
	public String addPaymentOptionListController(@ModelAttribute("paymentOptionList") @Valid PaymentOptionListForm paymentOptionListForm, BindingResult errors){
		
		if(errors.hasErrors()){
			return "admin/payment_option_register_form.tiles"; //에러 발생 시 회원 가입 페이지로 이동
		}
		PaymentOptionList paymentOptionList = new PaymentOptionList();
		BeanUtils.copyProperties(paymentOptionListForm, paymentOptionList);
		paymentOptionListService.addPaymentOptionList(paymentOptionList);
		return "redirect:/admin/findpaymentOptionListController.do";
	}
	
	/**
	 * 플랫폼에서 지원하는 모든 결제 방법을 보여줌
	 * @return String 반환경로
	 */
	@RequestMapping("/admin/findpaymentOptionListController")
	public ModelAndView findpaymentOptionListController(){
		ModelAndView modelAndView = new ModelAndView();
		
		List<PaymentOptionList> list = paymentOptionListService.findpaymentOptionList();
		
		modelAndView.setViewName("admin/payment_option_list.tiles"); //성공 시 이동할 경로
		modelAndView.addObject("list", list);
		
		return modelAndView;
	}
	
	/**
	 * 플랫폼에서 지워하는 하나의 결제 방법을 제거
	 * @param paymentId 제거할 결제 방법의 ID
	 * @return String 반환 경로
	 */
	@RequestMapping("admin/removePaymentOptionListController")
	public String removePaymentOptionListController(String paymentId){
		paymentOptionListService.removePaymentOptionListByPaymentId(paymentId);
		return "redirect:/admin/findpaymentOptionListController.do";
	}	
	
	/**
	 * 로그인된 회원의 정보를 받아 해당 회원을 탈퇴 시키는 Controller
	 * @param password 탈퇴할 회원의 비밀번호
	 * @return String - 응답 경로
	 */
	@RequestMapping("/admin/adminRemoveUserController")
	public String adminRemoveUserController(@RequestParam(value="userId",required=false) String userId, String storeId){
		
		if(userId == null){
			
			System.out.println("user = "+ userId);
			return "redirect:/admin/findUserListBySelectToKeywordController.do"; //탈퇴 시도 실패
		}

		try {
			generalUserService.removeUser(userId, storeId);
		} catch (UserManageException e) {
			return "redirect:/admin/findUserListBySelectToKeywordController.do"; //에러 페이지 이동
		}

		return "redirect:/admin/findUserListBySelectToKeywordController.do";
	}
}
