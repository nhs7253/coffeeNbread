package com.cnb.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.service.AdminService;
import com.cnb.service.PaymentOptionListService;
import com.cnb.validation.annotation.PaymentOptionListForm;
import com.cnb.validation.annotation.UserManagementListViewForm;
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
	private PaymentOptionListService paymentOptionListService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * 관리자가 입력한 키워드를 통해 조회한 회원과 매장의 조인 데이터를 페이징하여 보여주는 컨트롤러 (주로 매장 관리)
	 * @param userManagementListViewForm
	 * @param errors 요청 파라미터 에러 처리
	 * @return String 반환 경로
	 */
	@RequestMapping("/userManagementListController")
	public ModelAndView userManagementListController(@ModelAttribute("userManagementListView") @Valid UserManagementListViewForm userManagementListViewForm, BindingResult errors){
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()){
			modelAndView.setViewName("index.tiles");
			return modelAndView; //에러 발생 시 이동할 경로
		}
		
		Map<String, Object> map = adminService.userManagementListService(userManagementListViewForm.getSelect(), userManagementListViewForm.getKeyword(), userManagementListViewForm.getPage());
		modelAndView.setViewName("store_manage_list.tiles"); //성공 시 이동할 경로
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
	@RequestMapping("/storeApproveController")
	public String storeApproveController(String userId, String storeId, String storePermission){
		
		adminService.storeApproveService(userId, storeId, storePermission);
		return "redirect:/userManagementListController.do";
	}
	
	/**
	 * 플랫폼에서 지원하는 결제 방법 추가
	 * @param paymentOptionListForm 결제 방법이 담긴 객체
	 * @param errors 요청파리미터 에러 처리
	 * @return String 반환 경로
	 */
	@RequestMapping("/addPaymentOptionListController")
	public String addPaymentOptionListController(@ModelAttribute("paymentOptionList") @Valid PaymentOptionListForm paymentOptionListForm, BindingResult errors){
		
		if(errors.hasErrors()){
			return "payment_option_register_form.tiles"; //에러 발생 시 회원 가입 페이지로 이동
		}
		PaymentOptionList paymentOptionList = new PaymentOptionList();
		BeanUtils.copyProperties(paymentOptionListForm, paymentOptionList);
		paymentOptionListService.addPaymentOptionList(paymentOptionList);
		return "redirect:/findpaymentOptionListController.do";
	}
	
	/**
	 * 플랫폼에서 지원하는 모든 결제 방법을 보여줌
	 * @return String 반환경로
	 */
	@RequestMapping("/findpaymentOptionListController")
	public ModelAndView findpaymentOptionListController(){
		ModelAndView modelAndView = new ModelAndView();
		
		List<PaymentOptionList> list = paymentOptionListService.findpaymentOptionList();
		
		modelAndView.setViewName("payment_option_list.tiles"); //성공 시 이동할 경로
		modelAndView.addObject("list", list);
		
		return modelAndView;
	}
	
	/**
	 * 플랫폼에서 지워하는 하나의 결제 방법을 제거
	 * @param paymentId 제거할 결제 방법의 ID
	 * @return String 반환 경로
	 */
	@RequestMapping("/removePaymentOptionListController")
	public String removePaymentOptionListController(String paymentId){
		paymentOptionListService.removePaymentOptionListByPaymentId(paymentId);
		return "redirect:/findpaymentOptionListController.do";
	}

	
	
	
