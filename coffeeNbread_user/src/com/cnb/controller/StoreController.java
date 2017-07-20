package com.cnb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.DuplicatedOptionCategoryNameException;
import com.cnb.exception.DuplicatedStoreCategorytNameException;
import com.cnb.exception.DuplicatedStoreIdException;
import com.cnb.exception.DuplicatedStorePictureException;
import com.cnb.exception.StorePictureNotFoundException;
import com.cnb.exception.UserManageException;
import com.cnb.service.PaymentOptionListService;
import com.cnb.service.StoreService;
import com.cnb.validation.annotation.NoticeBoardContentsViewForm;
import com.cnb.validation.annotation.StoreRegisterForm;
import com.cnb.validation.annotation.StoreViewForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.OptionCategory;
import com.cnb.vo.Store;
import com.cnb.vo.StoreCategory;
import com.cnb.vo.StorePicture;
import com.cnb.vo.StorePosition;

/*
 * 노현식
 * 2017-07-11
 * StorePaymentOptionList 관련 업데이트
 * 
 * 이진영
 * 2017-07-06
 * storeCategory controller 추가
 * optionCategory controller 추가
 * 
 * 이진영
 * 2017-07-05
 * 생성
 */

@Controller
public class StoreController {

	@Autowired
	private StoreService storeService;
	 
	@Autowired
	private PaymentOptionListService paymentOptionListService;

	/**
	 * Store 매장 전체를 등록하는 Controller
	 * 
	 * @param Store
	 *            요청파라미터 검증 Store 객체
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addStoreController")
	public ModelAndView addStoreController(@ModelAttribute("store") @Valid StoreRegisterForm storeRegisterForm,
			BindingResult errors, HttpServletRequest request, ModelMap map) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		
		if (errors.hasErrors()) {
			modelAndView.setViewName("index.tiles"); 
			return modelAndView;
		}
		
		Store store = new Store();
		BeanUtils.copyProperties(storeRegisterForm, store);
		
		String storeCategory = "";
	
		  // optionCategory 등록
		  List<String> optionCategoryList = new ArrayList<String>();
		  List<OptionCategory> oclist = new ArrayList<OptionCategory>();
		  for(int i = 0;i<storeRegisterForm.getOptionCategoryList().size();i++){
			  optionCategoryList.add(storeRegisterForm.getOptionCategoryList().get(i));
			 OptionCategory optionCategoryList2 = new OptionCategory(optionCategoryList.get(i),storeRegisterForm.getStoreId());
			 oclist.add(optionCategoryList2);
			 storeCategory += optionCategoryList2.getOptionCategory() +", ";
		  }
		  
		store.setStoreCategory(storeCategory.substring(0, storeCategory.length()-2));

		
		// storePicture 등록
		String destDir = request.getServletContext().getRealPath("/up_image");

		List<MultipartFile> list = storeRegisterForm.getStorePictureList();
		ArrayList<String> imageName = new ArrayList<>();// 업로드된 파일명을 저장할 list

		// 업로드된 파일의 정보(파일명) 조회, 파일 이동 처리 - 반복문 필요
		for (int i = 0; i < list.size(); i++) {
			MultipartFile mFile = list.get(i);
			if (mFile != null && !mFile.isEmpty()) { // 업로드된 파일이 있는 경우
				imageName.add(mFile.getOriginalFilename());
				mFile.transferTo(new File(destDir, mFile.getOriginalFilename())); // 예외
				// 던짐
			}
		}

		// 다른 경로로 이동 -> 경로 변경
		// 경로는 고정, 파일은 여러개 -> 파일 이름 저장

		StorePicture storePicture = new StorePicture(imageName.get(0), storeRegisterForm.getStoreId());
		

		// 세션으로 묶음
		HttpSession session = request.getSession();
		Store storeRetrun = null;
		try {
			storeRetrun = storeService.addStore(store, 
												oclist, 
												storePicture, 
												((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId(), 
												storeRegisterForm.getPaymentIdList(),
												new StorePosition(storeRegisterForm.getStoreId(),storeRegisterForm.getX() ,storeRegisterForm.getY()));
			session.setAttribute("storeInfo", storeRetrun);
		} catch (DuplicatedStoreIdException | DuplicatedOptionCategoryNameException
				| DuplicatedStoreCategorytNameException | DuplicatedStorePictureException e) {
			session.setAttribute("message", e.getMessage());	
			modelAndView.setViewName("redirect:/user/callStoreRegisterController.do"); 
			return modelAndView;
		}
		modelAndView.setViewName("common/store_view.tiles"); 
		modelAndView.addObject("store", storeRetrun);
		
		return modelAndView;
	}

	/**
	 * store매장을 수정하는 controller
	 * 
	 * @param storeRegisterForm
	 * @param errors
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping("modifyStoreController")
	public ModelAndView modifyStoreController(@ModelAttribute("store") @Valid StoreRegisterForm storeRegisterForm,
			BindingResult errors, HttpServletRequest request) throws IllegalStateException, IOException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if (errors.hasErrors()) {
			modelAndView.setViewName("redirect:/common/viewStoreController.do?storeId="+((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId()); 
			return modelAndView;
		}
		
//		HttpSession session = request.getSession();
//		Store store = new Store();
		
//		Store store = new Store();
//		BeanUtils.copyProperties(storeRegisterForm, store);
				 
/*
		

		Store store = (Store) session.getAttribute("store");*/
		HttpSession session = request.getSession();
//		Store store = (Store) session.getAttribute("storeInfo");
		Store store = new Store();
		BeanUtils.copyProperties(storeRegisterForm, store);
		
		
		String storeCategory = "";
		// 매장 분류 수정
		List<String> optionCategoryList = new ArrayList<String>();
		List<OptionCategory> oclist = new ArrayList<OptionCategory>();

