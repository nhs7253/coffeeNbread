package com.cnb.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.DuplicatedProductIdOrProductNameException;
import com.cnb.exception.DuplicatedProductPictureException;
import com.cnb.exception.ProductNotFoundException;
import com.cnb.service.OptionCategoryService;
import com.cnb.service.ProductPictureService;
import com.cnb.service.ProductService;
import com.cnb.validation.annotation.ProductDetailForm;
import com.cnb.validation.annotation.ProductFindForm;
import com.cnb.validation.annotation.ProductRegisterForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.OptionDetail;
import com.cnb.vo.Product;

/*
 * 최민희
 * 2017-07-05
 * 생성
 */

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private OptionCategoryService optionCategoryService;
	
	@Autowired
	private ProductPictureService productPictureService;
	
	//제품 등록 (+제품 사진 등록)
	@RequestMapping("addProductController")
	public String addProductController(@ModelAttribute("product") @Valid ProductRegisterForm productRegisterForm, HttpServletRequest request, ModelMap map, BindingResult errors) throws Exception {
		if(errors.hasErrors()) {
			return "store/product_register.tiles";
		}

		Product product = new Product();
		BeanUtils.copyProperties(productRegisterForm, product);
		
		product.setStoreId(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
		product.setOptionCategory(optionCategoryService.findOptionCategoryByOptionId(productRegisterForm.getOptionId()));
		product.setProductCategory(optionCategoryService.findOptionCategoryByOptionId(productRegisterForm.getOptionId()));
		
		productRegisterForm.setOptionCategoryString(optionCategoryService.findOptionCategoryByOptionId(productRegisterForm.getOptionId()));
		
		OptionDetail optionDetail = new OptionDetail(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(),
														productRegisterForm.getProductId(), productRegisterForm.getOptionId(), productRegisterForm.getProductId());
		
		//제품 사진 등록
		//파일 이동 (임시 경로 -> 최종 경로(up_image))
		String destDir = request.getServletContext().getRealPath("/up_image");
		List<MultipartFile> list = productRegisterForm.getProductPictureList();
		ArrayList<String> imageName = new ArrayList<>();	//업로드된 파일명을 저장할 list
		
		//업로드된 파일의 정보(파일명) 조회, 파일 이동 처리 - 반복문 필요
		for(int i = 0; i < list.size(); i++) {
			MultipartFile mFile = list.get(i);
			if(mFile != null && !mFile.isEmpty()) {	//업로드된 파일이 있는 경우
				imageName.add(mFile.getOriginalFilename());	//파일명을 담음
				mFile.transferTo(new File(destDir, mFile.getOriginalFilename()));	//예외 던짐
			}
		}
		
		//다른 경로로 이동 -> 경로 변경
		//경로는 고정, 파일은 여러개 -> 파일 이름 저장
		
		map.addAttribute("imageName", imageName);
		
		try {
			service.addProduct(product, optionDetail, list);
		} catch (DuplicatedProductIdOrProductNameException | DuplicatedProductPictureException e ) {
			return "store/product_register.tiles";
		}
		return "store/product_success.tiles";
	}

	//제품 상세 수정
	@RequestMapping("modifyProductController")
	public String modifyProductController(@ModelAttribute("product") @Valid ProductRegisterForm productRegisterForm, BindingResult errors) throws ProductNotFoundException {
		if(errors.hasErrors()){
			return "store/product_update.tiles"; //에러 발생
		}
		
		Product product = new Product();
		BeanUtils.copyProperties(productRegisterForm, product);

		OptionDetail optionDetail = new OptionDetail(product.getStoreId(), product.getProductId(), productRegisterForm.getOptionId(), productRegisterForm.getOptionCategoryString());
		service.modifyProduct(product, optionDetail);
		return "store/product_success.tiles";
	}
	
	//제품 목록 조회
	@RequestMapping("findProductListController")
	public ModelAndView findProductListController(@ModelAttribute("productFind") @Valid ProductFindForm productFindForm, BindingResult errors) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()) {
			modelAndView.setViewName("index.tiles");
			return modelAndView;
		}
		
		Map<String, Object> map = service.findProductList(productFindForm.getPage(), ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
				
		modelAndView.setViewName("store/product_list.tiles");
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("storeId", ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
		
		return modelAndView;
	}
	
	//제품 상세 조회
	@RequestMapping(value="findProductDetailController", method=RequestMethod.GET)
	public ModelAndView findProductDetailController(@ModelAttribute("productDetail") @Valid ProductDetailForm productDetailForm, BindingResult errors) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()) {
			modelAndView.setViewName("store/product_list.tiles");
			return modelAndView;
		}
		
		Product product = service.findProductById(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productDetailForm.getProductId());
		
		modelAndView.setViewName("store/product_detail.tiles");
		modelAndView.addObject("product", product);
		
		return modelAndView;
	}	
}

