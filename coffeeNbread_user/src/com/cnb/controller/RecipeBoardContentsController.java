package com.cnb.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.ContentsNotFoundException;
import com.cnb.exception.NotInputRecipeBoardPictureException;
import com.cnb.exception.QnaBoardContentsAuthenticationException;
import com.cnb.service.RecipeBoardContentsService;
import com.cnb.validation.annotation.RecipeBoardContentsForm;
import com.cnb.validation.annotation.RecipeBoardContentsViewForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.RecipeBoardContents;

/*
 * 김형주
 * 2017-07-06 
 * 생성, 초기 구현
 */

@Controller
public class RecipeBoardContentsController {


	
	@Autowired
	private RecipeBoardContentsService recipeBoardService;

	// -----------------------------------------------------------------------------------------
	// 회원이든 비회원이든 전체 게시판 볼수있다 - 조건별 조회 가능
	// userId가 있다면 user가 쓴글 볼수있게 서비스에서 처리.
	@RequestMapping("/common/findRecipeBoardContentsByMethod.do")
	public ModelAndView findRecipeBoardContentsByMethod(
			@ModelAttribute("allUserView") @Valid RecipeBoardContentsViewForm recipeBoardContentsViewForm,
			BindingResult errors) {
		ModelAndView modelAndView = new ModelAndView();

		if (errors.hasErrors()) {
			modelAndView.setViewName("index.tiles");
			return modelAndView; // 에러 발생 시 이동할 경로
		}
		Map<String, Object> map = recipeBoardService.findRecipeBoardContentsByMethod(
				recipeBoardContentsViewForm.getPage(), recipeBoardContentsViewForm.getSelect(),
				recipeBoardContentsViewForm.getKeyword());
		System.out.println("map:" + map);
		modelAndView.setViewName("common/recipeBoard.tiles"); // 성공 시 이동할 경로
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("methodContent", recipeBoardContentsViewForm.getKeyword());
		modelAndView.addObject("method", recipeBoardContentsViewForm.getSelect());
		modelAndView.addObject("storeId", recipeBoardContentsViewForm.getStoreId());
		return modelAndView;
	}

	// 등록
	@RequestMapping(value = "/user/addRecipeBoardContents")
	public String addRecipeBoardContents(
			@ModelAttribute("recipeBoardContents") @Valid RecipeBoardContentsForm recipeBoardContentsForm, BindingResult errors, ModelMap map,
			HttpServletRequest request) throws IllegalStateException, IOException {
		// 권한이 있는 사람들만 쓸수 있게
		GeneralUser generalUser = (GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (errors.hasErrors()) {

			return "user/recipe_board_register_form.tiles"; // 에러 발생
		}

		String fileName = recipeBoardContentsForm.getRecipeBoardPicture().getOriginalFilename();// 업로드된
																								// 파일명

		RecipeBoardContents recipeBoardContents = new RecipeBoardContents();
		BeanUtils.copyProperties(recipeBoardContentsForm, recipeBoardContents);

		if (fileName.equals("")) {
			recipeBoardContents.setRecipeBoardPicture(null);
		} else {
			recipeBoardContents.setRecipeBoardPicture(fileName);
			File dest = new File(request.getServletContext().getRealPath("/up_image"), fileName);
			// 톰켓안에 넣는다.
			recipeBoardContentsForm.getRecipeBoardPicture().transferTo(dest);
			map.addAttribute("fileName", fileName);
		}
		
		recipeBoardContents.setUserId(generalUser.getUserId());// 로그인한 유저 아이디
		recipeBoardContents.setRecipeBoardDate(new Date());
		
    	map.addAttribute("recipeBoardTitle", recipeBoardContentsForm.getRecipeBoardTitle());
		map.addAttribute("recipeBoardContent", recipeBoardContentsForm.getRecipeBoardContent());
		System.out.println("recipeBoardContents:" + recipeBoardContents);
		recipeBoardService.addRecipeBoardContents(recipeBoardContents);

		return "index.tiles";
	}
   
	//---------------------------------------------게시글 내용과 댓글목록.---------------------------------------------------
	@RequestMapping("/common/viewRecipeBoardContentsByReplyListController")
	public ModelAndView ViewRecipeBoardContentsByReplyListController(
			@RequestParam(value = "recipeBoardNo", required = false) Integer recipeBoardNo, Integer page,
		String storeId	) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		ModelAndView modelAndView = new ModelAndView();
		if (recipeBoardNo == null) {
			modelAndView.setViewName("index.tiles");
			return modelAndView; // 에러 발생 시 이동할 경로
		}
		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map;
		try {
			map = recipeBoardService.viewRecipeBoardContentsByReplyListService(recipeBoardNo, page);
		} catch (ContentsNotFoundException e) {
			modelAndView.setViewName("redirect:/common/findRecipeBoardContentsByMethod.do?storeId="+storeId);
			return modelAndView; // 에러 발생 시 이동할 경로
		}
		modelAndView.setViewName("common/recipeBoard_view.tiles"); 
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("content", map.get("content"));
        System.out.println("modelAndView:"+modelAndView);
		return modelAndView;
	}