		for (int i = 0; i < storeRegisterForm.getOptionCategoryList().size(); i++) {
			optionCategoryList.add(storeRegisterForm.getOptionCategoryList().get(i));
			OptionCategory optionCategoryList2 = new OptionCategory(optionCategoryList.get(i),
					storeRegisterForm.getStoreId());
			oclist.add(optionCategoryList2);
			storeCategory += optionCategoryList2.getOptionCategory() +", ";
		}
		store.setStoreCategory(storeCategory.substring(0, storeCategory.length()-2));
		 
		// 사진 수정 삭제 및 재업로드
		// storePicture 등록
		String destDir = request.getServletContext().getRealPath("/up_image");

		List<MultipartFile> list = storeRegisterForm.getStorePictureList();
		
		List<StorePicture> storePictureList = null;
		if(list.size() > 0){
			ArrayList<String> imageName = new ArrayList<>();// 업로드된 파일명을 저장할 list
	
			// System.out.println(list.get(0).toString());
//			if (list == null) {
//				String storePicture = store.getStorePictureList().get(0).toString();
//				List<StorePicture> storePictureList = new ArrayList<StorePicture>();
//				storePictureList.add(new StorePicture(storePicture, storeRegisterForm.getStoreId()));
//			}
	
			// 업로드된 파일의 정보(파일명) 조회, 파일 이동 처리 - 반복문 필요
			for (int i = 0; i < list.size(); i++) {
				MultipartFile mFile = list.get(i);
				if (mFile != null && !mFile.isEmpty()) { // 업로드된 파일이 있는 경우
					imageName.add(mFile.getOriginalFilename());
					mFile.transferTo(new File(destDir, mFile.getOriginalFilename())); // 예외
																						// 던짐
				}
			}
	
			// 다른 경로로 이동 -> 경로 변경
			// 경로는 고정, 파일은 여러개 -> 파일 이름 저장
	
			// 사진 객체로
			storePictureList = new ArrayList<StorePicture>();
			for (int i = 0; i < imageName.size(); i++) {
				storePictureList.add(new StorePicture(imageName.get(i), storeRegisterForm.getStoreId()));
			}
		}
//		session.setAttribute("store", store);

		// 수정하는 서비스 호출
	
		Store storeRetrun = null;
		try {
			storeRetrun = storeService.modifyStore(store, oclist, storePictureList, storeRegisterForm.getPaymentIdList(), new StorePosition(storeRegisterForm.getStoreId(),storeRegisterForm.getX() ,storeRegisterForm.getY()));
			session.setAttribute("storeInfo", storeRetrun);
		} catch (DuplicatedStoreIdException | StorePictureNotFoundException | DuplicatedOptionCategoryNameException e) {
			session.setAttribute("message", e.getMessage());			
			modelAndView.setViewName("redirect:/user/callStoreModifyController.do"); 
			return modelAndView;
		}	


