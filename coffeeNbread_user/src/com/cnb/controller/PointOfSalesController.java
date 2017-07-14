package com.cnb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.service.PointOfSalesService;
import com.cnb.validation.annotation.POSPaymentPageViewForm;
import com.cnb.validation.annotation.PointOfSalesViewForm;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.POSPaymentPage;
import com.cnb.vo.PaymentDetails;
import com.cnb.vo.Product;

/*
 * 노현식 
 * 2017-07-13
 * 생성
 */
/**
 * POS(Point of sales, 판매시점 정보관리)
 */
@Controller
public class PointOfSalesController {

	@Autowired
	private PointOfSalesService pointOfSalesService;
	
	@RequestMapping("/store/findProductListToPOSController")
	public ModelAndView findProductListToPOSController(@ModelAttribute("pointOfSalesView") @Valid PointOfSalesViewForm pointOfSalesViewForm, BindingResult errors, HttpSession session){
		session.removeAttribute("posPayment");
		session.removeAttribute("posPaymentTotal");
		ModelAndView modelAndView = new ModelAndView();
		if(errors.hasErrors()){
			modelAndView.setViewName("redirect:/common/viewStoreController.do?storeId="+pointOfSalesViewForm.getStoreId()); //매장 상세
			return modelAndView; 
		}
		
		List<Product> list = pointOfSalesService.findProductListToPOSService(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), pointOfSalesViewForm.getSelect(), pointOfSalesViewForm.getKeyword());
		
		modelAndView.setViewName("store/POS.tiles");
		modelAndView.addObject("list", list);
		return modelAndView;
	}
	
	// [매장ID], 제품ID, 제품 이름, 수량, 가격
	@RequestMapping("/store/movePaymentPageController")
	public ModelAndView movePaymentPageController(@ModelAttribute("POSPaymentPageView") @Valid POSPaymentPageViewForm pOSPaymentPageViewForm, BindingResult errors, HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		if(errors.hasErrors()){
			modelAndView.setViewName("redirect:/store/findProductListToPOSController.do"); 
			return modelAndView; 
		}
		int total = 0;
				
		List<POSPaymentPage> list = new ArrayList<>();
		if(pOSPaymentPageViewForm.getProductIdList() != null || pOSPaymentPageViewForm.getProductIdList().size() > 0){
			for(int i=0;i<pOSPaymentPageViewForm.getProductIdList().size();i++){
				if(pOSPaymentPageViewForm.getProductTradeCountList().get(i)>0){
				list.add(new POSPaymentPage(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId(), 
											pOSPaymentPageViewForm.getProductIdList().get(i), 
											pOSPaymentPageViewForm.getProductNameList().get(i), 
											pOSPaymentPageViewForm.getProductTradeCountList().get(i), 
											pOSPaymentPageViewForm.getProductPriceList().get(i)));
					total += pOSPaymentPageViewForm.getProductTradeCountList().get(i) * pOSPaymentPageViewForm.getProductPriceList().get(i);
				}
			}
		}
		
		if(total == 0){
			modelAndView.setViewName("redirect:/store/findProductListToPOSController.do");
			return modelAndView; 
		}
		 
	
//		session.setAttribute("posPaymentTotal", pOSPaymentPageViewForm.getTotal());
		session.setAttribute("posPaymentTotal", total);
		session.setAttribute("posPayment", list);
		modelAndView.addObject("storePaymentOptionList", pointOfSalesService.findStorePaymentOptionListByStoreIdService(((GeneralUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStoreId()));
		modelAndView.setViewName("store/POS_payment_view.tiles");
		return modelAndView;
	}
	
	@RequestMapping("/store/paymentCancelController")
	public ModelAndView PaymentCancelController(){
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}
	
	@RequestMapping("/store/PaymentExecuteController")
	public String PaymentExecuteController(HttpSession session, String select){
		List<POSPaymentPage> list = (List<POSPaymentPage>) session.getAttribute("posPayment");
		List<PaymentDetails> paymentDetailsList = null;
		if(list != null){
			Date date = new Date();
			paymentDetailsList = new ArrayList<>();
			for(int i=0;i<list.size();i++){
				paymentDetailsList.add(new PaymentDetails(select,date,"F", 0, null, list.get(i).getProductId(), list.get(i).getStoreId(), list.get(i).getProductTradeCount()));
			}
		}
		pointOfSalesService.paymentExecuteService(paymentDetailsList);
		return "redirect:/store/findProductListToPOSController.do";
	}
}
