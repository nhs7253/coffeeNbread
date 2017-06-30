package com.cnb.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cnb.exception.UserManageException;
import com.cnb.service.GeneralUserService;
import com.cnb.validation.annotation.GeneralUserForm;
import com.cnb.vo.GeneralUser;

/*
 * 노현식 
 * 2017-06-30 
 * 회원가입 구현
 * 
 * 노현식 
 * 2017-06-27 
 * 생성
 */
/**
 * 유저 관련 요청을 처리하는 Controller
 */
@Controller
public class GeneralUserController {

	@Autowired
	private GeneralUserService service;
	
	//@RequestMapping의 value 값 생략시 루트 경로로 이동
	@RequestMapping("addUser") //@ModelAttribute("generalUser")의 value 값으로 RequestScope에 매핑됨, 생략 시 클래이름 
						       //맨 앞글자 소문자로 매핑 됨
	private String addUser(@ModelAttribute("generalUser") @Valid GeneralUserForm generalUserForm, BindingResult errors){
		if(errors.hasErrors()){
			return "user/add_user_form.tiles"; //에러 발생 시 회원 가입 페이지로 이동
		}
		
		GeneralUser generalUser = new GeneralUser();
		//요청 파리미터 검증이 끝난 뒤 실제로 사용될 GeneralUser객채를 만듬
		
		BeanUtils.copyProperties(generalUserForm, generalUser); //소스, 타겟
		//BeanUtils.copyProperties(소스, 타켓); 
		//소스(Form)에 있는 검증 끝난 요청 파라미터 값을 실사용을 위한 타겟(ex - generalUser)에 넣음
		
		try {
			service.addUser(generalUser);
		} catch (UserManageException e) {
			System.out.println(e.getMessage());
			return "user/add_user_form.tiles"; //에러 발생 시 회원 가입 페이지로 이동
		}
		return "index.tiles"; //가입 성공 시 메인페이지로 이동
	}
	
}
