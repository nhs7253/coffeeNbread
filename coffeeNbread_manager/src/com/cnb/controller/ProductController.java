package com.cnb.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;

import com.cnb.exception.DuplicatedProductIdOrProductNameException;
import com.cnb.service.OptionCategoryService;
import com.cnb.service.ProductService;
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
	
	@RequestMapping("addProductController")
	public String addProductController(@ModelAttribute("product") @Valid ProductRegisterForm productRegisterForm, HttpServletRequest request, ModelMap map, BindingResult errors) throws Exception {
		if(errors.hasErrors()) {
			return "store/product_register.tiles";
		}

		Product product = new Product();
		BeanUtils.copyProperties(productRegisterForm, product);
		
		product.setStoreId(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
		
		product.setOptionCategory(optionCategoryService.findOptionCategoryByOptionId(productRegisterForm.getOptionId()));
		
		productRegisterForm.setOptionCategoryString(optionCategoryService.findOptionCategoryByOptionId(productRegisterForm.getOptionId()));
		
		OptionDetail optionDetail = new OptionDetail(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(),
														productRegisterForm.getProductId(), productRegisterForm.getOptionId(), productRegisterForm.getProductId());
		
		try {
			service.addProduct(product, optionDetail);
		} catch (DuplicatedProductIdOrProductNameException e) {
			System.out.println("제품아이디 혹은 이름이 중복되었습니다.");
		}
		
		//파일 이동 (임시 경로 -> 최종 경로(up_image))
		String destDir = request.getServletContext().getRealPath("/up_image");
		List<MultipartFile> list = productRegisterForm.getProductPictureList();
		ArrayList<String> imageName = new ArrayList<>();	//업로드된 파일명을 저장할 list
		System.out.println("사이즈"+list.size());
		//업로드된 파일의 정보(파일명) 조회, 파일 이동 처리 - 반복문 필요
		for(int i = 0; i < list.size(); i++) {
			MultipartFile mFile = list.get(i);
			if(mFile != null && !mFile.isEmpty()) {	//업로드된 파일이 있는 경우
				imageName.add(mFile.getOriginalFilename());
				mFile.transferTo(new File(destDir, mFile.getOriginalFilename()));	//예외 던짐
			}
		}
		
		//다른 경로로 이동 -> 경로 변경
		//경로는 고정, 파일은 여러개 -> 파일 이름 저장
		
		map.addAttribute("imageName", imageName);
		

		return "store/product_success.tiles";
	}

}

