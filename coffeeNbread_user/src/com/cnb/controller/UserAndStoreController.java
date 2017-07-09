package com.cnb.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ViewResolverComposite;

import com.cnb.exception.UserAndStoreServiceException;
import com.cnb.service.UserAndStoreService;
import com.cnb.validation.annotation.StoreBookmarkForm;
import com.cnb.validation.annotation.UserAndStoreFindListForm;
import com.cnb.validation.annotation.UserAndStoreSelectDeleteForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.StoreBookmark;
import com.cnb.vo.UserPreferenceStore;

/*
 * 노현식 
 * 2017-07-02 
 * 생성, 초기 구현
 */
/**
 * 유저가 매장 정보에 관해 받는 보조적인 서비스 요청 처리하는 Controller class
 *  - 즐겨찾기, 조회 수별 추천가게, 최근 조회 매장
 */
@Controller
public class UserAndStoreController {

	@Autowired
	private UserAndStoreService service;
	
	
	
	/************** 즐겨찾기 **************/
	
	/**
	 * 유저의 북마크 등록 요청을 처리하는 Controller
	 * @param storeBookmarkFrom (String userId, String storeId) - 요청하는 유저 ID, 등록할 매장 ID
	 * @param errors 요청 파라미터 체크
	 * @return String - 응답 경로
	 */
	@RequestMapping("/user/addStoreBookmarkController") 
	public String addStoreBookmarkController(@ModelAttribute("storeBookmark") @Valid StoreBookmarkForm storeBookmarkFrom, BindingResult errors){
		if(errors.hasErrors()){
			return "redirect:/common/viewStoreController.do?storeId="+storeBookmarkFrom.getStoreId(); //에러 발생 시 이동할 경로
		}
		
		StoreBookmark storeBookmark = new StoreBookmark();
		BeanUtils.copyProperties(storeBookmarkFrom, storeBookmark);
		
		try {
			service.addStoreBookmark(storeBookmark);
		} catch (UserAndStoreServiceException e) {
			return "redirect:/common/viewStoreController.do?storeId="+storeBookmarkFrom.getStoreId(); //이미 등록한 매장일 경우 이동할 페이지
		}
		
		return "redirect:/common/viewStoreController.do?storeId="+storeBookmarkFrom.getStoreId(); //성공적인 추가 시 이동할 페이지
	}
	
	
	/**
	 * 유저가 선택한 북마크 매장들을 삭제하는 Controller
	 * @param userAndStoreSelectDeleteForm (String userId, List<String> storeIdList) - 북마크를 가진 유저ID, 삭제할 매장 ID 목록
	 * @param errors 요청 파라미터 체크
	 * @return String - 응답 경로
	 * @throws Exception 
	 */
	@RequestMapping("/user/selectRemoveStoreBookmarkController") 
	public String selectRemoveStoreBookmarkController(@ModelAttribute("userAndStoreSelectDelete") @Valid UserAndStoreSelectDeleteForm userAndStoreSelectDeleteForm, BindingResult errors) throws Exception{
		
		if(errors.hasErrors()){
			return "redirect:/user/findStoreBookmarkListByKeywordController.do"; //에러 발생 시 이동할 경로
		}			
		service.selectRemoveStoreBookmark(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId(), userAndStoreSelectDeleteForm.getStoreIdList());
		return "redirect:/user/findStoreBookmarkListByKeywordController.do"; //삭제 성공 시 이동할 페이지
	}
	
	/**
	 * 유저가 입력한 키워드를 통해 조회, 북마크 목록을 페이징하여 보여주는 Controller
	 * @param userAndStoreFindListForm (String userId, String keyword, int page) - 검색하는 유저 ID, 검색하려는 키워드, 보려는 페이지 번호
	 * @param errors 요청 파라미터 체크
	 * @return ModelAndView - 응답 경로, 페이징 결과 목록
	 */
	@RequestMapping("/user/findStoreBookmarkListByKeywordController") 
	public ModelAndView findStoreBookmarkListByKeywordController(@ModelAttribute("userAndStoreFindList") @Valid UserAndStoreFindListForm userAndStoreFindListForm, BindingResult errors){
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()){
			modelAndView.setViewName("index.tiles");
			return modelAndView; //에러 발생 시 이동할 경로
		}
		
