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
import com.cnb.exception.QnaBoardContentsAuthenticationException;
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
	
	

	@RequestMapping("/user/addQnaBoardContentsController")
	/**
	 * Q&A 게시글을 등록해 주는 컨트롤러
	 * @param qnaBoardContentsForm 요청 파라미터 검증 qnaBoardContentsForm 객체
	 * @param errors 요청 파라미터 에러 검증 결과 
	 * @return String 응답 경로
	 */
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
	/**
	 * 게시글 번호로 1개의 글을 삭제하는 컨르롤러
	 * @param qnaBoardNo Integer 삭제할 글번호
	 * @param qnaBoardWriter String 글쓴이 - 삭제 권한 검증
	 * @param qnaStoreId String 매장 ID - 에러 반환시 게시판 구분
	 * @return String 응답 경로
	 */
	public String removeQnaBoardContentsController(Integer qnaBoardNo, String qnaBoardWriter, @RequestParam(value="qnaStoreId",required=false) String qnaStoreId){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();	
		
		try {
			qnaBoardContentsService.removeQnaBoardContents(qnaBoardNo, authentication);
		} catch (ContentsNotFoundException e) {
			return "redirect:/common/findQnaBoardContentsBySelectToKeywordController.do?storeId="+qnaStoreId;
		} catch (QnaBoardContentsAuthenticationException e) {
			return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo=" + qnaBoardNo;
		}
		
		return "redirect:/common/findQnaBoardContentsBySelectToKeywordController.do?storeId="+qnaStoreId;
	}
	
	@RequestMapping("/user/modifyQnaBoardContentsController")
	/**
	 * 하나이 게시글을 수정해주는 컨트롤러
	 * @param qnaBoardContentsForm 요청 파라미터 검증을 받을 qnaBoardContents객체
	 * @param errors 요청 파라미터 에러 검증 결과 
	 * @param qnaBoardNo 글 번호
	 * @return String 응답 경로
	 */
	public String modifyQnaBoardContentsController(@ModelAttribute("qnaBoardContents") @Valid QnaBoardContentsForm qnaBoardContentsForm, BindingResult errors, Integer qnaBoardNo, String qnaBoardWriter){
		if(errors.hasErrors()){
			return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo=" + qnaBoardNo + "&qnaBoardWriter=" + qnaBoardWriter; //에러 발생
		}
				
		QnaBoardContents qnaBoardContents = new QnaBoardContents();
		BeanUtils.copyProperties(qnaBoardContentsForm, qnaBoardContents);
		
		try {
			qnaBoardContentsService.modifyQnaBoardContents(qnaBoardNo, qnaBoardContents);
		} catch (ContentsNotFoundException e) {
			return "/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo=" + qnaBoardNo + "&qnaBoardWriter=" + qnaBoardWriter;
		}
		
		return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo="+qnaBoardNo + "&qnaBoardWriter=" + qnaBoardWriter;
	}
	
	@RequestMapping("/user/settingQnaBoardContentsController")
	/**
	 * 게시글 수정을 위해 HttpServletRequest에 속성값을 바인딩 해주는 컨트롤러 - 업데이트 권한 처리 포함
	 * @param qnaBoardNo 수정할 게시글
	 * @param qnaBoardWriter 저자 - 권한 처리
	 * @param request 게시글을 묶을 범위
	 * @return  String 응답 경로
	 */
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
	/**
	 * 페이징하여 결과 목록을 보여주는 컨트롤러
	 * @param qnaBoardContentsViewForm 페이징에 필요한 데이터들을 받은 폼
	 * @param errors 요청 파라미터 에러 검증 결과  
	 * @return - 응답 경로, 페이징 결과 목록
	 */
	public ModelAndView findQnaBoardContentsBySelectToKeywordController(@ModelAttribute("qnaBoardContentsView") @Valid QnaBoardContentsViewForm qnaBoardContentsViewForm, BindingResult errors){

		ModelAndView modelAndView = new ModelAndView();
				
		if(errors.hasErrors()){
			modelAndView.setViewName("index.tiles");
			return modelAndView; //에러 발생 시 이동할 경로
		}
					
		//storeId 속성으로 받을 시, 수정 필요
		Map<String, Object> map = qnaBoardContentsService.findQnaBoardContentsBySelectToKeyword(qnaBoardContentsViewForm.getSelect(), qnaBoardContentsViewForm.getKeyword(), qnaBoardContentsViewForm.getStoreId(), qnaBoardContentsViewForm.getPage());
		
		
		modelAndView.setViewName("common/qnaBoard.tiles"); //성공 시 이동할 경로
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("storeId", qnaBoardContentsViewForm.getStoreId());
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("keyword", qnaBoardContentsViewForm.getKeyword());
		modelAndView.addObject("select", qnaBoardContentsViewForm.getSelect());
		modelAndView.addObject("storeId", qnaBoardContentsViewForm.getStoreId());
		return modelAndView;
	}
	
	
	/**
	 * 게시글의 내용, 그리고 댓글을 페이징하여 보여주는 컨트롤러
	 * @param qnaBoardNo 볼 게시글
	 * @param page 볼 댓글 페이지
	 * @param qnaStoreId 매장, 전체 글 여부
	 * @return ModelAndView -  응답 경로, 페이징 결과 목록
	 */
	@RequestMapping("/common/viewQnaBoardContentsByReplyListController")
	public ModelAndView ViewQnaBoardContentsByReplyListController(@RequestParam(value="qnaBoardNo", required=false) Integer qnaBoardNo, Integer page, String qnaStoreId, String qnaBoardWriter){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		boolean removeAuthority = false;
		boolean modifyAuthority = false;
		
		//관리자, 매장 주인, 작성자라면 삭제 가능 // 본인만 수정 가능
		if(!(authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]"))){
			removeAuthority =  authentication.getAuthorities().toString().equals("[ROLE_CNB_ADMIN]") ||
							   ((GeneralUser)authentication.getPrincipal()).getStoreId().equals(qnaStoreId) ||
							   ((GeneralUser)authentication.getPrincipal()).getUserId().equals(qnaBoardWriter);
			
			modifyAuthority = ((GeneralUser)authentication.getPrincipal()).getUserId().equals(qnaBoardWriter);
		}

		
		ModelAndView modelAndView = new ModelAndView();

		if(qnaBoardNo == null){
			modelAndView.setViewName("index.tiles");
			return modelAndView; //에러 발생 시 이동할 경로
		}
		
		if(page == null || page == 0){
			page = 1;
		}
		
		Map<String, Object> map;
		try {
			map = qnaBoardContentsService.viewQnaBoardContentsByReplyListService(qnaBoardNo, page, authentication);
		} catch (ContentsNotFoundException e) {
			modelAndView.setViewName("index.tiles");
			return modelAndView; //에러 발생 시 이동할 경로
		} catch (QnaBoardContentsAuthenticationException e) {
			modelAndView.setViewName("redirect:/common/findQnaBoardContentsBySelectToKeywordController.do?storeId="+qnaStoreId);
			return modelAndView; //에러 발생 시 이동할 경로
		}

		modelAndView.setViewName("common/qnaBoard_view.tiles"); //성공 시 이동할 경로
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("content", map.get("content"));
		
		modelAndView.addObject("removeAuthority", removeAuthority);
		modelAndView.addObject("modifyAuthority", modifyAuthority);
		
		
		return modelAndView;
	}
	
}
