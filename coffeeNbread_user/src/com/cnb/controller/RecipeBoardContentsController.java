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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.ContentsNotFoundException;
import com.cnb.service.RecipeBoardContentsService;
import com.cnb.validation.annotation.QnaBoardContentsForm;
import com.cnb.validation.annotation.RecipeBoardContentsForm;
import com.cnb.validation.annotation.RecipeBoardContentsViewForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.QnaBoardContents;
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
		System.out.println("----------------시작-----------");
		ModelAndView modelAndView = new ModelAndView();

		if (errors.hasErrors()) {
			modelAndView.setViewName("index.tiles");
			return modelAndView; // 에러 발생 시 이동할 경로
		}

		System.out.println("----------서비스 시작 전--------------");
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

	// ------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/user/addRecipeBoardContents")
	public String addRecipeBoardContents(
			@ModelAttribute("recipeBoardContents") @Valid RecipeBoardContentsForm recipeBoardContentsForm, ModelMap map,
			HttpServletRequest request, BindingResult errors) throws IllegalStateException, IOException {
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

		/*
		 * if (recipeBoardContentsForm.getRecipeBoardPicture() != null &&
		 * !recipeBoardContentsForm.getRecipeBoardPicture().isEmpty()) {
		 * 
		 * fileName =
		 * recipeBoardContentsForm.getRecipeBoardPicture().getOriginalFilename()
		 * ;// 업로드된 파일명 File dest = new
		 * File(request.getServletContext().getRealPath("/up_image"), fileName);
		 * // 톰켓안에 넣는다.
		 * recipeBoardContentsForm.getRecipeBoardPicture().transferTo(dest);
		 * map.addAttribute("fileName", fileName); }
		 */
		recipeBoardContents.setUserId(generalUser.getUserId());// 로그인한 유저 아이디
		recipeBoardContents.setRecipeBoardDate(new Date());
		System.out.println(
				"recipeBoardContentsForm.getRecipeBoardPicture():" + recipeBoardContentsForm.getRecipeBoardPicture());
		// recipeBoardContents.setRecipeBoardPicture(recipeBoardContentsForm.getRecipeBoardPicture());

		map.addAttribute("recipeBoardTitle", recipeBoardContentsForm.getRecipeBoardTitle());
		map.addAttribute("recipeBoardContent", recipeBoardContentsForm.getRecipeBoardContent());
		System.out.println("recipeBoardContents:" + recipeBoardContents);

		recipeBoardService.addRecipeBoardContents(recipeBoardContents);

		return "common/recipeBoard.tiles";
	}

	
/*
	@RequestMapping("/user/settingRecipeBoardContentsController")
	public String settingRecipeBoardContentsController(@RequestParam(value="recipeBoardNo", required=false) Integer recipeBoardNo, String recipeBoardWriter, HttpServletRequest request){
		
		if(!qnaBoardWriter.equals(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId())){
			return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo=" + qnaBoardNo;
		}
		
		try {
			request.setAttribute("content", qnaBoardContentsService.findQnaBoardContents(qnaBoardNo));
			System.out.println(request.getAttribute("content"));
		} catch (ContentsNotFoundException e) {
			return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo=" + qnaBoardNo;
		}
		
		return "user/QnA_board_update_form.tiles";
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	@RequestMapping("/common/viewRecipeBoardContentsByReplyListController")
	public ModelAndView ViewRecipeBoardContentsByReplyListController(
			@RequestParam(value = "recipeBoardNo", required = false) Integer recipeBoardNo, Integer page,
			HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		GeneralUser generalUser = null;
		ModelAndView modelAndView = new ModelAndView();
		if (recipeBoardNo == null) {
			modelAndView.setViewName("index.tiles");
			return modelAndView; // 에러 발생 시 이동할 경로
		}
		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = recipeBoardService.viewRecipeBoardContentsByReplyListService(recipeBoardNo, page);
		RecipeBoardContents recipeBoardContents = (RecipeBoardContents) map.get("content");

		modelAndView.setViewName("common/recipeBoard_view.tiles"); // 성공 시 이동할
																	// 경로
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("content", recipeBoardContents);

		return modelAndView;
	}*/

}
