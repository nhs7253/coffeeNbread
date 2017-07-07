package com.cnb.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.ContentsNotFoundException;
import com.cnb.service.QnaBoardContentsService;
import com.cnb.validation.annotation.QnaBoardContentsForm;
import com.cnb.validation.annotation.QnaBoardContentsViewForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.QnaBoardContents;

/*
 * 노현식 
 * 2017-07-06 
 * 생성, 초기 구현
 */

@Controller
public class QnaBoardContentsController {

	@Autowired
	private QnaBoardContentsService qnaBoardContentsService;
	
	
//	@Autowired
//	private QnaBoardContentsService service;
	
	@RequestMapping("/user/addQnaBoardContentsController")
	public String addQnaBoardContentsController(@ModelAttribute("qnaBoardContents") @Valid QnaBoardContentsForm qnaBoardContentsForm, BindingResult errors){
		GeneralUser generalUser = (GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		
		if(errors.hasErrors()){
			return "user/QnA_board_register_form.tiles"; //에러 발생
		}
		
		
		QnaBoardContents qnaBoardContents = new QnaBoardContents();
		
		BeanUtils.copyProperties(qnaBoardContentsForm, qnaBoardContents);
		
		
		qnaBoardContents.setQnaBoardWriter(generalUser.getUserId());//로그인한 유저 아이디
		qnaBoardContents.setQnaBoardDate(new Date());
		
		qnaBoardContentsService.addQnaBoardContents(qnaBoardContents);
		
		return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo="+qnaBoardContents.getQnaBoardNo();
	}
	
	@RequestMapping("/user/removeQnaBoardContentsController")
	public String removeQnaBoardContentsController(Integer qnaBoardNo, String qnaBoardWriter, @RequestParam(value="qnaStoreId",required=false) String qnaStoreId){
		
		if(!qnaBoardWriter.equals(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId())){
			return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo=" + qnaBoardNo;
		}
		
		qnaBoardContentsService.removeQnaBoardContents(qnaBoardNo);
		
		return "redirect:/common/findQnaBoardContentsBySelectToKeywordController.do?storeId="+qnaStoreId;
		
		
	}
	
	@RequestMapping("/user/modifyQnaBoardContentsController")
	public String modifyQnaBoardContentsController(@ModelAttribute("qnaBoardContents") @Valid QnaBoardContentsForm qnaBoardContentsForm, BindingResult errors, Integer qnaBoardNo){
		if(errors.hasErrors()){
			return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo=" + qnaBoardNo; //에러 발생
		}
		
		QnaBoardContents qnaBoardContents = new QnaBoardContents();
		
		BeanUtils.copyProperties(qnaBoardContentsForm, qnaBoardContents);
		
		try {
			qnaBoardContentsService.modifyQnaBoardContents(qnaBoardNo, qnaBoardContents);
		} catch (ContentsNotFoundException e) {
			return "/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo=" + qnaBoardNo;
		}
		
		return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo="+qnaBoardNo;
	}
	
	@RequestMapping("/user/settingQnaBoardContentsController")
	public String settingQnaBoardContentsController(@RequestParam(value="qnaBoardNo", required=false) Integer qnaBoardNo, String qnaBoardWriter, HttpServletRequest request){
		
		if(!qnaBoardWriter.equals(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId())){
			return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo=" + qnaBoardNo;
		}
		
		try {
			request.setAttribute("content", qnaBoardContentsService.findQnaBoardContents(qnaBoardNo));
		} catch (ContentsNotFoundException e) {
			return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo=" + qnaBoardNo;
		}
		
		return "user/QnA_board_update_form.tiles";
	}
	
	@RequestMapping("/common/findQnaBoardContentsBySelectToKeywordController")
	public ModelAndView findQnaBoardContentsBySelectToKeywordController(@ModelAttribute("generalUserView") @Valid QnaBoardContentsViewForm qnaBoardContentsViewForm, BindingResult errors){

		ModelAndView modelAndView = new ModelAndView();
				
		if(errors.hasErrors()){
			modelAndView.setViewName("index.tiles");
			return modelAndView; //에러 발생 시 이동할 경로
		}
		

		
		//storeId 속성으로 받을 시, 수정 필요
		Map<String, Object> map = qnaBoardContentsService.findQnaBoardContentsBySelectToKeyword(qnaBoardContentsViewForm.getSelect(), qnaBoardContentsViewForm.getKeyword(), qnaBoardContentsViewForm.getStoreId(), qnaBoardContentsViewForm.getPage());
		
		
		modelAndView.setViewName("common/qnaBoard.tiles"); //성공 시 이동할 경로
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("keyword", qnaBoardContentsViewForm.getKeyword());
		modelAndView.addObject("select", qnaBoardContentsViewForm.getSelect());
		modelAndView.addObject("storeId", qnaBoardContentsViewForm.getStoreId());
		return modelAndView;
	}
	
	@RequestMapping("/common/viewQnaBoardContentsByReplyListController")
	public ModelAndView ViewQnaBoardContentsByReplyListController(@RequestParam(value="qnaBoardNo", required=false) Integer qnaBoardNo, Integer page, HttpSession session){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		GeneralUser generalUser = null;
		ModelAndView modelAndView = new ModelAndView();
		
//		//authorities 접근
//		Iterator it = authentication.getAuthorities().iterator();
//		String authority = null;
//		while(it.hasNext()){
//			authority = it.next().toString();
//		}
		
				


		if(qnaBoardNo == null){
			modelAndView.setViewName("index.tiles");
			return modelAndView; //에러 발생 시 이동할 경로
		}
		
		if(page == null || page == 0){
			page = 1;
		}
		
		Map<String, Object> map = qnaBoardContentsService.viewQnaBoardContentsByReplyListService(qnaBoardNo, page);
		QnaBoardContents qnaBoardContents = (QnaBoardContents)map.get("content");
		
		
//		if(qnaBoardContents.getQnaBoardSecret().equals("Y") && authority.equals("ROLE_ANONYMOUS")){
//			modelAndView.setViewName("redirect:/common/findQnaBoardContentsBySelectToKeyword.do?storeId="+qnaBoardContents.getQnaStoreId());
//			return modelAndView; //에러 발생 시 이동할 경로
//		}else if(!authority.equals("ROLE_ANONYMOUS")){
//			generalUser = (GeneralUser)authentication.getPrincipal();
//		}
		
//		System.out.println("매장 비밀글 : " + (qnaBoardContents.getQnaBoardSecret().equals("Y") && qnaBoardContents.getQnaStoreId() != null));
//		System.out.println("내가 쓴 글 : " + qnaBoardContents.getQnaBoardWriter().equals(generalUser.getUserId()));
//		System.out.println("매장 주인 : " + (generalUser.getStoreId() != null || qnaBoardContents.getQnaStoreId().equals(generalUser.getStoreId())));
//		System.out.println("=====================================");
//		System.out.println("전체 비밀글 : " + (qnaBoardContents.getQnaBoardSecret().equals("Y") && qnaBoardContents.getQnaStoreId() == null));
//		System.out.println("내가 쓴 글 : " + qnaBoardContents.getQnaBoardWriter().equals(generalUser.getUserId()));
//		System.out.println("관리자 : " + (authority.equals("ROLE_CNB_ADMIN")));
		
		
		
//		//매장 비밀글일 때 && 본인이나 매장 주인이 아니라면 
//		if((qnaBoardContents.getQnaBoardSecret().equals("Y") && qnaBoardContents.getQnaStoreId() != null) && !(qnaBoardContents.getQnaBoardWriter().equals(generalUser.getUserId()) && !(generalUser.getStoreId() != null || qnaBoardContents.getQnaStoreId().equals(generalUser.getStoreId())))){
//			modelAndView.setViewName("redirect:/common/findQnaBoardContentsBySelectToKeyword.do?storeId="+qnaBoardContents.getQnaStoreId());
//			System.out.println("매장 비밀글");
//			
//			return modelAndView; //에러 발생 시 이동할 경로
//		}
//		
//		//전체 비밀글일 떼 && 본인이나 관리자가 아니라면
//		if((qnaBoardContents.getQnaBoardSecret().equals("Y") && qnaBoardContents.getQnaStoreId() == null) && !(qnaBoardContents.getQnaBoardWriter().equals(generalUser.getUserId()) && !(authority.equals("ROLE_CNB_ADMIN")))){
//			modelAndView.setViewName("redirect:/common/findQnaBoardContentsBySelectToKeyword.do");
//			System.out.println("전체 비밀글");
//			return modelAndView; //에러 발생 시 이동할 경로
//		}
		
		
		modelAndView.setViewName("common/qnaBoard_view.tiles"); //성공 시 이동할 경로
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("content", qnaBoardContents);
		
		
		return modelAndView;
	}
	
}