		modelAndView.setViewName("common/store_view.tiles"); 
		modelAndView.addObject("store", storeRetrun);
			
		return modelAndView;
		
	}

	/**
	 * store매장을 삭제하는 controller
	 * 
	 * @param storeRegisterForm
	 * @param errors
	 * @param request
	 * @return
	 */
	@RequestMapping("removeStoreController")
	public String removeStoreController(@ModelAttribute("store") @Valid StoreRegisterForm storeRegisterForm,
			BindingResult errors, HttpSession session) {

		
		Store store = (Store) session.getAttribute("storeInfo");

		storeService.removeStoretById(store.getStoreId(), ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		session.removeAttribute("storeInfo");
		//return "redirect:/user/callStoreRegisterController.do";
		
		SecurityContext context = SecurityContextHolder.getContext();
		GeneralUser generalUser = null;
		
		generalUser = ((GeneralUser)context.getAuthentication().getPrincipal());
		List<SimpleGrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority("ROLE_CNB_USER"));
		context.setAuthentication(new UsernamePasswordAuthenticationToken(generalUser, null, authList));
		
		
		return "index.tiles";
	}
	
	/**
	 * 매장 목록을 페이징 하여 보여주는 컨드롤러
	 * @param storeViewForm (select 검색 종류 -매장 이름(storeName), 매장 소개(storeIntro), 매장 주소(storeAddress), keyword 검색 내용, 카테고리(storeCategory)) 
	 * @param errors 요청파라미터 에러
	 * @return 반환 경로
	 */
	@RequestMapping("/common/findStorePagingListController")
	public ModelAndView findStorePagingListController(@ModelAttribute("storeView") @Valid StoreViewForm storeViewForm, BindingResult errors){
		ModelAndView modelAndView = new ModelAndView();
		if(errors.hasErrors()){
			modelAndView.setViewName("index.tiles");
			return modelAndView; //에러 발생 시 이동할 경로
		}
		
		Map<String, Object> map = storeService.findStorePagingList(storeViewForm.getSelect(), storeViewForm.getKeyword(), storeViewForm.getPage());
		
		modelAndView.setViewName("common/store_list.tiles");
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("keyword", storeViewForm.getKeyword());
		modelAndView.addObject("select", storeViewForm.getSelect());
		
		return modelAndView;
	}
	
	@RequestMapping("/common/viewStoreController")
	public ModelAndView viewStoreController(@RequestParam(value="storeId", required=false) String storeId, HttpSession session){
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(storeId == null){
			modelAndView.setViewName("redirect:/common/findStorePagingListController.do");
			return modelAndView; //에러 발생 시 이동할 경로
		}
	
		
		Store store = storeService.viewStore(storeId, SecurityContextHolder.getContext().getAuthentication());
		modelAndView.setViewName("common/store_view.tiles"); //성공 시 이동할 경로
		modelAndView.addObject("store", store);
		
	
		if(!(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().equals("[ROLE_CNB_ADMIN]") || 
				SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().equals("[ROLE_ANONYMOUS]"))){
			String authority = ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId();
			if(authority != null){
				modelAndView.addObject("authority", authority.equals(storeId));
			}
		}
		
		
		
		
		session.setAttribute("storeInfo", store);
		
		return modelAndView;
	}
	
	/**
	 * 플랫폼에서 지원하는 결제 목록을 매장 등록 폼에 뿌려주는 컨트롤러
	 * @return 반환 경로 및 뿌려줄 객체
	 */
	@RequestMapping("/user/callStoreRegisterController")
	public ModelAndView callStoreRegisterController(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("store/store_register.tiles"); 
		modelAndView.addObject("paymentOptionList", paymentOptionListService.findpaymentOptionList());
		return modelAndView;
	}
	
	/**
	 * 플랫폼에서 지원하는 결제 목록을 매장 수정 폼에 뿌려주는 컨트롤러
	 * @return 반환 경로 및 뿌려줄 객체
	 */
	@RequestMapping("/user/callStoreModifyController")
	public ModelAndView callStoreModifyController(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("store/store_modify.tiles"); 
		modelAndView.addObject("paymentOptionList", paymentOptionListService.findpaymentOptionList());
		return modelAndView;
	}
	
	

	
}