//	//@RequestMapping의 value 값 생략시 루트 경로로 이동
//	@RequestMapping("addUserController") //@ModelAttribute("generalUser")의 value 값으로 RequestScope에 매핑됨, 생략 시 클래스 이름 
//						       //맨 앞글자 소문자로 매핑 됨
//	/**
//	 * 회원 가입을 처리하는 Controller
//	 * @param generalUserForm 요청 파라미터 검증 generalUser 객체
//	 * @param errors 요청 파라미터 에러
//	 * @return String - 응답 경로
//	 */
//	public String addUserController(@ModelAttribute("generalUser") @Valid GeneralUserForm generalUserForm, BindingResult errors){
//		if(errors.hasErrors()){
//			return "user/add_user_form.tiles"; //에러 발생 시 회원 가입 페이지로 이동
//		}
//		
//		GeneralUser generalUser = new GeneralUser();
//		//요청 파리미터 검증이 끝난 뒤 실제로 사용될 GeneralUser객채를 만듬
//		
//		BeanUtils.copyProperties(generalUserForm, generalUser); //소스, 타겟
//		//BeanUtils.copyProperties(소스, 타켓); 
//		//소스(Form)에 있는 검증 끝난 요청 파라미터 값을 실사용을 위한 타겟(ex - generalUser)에 넣음
//		
//		try {
//			service.addUser(generalUser);
//		} catch (UserManageException e) {
//			System.out.println(e.getMessage());
//			return "user/add_user_form.tiles"; //에러 발생 시 회원 가입 페이지로 이동
//		}
//		return "index.tiles"; //가입 성공 시 메인페이지로 이동
//	}
//	
//	
//	@RequestMapping("/user/modifyUserController")
//	/**
//	 * 회원 정보를 수정하는 Controller
//	 * @param generalUserForm GeneralUser 객체의 파라미터 검증을 위한 객체
//	 * @param errors 요청 파라미터 에러
//	 * @param oldUserPassword 이전 비밀번호
//	 * @return - 응답 경로
//	 */
//	public String modifyUserController(@ModelAttribute("generalUser") @Valid GeneralUserForm generalUserForm, BindingResult errors, @RequestParam String oldUserPassword){
//		SecurityContext context = SecurityContextHolder.getContext();
//
//		if(errors.hasErrors() && !passwordEncoder.matches(oldUserPassword, ((GeneralUser)context.getAuthentication().getPrincipal()).getUserPw())){
//			return "user/update_profile_form.tiles"; //에러 페이지 이동
//		}
//		
//		
//		GeneralUser generalUser = new GeneralUser();
//		//요청 파리미터 검증이 끝난 뒤 실제로 사용될 GeneralUser객채를 만듬
//		
//		BeanUtils.copyProperties(generalUserForm, generalUser); //소스, 타겟
//		//BeanUtils.copyProperties(소스, 타켓); 
//		//소스(Form)에 있는 검증 끝난 요청 파라미터 값을 실사용을 위한 타겟(ex - generalUser)에 넣음
//		
//		generalUser.setUserActiveState("Y");
//		try {
//			service.modifyUser(generalUser);
//		} catch (UserManageException e) {
//			return "user/update_profile_form.tiles"; //에러 페이지 이동
//		}
//		/*   //authorities 접근
//		Iterator it = context.getAuthentication().getAuthorities().iterator();
//		String authority = null;
//		while(it.hasNext()){
//			authority = (String)it.next();
//		}
//		
//		//SimpleGrantedAuthority - 권한정보를 문자열로 저장.
//		List<SimpleGrantedAuthority> authList = new ArrayList<>();
//		authList.add(new SimpleGrantedAuthority(authority));
//		*/
//		
//		List<GrantedAuthority> authList = new ArrayList<>(context.getAuthentication().getAuthorities());
//		context.setAuthentication(new UsernamePasswordAuthenticationToken(generalUser, null, authList));
//		 
//		return "user/mypage.tiles"; //처리 페이지 이동
//	}
//	
//	/**
//	 * 로그인된 회원의 정보를 받아 해당 회원을 탈퇴 시키는 Controller
//	 * @param password 탈퇴할 회원의 비밀번호
//	 * @return String - 응답 경로
//	 */
//	@RequestMapping("/user/removeUserController")
//	public String removeUserController(@RequestParam(value="password",required=false) String password){
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //로그인 시 사용했던 유저 정보 받음
//		//GeneralUser generalUser = (GeneralUser)authentication.getPrincipal();
//		
//		if(authentication == null){
//			return "index.tiles"; //에러 페이지로 이동 (잘못된 접근)
//		}
//		
//		if(password == null || !passwordEncoder.matches(password, ((GeneralUser)authentication.getPrincipal()).getUserPw())){
//			return "user/remove_user_form.tiles"; //탈퇴 시도 실패
//		}
//
//		try {
//			service.removeUser(((GeneralUser)authentication.getPrincipal()).getUserId());
//		} catch (UserManageException e) {
//			return "index.tiles"; //에러 페이지 이동
//		}
//
//		SecurityContextHolder.getContext().setAuthentication(null); //SecurityContext에 묶여 있던 유저 정보 제거
//		
//		return "redirect:/index.do"; 
//		//로그아웃 페이지로 이동 하여 로그아웃 후 로그아웃 페이지가 메인 페이지로 보냄   ↑해당 구문 주석 - 현재 불가능
//	}
//	
//	/**
//	 * 회원 목록을 userId와 userName 카테고리, 키워드로 검색하여 페이징 해주는 Controller
//	 * @param generalUserViewForm (String select, String keyword, int page) - 검색하려는 카테고리, 검색하려는 키워드, 보려는 페이지 번호
//	 * @param errors 요청 파라미터 체크
//	 * @return ModelAndView - 응답 경로, 페이징 결과 목록
//	 */
//	@RequestMapping("/findUserListBySelectToKeywordController")
//	public ModelAndView findUserListBySelectToKeywordController(@ModelAttribute("generalUserView") @Valid GeneralUserViewForm generalUserViewForm, BindingResult errors){
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		if(errors.hasErrors()){
//			modelAndView.setViewName("index.tiles");
//			return modelAndView; //에러 발생 시 이동할 경로
//		}
//		
//		Map<String, Object> map = service.findUserListBySelectToKeyword(generalUserViewForm.getSelect(), generalUserViewForm.getKeyword(), generalUserViewForm.getPage());
//
//		List<Product> list = (List<Product>) map.get("list");
//		
//		modelAndView.setViewName("user_list.tiles"); //성공 시 이동할 경로
//		modelAndView.addObject("list", map.get("list"));
//		modelAndView.addObject("pageBean", map.get("pageBean"));
//		modelAndView.addObject("keyword", generalUserViewForm.getKeyword());
//		modelAndView.addObject("select", generalUserViewForm.getSelect());
//		return modelAndView;
//	}
	
}
