package com.cnb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.BoardReplyException;
import com.cnb.exception.UserManageException;
import com.cnb.service.BoardReplyService;
import com.cnb.service.GeneralUserService;
import com.cnb.validation.annotation.GeneralUserForm;
import com.cnb.validation.annotation.GeneralUserViewForm;
import com.cnb.vo.BoardReply;
import com.cnb.vo.GeneralUser;

/*
 * 노현식 
 * 2017-07-07 
 * 생성, 초기 구현
 */
/**
 * 게시판 댓글 관련 요청을 처리하는 Controller class
 */
@Controller
public class BoardReplyController {

	@Autowired
	private BoardReplyService boardReplyService;
	
	@RequestMapping("/user/addBoardReplyToQnaBoardNoController")
	/**
	 * Q&A 게시판의 1개의 댓글을 달아주는 컨트롤러
	 * @return String - 응답 경로
	 */
	String addBoardReplyToQnaBoardNoController(int qnaBoardNo, String replyContent ,@RequestParam(value="qnaStoreId",required=false) String qnaStoreId){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //로그인 시 사용했던 유저 정보 받음
		GeneralUser generalUser = (GeneralUser)authentication.getPrincipal();
		BoardReply boardReply = new BoardReply(replyContent, generalUser.getUserId(), new Date(), qnaBoardNo);
		
		boardReplyService.addBoardReplyToQnaBoardNo(boardReply);
		
		
		return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo="+qnaBoardNo+"&qnaStoreId="+qnaStoreId;
	}

	
	@RequestMapping("/user/modifyBoardReplyToQnaBoardNoController")
	/**
	 * Q&A 게시판의 1개의 댓글을 수정해 주는 컨트롤러
	 * @return String - 응답 경로
	 */
	String modifyBoardReplyToQnaBoardNoController(Integer replyNo, int qnaBoardNo, String replyContent, @RequestParam(value="qnaStoreId",required=false) String qnaStoreId){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //로그인 시 사용했던 유저 정보 받음
		GeneralUser generalUser = (GeneralUser)authentication.getPrincipal();
		BoardReply boardReply = new BoardReply(replyNo, replyContent, generalUser.getUserId(), new Date(), qnaBoardNo);
		
		boardReplyService.modifyBoardReplyToQnaBoardNo(boardReply);
		
		return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo="+qnaBoardNo+"&qnaStoreId="+qnaStoreId;
	}
	
	@RequestMapping("/user/modifyBoardReplySettigController")
	/**
	 * Q&A 게시판의 1개의 댓글을 수정하기 위해 셋팅과 권한처리를 해주는 컨트롤러
	 * @param replyNo
	 * @param qnaBoardNo
	 * @param qnaBoardWriter
	 * @param qnaStoreId
	 * @param request
	 * @return
	 */
	String modifyBoardReplySettigController(Integer replyNo, int qnaBoardNo, String replyName, @RequestParam(value="qnaStoreId",required=false) String qnaStoreId, HttpServletRequest request){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //로그인 시 사용했던 유저 정보 받음
		GeneralUser generalUser = (GeneralUser)authentication.getPrincipal();

		try {
			request.setAttribute("boardReply", boardReplyService.findBoardReplyModifySetting(replyNo, generalUser.getUserId(), replyName));
			request.setAttribute("qnaStoreId", qnaStoreId);
		} catch (BoardReplyException e) {
			return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo="+qnaBoardNo+"&qnaStoreId="+qnaStoreId;
		}

		return "user/reply_update_form.tiles";
	}
	
	
	
	@RequestMapping("/user/removeBoardReplyToQnaBoardNoController")
	/**
	 * Q&A 게시판의 1개의 댓글을 삭제해 주는 컨트롤러
	 * @return String - 응답 경로
	 */
	String removeBoardReplyToQnaBoardNoController(Integer replyNo, int qnaBoardNo, String replyName, @RequestParam(value="qnaStoreId",required=false) String qnaStoreId){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //로그인 시 사용했던 유저 정보 받음
		GeneralUser generalUser = (GeneralUser)authentication.getPrincipal();
		
		try {
			boardReplyService.removeBoardReplyToQnaBoardNo(replyNo, qnaBoardNo, replyName, generalUser.getUserId());
		} catch (BoardReplyException e) {
			return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo="+qnaBoardNo+"&qnaStoreId="+qnaStoreId;
		}
		
		return "redirect:/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo="+qnaBoardNo+"&qnaStoreId="+qnaStoreId;
	}
	
	
	/***********************   Q&A  *********************************/
}
