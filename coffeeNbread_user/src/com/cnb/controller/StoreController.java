package com.cnb.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnb.exception.DuplicatedOptionCategoryNameException;
import com.cnb.exception.DuplicatedStoreCategorytNameException;
import com.cnb.exception.DuplicatedStoreIdException;
import com.cnb.exception.DuplicatedStorePictureException;
import com.cnb.exception.UserManageException;
import com.cnb.service.StoreService;
import com.cnb.validation.annotation.StoreRegisterForm;
import com.cnb.vo.OptionCategory;
import com.cnb.vo.Store;
import com.cnb.vo.StoreCategory;
import com.cnb.vo.StorePicture;

/*
 * 이진영
 * 2017-07-05
 * 생성
 */

@Controller
public class StoreController {

	@Autowired
	private StoreService service;
	
	/**
	 * Store 기본 내용을 등록하는 Controller
	 * @param Store 요청파라미터 검증 Store 객체
	 * @return
	 */
	@RequestMapping("addStoreController")
	public String addStoreController(@ModelAttribute("store") @Valid StoreRegisterForm storeRegisterForm, BindingResult errors) throws UserManageException{
		
		Store store = new Store();
		BeanUtils.copyProperties(storeRegisterForm, store);
		
		System.out.println("store = " + store);
		
		storeRegisterForm.setStorePicture(storeRegisterForm.getStoreId());
		
		StoreCategory storeCategory = new StoreCategory(storeRegisterForm.getStoreCategory(),storeRegisterForm.getStoreId());
		
		OptionCategory optionCategory = new OptionCategory(storeRegisterForm.getOptionCategory(),storeRegisterForm.getStoreId());
		StorePicture storePicture = new StorePicture(storeRegisterForm.getStorePicture(),storeRegisterForm.getStoreId());
	
		try {
			service.addStore(store,storeCategory,optionCategory,storePicture);
		} catch (DuplicatedStoreIdException | DuplicatedOptionCategoryNameException
				| DuplicatedStoreCategorytNameException | DuplicatedStorePictureException e) {
			System.out.println(e.getMessage());
		}
		return "store/store_success.tiles";
	}
}
