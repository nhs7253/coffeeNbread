package com.cnb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.service.OptionCategoryService;
import com.cnb.validation.annotation.OptionCategoryFindForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.OptionCategory;

@Controller
public class OptionCategoryController {
	
	@Autowired
	private OptionCategoryService service;
	
	@RequestMapping("findOptionCategoryController")
	public ModelAndView findOptionCategoryController() {
		
		ModelAndView modelAndView = new ModelAndView();

		List<OptionCategory> optionCategoryList = service.findOptionCategoryList(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
		
		modelAndView.setViewName("store/product_register.tiles");
		modelAndView.addObject("optionCategoryList", optionCategoryList);
		return modelAndView;
	}
}
