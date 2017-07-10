package com.cnb.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cnb.exception.BoardReplyException;
import com.cnb.exception.BookCardNumDuplicationException;
import com.cnb.exception.DeleteBookMarkException;
import com.cnb.service.BookMarkCardNumService;
import com.cnb.vo.BoardReply;
import com.cnb.vo.BookMarkCardNum;
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
public class BookMarkCardNumController {

	@Autowired
	private BookMarkCardNumService service;

	@RequestMapping("/user/addBookMarkCardNumController")
	/**
	 * 즐겨찾는 카드번호 등록.
	 * 
	 * @return String - 응답 경로
	 */

	/* 유저가 매장에서 카드를 입력 --- 카드num */
	String addBookMarkCardNumController(@RequestParam(value = "cardNum", required = false) String cardNum) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 로그인
																								// 시
																								// 사용했던
																								// 유저
																								// 정보
																								// 받음
		GeneralUser generalUser = (GeneralUser) authentication.getPrincipal();
		BookMarkCardNum bookMarkCardNum = new BookMarkCardNum(cardNum, generalUser.getUserId());
		try {
			service.addBookMarkCardNum(bookMarkCardNum);
		} catch (BookCardNumDuplicationException e) {

			e.printStackTrace();
			return "user/payment_form.tiles"; // 만약 중복된거 입력한다하더라도 결제폼으로 보여줌.
		}
		return "user/payment_form.tiles";
	}

	@RequestMapping("/user/removeBookMarkCardNumController")

	String removeBookMarkCardNumController(@RequestParam(value = "cardNum", required = false) String cardNum) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		GeneralUser generalUser = (GeneralUser) authentication.getPrincipal();

		try {
			service.removeBookMarkCardNumByCardNumAndUserId(cardNum, generalUser.getUserId());
		} catch (DeleteBookMarkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "user/payment_form.tiles";
		}

		return "user/payment_form.tiles";
	}

	
	
	@RequestMapping("/user/findBookMarkCardNumController")

	String findBookMarkCardNumController(@RequestParam(value = "cardNum", required = false) String cardNum) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		GeneralUser generalUser = (GeneralUser) authentication.getPrincipal();

	    service.findBookMarkCardNumListByUserId(generalUser.getUserId());
		return "user/payment_form.tiles";
	}
	
	
	
}
