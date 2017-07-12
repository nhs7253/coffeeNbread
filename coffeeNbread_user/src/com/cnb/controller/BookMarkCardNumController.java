package com.cnb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.BookCardNumDuplicationException;
import com.cnb.exception.DeleteBookMarkException;
import com.cnb.service.BookMarkCardNumService;
import com.cnb.vo.BookMarkCardNum;
import com.cnb.vo.GeneralUser;


/**
 * 결제 할때 즐겨찾는 카드번호 등록 및 조회.
 * @author 김형주
 *
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

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		GeneralUser generalUser = (GeneralUser) authentication.getPrincipal();
		BookMarkCardNum bookMarkCardNum = new BookMarkCardNum(cardNum, generalUser.getUserId());
		
		bookMarkCardNum.setUserId(
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		System.out.println("-----즐겨찾는 카드번호 ----:"+cardNum);
	    bookMarkCardNum.setCardNum(cardNum);
		try {
			service.addBookMarkCardNum(bookMarkCardNum);
		} catch (BookCardNumDuplicationException e) {

			e.printStackTrace();
			return "user/payment_view.tiles"; // 만약 중복된거 입력한다하더라도 결제폼으로 보여줌.
		}
		return "user/payment_view.tiles";
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

	public ModelAndView findBookMarkCardNumController(@RequestParam(value = "cardNum", required = false) String cardNum) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		GeneralUser generalUser = (GeneralUser) authentication.getPrincipal();
      ModelAndView modelAndView=new ModelAndView();
	List<BookMarkCardNum> bookMarkCardNumList=service.findBookMarkCardNumListByUserId(generalUser.getUserId());
		
	    modelAndView.setViewName("user/payment_view.tiles"); 
		modelAndView.addObject("bookMarkCardNumList",bookMarkCardNumList);
		return modelAndView;
	    
	    
	}
	
	
	
}
