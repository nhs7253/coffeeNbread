package com.cnb.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.NoUpdateShoppingBasketProductException;
import com.cnb.exception.addShoppingCountZeroException;
import com.cnb.service.ProductService;
import com.cnb.service.ShoppingBasketProductService;
import com.cnb.validation.annotation.ProductRegisterForm;
import com.cnb.validation.annotation.ShoppingBasketProductForm;
import com.cnb.validation.annotation.ShoppingBasketProductViewForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.Product;
import com.cnb.vo.ShoppingBasketProduct;

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
	public String addShoppingBasketProductController(
			@ModelAttribute("shoppingBasketProduct") @Valid ShoppingBasketProductForm shoppingBasketProductForm,
			BindingResult errors, HttpServletRequest request) {

		System.err.println(shoppingBasketProductForm);
		System.out.println("errorCount : " + errors.getErrorCount());
		if (errors.hasErrors()) {
			System.out.println("---------------------------오류발생------------------");
			return "redirect:/user/userFindProductListController.do?storeId=" + shoppingBasketProductForm.getStoreId();

		}
		ShoppingBasketProduct shoppingBasketProduct = new ShoppingBasketProduct();
		BeanUtils.copyProperties(shoppingBasketProductForm, shoppingBasketProduct);
		System.out.println("shoppingBasketProduct:" + shoppingBasketProduct);
		shoppingBasketProduct.setUserId(
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		shoppingBasketProduct.setProductCount(shoppingBasketProductForm.getProductCount());
		shoppingBasketProduct.setProductStoreId(shoppingBasketProductForm.getStoreId());

		// 객체에서 담은 것 카피 해서 넣기.
		// -------조회한 매장(storeId, productStoreId)-> 요청파라미터.에 담겨서 옴.
		// -------등록하려는 제품정보.(productId) -> 제품에 대한 정보는 세션에 담겨서옴.
		// -------등록하려는 제품의 개수(productCount)-> 제품에대한 개수
		try {
			System.out.println("----------------------------------4");
			service.addShoppingBasketProduct(shoppingBasketProduct);
			System.out.println("--------------------------5----------------------");
		} catch (addShoppingCountZeroException e) {
			return "redirect:/user/userFindProductListController.do?storeId=" + shoppingBasketProductForm.getStoreId();

		}
		return "redirect:/user/userFindProductListController.do?storeId=" + shoppingBasketProductForm.getStoreId();// 장바구니등록이
	}

	// 장바구니 폼 이동. ==> 장바구니는 페이징안하고 스크롤로 내려서 보는걸로 선택. 개수 수정되도 원래거에서 수정되는것이므로 양이
	// 적어서 페이징 할필요 못느낌.
	@RequestMapping("/user/ViewShoppingBasketProductController")
	public ModelAndView ViewShoppingBasketProductController(
			@ModelAttribute("shoppingBasketProduct") @Valid ShoppingBasketProductViewForm shoppingBasketProductViewForm,
			BindingResult errors, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		// 요청파라미터를 잘못불렀을때 일어나는 보여줄 view
		if (errors.hasErrors()) {
			System.out.println("------------오류 발생--------------");
			modelAndView.setViewName("user/user_product_list.tiles");

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
		shoppingBasketProduct.setStoreId(shoppingBasketProductViewForm.getStoreId());
		shoppingBasketProduct.setProductId(shoppingBasketProductViewForm.getProductId());
		System.out.println("shoppingBasketProduct:" + shoppingBasketProduct);

		// 유저가 매장에서 등록한 장바구니 목록들 찾기.
		List<ShoppingBasketProduct> shoppingBasketProductList = service.findShoppingBasketProductListByStoreIdAndUserId(
				shoppingBasketProductViewForm.getStoreId(),
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		// 장바구니 목록 보여줄 viewName
		System.out.println("--view:" + shoppingBasketProductList);
		modelAndView.setViewName("user/shoppingBasketProduct_list.tiles");
		modelAndView.addObject("shoppingBasketProductList", shoppingBasketProductList);
		return modelAndView;

	}

	/* 결제페이지로 이동 눌렀을떄 장바구니 폼에서 수정한 개수수정되게 하려고 함 */
	// 장바구니 목록보여주는 폼에서 - 개수 수정 -- 개수 -- ajax써야 할듯- 맨처음 신청한것은 값가져와서 띄워주고 , 나중에
	// 수정할수있게 default값으로 띄워준다. 기억!!
	@RequestMapping("/user/modifyShoppingBasketProductCountAndProcess")
	public ModelAndView modifyShoppingBasketProductCount(
			@ModelAttribute("modifyShoppingBasketProductCount") @Valid ShoppingBasketProductViewForm shoppingBasketProductViewForm,
			BindingResult errors, HttpServletRequest request, ModelMap map) {

		ModelAndView modelAndView = new ModelAndView();
		System.out.println("------------------ㅡmodify진입 0---------------------------");
		if (errors.hasErrors()) {
			modelAndView.setViewName("user/shoppingBasketProduct_list.tiles");
			return modelAndView; // 개수 수정. -장바구니 원래 폼으로 이동.
		}
		
		System.out.println("개수 확인 입니다. " + shoppingBasketProductViewForm);

		System.out.println("shoppingBasketProductViewForm.getStoreId():" + shoppingBasketProductViewForm.getStoreId());
		System.out.println(
				"((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId():"
						+ ((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
								.getUserId());
		List<ShoppingBasketProduct> shopppingBasketProductList = service
				.findShoppingBasketProductListByStoreIdAndUserId(shoppingBasketProductViewForm.getStoreId(),
						((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
								.getUserId());
		System.out.println("modify진입 1->shopppingBasketProductList:" + shopppingBasketProductList);

		ShoppingBasketProduct shoppingBasketProduct = new ShoppingBasketProduct();
		BeanUtils.copyProperties(shoppingBasketProductViewForm, shoppingBasketProduct);

		// shoppingBasketProductList.add(e);
		// ShoppingBasketProduct shoppingBasketProduct = new
		// ShoppingBasketProduct();
		// 웹에서 수정한 개수반영되게함.
		System.out.println("shoppingBasketProduct:" + shoppingBasketProduct);

		System.out.println(
				"modify-shoppingBasketProductViewForm.getStoreId():" + shoppingBasketProductViewForm.getStoreId());
		System.out.println("--------------------modify2진입----------------------------");
		List<ShoppingBasketProduct> sbpList = service.findShoppingBasketProductList(
				shoppingBasketProductViewForm.getStoreId(),
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		System.out.println("------------------modify3진입---------------------------------------------");
		System.out.println("modify4:" + sbpList);
		System.out.println("sbpList.size():" + sbpList.size());
		for (int i = 0; i < sbpList.size(); i++) {

			try {
				System.out.println("shoppingBasketProductViewForm.getProductCount():"+shoppingBasketProductViewForm.getProductCount());
				shopppingBasketProductList.get(i).setProductCount(i);
				//(shoppingBasketProductViewForm.getProductCount());
 				service.modifyShoppingBasketProduct(shoppingBasketProduct);
			} catch (NoUpdateShoppingBasketProductException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("------------------------------------------");
		modelAndView.setViewName("user/payment_view.tiles");
		modelAndView.addObject("shopppingBasketProductList", shopppingBasketProductList); 
		return modelAndView;

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

		System.out.println("-------------remove 1----------------");
		// 어차피 제품아이디는 개별적으로 다르기때문에 매장을 따로 둘필요 없음.
		service.deleteShoppingBasketProductByProductIdAndUserId(productId,
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		System.out.println("--------------remove2-------------------");
		System.out.println("productId:" + productId);
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
	public ModelAndView findAllProductPriceController(@RequestParam(value = "storeId") String storeId ,  @RequestParam(value = "productId") String productId) {
       System.out.println("---------총금액 1--------------");
		ModelAndView modelAndView = new ModelAndView();
		// 어차피 제품아이디는 개별적으로 다르기때문에 매장을 따로 둘필요 없음.
      System.out.println("---------총금액 2---------------");
		// -요청파라미터: storeId필요
   //매장아이디만 보내주면 여기서 유저아이디 세팅해서 장바구니에 넣어진거 계산함.
		int totalPrice = service.findAllProductPrice(storeId,
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		List<ShoppingBasketProduct> shoppingBasketProductList = service.findShoppingBasketProductListByStoreIdAndUserId(
				storeId,
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
		int productTotalPrice = service.findProductPrice(storeId,
				((GeneralUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId(),
				productId);
		
		System.out.println("controller에서의 productId:"+productId);
		System.out.println("totalPrice:"+totalPrice);
		// 총 가격 구하고 다시 원래자리.
		System.out.println("----------------총금액 3------------------");
		modelAndView.setViewName("user/payment_view.tiles");
		modelAndView.addObject("shoppingBasketProductList", shoppingBasketProductList);
		modelAndView.addObject("totalPrice", totalPrice);
		modelAndView.addObject("productTotalPrice", productTotalPrice);
		return modelAndView;
	}

	/**
	 * 장바구니에 넣어둔 각 제품의 제품별 가격 * 개수
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping("/user/findProductPriceController")

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

}
