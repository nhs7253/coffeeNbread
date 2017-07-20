package com.cnb.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.cnb.exception.NoUpdateShoppingBasketProductException;
import com.cnb.exception.addShoppingCountZeroException;
import com.cnb.service.ShoppingBasketProductService;
import com.cnb.validation.annotation.ShoppingBasketProductForm;
import com.cnb.validation.annotation.ShoppingBasketProductViewForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.ShoppingBasketProduct;
import com.cnb.vo.Store;

/*
 * 김형주
 * 2017-07-09 생성
 * 
 */

@Controller
public class ShoppingBasketProductController {

	@Autowired
	private ShoppingBasketProductService service;

	// 장바구니 등록 ( 장바구니에 들어갈 제품+제품 사진 등록) -완료
	@RequestMapping("/user/addShoppingBasketProductController")
	public String addShoppingBasketProductController(@ModelAttribute("shoppingBasketProduct") @Valid ShoppingBasketProductForm shoppingBasketProductForm, BindingResult errors, HttpServletRequest request, HttpSession session) {

		if (errors.hasErrors()) {
			return "redirect:/user/userFindProductListController.do?storeId=" + shoppingBasketProductForm.getStoreId();
		}
		ShoppingBasketProduct shoppingBasketProduct = new ShoppingBasketProduct();
		BeanUtils.copyProperties(shoppingBasketProductForm, shoppingBasketProduct);
		shoppingBasketProduct.setUserId(
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		shoppingBasketProduct.setProductCount(shoppingBasketProductForm.getProductCount());
		shoppingBasketProduct.setProductStoreId(shoppingBasketProductForm.getStoreId());

		try {
			service.addShoppingBasketProduct(shoppingBasketProduct);
		} catch (addShoppingCountZeroException e) {
			session.setAttribute("message", e.getMessage());
			return "redirect:/user/userFindProductListController.do?storeId=" + shoppingBasketProductForm.getStoreId();

		}
		return "redirect:/user/userFindProductListController.do?storeId=" + shoppingBasketProductForm.getStoreId();
	}

	// 장바구니 폼 이동. ==> 장바구니는 페이징안하고 스크롤로 내려서 보는걸로 선택. 개수 수정되도 원래거에서 수정되는것이므로 양이
	// 적어서 페이징 할필요 못느낌.
	@RequestMapping("/user/ViewShoppingBasketProductController")
	public ModelAndView ViewShoppingBasketProductController(
			@ModelAttribute("shoppingBasketProduct") @Valid ShoppingBasketProductViewForm shoppingBasketProductViewForm,
			BindingResult errors, HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();
		// 요청파라미터를 잘못불렀을때 일어나는 보여줄 view
		if (errors.hasErrors()) {
			modelAndView.setViewName("user/user_findproduct_List.tiles");

			return modelAndView; // 에러 발생
		}

		ShoppingBasketProduct shoppingBasketProduct = new ShoppingBasketProduct();
		BeanUtils.copyProperties(shoppingBasketProductViewForm, shoppingBasketProduct);
		// 유저아이디
		shoppingBasketProduct.setUserId(
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		// 매장아이디(productStoreId)
		shoppingBasketProduct.setProductStoreId(shoppingBasketProductViewForm.getStoreId());
		// 매장아이디(storeId)
		/*
		 * shoppingBasketProduct.setStoreId(shoppingBasketProductViewForm.
		 * getStoreId());
		 */

		String storeId = ((Store) session.getAttribute("storeInfo")).getStoreId();
		
		
		
		shoppingBasketProductViewForm.setStoreId(storeId);

		shoppingBasketProduct.setProductId(shoppingBasketProductViewForm.getProductId());
		shoppingBasketProduct.setStoreId(shoppingBasketProductViewForm.getStoreId());
  
		// 유저가 매장에서 등록한 장바구니 목록들 찾기.
		
		List<ShoppingBasketProduct> shoppingBasketProductList = service.findShoppingBasketProductListByStoreIdAndUserId(
				shoppingBasketProductViewForm.getStoreId(),
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		
		int totalPrice = service.findAllProductPrice(storeId,
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		
		// 장바구니 목록 보여줄 viewName
		modelAndView.setViewName("user/shoppingBasketProduct_list.tiles");
		modelAndView.addObject("totalPrice", totalPrice);
		modelAndView.addObject("shoppingBasketProductList", shoppingBasketProductList);
		
		return modelAndView;

	}

	// 수정버튼눌렀을때 가능.
	@RequestMapping("/user/modifyShoppingBasketProductCount")
	public String modifyShoppingBasketProductCount(
			@ModelAttribute("modifyShoppingBasketProductCount") @Valid ShoppingBasketProductViewForm shoppingBasketProductViewForm,
			BindingResult errors, HttpServletRequest request, HttpSession session) {
		
		
		System.out.println("shoppingBasketProductViewForm:"+shoppingBasketProductViewForm);
		if (errors.hasErrors()) {
			return "user/shoppingBasketProduct_list.tiles"; 
		}
		
		ShoppingBasketProduct shoppingBasketProduct = new ShoppingBasketProduct();
		BeanUtils.copyProperties(shoppingBasketProductViewForm, shoppingBasketProduct);
		
		String storeId = ((Store) request.getSession().getAttribute("storeInfo")).getStoreId();

		// 유저아이디
		shoppingBasketProduct.setUserId(
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		// 매장아이디(productStoreId)
		shoppingBasketProduct.setProductStoreId(storeId);
		//매장아이디(storeId)
		shoppingBasketProduct.setStoreId(storeId);
		//제품아이디(productId)
    	shoppingBasketProduct.setProductId(shoppingBasketProductViewForm.getProductId());
    	shoppingBasketProduct.setProductCount(shoppingBasketProductViewForm.getProductCount());
		// 유저가 매장에서 등록한 장바구니 목록들 찾기.
				// 장바구니 목록 보여줄 viewName
	   ShoppingBasketProduct sbp = service.findShoppingBasketProduct(shoppingBasketProduct.getUserId(), shoppingBasketProduct.getStoreId(), shoppingBasketProduct.getProductId());
	   try {
			service.modifyShoppingBasketProduct(shoppingBasketProduct);
		} catch (NoUpdateShoppingBasketProductException e) {
			session.setAttribute("message", e.getMessage());
			return "redirect:/user/ViewShoppingBasketProductController.do";
		}
	
		   return "redirect:/user/ViewShoppingBasketProductController.do"; 
	}
		
	


	/**
	 * 제품아이디로 장바구니 목록 삭제
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping("/user/removeShoppingBasketProductController")

	// 꼭있어야할 name: productId
	public String removeShoppingBasketProductController(@RequestParam(value = "productId") String productId) {


		// 어차피 제품아이디는 개별적으로 다르기때문에 매장을 따로 둘필요 없음.
		service.deleteShoppingBasketProductByProductIdAndUserId(productId,
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());

		// 삭제하고 다시 장바구니 폼으로 돌아온다.
		return "redirect:/user/ViewShoppingBasketProductController.do";
	}

	/**
	 * 장바구니에 넣어둔 제품의 모든 제품의 총가격 구하기
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping("/user/findAllProductPriceController")

	// 꼭있어야할 name: productId
	public ModelAndView findAllProductPriceController(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		// 어차피 제품아이디는 개별적으로 다르기때문에 매장을 따로 둘필요 없음.
		// -요청파라미터: storeId필요
		// 매장아이디만 보내주면 여기서 유저아이디 세팅해서 장바구니에 넣어진거 계산함.
		String storeId = ((Store) request.getSession().getAttribute("storeInfo")).getStoreId();
     	int totalPrice = service.findAllProductPrice(storeId,
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		// 총 가격 구하고 다시 원래자리.
		modelAndView.setViewName("user/shoppingBasketProduct_list.tiles");
		modelAndView.addObject("totalPrice", totalPrice);
		return modelAndView;
	}


	/*@RequestMapping("/user/findProductPriceController")

	// 꼭있어야할 name: productId
	public ModelAndView findProductPriceController(
			@ModelAttribute("findProductPriceController") @Valid ShoppingBasketProductForm shoppingBasketProductForm) {

		ModelAndView modelAndView = new ModelAndView();
		// 어차피 제품아이디는 개별적으로 다르기때문에 매장을 따로 둘필요 없음.
		ShoppingBasketProduct shoppingBasketProduct = new ShoppingBasketProduct();
		BeanUtils.copyProperties(shoppingBasketProductForm, shoppingBasketProduct);

		// -요청파라미터: storeId필요
		int productTotalPrice = service.findProductPrice(shoppingBasketProductForm.getStoreId(),
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId(),
				shoppingBasketProductForm.getProductId());
		// 제품별 가격 구하고 제자리
		modelAndView.setViewName("user/ViewShoppingBasketProduct.tiles");
		modelAndView.addObject("productTotalPrice", productTotalPrice);
		return modelAndView;
	}
*/
}
