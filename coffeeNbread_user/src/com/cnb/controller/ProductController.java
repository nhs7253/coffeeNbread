package com.cnb.controller;

import java.io.File;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.DuplicatedProductIdOrProductNameException;
import com.cnb.exception.DuplicatedProductPictureException;
import com.cnb.exception.ProductNotFoundException;
import com.cnb.service.OptionCategoryService;
import com.cnb.service.ProductPictureService;
import com.cnb.service.ProductService;
import com.cnb.validation.annotation.ProductFindByMethodForm;
import com.cnb.validation.annotation.ProductFindForm;
import com.cnb.validation.annotation.ProductRegisterForm;
import com.cnb.validation.annotation.ProductSelectForDeleteForm;
import com.cnb.validation.annotation.ReserSalesViewForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.OptionDetail;
import com.cnb.vo.Product;
import com.cnb.vo.ProductPicture;

/*
 * 최민희
 * 2017-07-09
 * 수정
 */
/*
 * 최민희
 * 2017-07-08
 * 수정
 */
/*
 * 최민희
 * 2017-07-07
 * 수정
 */
/*
 * 최민희
 * 2017-07-06
 * 수정
 */
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
	public String addProductController(@ModelAttribute("product") @Valid ProductRegisterForm productRegisterForm, BindingResult errors, HttpServletRequest request, ModelMap map) throws Exception {
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
		
		String fileName = productRegisterForm.getProductPicture().getOriginalFilename();
		
		if (fileName.equals("")) {
			product.setProductPicture(null);
		}else {
			product.setProductPicture(fileName);
			File dest = new File(request.getServletContext().getRealPath("/up_image"), fileName);
			// 톰켓안에 넣는다.
			productRegisterForm.getProductPicture().transferTo(dest);
			map.addAttribute("fileName", fileName);
		}
		
		try {
			service.addProduct(product, optionDetail);
		} catch (DuplicatedProductIdOrProductNameException | DuplicatedProductPictureException e ) {
			return "store/product_register.tiles";
		}
		return "store/product_success.tiles";
	}

	//제품 상세 수정
	@RequestMapping("modifyProductController")
	public ModelAndView modifyProductController(@ModelAttribute("product") @Valid ProductRegisterForm productRegisterForm, BindingResult errors, HttpServletRequest request, ModelMap map) throws ProductNotFoundException, Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()){
			modelAndView.setViewName("store/product_update.tiles");
			return modelAndView; //에러 발생
		}
		
		Product product = new Product();
		BeanUtils.copyProperties(productRegisterForm, product);

		product.setStoreId(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
		product.setOptionCategory(productRegisterForm.getOptionCategoryString());
		product.setProductCategory(productRegisterForm.getOptionCategoryString());
				
		OptionDetail optionDetail = new OptionDetail(product.getStoreId(), product.getProductId(), productRegisterForm.getOptionId(), productRegisterForm.getOptionCategoryString());
		
		String fileName = productRegisterForm.getProductPicture().getOriginalFilename();
		
		if (fileName.equals("")) {
			product.setProductPicture(productRegisterForm.getOriginalProductPicture());
		}else {
			product.setProductPicture(fileName);
			File dest = new File(request.getServletContext().getRealPath("/up_image"), fileName);
			// 톰켓안에 넣는다.
			productRegisterForm.getProductPicture().transferTo(dest);
			map.addAttribute("fileName", fileName);
		}
		
		ProductPicture productPicture = productPictureService.findProductPictureByProductIdAndStoreId(product.getProductId(), ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
		productPicture.setProductPicture(fileName);
		
		try {
			product = service.findProductById(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productRegisterForm.getProductId());
			
			product.setProductName(productRegisterForm.getProductName());
			product.setProductPrice(productRegisterForm.getProductPrice());
			product.setProductDetail(productRegisterForm.getProductDetail());
			product.setSellingOption(productRegisterForm.getSellingOption());
			product.setTodayProductCount(productRegisterForm.getTodayProductCount());
			product.setRecommendProductCount(productRegisterForm.getRecommendProductCount());
			product.setProductCategory(productRegisterForm.getOptionCategoryString());
			
			service.modifyProduct(product, optionDetail, fileName);
		} catch (DuplicatedProductPictureException e) {
			modelAndView.setViewName("store/product_update.tiles");
			return modelAndView;
		}
		modelAndView.setViewName("store/product_success.tiles");
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	
	
	//제품 목록 조회
		@RequestMapping("findProductListController")
		public ModelAndView findProductListController(@ModelAttribute("productFind") @Valid ProductFindForm productFindForm, BindingResult errors) {
			
			ModelAndView modelAndView = new ModelAndView();
			
			if(errors.hasErrors()) {
				modelAndView.setViewName("index.tiles");
				return modelAndView;
			}

			Map<String, Object> map = service.findProductList(productFindForm.getPage(), productFindForm.getStoreId());
			
			modelAndView.setViewName("store/product_list.tiles");
			modelAndView.addObject("list", map.get("list"));
			modelAndView.addObject("pageBean", map.get("pageBean"));
			modelAndView.addObject("storeId", productFindForm.getStoreId());
			
			return modelAndView;
		}
	///////////////////--------------------일단 지우지 말아주세요~~ 테스트 중입니다.
		//유저가 보는 제품 목록 조회
				/*@RequestMapping("/user/userFindProductListController")
				public ModelAndView userFindProductListController(@ModelAttribute("productFind") @Valid ProductFindForm productFindForm, BindingResult errors) {
					
					ModelAndView modelAndView = new ModelAndView();
					
					if(errors.hasErrors()) {
						modelAndView.setViewName("index.tiles");
						return modelAndView;
					}

					Map<String, Object> map = service.findProductList(productFindForm.getPage(), productFindForm.getStoreId());
					
					modelAndView.setViewName("user/user_product_list.tiles");
					modelAndView.addObject("list", map.get("list"));
					modelAndView.addObject("pageBean", map.get("pageBean"));
					modelAndView.addObject("storeId", productFindForm.getStoreId());
					
					return modelAndView;
				}*/
		
		   
		
	@RequestMapping("/user/userFindProductListController")
		public ModelAndView userFindProductListController(@ModelAttribute("productFind") @Valid ReserSalesViewForm reserSalesViewForm, BindingResult errors) {
			
			ModelAndView modelAndView = new ModelAndView();
		System.out.println("reserSalesViewForm:"+reserSalesViewForm);
		
			if(errors.hasErrors()) {
				modelAndView.setViewName("index.tiles");
				return modelAndView;
			}
			//여기서 select, keyword필요.  
			Map<String, Object> map =service.findProductListByMethod(reserSalesViewForm.getPage(),reserSalesViewForm.getStoreId() , reserSalesViewForm.getSelect(), reserSalesViewForm.getKeyword());
		
		  
			System.out.println("controller-map:"+map);
			System.out.println("controller- -----:"+reserSalesViewForm.getSelect());
			System.out.println("controller- -----:"+reserSalesViewForm.getKeyword());
			modelAndView.setViewName("user/user_findProduct_List.tiles");
			modelAndView.addObject("list", map.get("list"));
			System.out.println("list:"+map.get("list"));
			modelAndView.addObject("pageBean", map.get("pageBean"));
			modelAndView.addObject("storeId", reserSalesViewForm.getStoreId());
			
			return modelAndView;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//	//제품 목록 조회
//	@RequestMapping("findProductListController")
//	public ModelAndView findProductListController(@ModelAttribute("productFind") @Valid ProductFindForm productFindForm, BindingResult errors) {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		if(errors.hasErrors()) {
//			modelAndView.setViewName("index.tiles");
//			return modelAndView;
//		}
//
//		Map<String, Object> map = service.findProductList(productFindForm.getPage(), ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
//		
//		modelAndView.setViewName("store/product_list.tiles");
//		modelAndView.addObject("list", map.get("list"));
//		modelAndView.addObject("pageBean", map.get("pageBean"));
//		modelAndView.addObject("storeId", ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
//		
//		return modelAndView;
//	}
		
		//제품 목록 조회 - 제품 종류/제품명/판매여부
		@RequestMapping("findProductListByMethod")
		public ModelAndView findProductListByMethod(@ModelAttribute("productFindByMethod") @Valid ProductFindByMethodForm productFindByMethodForm, BindingResult errors, String storeId) {
			

			
			ModelAndView modelAndView = new ModelAndView();
			
			if(errors.hasErrors()) {
				modelAndView.setViewName("store/product_list.tiles");
				return modelAndView;
			}
			
			Map<String, Object> map = new HashMap<>();
			
			if(productFindByMethodForm.getMethod().equals("productCategory")) {	//종류로 조회
				map = service.findProductListByCategory(productFindByMethodForm.getPage(), storeId, productFindByMethodForm.getMethodContent());

			}else if(productFindByMethodForm.getMethod().equals("productName")) {	//제품명으로 조회
				map = service.findProductListByName(productFindByMethodForm.getPage(), storeId, productFindByMethodForm.getMethodContent());
				
			}else if(productFindByMethodForm.getMethod().equals("sellingOption")) {	//판매여부로 조회
				String sellingOption = productFindByMethodForm.getMethodContent().toUpperCase();
				map = service.findProductListBySellingOption(productFindByMethodForm.getPage(), storeId, sellingOption);
			}
			
			
			modelAndView.setViewName("store/product_list.tiles");
			modelAndView.addObject("list", map.get("list"));
			modelAndView.addObject("pageBean", map.get("pageBean"));
			
			modelAndView.addObject("method", productFindByMethodForm.getMethod());
			modelAndView.addObject("methodContent", productFindByMethodForm.getMethodContent());
			modelAndView.addObject("storeId", storeId);
			return modelAndView;
		}

//	//제품 목록 조회 - 제품 종류/제품명/판매여부
//	@RequestMapping("findProductListByMethod")
//	public ModelAndView findProductListByMethod(@ModelAttribute("productFindByMethod") @Valid ProductFindByMethodForm productFindByMethodForm, BindingResult errors) {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		if(errors.hasErrors()) {
//			modelAndView.setViewName("store/product_list.tiles");
//			return modelAndView;
//		}
//		
//		Map<String, Object> map = new HashMap<>();
//		
//		if(productFindByMethodForm.getMethod().equals("productCategory")) {	//종류로 조회
//			map = service.findProductListByCategory(productFindByMethodForm.getPage(), ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productFindByMethodForm.getMethodContent());
//
//		}else if(productFindByMethodForm.getMethod().equals("productName")) {	//제품명으로 조회
//			map = service.findProductListByName(productFindByMethodForm.getPage(), ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productFindByMethodForm.getMethodContent());
//			
//		}else if(productFindByMethodForm.getMethod().equals("sellingOption")) {	//판매여부로 조회
//			String sellingOption = productFindByMethodForm.getMethodContent().toUpperCase();
//			map = service.findProductListBySellingOption(productFindByMethodForm.getPage(), ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), sellingOption);
//		}
//		modelAndView.setViewName("store/product_list.tiles");
//		modelAndView.addObject("list", map.get("list"));
//		modelAndView.addObject("pageBean", map.get("pageBean"));
//		
//		modelAndView.addObject("method", productFindByMethodForm.getMethod());
//		modelAndView.addObject("methodContent", productFindByMethodForm.getMethodContent());
//		modelAndView.addObject("storeId", ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
//		return modelAndView;
//	}
	
		//제품 상세 조회
		@RequestMapping("findProductDetailController")
		public ModelAndView findProductDetailController(@RequestParam(value="productId", required=false) String productId, String StoreId) {
			
			ModelAndView modelAndView = new ModelAndView();
			
			if(productId == null) {
				modelAndView.setViewName("store/product_list.tiles");
				return modelAndView;
			}
			
			Product product = service.findProductById(StoreId, productId);
			ProductPicture productPicture = productPictureService.findProductPictureByProductIdAndStoreId(productId, StoreId);
			
			product.setProductPicture(productPicture.getProductPicture());
			
			modelAndView.setViewName("store/product_detail.tiles");
			modelAndView.addObject("product", product);
			
			return modelAndView;
		}	
	
//	//제품 상세 조회
//	@RequestMapping("findProductDetailController")
//	public ModelAndView findProductDetailController(@RequestParam(value="productId", required=false) String productId) {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		if(productId == null) {
//			modelAndView.setViewName("store/product_list.tiles");
//			return modelAndView;
//		}
//		
//		Product product = service.findProductById(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productId);
//		ProductPicture productPicture = productPictureService.findProductPictureByProductIdAndStoreId(productId, ((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId());
//		
//		product.setProductPicture(productPicture.getProductPicture());
//		
//		modelAndView.setViewName("store/product_detail.tiles");
//		modelAndView.addObject("product", product);
//		
//		return modelAndView;
//	}	
	
	//삭제할 제품 선택
	@RequestMapping("selectRemoveProductController")
	public String selectRemoveProductController(@ModelAttribute("productSelectForDelete") @Valid ProductSelectForDeleteForm productSelectForDeleteForm, BindingResult errors) {
		if(errors.hasErrors()) {
			return "redirect:/findProductListController.do";
		}
		service.findRemoveProduct(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), productSelectForDeleteForm.getProductIdList());
		return "redirect:/findProductListController.do";
	}
}

