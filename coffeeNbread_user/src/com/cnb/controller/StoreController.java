package com.cnb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cnb.service.StoreService;
import com.cnb.validation.annotation.StoreRegisterForm;

public class StoreController {

	@Autowired
	private StoreService service;
	
	/**
	 * Store 기본 내용을 등록하는 Controller
	 * @param Store 요청파라미터 검증 Store 객체
	 * @return
	 */
	@RequestMapping("addStoreController")
	public String addStoreController(@ModelAttribute("Store") @Valid StoreRegisterForm StoreRegisterForm, BindingResult errors){
		return null;
		
	}
}
