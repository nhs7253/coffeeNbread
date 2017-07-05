package com.cnb.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.UserManageException;
import com.cnb.service.GeneralUserService;
import com.cnb.service.QnaBoardContentsService;
import com.cnb.validation.annotation.GeneralUserForm;
import com.cnb.validation.annotation.GeneralUserViewForm;
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
	private QnaBoardContentsService service;
	
	@RequestMapping("/user/addQnaBoardContents")
	public String addQnaBoardContents(@ModelAttribute("qnaBoardContents") @Valid QnaBoardContentsForm qnaBoardContentsForm, BindingResult errors){
		if(errors.hasErrors()){
			return null; //에러 발생
		}
		
		QnaBoardContents qnaBoardContents = new QnaBoardContents();
		
		BeanUtils.copyProperties(qnaBoardContentsForm, qnaBoardContents);
		
		service.addQnaBoardContents(qnaBoardContents);
		
		return null;
	}
	
	@RequestMapping("/user/removeQnaBoardContents")
	public String removeQnaBoardContents(@RequestParam(value="qnaBoardNo",required=false) Integer qnaBoardNo){
		if(qnaBoardNo == null){
			return null; //에러페이지 이동
		}
		
		service.removeQnaBoardContents(qnaBoardNo);
		
		return null;
	}
	
	@RequestMapping("/user/modifyQnaBoardContents")
	public String modifyQnaBoardContents(@ModelAttribute("qnaBoardContents") @Valid QnaBoardContentsForm qnaBoardContentsForm, BindingResult errors){
		if(errors.hasErrors()){
			return null; //에러 발생
		}
		
		QnaBoardContents qnaBoardContents = new QnaBoardContents();
		
		BeanUtils.copyProperties(qnaBoardContentsForm, qnaBoardContents);
		
		service.modifyQnaBoardContents(qnaBoardContents);
		
		return null;
	}
	
	@RequestMapping("findQnaBoardContentsBySelectToKeyword")
	public ModelAndView findQnaBoardContentsBySelectToKeyword(@ModelAttribute("generalUserView") @Valid QnaBoardContentsViewForm qnaBoardContentsViewForm, BindingResult errors){
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()){
			modelAndView.setViewName(null);
			return modelAndView; //에러 발생 시 이동할 경로
		}
		
		//storeId 속성으로 받을 시, 수정 필요
		Map<String, Object> map = service.findQnaBoardContentsBySelectToKeyword(qnaBoardContentsViewForm.getSelect(), qnaBoardContentsViewForm.getKeyword(), qnaBoardContentsViewForm.getStoreId(), qnaBoardContentsViewForm.getPage());
		
		modelAndView.setViewName(null); //성공 시 이동할 경로
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("keyword", qnaBoardContentsViewForm.getKeyword());
		modelAndView.addObject("select", qnaBoardContentsViewForm.getSelect());
		return modelAndView;
	}
	
	//댓글 완성 후 상세 내용 추가
	
}