		Map<String, Object> map = service.findStoreBookmarkListByKeyword(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId(), userAndStoreFindListForm.getKeyword(), userAndStoreFindListForm.getPage());
		
		
		modelAndView.setViewName("user/storeBookmark_list.tiles"); //성공 시 이동할 경로
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("keyword", userAndStoreFindListForm.getKeyword());
		
		return modelAndView;
	}
	
	/************** 즐겨찾기 **************/
	
	
	
	/************** 최근 조회 매장 **************/
	
	/**
	 * 유저가 선택한 방문 내역들을 삭제하는 Controller
	 * @param userAndStoreSelectDeleteForm (String userId, List<String> storeIdList) - 방문내역을 가진 유저ID, 삭제할 매장 ID 목록
	 * @param errors 요청 파라미터 체크
	 * @return String - 응답 경로
	 */
	@RequestMapping("/user/selectRemoveStoreVisitHistoryController") 
	public String selectRemoveStoreVisitHistoryController(@ModelAttribute("userAndStoreSelectDelete") @Valid UserAndStoreSelectDeleteForm userAndStoreSelectDeleteForm, BindingResult errors){
		if(errors.hasErrors()){
			return "redirect:/user/findStoreVisitHistoryListByKeywordController.do"; //에러 발생 시 이동할 경로
		}
		
		service.selectRemoveStoreVisitHistory(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId(), userAndStoreSelectDeleteForm.getStoreIdList());
		
		return "redirect:/user/findStoreVisitHistoryListByKeywordController.do"; //삭제 성공 시 이동할 페이지
	}
	
	/**
	 * 유저가 입력한 키워드를 통해 조회 북마크 목록을 페이징하여 보여주는 Controller
	 * @param userAndStoreFindListForm  (String userId, String keyword, int page) - 검색하는 유저 ID, 검색하려는 키워드, 보려는 페이지 번호
	 * @param errors 요청 파라미터 체크
	 * @return ModelAndView - 응답 경로, 페이징 결과 목록
	 */
	@RequestMapping("/user/findStoreVisitHistoryListByKeywordController") 
	public ModelAndView findStoreVisitHistoryListByKeywordController(@ModelAttribute("userAndStoreFindList") @Valid UserAndStoreFindListForm userAndStoreFindListForm, BindingResult errors){
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()){
			modelAndView.setViewName("index.tiles");
			return modelAndView; //에러 발생 시 이동할 경로
		}
		
		Map<String, Object> map = service.findStoreVisitHistoryListByKeyword(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId(), userAndStoreFindListForm.getKeyword(), userAndStoreFindListForm.getPage());
		
		modelAndView.setViewName("user/visitHistory_list.tiles"); //성공 시 이동할 경로
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("keyword", userAndStoreFindListForm.getKeyword());
		
		return modelAndView;
	}
	
	/************** 최근 조회 매장 **************/
	
	
	
	/************** 조회 수별 추천 가게 **************/
	
	@RequestMapping("/user/viewUserPreferenceStoreListController") 
	public ModelAndView viewUserPreferenceStoreListController(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //로그인 시 사용했던 유저 정보 받음
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(authentication == null){
			modelAndView.setViewName("index.tiles");
			return modelAndView; //에러 페이지로 이동 (잘못된 접근)
		}
		
		List<UserPreferenceStore> list = service.viewUserPreferenceStoreList(((GeneralUser)authentication.getPrincipal()).getUserId());
		
		modelAndView.setViewName("user/userPreferenceStore_list.tiles"); //성공 시 이동할 경로
		modelAndView.addObject("list", list);
		
		return modelAndView;
	}
	
	/************** 조회 수별 추천 가게 **************/
	
	
}