	@RequestMapping("/user/removeRecipeBoardContentsController")
	public String removeRecipeBoardContentsController(Integer recipeBoardNo, String userId, @RequestParam(value="storeId",required=false) String storeId){
		System.out.println("aaaaaaaaaaaaaaaaaa");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();	
		
		try {
			recipeBoardService.removeRecipeBoardContents(recipeBoardNo, authentication);
		} catch (ContentsNotFoundException e) {
			return "redirect:/common/findRecipeBoardContentsByMethod.do?storeId="+storeId;
		} catch (QnaBoardContentsAuthenticationException e) {
			return "redirect:/common/findRecipeBoardContentsByMethod.do?storeId="+storeId;
		}
		
		return "redirect:/common/findRecipeBoardContentsByMethod.do?storeId="+storeId;
	}
	
	@RequestMapping("/user/modifyRecipeBoardContents")
	/**
	 * 하나이 게시글을 수정해주는 컨트롤러
	 * @param recipeBoardContentsForm 요청 파라미터 검증을 받을 recipeBoardContents객체
	 * @param errors 요청 파라미터 에러 검증 결과 
	 * @param recipeBoardNo 글 번호
	 * @return String 응답 경로
	 */
	public String modifyRecipeBoardContentsController(@ModelAttribute("recipeBoardContents") @Valid RecipeBoardContentsForm recipeBoardContentsForm, BindingResult errors, Integer recipeBoardNo) throws NotInputRecipeBoardPictureException{
		if(errors.hasErrors()){
			System.out.println("-------------오류 발생 ------------------");
			return "redirect:/common/viewRecipeBoardContentsByReplyListController.do?recipeBoardNo=" + recipeBoardNo; //에러 발생
		}
		RecipeBoardContents recipeBoardContents = new RecipeBoardContents();
		BeanUtils.copyProperties(recipeBoardContentsForm, recipeBoardContents);
		System.out.println("recipeBoardContents:"+recipeBoardContents);
		try {
			recipeBoardService.modifyRecipeBoardContents(recipeBoardNo,recipeBoardContents);
		} catch (ContentsNotFoundException e) {
			return "/common/viewRecipeBoardContentsByReplyListController.do?recipeBoardNo=" + recipeBoardNo;
		}
		return "redirect:/common/viewRecipeBoardContentsByReplyListController.do?recipeBoardNo="+recipeBoardNo;
	}
	

	@RequestMapping("/user/settingRecipeBoardContentsController")
	/**
	 * 게시글 수정을 위해 HttpServletRequest에 속성값을 바인딩 해주는 컨트롤러 - 업데이트 권한 처리 포함
	 * @param recipeBoardNo 수정할 게시글
	 * @param userId 저자 - 권한 처리
	 * @param request 게시글을 묶을 범위
	 * @return  String 응답 경로
	 */
	public String settingRecipeBoardContentsController(@RequestParam(value="recipeBoardNo", required=false) Integer recipeBoardNo, String userId, HttpServletRequest request) throws ContentsNotFoundException{
		
		if(!userId.equals(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId())){
			return "redirect:/common/viewRecipeBoardContentsByReplyListController.do?recipeBoardNo=" + recipeBoardNo;
		}
		
   	//수정자와 작성자가 서로 다를때 수정 못하게 하는것.
		try {
			request.setAttribute("content", recipeBoardService.findRecipeBoardContents(recipeBoardNo));
		} catch (ContentsNotFoundException e) {
			return "redirect:/common/viewRecipeBoardContentsByReplyListController.do?recipeBoardNo=" + recipeBoardNo;
		}
		
	
		return "user/recipe_board_update_form.tiles";
	}


}
