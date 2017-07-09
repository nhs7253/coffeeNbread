package com.cnb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.service.OptionCategoryService;
import com.cnb.service.ProductPictureService;
import com.cnb.service.ProductService;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.OptionCategory;
import com.cnb.vo.Product;

@Controller
public class OptionCategoryController {
	
	@Autowired
	private OptionCategoryService service;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductPictureService productPictureService;
	
	@RequestMapping("findOptionCategoryController")
	public ModelAndView findOptionCategoryController(@RequestParam(value="productId", required=false) String productId) {
		
		ModelAndView modelAndView = new ModelAndView();

		List<OptionCategory> optionCategoryList = service.findOptionCategoryList(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
		Product product = productService.findProductById(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productId);

		if(productId == null) {
			modelAndView.setViewName("store/product_register.tiles");
		}else {
			String productPicture = (productPictureService.findProductPictureByProductIdAndStoreId(productId, ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId())).getProductPicture();
			product.setProductPicture(productPicture);
			
			modelAndView.setViewName("store/product_update.tiles");
			modelAndView.addObject("product", product);
		}
		
		modelAndView.addObject("optionCategoryList", optionCategoryList);
		return modelAndView;
	}
}
